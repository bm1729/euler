(ns euler.utils
  (:require [clojure.math.numeric-tower :as math]))

(defn divides?
  [num div]
  (zero? (mod num div)))

(defn power
  [x n]
  (reduce *' 1 (repeat n x)))

(defn square
  [n]
  (*' n n))

(defn factorial
  [n]
  (reduce *' (range 1 (inc n))))

(defn factors
  "Returns list of unordered factors of n (including 1 and n)"
  [n]
  (let [[s _r] (math/exact-integer-sqrt n)]
    (->> (range 1 (inc s))
         (filter (partial divides? n))
         (mapcat (fn [x]
                   (if (= n (square x))
                     [x]
                     [x (/ n x)]))))))

(defn decompose-number
  [n]
  (->> n
       str
       (map str)
       (map #(Integer/parseInt %))))

(defn compose-number
  [digits]
  (reduce #(+ %2 (* 10 %1)) digits))

(defn number-of-digits
  [n]
  (count (str n)))

(defn sum-of-digits
  [n]
  (reduce + (decompose-number n)))

(defn fibonacci-sequence
  ([]
   (fibonacci-sequence 0 1))
  ([x y]
   ((fn fib [a b]
      (lazy-seq (cons a (fib b (+' a b)))))
     x y)))

(defn max-by
  [f coll]
  (->> coll
       (map (fn [x] [(f x) x]))
       (reduce (partial max-key first))
       second))