(ns euler.problems.problem-031)

(defn- count-coins
  [[f & r :as c] n]
  (cond (nil? f) 0
        (neg? n) 0
        (zero? n) 1
        :else (+ (count-coins r n) (count-coins c (- n f)))))

(defn solution-031
  []
  (count-coins [200 100 50 20 10 5 2 1] 200))