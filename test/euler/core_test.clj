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

(defmacro euler
  [expected solution-fn]
  `(deftest ~(symbol (str "testing-" solution-fn))
     (let [start-ns# (. java.lang.System (nanoTime))]
       (is (= ~expected (~solution-fn)))
       (let [time-taken-ns# (- (. java.lang.System (nanoTime)) start-ns#)
             time-taken-ms# (/ time-taken-ns# 1000000.0)]
         (println ~(str solution-fn) time-taken-ms# "ms")
         (is (< time-taken-ms# 5000.0))))))

(euler 233168 solution-001)
(euler 4613732 solution-002)
(euler 6857 solution-003)
(euler 906609 solution-004)
(euler 232792560 solution-005)
(euler 25164150 solution-006)
(euler 23514624000 solution-008)
(euler 31875000 solution-009)
(euler 70600674 solution-011)

(euler 104743 solution-007)
(euler 142913828922 solution-010)
