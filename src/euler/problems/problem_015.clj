(ns euler.problems.problem-015
  (:require [euler.utils :refer :all]))

(defn solution-015
  []
  (let [twenty-factorial (factorial 20)]
    (/ (factorial 40) twenty-factorial twenty-factorial)))
