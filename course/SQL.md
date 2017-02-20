# Rappels

Apres ce rapide avant goût nous allons essayer deux requêtes à peine plus complexes.

Soit le modele physique suivant:
![Modele](https://github.com/CCavalier/orm-epsi/blob/master/course/PRODUITS-FOURNISSEURS.jpg?raw=true)

A partir de celui ci remplissez les requetes manquantes dans l'editeur.

La premiere requete doit retourner les numéros et libellés des articles dont le stock est inférieur à 10.
La deuxieme retournera les noms et adresses des fournisseurs qui proposent des articles
pour lesquels le délai d'approvisionnement est supérieur à 20 jours.


@[First Exercise]({"stubs": ["src/main/java/fr/ccavalier/hibernate/course/Requests.java","src/test/resources/products-db.sql","src/test/resources/products-data.sql"],"command": "fr.ccavalier.hibernate.course.RequestsTest#findNameQuantityInf10", "layout":"aside"})
