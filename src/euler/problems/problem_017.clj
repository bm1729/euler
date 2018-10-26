(ns euler.problems.problem-017
  (:require [euler.utils :refer :all]))

(def ^:private one-19-numbers
  (zipmap (range 1 20) ["one" "two" "three" "four" "five" "six" "seven" "eight" "nine" "ten"
                        "eleven" "twelve" "thirteen" "fourteen" "fifteen" "sixteen" "seventeen"
                        "eighteen" "nineteen"]))

(def ^:private twenty-ninety-numbers
  (zipmap (range 20 91 10) ["twenty" "thirty" "forty" "fifty" "sixty" "seventy" "eighty" "ninety"]))

(defn- number->string
  [n]
  (cond (= n 1000) "onethousand"
        (divides? n 100) (str (number->string (quot n 100)) "hundred")
        (< 100 n) (str (number->string (* 100 (quot n 100))) "and" (number->string (rem n 100)))
        (<= 1 n 19) (first-19-numbers n)
        (divides? n 10) (twenty-ninety-numbers n)
        :else (str (number->string (* 10 (quot n 10))) (number->string (rem n 10)))))

(defn solution-017
  []
  (->> (range 1 1001)
       (map number->string)
       (map count)
       (reduce +)))