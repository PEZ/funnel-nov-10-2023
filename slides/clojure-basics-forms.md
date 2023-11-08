<div class="slide">

# Special forms, macros, functions
<div class="gutters-10 row">
<div class="column">

* 14 (-ish) Special forms
* Macros build from special forms, macros and functions
* Functions are values

* `if` special form
* `when` macro
* All conditionals use `if`

</div>

<div class="column" style="flex: 2;">

``` clojure
;; `def` a special form
(def foo :bar)

;; `fn` a macro
(fn [x & y]
  {x (apply list y)})

;; `apply` and `list` are functions
(def f (fn [x & y]
         {x (apply list y)}))

(defn f [x & y]
  {x (apply list y)})
```

</div>
</div>

<kbd>F12</kbd> to go to definitions. Try with `when`, and `comment`. What about `if`?.

</div>
