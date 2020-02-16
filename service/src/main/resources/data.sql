
INSERT INTO position (title) VALUES ('junior developer');
INSERT INTO position (title) VALUES ('middle developer');
INSERT INTO position (title) VALUES ('senior developer');
INSERT INTO position (title) VALUES ('manager');

INSERT INTO organization (name, address, city) VALUES ('Surgutneftegas', 'Gubkina', 'Surgut');
INSERT INTO organization (name, address, city) VALUES ('CFT', 'MKAD', 'Moscow');

INSERT INTO employee (fname, lname, birth_date, start_date, salary, position_id, organization_id) VALUES ('Vladimir', 'Gladkov', '1991-06-27', '2015-10-10', '100000', '1', '1');
INSERT INTO employee (fname, lname, birth_date, start_date, salary, position_id, organization_id) VALUES ('Some', 'Manager', '1989-04-24', '2016-10-10', '400000', '4', '1');
INSERT INTO employee (fname, lname, birth_date, start_date, salary, position_id, organization_id) VALUES ('Ivan', 'Petrov', '1981-03-06', '2009-10-10', '200000', '2', '2');
INSERT INTO employee (fname, lname, birth_date, start_date, salary, position_id, organization_id) VALUES ('Ivan', 'Ivanov', '1988-01-09', '2017-10-10', '300000', '3', '2');