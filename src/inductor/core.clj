(ns inductor.core 
  (:use [gloss core io]
        [clojure.java.io]
        [overtone/midi-clj :as midi]))

;; (defn read-from-file [buffer filename] 
;;   (.read (input-stream filename) buffer))

;; (defn read-from-string [buffer sbytes]

;; )

;; (.read (input-stream "test/data/PJPfiles_2011.syx") buffer-8bit)
;; (decode example-codec buffer-8bit)

;;(encode example-codec {:id 42, :msg-type :a, :status "A-OKAY"})

;;(ns inductor.sysex (:use gloss.core))

;; microKORG format
;; F0: exclusive status
;; 42: Korg ID
;; 3n: [n=0—F] MIDI channel
;; 58: microKORG model ID (same as MS2000/MS2000R) ff: function ID (type of message)
;; —
;; F7: end of exclusive

(defcodec hdr (enum :ubyte { :hdr 0xF0 }))
(defcodec vendor (enum :ubyte { :korg 0x42 }))
(defcodec model (enum :ubyte { :microkorg 0x58 }))
(defcodec device (enum :ubyte :device ))

;; (defmacro system-exclusive-header)
;; (defmacro system-exclusive-footer)

(defcodec req (enum :ubyte { :send 0x12 :recv 0x11 }))

;; (defcodec address ())

;; (defcodec address) ;; the address of the setting 
;; (defcodec param) ;; the parameter we're sending (only for req=0x12)
;; (defcodec roland-checksum) 

(defcodec footer (enum :ubyte { :ftr 0xf7 }))

;; write macro to define sysex messages

;; define a series of frames that defines a sysex commands
;; (defcodec microkorg-current-program-datadump)

;; define a series of frames that describes a sysex response

;; (defcodec tag-byte-array
;;   (ordered-map :tag-type    :TAG_Byte_Array
;;                :payload (repeated :byte :prefix :int32-be)))

(defn get-send-codec [t]
  "Gets the correct codec for a command"
  )

