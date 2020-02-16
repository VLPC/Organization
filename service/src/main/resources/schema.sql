CREATE TABLE position (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  title VARCHAR(250) NOT NULL
);

CREATE TABLE organization (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  address VARCHAR(250) NOT NULL,
  city VARCHAR(250) NOT NULL
);

CREATE TABLE employee (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  fname VARCHAR(250) NOT NULL,
  lname VARCHAR(250) NOT NULL,
  birth_date DATE NOT NULL,
  start_date DATE NOT NULL,
  salary DOUBLE NOT NULL,
  position_id INT NOT NULL,
  organization_id INT NOT NULL,
  CONSTRAINT fk_position FOREIGN KEY (position_id) REFERENCES position (id),
  CONSTRAINT fk_organization FOREIGN KEY (organization_id) REFERENCES organization (id)
);