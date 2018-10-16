(ns euler.utils)

(defn divides?
  [num div]
  (zero? (mod num div)))

(defn power
  [x n]
  (reduce * 1N (repeat n x)))

(defn square
  [n]
  (* n n))

(defn factorial
  [n]
  (reduce * (range 1N (inc n))))

(defn sum-digits
  [n]
  (->> n
       str
       (map #(str %))
       (map #(Integer/parseInt %))
       (reduce +)))