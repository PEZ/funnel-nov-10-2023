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
  (-> (p/let [file-uri (vscode/Uri.joinPath (next/ws-root) relative-path)
              encoder (js/TextEncoder.)
              content-data (.encode encoder content)]

        (vscode.workspace.fs.writeFile file-uri content-data))
      (p/catch (fn [e]
                 (vscode/window.showErrorMessage e)))))

(comment
  (p/do (create-file!+ "foo-file.md" "# hello\n\n \\newpage"))
  (p/let [slides (next/slides-list+)
          notes (notes-list+ slides)
          headers (headers-list+ slides)
          nhs (notes-and-headers+ headers notes)
          _ (def nhs nhs)
          notes->headers (into {} nhs)
          missing (missing-notes-paths+ nhs)
          _ (def missing missing)])


  :rcf)


