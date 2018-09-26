(ns euler.problems.problem-002)

(defn solution-002
  []
  (->> ((fn fib [a b]
          (lazy-seq (cons a (fib b (+ a b)))))
         0 1)
       (take-while #(< % 4000000))
       (filter even?)
       (reduce +)))
