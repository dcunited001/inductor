(ns inductor.core
  (:require gloss.core))

(ns inductor.sysex)

;; sample sysex msg
;; sysex_msg = [0xF0, 0x41, 0x10, 0x42, 0x12, 0x40, 0x00, 0x7F, 0x00, 0x41, 0xF7]

(defcodec header (enum :byte { :hdr 0xf0 }))
(defcodec vendor (enum :byte { :korg 0x42 )))
(defcodec model (enum :byte { :microkorg 0x3g }))
(defcodec device (enum :byte { :master 0x58 }))
(defcodec req (enum :byte { :send 0x12
                            :recv 0x11 }))
;; (defcodec address) ;; the address of the setting 
;; (defcodec param) ;; the parameter we're sending (only for req=0x12)
;; (defcodec roland-checksum) 

(defcodec footer (enum :byte { :ftr 0xf7 }))

;; write macro to define sysex messages

;; define a series of frames that defines a sysex commands
;; (defcodec microkorg-current-program-datadump)

;; define a series of frames that describes a sysex response

;;
;; (defcodec tag-byte-array
;;   (ordered-map :tag-type    :TAG_Byte_Array
;;                :payload (repeated :byte :prefix :int32-be)))



