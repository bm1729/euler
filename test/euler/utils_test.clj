(ns euler.utils-test
  (:require [euler.utils :as target]
            [clojure.test :refer :all]
            [clojure.spec.alpha :as s]
            [clojure.spec.test.alpha :as stest]))

(s/fdef target/decompose-number
        :args (s/cat :n nat-int?)
        :ret (s/and coll? seq)
        :fn (fn [{{n :n} :args ret :ret}]
              (= n (target/compose-number ret))))

(deftest number-composition-decomposition
  (let [{check-failed :check-failed no-of-tests :total} (-> `target/decompose-number
                                                            stest/check
                                                            stest/summarize-results)]
    (is (nil? check-failed))
    (is (< 0 no-of-tests))))

(deftest divides?
  (is (target/divides? 10 10))
  (is (target/divides? 10 5))
  (is (target/divides? 10 2))
  (is (target/divides? 10 1))
  (is (not (target/divides? 10 3)))
  (is (not (target/divides? 10 4))))

(deftest power
  (is (= 1 (target/power 2 0)))
  (is (= 2 (target/power 2 1)))
  (is (= 4 (target/power 2 2)))
  (is (= 8 (target/power 2 3)))
  (is (= 1267650600228229401496703205376N (target/power 2 100))))

(deftest square
  (is (= 1 (target/square -1)))
  (is (= 0 (target/square 0)))
  (is (= 1 (target/square 1)))
  (is (= 4 (target/square 2)))
  (is (= 1234567901234567654320987654321N (target/square 1111111111111111))))

(deftest factorial
  (is (= 1 (target/factorial 0)))
  (is (= 1 (target/factorial 1)))
  (is (= 2 (target/factorial 2)))
  (is (= 6 (target/factorial 3)))
  (is (= 265252859812191058636308480000000N (target/factorial 30))))

(deftest factors
  (is (= #{1} (into #{} (target/factors 1))))
  (is (= #{1 2} (into #{} (target/factors 2))))
  (is (= #{1 3 9} (into #{} (target/factors 9))))
  (is (= #{1 2 4 7 14 28} (into #{} (target/factors 28)))))

(deftest number-of-digits
  (is (= 1 (target/number-of-digits 1)))
  (is (= 2 (target/number-of-digits 10)))
  (is (= 7 (target/number-of-digits 1000000))))

(deftest sum-of-digits
  (is (= 0 (target/sum-of-digits 0)))
  (is (= 1 (target/sum-of-digits 1)))
  (is (= 10 (target/sum-of-digits 1234))))

(deftest fibonacci-sequence
  (is (= [0 1 1 2 3 5 8 13 21 34] (take 10 (target/fibonacci-sequence)))))

(deftest max-by
  (is (= "seventeen" (target/max-by count ["one" "two" "three" "four" "five" "six" "seven" "eight" "nine" "ten"
                                           "eleven" "twelve" "thirteen" "fourteen" "fifteen" "sixteen" "seventeen"
                                           "eighteen" "nineteen" "twenty"]))))