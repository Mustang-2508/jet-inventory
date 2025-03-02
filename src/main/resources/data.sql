INSERT INTO Company(created_on, modified_on, version, company_name, founded_on) values (current_date(), current_date(), 1, 'Lockheed Martin', null);
INSERT INTO Company(created_on, modified_on, version, company_name, founded_on) values (current_date(), current_date(), 1, 'Sukhoi', null);
INSERT INTO Company(created_on, modified_on, version, company_name, founded_on) values (current_date(), current_date(), 1, 'Eurofighter GmbH', null);
INSERT INTO Company(created_on, modified_on, version, company_name, founded_on) values (current_date(), current_date(), 1, 'Mikoyan', null);
INSERT INTO Company(created_on, modified_on, version, company_name, founded_on) values (current_date(), current_date(), 1, 'Saab', null);
INSERT INTO Company(created_on, modified_on, version, company_name, founded_on) values (current_date(), current_date(), 1, 'Hindustan Aeronautics Ltd', null);
INSERT INTO Company(created_on, modified_on, version, company_name, founded_on) values (current_date(), current_date(), 1, 'Korea Aerospace Industries', null);
INSERT INTO Company(created_on, modified_on, version, company_name, founded_on) values (current_date(), current_date(), 1, 'Shenyang Aircraft Corp', null);
INSERT INTO Company(created_on, modified_on, version, company_name, founded_on) values (current_date(), current_date(), 1, 'Dassault Aviation', null);
INSERT INTO Company(created_on, modified_on, version, company_name, founded_on) values (current_date(), current_date(), 1, 'Chengdu Aircraft Industry', null);
INSERT INTO Company(created_on, modified_on, version, company_name, founded_on) values (current_date(), current_date(), 1, 'Boing', null);


INSERT INTO fighter_jet(created_on, modified_on, version, model, max_speed,  manufactured_by_id) VALUES (current_date(), current_date(), 1, 'F-35A Lightning II', 1.6, (SELECT id FROM Company WHERE company_name = 'Lockheed Martin'));
INSERT INTO fighter_jet(created_on, modified_on, version, model, max_speed,  manufactured_by_id) VALUES (current_date(), current_date(), 1, 'F-22 Raptor', 2.25, (SELECT id FROM Company WHERE company_name = 'Lockheed Martin'));
INSERT INTO fighter_jet(created_on, modified_on, version, model, max_speed,  manufactured_by_id) VALUES (current_date(), current_date(), 1, 'F-35B Lightning II', 1.6, (SELECT id FROM Company WHERE company_name = 'Lockheed Martin'));
INSERT INTO fighter_jet(created_on, modified_on, version, model, max_speed,  manufactured_by_id) VALUES (current_date(), current_date(), 1, 'F-35C Lightning II', 1.6, (SELECT id FROM Company WHERE company_name = 'Lockheed Martin'));
INSERT INTO fighter_jet(created_on, modified_on, version, model, max_speed,  manufactured_by_id) VALUES (current_date(), current_date(), 1, 'Chengdu J-20', 2.0, (SELECT id FROM Company WHERE company_name = 'Chengdu Aircraft Industry'));
INSERT INTO fighter_jet(created_on, modified_on, version, model, max_speed,  manufactured_by_id) VALUES (current_date(), current_date(), 1, 'Sukhoi Su-57', 2.0, (SELECT id FROM Company WHERE company_name = 'Sukhoi'));
INSERT INTO fighter_jet(created_on, modified_on, version, model, max_speed,  manufactured_by_id) VALUES (current_date(), current_date(), 1, 'Shenyang J-35', 2.0, (SELECT id FROM Company WHERE company_name = 'Shenyang Aircraft Corp'));
INSERT INTO fighter_jet(created_on, modified_on, version, model, max_speed,  manufactured_by_id) VALUES (current_date(), current_date(), 1, 'Eurofighter Typhoon', 2.0, (SELECT id FROM Company WHERE company_name = 'Eurofighter GmbH'));
INSERT INTO fighter_jet(created_on, modified_on, version, model, max_speed,  manufactured_by_id) VALUES (current_date(), current_date(), 1, 'Dassault Rafale', 1.8, (SELECT id FROM Company WHERE company_name = 'Dassault Aviation'));
INSERT INTO fighter_jet(created_on, modified_on, version, model, max_speed,  manufactured_by_id) VALUES (current_date(), current_date(), 1, 'F/A-18E/F Super Hornet', 1.8, (SELECT id FROM Company WHERE company_name = 'Boing'));
INSERT INTO fighter_jet(created_on, modified_on, version, model, max_speed,  manufactured_by_id) VALUES (current_date(), current_date(), 1, 'Mikoyan MiG-35', 2.25, (SELECT id FROM Company WHERE company_name = 'Mikoyan'));
INSERT INTO fighter_jet(created_on, modified_on, version, model, max_speed,  manufactured_by_id) VALUES (current_date(), current_date(), 1, 'Saab JAS 39 Gripen E/F', 2.0, (SELECT id FROM Company WHERE company_name = 'Saab'));
INSERT INTO fighter_jet(created_on, modified_on, version, model, max_speed,  manufactured_by_id) VALUES (current_date(), current_date(), 1, 'HAL Tejas Mk2', 1.8, (SELECT id FROM Company WHERE company_name = 'Hindustan Aeronautics Ltd'));
INSERT INTO fighter_jet(created_on, modified_on, version, model, max_speed,  manufactured_by_id) VALUES (current_date(), current_date(), 1, 'KAI KF-21 Boramae', 1.8, (SELECT id FROM Company WHERE company_name = 'Korea Aerospace Industries'));
INSERT INTO fighter_jet(created_on, modified_on, version, model, max_speed,  manufactured_by_id) VALUES (current_date(), current_date(), 1, 'Sukhoi Su-75 Checkmate', 1.8, (SELECT id FROM Company WHERE company_name = 'Sukhoi'));


INSERT INTO multirole_fighter (id, generation, stealth_capacity) VALUES (1, 5, true);
INSERT INTO multirole_fighter (id, generation, stealth_capacity) VALUES (2, 5, true);
INSERT INTO multirole_fighter (id, generation, stealth_capacity) VALUES (3, 5, true);
INSERT INTO multirole_fighter (id, generation, stealth_capacity) VALUES (4, 5, true);
INSERT INTO multirole_fighter (id, generation, stealth_capacity) VALUES (5, 4, true);
INSERT INTO multirole_fighter (id, generation, stealth_capacity) VALUES (6, 5, true);
INSERT INTO multirole_fighter (id, generation, stealth_capacity) VALUES (9, 4, false);
INSERT INTO multirole_fighter (id, generation, stealth_capacity) VALUES (11, 4, false);
INSERT INTO multirole_fighter (id, generation, stealth_capacity) VALUES (15, 5, true);


INSERT INTO interceptor (id, climb_rate, missile_count) VALUES (7, 15000, 10);
INSERT INTO interceptor (id, climb_rate, missile_count) VALUES (8, 19000, 13);
INSERT INTO interceptor (id, climb_rate, missile_count) VALUES (10, 18000, 11);
INSERT INTO interceptor (id, climb_rate, missile_count) VALUES (12, 18000, 10);
INSERT INTO interceptor (id, climb_rate, missile_count) VALUES (13, 18000, 8);
INSERT INTO interceptor (id, climb_rate, missile_count) VALUES (14, 17000, 10);