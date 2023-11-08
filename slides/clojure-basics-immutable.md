<div class="slide">

# Collections
<div class="gutters-10 row">
<div class="column">

* Immutable
* Persistent Data Structures
  * Structural sharing
  * [Wikipedia: Persistent data structure](https://en.wikipedia.org/wiki/Persistent_data_structure)
* Value semantics
* Designed for thread first, `->`
  * E.g. `conj`, `assoc`, `update` 

</div>

<div class="column" style="flex: 2;">

``` clojure
  (def m {:a 1}) ;=> #'get-started.my-basics/m
  
  (def m2 (assoc m :b 2)) ; m2 => {:a 1, :b 2}
  
  m ;=> {:a 1}
  
  (def v (conj [1 2] 3))
  
  (assoc v 1 0)
  
  (update m2 :b inc)

  (-> m
      (assoc ,,, :c {:d 4})
      (update-in ,,, [:c :d] dec)
      :c) ; (:c ,,,), (get :c ,,,)
```

</div>
</div>

</div>
