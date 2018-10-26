(ns euler.problems.problem-025
  (:require [euler.utils :refer :all]))

(defn steve
  ([x]
    (clojure.pprint/pprint (take 50 x))
    (println)
    x)
  ([l x]
    (println l)
    (clojure.pprint/pprint (take 50 x))
    (println)
    x))

(defn solution-025
  []
  (->> (fibonacci-sequence 1 1)
       (map number-of-digits)
       (map vector (iterate inc 1))
       (filter (fn [[_index digits-count ]] (= 1000 digits-count)))
       ffirst))