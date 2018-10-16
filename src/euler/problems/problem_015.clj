(ns euler.problems.problem-015)

(defn factorial
  [n]
  (reduce * (range 1N (inc n))))

(defn solution-015
  []
  (let [twenty-factorial (factorial 20)]
    (/ (factorial 40) twenty-factorial twenty-factorial)))
