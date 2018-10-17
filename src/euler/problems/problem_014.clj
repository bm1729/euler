(ns euler.problems.problem-014)

(defn- collatz-seq-length
  [n]
  (loop [x n
         c 1]
    (cond (= 1 x) c
          (even? x) (recur (/ x 2) (inc c))
          :else (recur (inc (* 3 x)) (inc c)))))

(defn solution-014
  []
  (->> (range 500000 1000000)
       (remove #(= 1 (quot % 3)))
       (map (fn [n] [(collatz-seq-length n) n]))
       (reduce (partial max-key first))
       second))
