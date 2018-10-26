(ns euler.problems.problem-019
  (:require [euler.utils :refer :all]))

(defn- days-of-month
  [days-per-month]
  (range 1 (inc days-per-month)))

(defn- leap?
  [year]
  (divides? year 4))

(defn- days-of-month-for-year
  [year]
  (let [february (if (leap? year) (days-of-month 29) (days-of-month 28))]
    (concat (days-of-month-for-year 31)
            february
            (days-of-month 31)
            (days-of-month 30)
            (days-of-month 31)
            (days-of-month 30)
            (days-of-month 31)
            (days-of-month 31)
            (days-of-month 30)
            (days-of-month 31)
            (days-of-month 30)
            (days-of-month 31))))

(defn solution-019
  []
  (->> (range 1901 2001)
       (mapcat days-of-month-for-year)
       (map vector (cycle [3 4 5 6 7 1 2]))                 ;; 1st Jan 1901 was a Tuesday
       (filter (fn [[day-of-week day-of-month]] (= 1 day-of-week day-of-month)))
       count))