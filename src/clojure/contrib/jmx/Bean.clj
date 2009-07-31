(ns clojure.contrib.jmx.Bean
  (:gen-class
   :implements [javax.management.DynamicMBean]
   :init init
   :state state
   :constructors {[Object] []})
  (:import [javax.management DynamicMBean MBeanInfo]))

(defn -init [derefable]
  [[] derefable])

; TODO: rest of the arguments
(defn generate-mbean-info [_]
  (proxy [MBeanInfo] ["GeneratedClass" "Clojure Dynamic MBean" nil nil nil nil]
    ))

(defn -getMBeanInfo
  [this]
  (generate-mbean-info {}))

(defn -getAttribute
  [this attr]
  ((.state this) (keyword attr)))