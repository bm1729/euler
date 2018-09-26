(ns euler.problems.problem-002)

(def ^:private fibonnaci-seq ((fn fib [a b]
                                (lazy-seq (cons a (fib b (+ a b)))))
                               0 1))

(defn solution-002
  []
  (->> fibonnaci-seq
       (take-while #(< % 4000000))
       (filter even?)
       (reduce +)))
