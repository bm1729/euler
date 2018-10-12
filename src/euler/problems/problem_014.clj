(ns euler.problems.problem-014)

(def collatz (memoize (fn [n]
                        (cond (= 1 n) 1
                              (even? n) (inc (collatz (/ n 2)))
                              :else (inc (collatz (inc (* 3 n))))))))

(defn solution-014
  []
  (->> (range 1 1000000)
       (map (fn [n] [(collatz n) n]))
       sort
       last
       second))
