# Rappels

Avant de pouvoir decouvrir les forces de l'ORM, il est necessaire de faire quelques rappels de SQL.

## Qu'est ce que le SQL
Le SQL, 'Structured Query Language', est un langage de programmation concu pour manipuler les données stockées dans des
bases de données relationnelles. Celui ci permet de concerver l'integrité et la cohérence des données en base, peut importe
leur volume.

Bien qu'aujourd'hui son usage tende à legerement diminuer, grace à l'usage de base de données NoSql, il reste un standanrd de fait,
utilisé sur la totalité des systèmes d'information.


Il est important de bien maitriser son usage avant de s'en abstraire. Nous pourrons ainsi faire un meilleur usage des outils de plus haut niveau.

## Premier Exemple
Essayons de modifier cette application JAVA de facon à recuperer la totalité des utilisateurs de la base.
@[First Exercise]({"stubs": ["src/main/java/fr/ccavalier/hibernate/course/UsersDao.java","src/test/resources/pinguin.jpg","src/test/resources/create-db.sql","src/test/resources/insert-data.sql"],"command": "fr.ccavalier.hibernate.course.UsersDaoTest#testFindAll"})



