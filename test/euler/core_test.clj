(ns euler.core-test
  (:require [clojure.test :refer :all]
            [euler.problems
             [problem-001 :refer :all]
             [problem-002 :refer :all]
             [problem-003 :refer :all]
             [problem-004 :refer :all]
             [problem-005 :refer :all]
             [problem-006 :refer :all]
             [problem-007 :refer :all]
             [problem-008 :refer :all]
             [problem-009 :refer :all]
             [problem-010 :refer :all]
             [problem-011 :refer :all]
             [problem-012 :refer :all]]))

(deftest fast-running-solutions
  (is (= 233168 (solution-001)))
  (is (= 4613732 (solution-002)))
  (is (= 6857 (solution-003)))
  (is (= 906609 (solution-004)))
  (is (= 232792560 (solution-005)))
  (is (= 25164150 (solution-006)))
  (is (= 23514624000 (solution-008)))
  (is (= 31875000 (solution-009)))
  (is (= 70600674 (solution-011))))

(deftest slow-running-solutions
  (is (= 104743 (time (solution-007))))
  (is (= 142913828922 (time (solution-010)))))
