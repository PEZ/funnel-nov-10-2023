<div class="slide">

# Sequences
<div class="gutters-10 row">
<div class="column">

* Immutable
* Implements `ISeq`
  * `first`
  * `next`
  * `more`
  * `cons`
* Often lazy
* Designed for thread last, `->>`
  * E.g. `filter`, `map`, `reduce`, `take`, `last`

</div>

<div class="column" style="flex: 2;">

``` clojure
(map inc [1 2 3]) ;=> (2 3 4)
  
(filter even? '(1 2 3 4) ;=> (2 4)

(reduce #(str %1 "-" %2) [1 2 3]) ;=> "1-2-3"

(take 3 [1 2 3 4 5]) ;= (1 2 3)

(->> (range) ; infinite and lazy (0 1 ...)
     (map #(+ 64 %) ,,,)
     (map (comp char inc) ,,,)
     (take 8)
     (reduce #(str %1 "-" %2) ,,,)) ;=> ??

(type (take 2 [1])) ;=> clojure.lang.LazySeq
```

</div>
</div>

</div>
