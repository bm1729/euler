(ns euler.problems.problem-033
  (:require [euler.utils :refer :all]))

(defn- is-digit-cancelling-fraction?
  [na nb da db]
  (or (and (= na db) (= (/ (compose-number [na nb]) (compose-number [da db])) (/ nb da)))
      (and (= nb da) (= (/ (compose-number [na nb]) (compose-number [da db])) (/ na db)))))

(defn solution-033
  []
  (denominator (reduce * (for [na (range 1 10)
                               nb (range 1 10)
                               da (range 1 10)
                               db (range 1 10)
                               :when (> 1 (/ (compose-number [na nb]) (compose-number [da db])))
                               :when (is-digit-cancelling-fraction? na nb da db)]
                           (/ (compose-number [na nb]) (compose-number [da db]))))))