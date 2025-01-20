(ns gerenciadorDeDataShow.database.professorDB 
  (:require
    [gerenciadorDeDataShow.database.connection :as connection]
    [next.jdbc :as jdbc]))

(defn create-professor [professor]
  (jdbc/execute! connection/get-db 
                 ["INSERT INTO professor (matricula, nome) VALUES (?, ?)"] 
                 (:matricula professor) (:nome professor)
                 :return-keys? true))

(defn read-professor-by-name [nome]
  (jdbc/query connection/get-db ["SELECT * FROM professor WHERE nome = ?" nome]))

(defn read-professor [matricula]
  (jdbc/query connection/get-db ["SELECT * FROM professor WHERE matricula = ?" matricula]))

(defn read-all-professors []
  (jdbc/query connection/get-db ["SELECT * FROM professor"]))

(defn delete-professor [matricula]
  (jdbc/execute! connection/get-db ["DELETE FROM professor WHERE matricula = ?" matricula]))

