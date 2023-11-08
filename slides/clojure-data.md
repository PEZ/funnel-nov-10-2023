<div class="slide">

# Clojure data
<div class="gutters-10 row">
<div class="column" style="flex: 4">

``` clojure
{:numbers {:big-integer 12345678901234567890N
           :big-decimal 3.14159265358979323846M
           :ratio 1/3 :base-n 2r10010}
 :character-types {:string "Hello
                            World!"
                   :character \a :regex #"[a-zA-Z]+"}
 :keywords :foo :namespaced-keyword :bar/baz
 :vectors [1 "2" :three 4]
 :maps {:foo #inst "2020-10-06T12:07:29.085-00:00" 
        :bar-baz [1 2 3]
        'qux {:foo :bar}}
 :sets #{1 "2" :three}
 :symbols hello :quoted-symbol 'foo-bar/baz
 #uuid "f47ac10b-58cc-4372-a567-0e02b2c3d479" :foo}
```
</div>

<div class="column">
<img src="images/clj.png" height=200 width=200>
</div>
</div>

EDN (`.edn`), Extensible Data Notation. Conceptually like JSON. Much, much richer.
</div>
