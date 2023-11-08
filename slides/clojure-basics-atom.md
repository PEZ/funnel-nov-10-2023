<div class="slide">

# Reference types
<div class="gutters-10 row">
<div class="column">

* Most often `clojure.core/atom`
* Updates are atomic
  * CAS, Compare and Set
* Often used as in-memory database
  * Or the backing of one
</div>

<div class="column" style="flex: 2;">

``` clojure
(def !a (atom {:a 1}))

@!a ;=> {:a 1}

(reset! !a {:b 1}) ;=> {:b 1}

(swap! !a assoc-in [:c :d] [1 2 3])

(swap! !a update :b str)

(def !b (atom 1))

(swap! !b inc)

@!b
```

</div>
</div>

</div>
