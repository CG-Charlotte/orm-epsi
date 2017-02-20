CREATE TABLE PRODUITS (
  id  INT not null primary key
      GENERATED ALWAYS AS IDENTITY
      (START WITH 1, INCREMENT BY 1),
 LIBELLE varchar(30),
 STOCK integer,
 PRIXINVENT integer
);

CREATE TABLE FOURNISSEURS (
      id  INT not null primary key
              GENERATED ALWAYS AS IDENTITY
      (START WITH 1, INCREMENT BY 1),
    NOM varchar(30),
    VILLE varchar(30));


create TABLE ACHETER
(ID_FOUR int references FOURNISSEURS(id),
ID_PROD int references PRODUITS(id),
PRIXACHAT float,
DELAI int) ;