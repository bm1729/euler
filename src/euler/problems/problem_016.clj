(ns euler.problems.problem-016)

(defn- power-of-2
  [n]
  (reduce * 1N (repeat n 2)))

(defn solution-016
  []
  (->> (power-of-2 1000)
       str
       (map #(str %))
       (map #(Integer/parseInt %))
       (reduce +)))