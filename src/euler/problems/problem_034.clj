(ns euler.problems.problem-034
  (:require [euler.utils :refer :all]))

;145 is a curious number, as 1! + 4! + 5! = 1 + 24 + 120 = 145.
;
;Find the sum of all numbers which are equal to the sum of the factorial of their digits.
;
;Note: as 1! = 1 and 2! = 2 are not sums they are not included.

(defn- is-digit-factorial-sum?
  [factorials n]
  (= n (reduce + (map factorials (decompose-number n)))))

(defn solution-034
  []
  (let [factorials (zipmap (range 10) (map factorial (range 10)))]
    (->> (range 10 1000000)
         (filter (partial is-digit-factorial-sum? factorials))
         (reduce +))))
