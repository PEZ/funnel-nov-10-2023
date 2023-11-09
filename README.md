# Funnel Clojure Workshop, 10 november 2023

To run the presentation using next-slide.cljs you need the Joyride extension.

You also need to run `npm i`.

Then reload the VS Code window: **Developer: Reload Window**

## next-slide.cljs

Then check [.joyride/src/next_slide.cljs](.joyride/src/next_slide.cljs) for the keyboard shortcuts. You can select the line commmented shortcuts block and toggle comments, paste the results in your `keybindings.json` file. (There's a VS Code command for easily finding it.)

The next-slide.cljs script will automatically activate, when you reload the VS Code window with Joyride installed.

The project has VS Code settings that zoom the VS Code UI, and the editor font sizes to suit my laptop and tastes. You might need to tweak this a bit to get the slides to fit your screen. See also [style.css](./style.css).

## next-slide-notes.cljs

There's also the script [.joyride/src/next_slide_notes.cljs](.joyride/src/next_slide_notes.cljs) which lets you jump between the slide markdown files and the corresponding slide notes markdown files. (Doesn't work from Preview mode, nb.)

There are also a command for generating a command line which let's you print the notes as a PDF. You will need Pandoc and LaTeX for the command line to work.
