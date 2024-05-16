(ns spacephoenix.window.switcher
  (:require
   [spacephoenix.window.core :as window]
   [spacephoenix.message :as message]))

(defn show-numbered-windows []
  (message/alert
   (get
    (reduce
     (fn [{:keys [count result]} window]
       {:count (inc count)
        :result (str result "\n" count ": " (window/title window))})
     {:count 0 :result ""}
     (window/all))
    :result)))
