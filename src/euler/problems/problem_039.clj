(ns euler.problems.problem-039
  (:require [euler.utils :refer :all]))

(defn solution-039
  []
  (first (max-by second (for [p (range 2 1001 2)]
                          [p (count (into #{} (for [a (range 1 (/ p 2))
                                                    b (range 1 (min a (- p a)))
                                                    :let [c (- p a b)]
                                                    :when (= (* c c) (+ (* a a) (* b b)))]
                                                #{a b c})))]))))
