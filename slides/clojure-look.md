<div class="slide">

# Clojure at a glance

No parens in Hello World! 😀
<div class="gutters-10 row">
<div class="column">



``` clojure
"Hello World!"
```

``` clojure
(println "Hello World!")

(println "Hello" "World!")

(defn hello [s]
  (str "Hello " s "!"))

(println (hello "World")) ;=> nil
```

Not Clojure:
``` ts
console.log(hello("World"));
```
</div>

<div class="column">

``` clojure
(->> "World" hello println) ;=> nil

(+ 1 2 3 36) ;=> 42

(if (even? 42) "Y" "N") ;=> "Y"

(vscode/window.showInformationMessage
 "Hello World!")

(vscode/window.showInformationMessage
 (->> ["🥚" "🐔"]
      sort
      (str "Jury says: ")))
```

</div>
</div>

</div>
