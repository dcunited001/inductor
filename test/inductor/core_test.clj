(ns inductor.core-test
  (:require [clojure.test :refer :all]
            [inductor.core :refer :all]))


(ns inductor.sysex-test
  (:require [clojure.test :refer :all]
            [inductor.sysex :refer :all]))

(ns gloss.test.bytes
  (:use
    [gloss.data bytes]
    [gloss.data.bytes.delimited :only (delimited-bytes-splitter)]
    [gloss.core formats])
  (:use [clojure test])
  (:import [java.nio ByteBuffer]))

(defn byte-seq [^ByteBuffer buf]
  (let [buf (duplicate buf)]
    (lazy-seq
      (when (.hasRemaining buf)
        (cons (.get buf) (byte-seq buf))))))
