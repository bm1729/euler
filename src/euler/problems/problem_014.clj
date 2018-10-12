(ns euler.problems.problem-014)

(defn- collatz
  [n]
  (loop [x n
         c 1]
    (cond (= 1 x) c
          (even? x) (recur (/ x 2) (inc c))
          :else (recur (inc (* 3 x)) (inc c)))))

(defn solution-014
  []
  (->> (range 500000 1000000)
       (map (fn [n] [(collatz n) n]))
       sort
       last
       second))
