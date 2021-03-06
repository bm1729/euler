(ns euler.problems.problem-032
  (:require [euler.utils :refer :all]))

(defn- is-2-3-4-pandigital-product?
  [a b c d e f g h i]
  (let [multiplicand (compose-number [a b])
        multiplier (compose-number [c d e])
        product (compose-number [f g h i])]
    (= product (* multiplicand multiplier))))

(defn- is-1-4-4-pandigital-product?
  [a b c d e f g h i]
  (let [multiplicand a
        multiplier (compose-number [b c d e])
        product (compose-number [f g h i])]
    (= product (* multiplicand multiplier))))

(defn- get-2-3-4-pandigital-products
  []
  (for [b (remove #{1 5} (range 1 10))
        e (remove #{1 5} (range 1 10))
        i (remove #{5} (range 1 10))
        :when (distinct? b e i)
        :when (= i (rem (* b e) 10))
        a (remove #{b e i} (range 1 10))
        d (remove #{b e i} (range 1 10))
        h (remove #{b e i} (range 1 10))
        :when (distinct? a d h)
        :when (= (compose-number [h i]) (rem (* (compose-number [a b]) (compose-number [d e])) 100))
        c (remove #{a b d e h i} (range 1 10))
        f (remove #{a b d e h i} (range 1 10))
        g (remove #{a b d e h i} (range 1 10))
        :when (distinct? c f g)
        :when (is-2-3-4-pandigital-product? a b c d e f g h i)]
    (compose-number [f g h i])))

(defn- get-1-4-4-pandigital-products
  []
  (for [a (remove #{1 5} (range 1 10))
        e (remove #{1 5} (range 1 10))
        i (remove #{5} (range 1 10))
        :when (distinct? a e i)
        :when (= i (rem (* a e) 10))
        d (remove #{a e i} (range 1 10))
        h (remove #{a e i} (range 1 10))
        :when (distinct? d h)
        :when (= (compose-number [h i]) (rem (* a (compose-number [d e])) 100))
        c (remove #{a d e h i} (range 1 10))
        g (remove #{a d e h i} (range 1 10))
        :when (distinct? c g)
        :when (= (compose-number [g h i]) (rem (* a (compose-number [c d e])) 1000))
        b (remove #{a c d e g h i} (range 1 10))
        f (remove #{a c d e g h i} (range 1 10))
        :when (distinct? b f)
        :when (is-1-4-4-pandigital-product? a b c d e f g h i )]
    (compose-number [f g h i])))

(defn solution-032
  []
  (->> (concat (get-1-4-4-pandigital-products) (get-2-3-4-pandigital-products))
       (into #{})
       (reduce +)))
