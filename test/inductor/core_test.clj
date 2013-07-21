(ns inductor.core-test
  (:require [clojure.test :refer :all]
            [inductor.core :refer :all]))

(deftest a-test
  (testing "FIXME, I fail."
    (is (= 0 1))))

(deftest test-syspack
  (testing "Testing packing a sysex message")
    (is (= (read-string "0xF0")))
)
