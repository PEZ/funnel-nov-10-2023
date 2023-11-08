<div class="slide">

# Clojure functions
<div class="gutters-10 row">
<div class="column">

* Lambdas (can be named)
* Literal function syntax
  * Can't be nested
* To bind to a namespace
  * assign a lambda to a `def`
  * use `defn`
* Can have varargs
* Can be multi-arity

</div>

<div class="column" style="flex: 2;">

``` clojure
(fn hello [s] (str "Hello " s "!"))

#(str "Hello " % "!")

(def hello2 *1)

(defn hello3 [s] (str "Hello " s "!"))

(defn hello4 [& s] (apply str "Hello " s))

(defn hello5
  ([s] (hello5 s nil))
  ([s1 s2] (str "Hello " s1 s2)))

(defn hello6 "I say Hello" [s]
  (str "Hello " s "!"))
```

</div>
</div>

</div>
