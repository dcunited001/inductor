;; check overtone/midi-clj library for example of converting byte-string to byte-seq
;; - check defn midi-clj/midi-sysex
;; - check defn midi-clj/midi
;; - check defn midi-clj/midi-mk-sysex-msg
;; - check defn midi-clj/midi-mk-byte-array

;; testing will require reading/writing binary files
;; - http://stackoverflow.com/questions/749871/how-to-parse-binary-files-in-clojure
;; - http://stackoverflow.com/questions/13080418/parse-a-little-endian-binary-file-stuffing-into-a-matrix

;; is MIDI/Sysex big-endian or little-endian?
;; - i think big-endian, but not sure

(ns inductor.core-test
  (:require [clojure.test :refer :all]
            [inductor.core :refer :all]))

;; microkorg requests
;; 10 - current program data dump request
;; 1C - program data dump request
;; 0E - global data dump request
;; 0F - all data (program,global) dump request

;; microkorg dumps
;; 40 - current program data dump
;; 4C - program data dump
;; 51 - global data dump
;; 50 - all data (program,global) dump

;; microkorg program write requests
;; 11 - program write request

;; microkorg receive only
;; 26 - receive data format error
;; 23 - data load completed
;; 24 - data load error
;; 21 - write completed
;; 22 - write error

(def microkorg-sysex
  { :current-program { 
                      :data-dump-request "F0 42 30 58 10 F7"
                      ;;:data-dump         "F0 42 30 58 40 F7" 
                      }
    :program {
              :data-dump-request "F0 42 30 58 1C F7"
              ;;:data-dump         "F0 42 30 58 4C F7" 
              }
    :global {
             :data-dump-request "F0 42 30 58 0E F7"
             ;;:data-dump         "F0 42 30 58 51 F7" 
             }
    :all-data {
               :data-dump-request "F0 42 30 58 0F F7"
               ;;:data-dump         "F0 42 30 58 11 F7" 
               }
   })

;; (ns inductor.sysex-test
;;   (:require [clojure.test :refer :all]
;;             [inductor.sysex :refer :all]))

;; ==========================================
;; reading/writing data with gloss
;; ==========================================

;;(defcodec example-codec
;;   [:id       :uint32
;;    :msg-type (enum :byte {:a \A, :b \B})
;;    :status   (string :ascii :length 11)])

;; (def buffer (byte-array 16))

;; (.read (input-stream "filename.bin") buffer)
;; (decode example-codec buffer)
;; (encode example-codec {:id 42, :msg-type :a, :status "A-OKAY"})

;; ==========================================
;; reading a string into an input-stream
;; ==========================================
;; - http://stackoverflow.com/questions/4855012/clojure-how-do-i-create-a-input-stream-that-reads-from-a-string-instead-of-a-fi
;; - with-in-str - http://clojure.github.io/clojure/clojure.core-api.html#clojure.core/with-in-str
;; - input-stream - http://richhickey.github.io/clojure/clojure.java.io-api.html
