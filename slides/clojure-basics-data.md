<div class="slide">

# Clojure data revisit
<div class="gutters-10 row">
<div class="column">

* Numbers, many kinds
* Strings
* Keywords
* Symbols
* Immutable data structures
  * Maps
  * Vectors
  * Sets

</div>

<div class="column" style="flex: 2.9;">

``` clojure
{:numbers {:big-integer 12345678901234567890N
           :big-decimal 3.14159265358979323846M
           :ratio 1/3 :base-n 2r10010}
 :strings {:string "Hello
                    World!"
           :character \a :regex #"[a-zA-Z]+"}
 :keywords :foo :namespaced-keyword :bar/baz
 :vectors [1 "2" :three 4]
 :maps {:foo #inst "2020-10-06T12:07:29.085-00:00" 
        :bar-baz [1 2 3]
        {:foo :bar}}
 :sets #{1 "2" :three}
 :symbols hello :quoted-symbol 'foo-bar/baz
 #uuid "f47ac10b-58cc-4372-a567-0e02b2c3d479" :foo}
```

</div>
</div>

</div>
