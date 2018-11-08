(ns euler.problems.problem-040
  (:require [euler.utils :refer :all]))

(defn dn
  ([n]
    (dn 1 (dec n)))
  ([digits-per-number n]
    (let [first-number-in-block (power 10 (dec digits-per-number))
          block-size (* digits-per-number 9 first-number-in-block)]
      (if (< block-size n)
        (recur (inc digits-per-number) (- n block-size))
        (let [q (quot n digits-per-number)
              r (rem n digits-per-number)
              t (+ q first-number-in-block)]
          (nth (decompose-number t) r))))))

(defn solution-040
  []
  (->> (range 7)
       (map (partial power 10))
       (map dn)
       (reduce *)))
