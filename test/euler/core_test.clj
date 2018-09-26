(ns euler.core-test
  (:require [clojure.test :refer :all]
            [euler.problems.problem-001 :refer :all]
            [euler.problems.problem-002 :refer :all]
            [euler.problems.problem-003 :refer :all]
            [euler.problems.problem-004 :refer :all]))

(deftest fast-running-solutions
  (is (= 233168 (solution-001)))
  (is (= 4613732 (solution-002)))
  (is (= 6857 (solution-003)))
  (is (= 906609 (solution-004))))
