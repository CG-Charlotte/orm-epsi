# Rappels

Apres ce rapide avant goût nous allons essayer deux requêtes à peine plus complexes.

Soit le modele physique suivant:


![Modele](https://github.com/CCavalier/orm-epsi/blob/master/course/PRODUITS-FOURNISSEURS.jpg?raw=true)

A partir de celui ci remplissez les requetes manquantes dans l'editeur.

La premiere requete doit retourner les numéros et libellés des articles dont le stock est inférieur à 10.
La deuxieme retournera les noms et adresses des fournisseurs qui proposent des articles
pour lesquels le délai d'approvisionnement est supérieur à 20 jours.


@[First Exercise]({"stubs": ["src/main/java/fr/ccavalier/hibernate/course/requests/Requests.java","src/test/resources/requests/products-db.sql","src/test/resources/requests/products-data.sql"],"command": "fr.ccavalier.hibernate.course.requests.RequestsTest#test_findNameQuantityInf10", "layout":"aside"})

@[Second Exercise]({"stubs": ["src/main/java/fr/ccavalier/hibernate/course/requests/Requests.java","src/test/resources/requests/products-db.sql","src/test/resources/requests/products-data.sql"],"command": "fr.ccavalier.hibernate.course.requests.RequestsTest#test_findFourDelaiSup20", "layout":"aside"})

Enfin vous completerez la requete qui supprime les fraises de la table produits

@[Troisieme Exercise]({"stubs": ["src/main/java/fr/ccavalier/hibernate/course/requests/Requests.java","src/test/resources/requests/products-db.sql","src/test/resources/requests/products-data.sql"],"command": "fr.ccavalier.hibernate.course.requests.RequestsTest#test_delete", "layout":"aside"})


## Syntaxe Requete SQL

Petit Rappel sur les requetes sql:


![Request](http://2.bp.blogspot.com/-taKaY43cWi4/UNbyD7tHSVI/AAAAAAAAGtg/O0S350z_4oQ/s1600/sql-selection.png)