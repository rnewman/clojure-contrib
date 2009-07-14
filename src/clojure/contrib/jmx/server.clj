;; JMX server APIs for Clojure
;; docs in clojure/contrib/jmx.clj!!

;; by Stuart Halloway

;; Copyright (c) Stuart Halloway, 2009. All rights reserved.  The use
;; and distribution terms for this software are covered by the Eclipse
;; Public License 1.0 (http://opensource.org/licenses/eclipse-1.0.php)
;; which can be found in the file epl-v10.html at the root of this
;; distribution.  By using this software in any fashion, you are
;; agreeing to be bound by the terms of this license.  You must not
;; remove this notice, or any other, from this software.

(in-ns 'clojure.contrib.jmx)

(defn register-mbean [mbean mbean-name]
  (.registerMBean *connection* mbean (as-object-name mbean-name)))

; TODO: rest of the arguments
(defn generate-mbean-info [_]
  (proxy [MBeanInfo] ["GeneratedClass" "Clojure Dynamic MBean" nil nil nil nil]
    ))

; TODO: rest of the methods
(defn dynamic-mbean [aref]
  (proxy [DynamicMBean] []
    (getMBeanInfo [] (generate-mbean-info {}))
    (getAttribute [attr] (@aref (keyword attr)))))
