(ns euler.problems.problem-003
  (:require [euler.utils :refer :all]))

(defn- largest-prime-factor
  ([num]
   (largest-prime-factor num 2))
  ([num candidate]
   (cond (= candidate num) num
         (divides? num candidate) (recur (/ num candidate) candidate)
         :else (recur num (inc candidate)))))

(defn solution-003
  []
  (largest-prime-factor 600851475143))
