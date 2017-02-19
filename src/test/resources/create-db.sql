CREATE TABLE users (
  id  INT not null primary key
      GENERATED ALWAYS AS IDENTITY
      (START WITH 1, INCREMENT BY 1),
  first_name VARCHAR(30),
  last_name  VARCHAR(30),
  address  VARCHAR(80)
);