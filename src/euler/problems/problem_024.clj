(ns euler.problems.problem-024
  (:require [euler.utils :refer :all]))

(defn- vec-remove
  [coll pos]
  (vec (concat (subvec coll 0 pos) (subvec coll (inc pos)))))

(defn list-of-digits
  [candidates n]
  (if (seq candidates)
    (let [increment (factorial (dec (count candidates)))
          idx (quot n increment)
          remainder (rem n increment)]
      (cons (nth candidates idx) (list-of-digits (vec-remove candidates idx) remainder)))
    ()))

(defn solution-024
  []
  (->> (list-of-digits (vec (range 10)) (dec 1000000))
       (map str)
       clojure.string/join
       Long/parseLong))


