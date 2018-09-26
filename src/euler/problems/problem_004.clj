(ns euler.problems.problem-004)

(defn- is-pallindromic?
  [x]
  (let [str-x (str x)]
    (= str-x (apply str (reverse str-x)))))

(def ^:private three-digit-products
  (for [x (reverse (range 100 1000))
        y (reverse (range 100 1000))
        :when (<= x y)
        :let [product (* x y)]]
    product))

(defn solution-004
  []
  (reduce (fn [agg product]
            (if (and (or (nil? agg) (< agg product))
                     (is-pallindromic? product))
              product
              agg))
          nil
          three-digit-products))
