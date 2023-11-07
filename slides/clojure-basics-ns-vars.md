<div class="slide">

# namespaces, vars, symbols
<div class="gutters-10 row">
<div class="column">

* _namespaces_ bind _vars_
* _var_, mutable reference to _values_
* a _symbol_ “names” a _var_

* local bindings immutably binds in lexical scopes
</div>

<div class="column" style="flex: 3;">

``` clojure
(ns my-app.hello
  (:require [my-app.baz :as baz :refer [qux]]))

(def foo ::baz/fred) ;=> #'my-app.hello-test/foo
;symbol^ ^value          ^var         ns sep^

(defn f [s]
  (let [x 42/5
        y 7
        f' (fn f' [d]
             (str s (+ x d) ":" (+ y d)))]
    (f' 10))) ;=> #'my-app.hello-test/f

(f "Q") ;=> "Q92/5:17"
```

</div>
</div>

</div>
