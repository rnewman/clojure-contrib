; making the REPL nicer
(use 'clojure.test
     'clojure.contrib.java-utils
     'clojure.contrib.seq-utils
     'clojure.contrib.repl-utils
     'clojure.contrib.duck-streams
     'clojure.contrib.def
     'clojure.contrib.lazy-xml)
(import 'clojure.contrib.jmx.Bean)
(require '[clojure.contrib.jmx :as jmx])

(def demo-name "clojure.contrib.test_contrib.test_jmx:name=Foo")
(def demo-ref (ref {:foobar 10}))
(def demo-bean (Bean. demo-ref))
(def demo-oname (jmx/register-mbean demo-bean demo-name))
  
  