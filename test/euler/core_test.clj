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
             [problem-012 :refer :all]
             [problem-013 :refer :all]
             [problem-014 :refer :all]]))

(defmacro euler
  [expected solution-fn description]
  `(deftest ~(symbol (str "testing-" solution-fn))
     (testing ~description
       (let [start-ns# (. java.lang.System (nanoTime))]
         (is (= ~expected (~solution-fn)))
         (let [time-taken-ns# (- (. java.lang.System (nanoTime)) start-ns#)
               time-taken-ms# (/ time-taken-ns# 1000.0 1000.0)]
           (printf "%s: %.3f ms\n\n" ~(str solution-fn) time-taken-ms#)
           (is (< time-taken-ms# 5000.0)))))))

(euler 233168 solution-001 "Multiples of 3 and 5")
(euler 4613732 solution-002 "Even Fibonacci numbers")
(euler 6857 solution-003 "Largest prime factor")
(euler 906609 solution-004 "Largest palindrome product")
(euler 232792560 solution-005 "Smallest multiple")
(euler 25164150 solution-006 "Sum square difference")
(euler 104743 solution-007 "10001st prime")
(euler 23514624000 solution-008 "Largest product in a series")
(euler 31875000 solution-009 "Special Pythagorean triplet")
(euler 142913828922 solution-010 "Summation of primes")
(euler 70600674 solution-011 "Largest product in a grid")
(euler 5537376230 solution-013 "Large sum")
(euler 837799 solution-014 "Longest Collatz sequence")
