USE human_friends;


SET FOREIGN_KEY_CHECKS=0;
DROP TABLE IF EXISTS animal_groups;
SET FOREIGN_KEY_CHECKS=1;
CREATE TABLE animal_groups
(
group_id INT PRIMARY KEY AUTO_INCREMENT,
group_name VARCHAR(25)
);

INSERT INTO animal_groups (group_name) VALUES
('Home animals'),
('Pack animals');

SET FOREIGN_KEY_CHECKS=0;
DROP TABLE IF EXISTS home_animals;
SET FOREIGN_KEY_CHECKS=1;
CREATE TABLE home_animals
(
type_id INT PRIMARY KEY AUTO_INCREMENT,
group_id INT,
type_name VARCHAR(25),
FOREIGN KEY (group_id) REFERENCES animal_groups(group_id)
);

INSERT INTO home_animals (group_id, type_name) VALUES
('1', 'Dog'),
('1', 'Cat'),
('1', 'Hamster');

SET FOREIGN_KEY_CHECKS=0;
DROP TABLE IF EXISTS pack_animals;
SET FOREIGN_KEY_CHECKS=1;
CREATE TABLE pack_animals
(
type_id INT PRIMARY KEY AUTO_INCREMENT,
group_id INT,
type_name VARCHAR(25),
FOREIGN KEY (group_id) REFERENCES animal_groups(group_id)
);

INSERT INTO pack_animals (group_id, type_name) VALUES
('2', 'Horse'),
('2', 'Camel'),
('2', 'Donkey');

DROP TABLE IF EXISTS dogs;
CREATE TABLE dogs
(
group_id INT,
type_id INT,
animal_id INT PRIMARY KEY AUTO_INCREMENT,
animal_name VARCHAR(25),
commands VARCHAR(100),
birth_date DATE,
FOREIGN KEY (group_id) REFERENCES animal_groups(group_id),
FOREIGN KEY (type_id) REFERENCES home_animals(type_id)
);

INSERT INTO dogs (group_id, type_id, animal_name, commands, birth_date) VALUES
('1', '1', 'Жучка', 'сидеть, лежать', '2021-12-01'),
('1', '1', 'Бобик', 'сидеть, лежать, голос', '2020-01-01'),
('1', '1', 'Мухтар', 'сидеть, лежать, голос, рядом', '2023-12-01');

DROP TABLE IF EXISTS cats;
CREATE TABLE cats
(
group_id INT,
type_id INT,
animal_id INT PRIMARY KEY AUTO_INCREMENT,
animal_name VARCHAR(25),
commands VARCHAR(100),
birth_date DATE,
FOREIGN KEY (group_id) REFERENCES animal_groups(group_id),
FOREIGN KEY (type_id) REFERENCES home_animals(type_id)
);

INSERT INTO cats (group_id, type_id, animal_name, commands, birth_date) VALUES
('1', '2', 'Мурзик', 'кушать', '2021-11-02'),
('1', '2', 'Барсик', 'кушать, гулять', '2020-02-02'),
('1', '2', 'Мурка', '', '2023-11-02');

DROP TABLE IF EXISTS hamsters;
CREATE TABLE hamsters
(
group_id INT,
type_id INT,
animal_id INT PRIMARY KEY AUTO_INCREMENT,
animal_name VARCHAR(25),
commands VARCHAR(100),
birth_date DATE,
FOREIGN KEY (group_id) REFERENCES animal_groups(group_id),
FOREIGN KEY (type_id) REFERENCES home_animals(type_id)
);

INSERT INTO hamsters (group_id, type_id, animal_name, commands, birth_date) VALUES
('1', '3', 'Виталий', 'команда_1, команда_2', '2021-10-03'),
('1', '3', 'Пиппа', 'команда_2', '2020-10-03');

DROP TABLE IF EXISTS horses;
CREATE TABLE horses
(
group_id INT,
type_id INT,
animal_id INT PRIMARY KEY AUTO_INCREMENT,
animal_name VARCHAR(25),
commands VARCHAR(100),
birth_date DATE,
FOREIGN KEY (group_id) REFERENCES animal_groups(group_id),
FOREIGN KEY (type_id) REFERENCES pack_animals(type_id)
);

INSERT INTO horses (group_id, type_id, animal_name, commands, birth_date) VALUES
('2', '1', 'Буран', 'вперед, стой', '2021-09-04'),
('2', '1', 'Звезда', 'вперед, стой, галоп', '2020-09-04');

DROP TABLE IF EXISTS camels;
CREATE TABLE camels
(
group_id INT,
type_id INT,
animal_id INT PRIMARY KEY AUTO_INCREMENT,
animal_name VARCHAR(25),
commands VARCHAR(100),
birth_date DATE,
FOREIGN KEY (group_id) REFERENCES animal_groups(group_id),
FOREIGN KEY (type_id) REFERENCES pack_animals(type_id)
);

INSERT INTO camels (group_id, type_id, animal_name, commands, birth_date) VALUES
('2', '2', 'Махмут', 'вперед, стой, ложись', '2021-08-05'),
('2', '2', 'Царица', '', '2020-08-05');

DROP TABLE IF EXISTS donkeys;
CREATE TABLE donkeys
(
group_id INT,
type_id INT,
animal_id INT PRIMARY KEY AUTO_INCREMENT,
animal_name VARCHAR(25),
commands VARCHAR(100),
birth_date DATE,
FOREIGN KEY (group_id) REFERENCES animal_groups(group_id),
FOREIGN KEY (type_id) REFERENCES pack_animals(type_id)
);

INSERT INTO donkeys (group_id, type_id, animal_name, commands, birth_date) VALUES
('2', '3', 'Иа', 'вперед', '2022-01-06'),
('2', '3', 'Донки', 'вперед, стой, назад', '2021-07-06');

TRUNCATE TABLE camels;

DROP TABLE IF EXISTS horses_n_donkeys;
CREATE TABLE horses_n_donkeys AS
SELECT * FROM horses
UNION
SELECT * FROM donkeys;

DROP TABLE IF EXISTS temp_animals;
CREATE TEMPORARY TABLE temp_animals AS
SELECT * FROM dogs UNION
SELECT * FROM cats UNION 
SELECT * FROM hamsters UNION
SELECT * FROM horses_n_donkeys;

ALTER TABLE temp_animals
ADD COLUMN age_years INT DEFAULT 0;

SET SQL_SAFE_UPDATES=0;
UPDATE temp_animals
SET age_years = TIMESTAMPDIFF(YEAR, birth_date, NOW());

DROP TABLE IF EXISTS young_animals;
CREATE TABLE young_animals AS
SELECT 
concat(group_id, type_id, animal_id) AS uniq_num, 
t_a.*
FROM temp_animals t_a
WHERE age_years > 1 AND age_years < 3;

ALTER TABLE young_animals
ADD COLUMN age_months INT DEFAULT 0;

UPDATE young_animals
SET age_months = TIMESTAMPDIFF(MONTH, birth_date, NOW());

SELECT all_types.*, a_g.group_name
FROM
(
SELECT all_a.*, y_a.age_months AS young_animal_month_age
FROM
(
SELECT concat(dg.group_id, dg.type_id, dg.animal_id) AS uniq_num, dg.*, h_a.type_name FROM dogs dg LEFT JOIN home_animals h_a ON dg.type_id = h_a.type_id
UNION
SELECT concat(ct.group_id, ct.type_id, ct.animal_id) AS uniq_num, ct.*, h_a.type_name FROM cats ct LEFT JOIN home_animals h_a ON ct.type_id = h_a.type_id
UNION
SELECT concat(hm.group_id, hm.type_id, hm.animal_id) AS uniq_num, hm.*, h_a.type_name FROM hamsters hm LEFT JOIN home_animals h_a ON hm.type_id = h_a.type_id
UNION
SELECT concat(hd.group_id, hd.type_id, hd.animal_id) AS uniq_num, hd.*, p_a.type_name FROM horses_n_donkeys hd LEFT JOIN pack_animals p_a ON hd.type_id = p_a.type_id
) 
AS all_a
LEFT JOIN
young_animals y_a
ON all_a.uniq_num = y_a.uniq_num
)
AS all_types
LEFT JOIN
animal_groups a_g
ON all_types.group_id = a_g.group_id;




