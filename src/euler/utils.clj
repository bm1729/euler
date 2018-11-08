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
  ([n]
    (decompose-number 10 n))
  ([base n]
   (loop [agg ()
          n n]
     (if (< n base)
       (conj agg (rem n base))
       (recur (conj agg (rem n base)) (quot n base))))))

(defn compose-number
  ([digits]
    (compose-number 10 digits))
  ([base digits]
   (reduce #(+ %2 (* base %1)) digits)))

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

(defn primes
  [n]
  (let [bs (new java.util.BitSet n)
        [s _r] (math/exact-integer-sqrt n)]
    (.flip bs 2 n)
    (doseq [x (range 2 (inc s))]
      (if (.get bs x)
        (doseq [m (range (* 2 x) n x)]
          (.clear bs m))))
    (loop [primes (transient [])
           bit 1]
      (let [next-set-bit (.nextSetBit bs bit)]
        (if (= -1 next-set-bit)
          (persistent! primes)
          (recur (conj! primes next-set-bit) (inc next-set-bit)))))))

(defn prime?
  [n]
  (if (< n 2)
    false
    (not (let [[s _r] (math/exact-integer-sqrt n)]
           (some (partial divides? n) (range 2 (inc s)))))))