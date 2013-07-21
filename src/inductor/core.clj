(ns inductor.core
  (:require gloss.core))

(ns inductor.sysex)

;; sample sysex msg
;; sysex_msg = [0xF0, 0x41, 0x10, 0x42, 0x12, 0x40, 0x00, 0x7F, 0x00, 0x41, 0xF7]

(defcodec header (enum :byte { :hdr 0xf0 }))
(defcodec vendor (enum :byte { :korg 0x72 )))

;; (defn header?)

;;
;; (defcodec tag-byte-array
;;   (ordered-map :tag-type    :TAG_Byte_Array
;;                :payload (repeated :byte :prefix :int32-be)))



