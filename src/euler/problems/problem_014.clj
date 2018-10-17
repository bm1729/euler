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
       (map (fn [n] [(collatz-seq-length n) n]))
       (reduce (fn [[best-length :as best] [this-length :as x]]
                 (if (< best-length this-length)
                   x
                   best)))
       second))
