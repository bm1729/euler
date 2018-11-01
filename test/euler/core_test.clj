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
             [problem-014 :refer :all]
             [problem-015 :refer :all]
             [problem-016 :refer :all]
             [problem-017 :refer :all]
             [problem-018 :refer :all]
             [problem-019 :refer :all]
             [problem-020 :refer :all]
             [problem-021 :refer :all]
             [problem-022 :refer :all]
             [problem-023 :refer :all]
             [problem-024 :refer :all]
             [problem-025 :refer :all]
             [problem-026 :refer :all]
             [problem-027 :refer :all]
             [problem-028 :refer :all]
             [problem-029 :refer :all]
             [problem-030 :refer :all]
             [problem-031 :refer :all]
             [problem-032 :refer :all]]))

(def problem-times (atom nil))

(defn setup
  [f]
  (reset! problem-times {})
  (f)
  (doseq [[problem-number time-taken] (->> @problem-times
                                           (sort-by second)
                                           reverse)]
    (printf "%s: %.3f ms\n\n" problem-number time-taken))
  (printf "Total time taken: %.3f ms\n\n" (->> @problem-times
                                               (map second)
                                               (reduce +))))

(use-fixtures :once setup)

(defmacro euler
  [expected solution-fn description]
  `(deftest ~(symbol (str "testing-" solution-fn))
     (testing ~description
       (let [start-ns# (. java.lang.System (nanoTime))
             problem-number# ~(str solution-fn)]
         (is (= ~expected (~solution-fn)))
         (let [time-taken-ns# (- (. java.lang.System (nanoTime)) start-ns#)
               time-taken-ms# (/ time-taken-ns# 1000.0 1000.0)]
           (swap! problem-times #(assoc % problem-number# time-taken-ms#))
           (is (< time-taken-ms# 10000.0)))))))

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
(euler 76576500 solution-012 "Highly divisible triangular number")
(euler 5537376230 solution-013 "Large sum")
(euler 837799 solution-014 "Longest Collatz sequence")
(euler 137846528820 solution-015 "Lattice paths")
(euler 1366 solution-016 "Power digit sum")
(euler 21124 solution-017 "Number letter counts")
(euler 1074 solution-018 "Maximum path sum I")
(euler 171 solution-019 "Counting Sundays")
(euler 648 solution-020 "Factorial digit sum")
(euler 31626 solution-021 "Amicable numbers")
(euler 871198282 solution-022 "Names scores")
(euler 4179871 solution-023 "Non-abundant sums")
(euler 2783915460 solution-024 "Lexicographic permutations")
(euler 4782 solution-025 "1000-digit Fibonacci number")
(euler 983 solution-026 "Reciprocal cycles")
(euler -59231 solution-027 "Quadratic primes")
(euler 669171001 solution-028 "Number spiral diagonals")
(euler 9183 solution-029 "Distinct powers")
(euler 443839 solution-030 "Digit fifth powers")
(euler 73682 solution-031 "Coin sums")
(euler 45228 solution-032 "Pandigital products")
