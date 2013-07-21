(ns overtone.device.midi.microkorg
  (:use [overtone.midi]
        [overtone.libs.event :only [event on-event on-latest-event]]
        [overtone.core :only [control-bus control-bus-set!]]
        [inductor.sysex]))

(defrecord Microkorg [name out interfaces state buses])

