<div class="slide">

# Clojure data
<div class="gutters-10 row">
<div class="column">

* **Numbers**, including big integers, big decimals, ratios, base-n
* **Character types**, strings (multiline), characters, regular expressions
* **Keywords**, `:foo`, fully interned, namespaced `:foo-bar/baz`
* **Vectors**, `[1 "2", :three 1]`
* **Maps**, `{:foo 1 :bar-baz [1 2 3]}`
* **Sets**, `"#{1 "2" :three}`
* **Symbols**, `foo`, namespaced
* Extensible via reader tags

EDN, Extensible Data Notation. Conceptually like JSON. Much, much richer.

</div>

<div class="column">

``` clojure
{:numbers {:integer 42
           :big-integer 12345678901234567890N
           :big-decimal 3.14159265358979323846M
           :ratio 1/3
           :hexadecimal 0x2A
           :octal 052
           :base-n 2r10010}
 :character-types {:string "Hello, World!\nNew line.
New line too."
                   :character \a
                   :regex #"[a-zA-Z]+"}
 :keyword :foo
 :namespaced-keyword :bar/baz
 :vector [1 "2" :three 4]
 :map {:foo 1
       :bar-baz [1 2 3]
       {:foo :bar}}
 :set #{1 "2" :three}
 :symbol 'foo-bar/baz
 [:key-1 :key-2] :whatever}
```

</div>
</div>

</div>
