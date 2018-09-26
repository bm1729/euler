(ns euler.core-test
  (:require [clojure.test :refer :all]
            [euler.problems.problem-001 :refer :all]
            [euler.problems.problem-002 :refer :all]
            [euler.problems.problem-003 :refer :all]
            [euler.problems.problem-004 :refer :all]
            [euler.problems.problem-005 :refer :all]
            [euler.problems.problem-006 :refer :all]
            [euler.problems.problem-007 :refer :all]))

(deftest fast-running-solutions
  (is (= 233168 (solution-001)))
  (is (= 4613732 (solution-002)))
  (is (= 6857 (solution-003)))
  (is (= 906609 (solution-004)))
  (is (= 232792560 (solution-005)))
  (is (= 25164150 (solution-006)))
  (is (= 104743 (time (solution-007)))))
