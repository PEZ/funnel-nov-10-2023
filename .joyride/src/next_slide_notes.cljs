;; == Keyboard shortcuts ==
;; Weird indent because of how comment block/selection works
    ;;{
    ;;    "key": "ctrl+alt+j ctrl+p",
    ;;    "command": "joyride.runCode",
    ;;    "args": "(next-slide-notes/prepare!)"
    ;;},
    ;;{
    ;;    "key": "ctrl+alt+j p",
    ;;    "command": "joyride.runCode",
    ;;    "args": "(next-slide/print!)"
    ;;},

(ns next-slide-notes
  (:require ["vscode" :as vscode]
            [joyride.core :as joyride]
            [promesa.core :as p]
            [clojure.set :as set]
            [clojure.string :as string]
            [next-slide :as next]))

;; create this file with whatever YAML frontmatter you want
;; (make it empty if you don't need any pandoc/TeX prelude)
(def notes-header-path "slides/_notes-header.md")

;; Use a font that prints something instead of nothing for missing characters
(def main-font "DejaVu Sans")

(defn log [& s]
  (.appendLine (joyride/output-channel) (string/join " " s)))

(defn- slide-header+ [slide-path]
  (p/let [slide-uri (vscode/Uri.joinPath (next/ws-root) slide-path)
          slide-text (p/-> slide-uri
                           vscode/workspace.fs.readFile
                           js/Buffer.from
                           (.toString "utf-8"))
          header (re-find #"(?<=\n)#.*(?=\n)" slide-text)]
    header))

(defn- notes-list+ [slides]
  (p/let [notes (map (fn [slide]
                       (string/replace-first slide #"\.md$" "-notes.md"))
                     slides)]
    notes))

(defn- headers-list+ [slides]
  (p/let [headers (p/all (map slide-header+ slides))]
    headers))

(defn- notes-and-headers+ [headers notes]
  (p/let [notes-and-headers (mapv (fn [note header]
                                    [note header])
                                  notes headers)]
    notes-and-headers))

(defn- missing-notes-paths+ [notes-and-headers]
  (p/let [notes-paths (map first notes-and-headers)
          glob (str "{" (string/join "," notes-paths) "}")
          existing-uris (vscode/workspace.findFiles glob)
          existing-notes (p/all (map vscode/workspace.asRelativePath existing-uris))
          missing-notes (set/difference (set notes-paths) (set (js->clj existing-notes)))]
    missing-notes))

(defn create-file!+ [relative-path content]
  (p/let [file-uri (vscode/Uri.joinPath (next/ws-root) relative-path)
          encoder (js/TextEncoder.)
          content-data (.encode encoder content)]

    (vscode.workspace.fs.writeFile file-uri content-data)))

(defn create-missing-notes!+ [notes->headers missing-notes]
  (p/do (p/doseq [note missing-notes]
          (let [header (notes->headers note)
                content (str header "\n\n\\newpage")]
            (log "  Creating " note "-" header)
            (create-file!+ note content)))
        (log "")))

(defn prepare! []
  (-> (p/let [slides (next/slides-list+)
              notes (notes-list+ slides)
              headers (headers-list+ slides)
              nhs (notes-and-headers+ headers notes)
              notes->headers (into {} nhs)
              missing (missing-notes-paths+ nhs)]
        (log "Creating" (count missing) "missing -notes.md files")
        (create-missing-notes!+ notes->headers missing)
        (log "Done creating missing notes")
        (vscode/window.showInformationMessage (str "Done creating " (count missing) " missing notes")))
      (p/catch (fn [e]
                 (vscode/window.showErrorMessage (str "Error creating missing notes: " e))))))

(defn print! []
  (p/let [slides (next/slides-list+)
          notes (notes-list+ slides)
          command-line (into ["pandoc" notes-header-path]
                             (concat notes ["-o" "output.pdf"
                                            "--pdf-engine=xelatex"
                                            "-V geometry:'landscape,a4paper,margin=2cm'"
                                            "-V" (str "mainfont='" main-font "'")]))
          command-line-string (string/join " " command-line)
          _ (println command-line-string)
          button (vscode/window.showInformationMessage
                  (str "Notes printing command line") "Copy to clipboard")]
    (log (str "Notes printing command line:\n" command-line-string))
    (when (= "Copy to clipboard" button)
      (p/do (vscode/env.clipboard.writeText command-line-string)
            (vscode/window.showInformationMessage (str "Notes printing command line copied to clipboard!") "OK")))))

(comment
  (prepare!)
  (print!)
  :rcf)
