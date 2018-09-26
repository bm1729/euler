(ns euler.problems.problem-004)

(defn is-pallindromic?
  [x]
  (let [str-x (str x)]
    (= str-x (apply str (reverse str-x)))))

(defn solution-004
  []
  (->> (for [x (range 100 1000)
             y (range 100 1000)
             :when (<= x y)
             :let [product (* x y)]]
         product)
       (filter is-pallindromic?)
       sort
       last))
