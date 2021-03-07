--
-- DELETE ALL DATA FROM ALL TABLES
--
DELETE FROM caretaker_pets;
DELETE FROM pets;
DELETE FROM caretakers;
DELETE FROM vets;
DELETE FROM cities; 


--
-- INSERTING CITIES
--
INSERT INTO cities (zip_code, city_name) 
VALUES 
    ('6969', 'Hogwarts'),
    ('0420', 'Nemoland'),
    ('0300', 'Sparta'),
    ('0666', 'Hell');

--
-- INSERTING VETS (with city reference)
--
INSERT INTO vets (cvr, name, phone, street, fk_zip_code) 
VALUES 
    ('69696969', 'WartHogs inc.', '093487694321', 'Diagonalley 9 3/4', '6969'),
    ('42004200', 'Helping Nemo ApS', '004512345678', 'High st. 420', '0420'),
    ('03000300', 'Good well inc.', '030003000300', 'Canyon entr. 1', '0300'),
    ('66666666', 'Soul Cerberus inc.', '666666666666', 'Purgatory 999', '0666');

--
-- INSERTING CARETAKERS (with city reference)
--
INSERT INTO caretakers (name, phone, street, fk_zip_code) 
VALUES 
    ('Harry Potter', '093487694399', 'Diagonalley 321 3/4', '6969'),
    ('Hermionie', '093487694388', 'Diagonalley 1748 3/4', '6969'),
    ('Lord Voldemort', '093487694377', 'Azkabanalley 3 3/4', '6969'),
    ('Snoop Dogg', '004512345666', 'High st. 421', '0420'),
    ('Seth Rogan', '004512345655', 'High st. 422', '0420'),
    ('Joe Rogan', '004512345644', 'High st. 423', '0420'),
    ('King Leonidas', '030003000333', 'Canyon entr. -1', '0300'),
    ('Stelios', '030003000322', 'Canyon entr. 2', '0300'),
    ('Xerxes', '030003000311', 'Pre Canyon entr. 3', '0300'),
    ('Mr. Devil', '666666666600', 'Purgatory 666', '0666'),
    ('Demon', '666666666699', 'Purgatory 696', '0666'),
    ('Tormented soul', '666666666688', 'Purgatory 969', '0666');

--
-- INSERTING PETS (with vet reference)
--
INSERT INTO pets (d_type, name, age, live_count, bark_pitch, fk_vet_cvr) 
VALUES 
    ('owl', 'Hedwig', 15, null, null, '69696969'),
    ('cat', 'Crookshanks', 10, 7, null, '69696969'),
    ('snake', 'Gurth', 109, null, null, '69696969'),
    ('dog', 'Dobby', 350, null, 'C2', '69696969'),
    ('cat', 'Ronald Weasley', 15, 1, null, '69696969'),
    ('dog', 'Fluffy', 25, null, 'A1', '69696969'),
    ('dog', 'Doggy Snoop', 56, null, 'D1', '42004200'),
    ('cat', 'Rogan Seth', 10, 9, null, '42004200'),
    ('bear', 'Grills', 15, null, null, '42004200'),
    ('fish', 'Bubble', 1, null, null, '42004200'),
    ('dog', 'Fido', 6, null, 'E3', '42004200'),
    ('dog', 'Lassie', 4, null, 'E4', '42004200'),
    ('scorpion', 'Black Death', 5, null, null, '03000300'),
    ('scorpion', 'Purple Rain Death', 6, null, null, '03000300'),
    ('cat', 'Purr', 8, 8, null, '03000300'),
    ('cat', 'Mr. Miawgi', 7, 2, null, '03000300'),
    ('dog', 'Bully', 10, null, 'B7', '03000300'),
    ('dog', 'Dawg Judy', 7, null, 'A3' , '03000300'),
    ('gargoyle', 'Gar Goyle', 666, null, null, '66666666'),
    ('dog', 'Ceberes', 999, null, 'A0', '66666666'),
    ('cat', 'Mr. Fluff', 666, 1, null, '66666666'),
    ('cat', 'Puss', 69, 69, null, '66666666'),
    ('dog', 'Torment dog', 696, null, 'G7', '66666666'),
    ('dog', 'Soul dawg', 10, null, 'G6', '66666666');

--
-- INSERTING INTO CARETAKER_PETS (references caretaker and pet)
-- two pets for each caretaker and six ekstra combos
--
INSERT INTO caretaker_pets (caretaker_id, pet_id) 
VALUES 
    (1,1),(2,2),(3,3),(1,4),(2,5),(3,6),(4,7),(5,8),(6,9),(4,10),
    (5,11),(6,12),(7,13),(8,14),(9,15),(7,16),(8,17),(9,18),(10,19),
    (11,20),(12,21),(10,22),(11,23),(12,24),(1,5),(5,2),(8,9),(10,5),
    (11,6),(12,7);


