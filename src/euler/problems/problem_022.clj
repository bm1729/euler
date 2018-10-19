(ns euler.problems.problem-022
  (:require [clojure.string :as str]))

(defn- name-score
  [name]
  (reduce + (map (zipmap "ABCDEFGHIJKLMNOPQRSTUVWXYZ" (iterate inc 1)) name)))

(defn read-file
  []
  (map #(str/replace % #"\"" "") (str/split (slurp "resources/p022_names.txt") #"\,")))

(defn solution-022
  []
  (->> (read-file)
       sort
       (map (fn [idx name] (* idx (name-score name))) (iterate inc 1))
       (reduce +)))
