# Блок 2. Объектно-ориентированное программирование + SQL

## Задания

6. Нарисовать диаграмму, в которой есть класс родительский класс, домашние
животные и вьючные животные, в составы которых в случае домашних
животных войдут классы: собаки, кошки, хомяки, а в класс вьючные животные
войдут: Лошади, верблюды и ослы.

### Решение задачи 6

![Диаграмма классов](./img/Диаграмма%20без%20названия.drawio.png)

7. В подключенном MySQL репозитории создать базу данных “Друзья человека”

```sql
CREATE DATABASE animalsFriends;

USE animalsFriends;
```

8. Создать таблицы с иерархией из диаграммы в БД

```sql
CREATE TABLE animals
(
	id INT AUTO_INCREMENT PRIMARY KEY,
	animal_type VARCHAR(30)
);

INSERT INTO animals (animal_type)
VALUES ('Домашние животные'), ('Вьючные животные');

CREATE TABLE pets
(
	id INT AUTO_INCREMENT PRIMARY KEY,
	animal_kind VARCHAR(30),
	animal_type_id INT DEFAULT 1,
	FOREIGN KEY (animal_type_id) REFERENCES animals (id) ON DELETE CASCADE ON UPDATE CASCADE
);

INSERT INTO pets (animal_kind)
VALUES ('Собаки'), ('Кошки'), ('Хомяки');

CREATE TABLE pack_animals
(
	id INT AUTO_INCREMENT PRIMARY KEY,
	animal_kind VARCHAR(30),
	animal_type_id INT DEFAULT 2,
	FOREIGN KEY (animal_type_id) REFERENCES animals (id) ON DELETE CASCADE ON UPDATE CASCADE
);

INSERT INTO pack_animals (animal_kind)
VALUES ('Лошади'), ('Верблюды'), ('Ослы');
```

9. Заполнить низкоуровневые таблицы именами(животных), командами которые они выполняют и датами рождения

```sql
CREATE TABLE dogs 
(       
    id INT AUTO_INCREMENT PRIMARY KEY, 
    name VARCHAR(30), 
    commands VARCHAR(100),
    birthday DATE,
    animal_kind_id INT DEFAULT 1,
    Foreign KEY (animal_kind_id) REFERENCES pets (id) ON DELETE CASCADE ON UPDATE CASCADE
);

INSERT INTO dogs (name, commands, birthday)
VALUES ('Старк', 'лежать, сидеть', '2021-05-28'),
('Бобик', 'дай лапу, фас', '2016-05-08'),
('Снежок', 'место, голос', '2020-03-25');

CREATE TABLE cats 
(       
    id INT AUTO_INCREMENT PRIMARY KEY, 
    name VARCHAR(30), 
    commands VARCHAR(100),
    birthday DATE,
    animal_kind_id INT DEFAULT 2,
    Foreign KEY (animal_kind_id) REFERENCES pets (id) ON DELETE CASCADE ON UPDATE CASCADE
);

INSERT INTO cats (name, commands, birthday)
VALUES ('Мурзик', 'стоять', '2021-03-14'),
('Мурка', 'дай лапу', '2017-03-09'),
('Кузя', 'ко мне', '2019-02-21');

CREATE TABLE hamsters 
(       
    id INT AUTO_INCREMENT PRIMARY KEY, 
    name VARCHAR(30), 
    commands VARCHAR(100),
    birthday DATE,
    animal_kind_id INT DEFAULT 3,
    Foreign KEY (animal_kind_id) REFERENCES pets (id) ON DELETE CASCADE ON UPDATE CASCADE
);

INSERT INTO hamsters (name, commands, birthday)
VALUES ('Рыжик', 'стоять', '2021-06-11'),
('Умка', 'гулять', '2016-02-19'),
('Черныш', 'кушать', '2019-04-21');

CREATE TABLE horses 
(       
    id INT AUTO_INCREMENT PRIMARY KEY, 
    name VARCHAR(30), 
    commands VARCHAR(100),
    birthday DATE,
    animal_kind_id INT DEFAULT 1,
    Foreign KEY (animal_kind_id) REFERENCES pack_animals (id) ON DELETE CASCADE ON UPDATE CASCADE
);

INSERT INTO horses (name, commands, birthday)
VALUES ('Призрак', 'тише, хоп, вперед', '2021-03-12'),
('Орхидея', 'стой, рысь, шагом', '2016-05-15'),
('Кондор', 'стой, шагом, хоп', '2018-02-27');

CREATE TABLE camels 
(       
    id INT AUTO_INCREMENT PRIMARY KEY, 
    name VARCHAR(30), 
    commands VARCHAR(100),
    birthday DATE,
    animal_kind_id INT DEFAULT 2,
    Foreign KEY (animal_kind_id) REFERENCES pack_animals (id) ON DELETE CASCADE ON UPDATE CASCADE
);

INSERT INTO camels (name, commands, birthday)
VALUES ('Лила', 'гит, дурр', '2021-02-15'),
('Хлоя', 'дурр', '2016-11-05'),
('Джоси', 'каш, гит', '2017-07-21');

CREATE TABLE donkeys 
(       
    id INT AUTO_INCREMENT PRIMARY KEY, 
    name VARCHAR(30), 
    commands VARCHAR(100),
    birthday DATE,
    animal_kind_id INT DEFAULT 3,
    Foreign KEY (animal_kind_id) REFERENCES pack_animals (id) ON DELETE CASCADE ON UPDATE CASCADE
);

INSERT INTO donkeys (name, commands, birthday)
VALUES ('Чоко', 'вперед, стоять', '2020-03-19'),
('Денвер', 'идти, стоять', '2017-10-15'),
('Изабель', 'шагом, вперед', '2022-08-24');
```

10. Удалив из таблицы верблюдов, т.к. верблюдов решили перевезти в другой
питомник на зимовку. Объединить таблицы лошади, и ослы в одну таблицу.

```sql
DELETE FROM camels;

CREATE TABLE horses_and_donkeys SELECT * FROM horses
UNION SELECT * FROM donkeys;
```

11. Создать новую таблицу “молодые животные” в которую попадут все
животные старше 1 года, но младше 3 лет и в отдельном столбце с точностью
до месяца подсчитать возраст животных в новой таблице

```sql
CREATE TEMPORARY TABLE all_animals
SELECT * FROM dogs
UNION SELECT * FROM cats
UNION SELECT * FROM hamsters
UNION SELECT * FROM horses
UNION SELECT * FROM camels
UNION SELECT * FROM donkeys;

CREATE TABLE young_animals
SELECT name, commands, birthday, animal_kind_id, TIMESTAMPDIFF(MONTH, birthday, CURDATE()) AS age_in_month
FROM all_animals
WHERE birthday BETWEEN ADDDATE(CURDATE(), INTERVAL -3 YEAR) AND ADDDATE(CURDATE(), INTERVAL -1 YEAR);
```

12. Объединить все таблицы в одну, при этом сохраняя поля, указывающие на
прошлую принадлежность к старым таблицам.

```sql
CREATE TABLE Animals LIKE Horses;

ALTER TABLE Animals
ADD type Varchar(20);

ALTER TABLE Animals
ADD species Varchar(20);

INSERT INTO Animals (name, birthDate, weight, color, type, species)
SELECT  name, birthDate, weight, color, 'Pet', 'Dog' From Dogs;
INSERT INTO Animals (name, birthDate, weight, color, type, species)
SELECT  name, birthDate, weight, color, 'Pet', 'Cat' From Cats;
INSERT INTO Animals (name, birthDate, weight, color, type, species)
SELECT  name, birthDate, weight, color, 'Pet', 'Hamster' From Hamsters;
INSERT INTO Animals (name, birthDate, weight, color, type, species)
SELECT  name, birthDate, weight, color, 'PackAnimal', 'Horse' From Horses;
INSERT INTO Animals (name, birthDate, weight, color, type, species)
SELECT  name, birthDate, weight, color, 'PackAnimal', 'Donckey' From Donkeys;
INSERT INTO Animals (name, birthDate, weight, color, type, species)
SELECT  name, birthDate, weight, color, 'PackAnimal', 'Camel' From Camels;
```