(ns overtone.device.midi.radias
  (:use [overtone.midi]
        [overtone.libs.event :only [event on-event on-latest-event]]
        [overtone.core :only [control-bus control-bus-set!]]))

(defrecord Radias [name out interfaces state buses])

