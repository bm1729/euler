(ns euler.problems.problem-009)

(defn solution-009
  []
  (first (for [a (range 1 (/ 1000 2))
               b (range 1 (min a (- 1000 a)))
               :let [c (- 1000 a b)]
               :when (not= a b)
               :when (= (* c c) (+ (* a a) (* b b)))]
           (* a b c))))
