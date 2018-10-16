(ns euler.problems.problem-016)

(defn- power-of-2
  [n]
  (if (zero? n)
    1N
    (* 2 (power-of-2 (dec n)))))

(defn solution-016
  []
  (->> (power-of-2 1000)
       str
       (map #(str %))
       (map #(Integer/parseInt %))
       (reduce +)))