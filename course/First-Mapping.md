# Debut des ennuis  

Nous allons donc représenter les entités User et Media ainsi que leurs association sous la forme d'une collection dans le monde objet.  
La principale problématique est lors de la manipulation d'un object User. Les Media associés soivent être correctement interprétés que ce soit en écriture ou en lecture.  

Nous allons essayer de représenter cette association dans notre hierarchie de classe.  
Pour cela nous devons réalisés un pont entre le monde Objet et le monde Relation en écrivant des méthode permettant de créer des User et Media a partir de ResultSet représentant un ensemble de tuples de base de donnée.



?[Etapes à suivre]
-[ ] User.Media : Creer la classe Media comme représentation de la table media
-[ ] User : Ajouter un attribut contacts qui est une liste de media
-[ ] User : Ajouter les getter/setter pour le nouvelle attribut contacts sur User
-[ ] UserDao.findByFirstName -> Recuperer un utilisateur par nom
-[ ] UserDao.UserMapper.mapRow : Remplir les mapper de user
-[ ] UserDao.UserMapper.mapContacts : Recuperer l'association media client
-[ ] UserDao.findByFirstName : Mapper les valeurs correctes au media de l'objet user remonté



@[Mapping JDBC]({"stubs": ["src/main/java/fr/ccavalier/hibernate/course/mapping/UserDao.java","src/main/java/fr/ccavalier/hibernate/course/mapping/User.java","src/test/resources/mapping/create-db.sql","src/test/resources/mapping/insert-data.sql"],"command": "fr.ccavalier.hibernate.course.mapping.UserDaoTest#testFindByName", "layout":"aside"})
