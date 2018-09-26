(ns euler.problems.problem-009)

(defn solution-009
  []
  (loop [a 1
         b 1]
    (let [c (- 1000 a b)]
      (cond (= (* c c) (+ (* a a) (* b b))) (* a b c)
            (< b 1000) (recur a (inc b))
            :else (recur (inc a) (inc a))))))
