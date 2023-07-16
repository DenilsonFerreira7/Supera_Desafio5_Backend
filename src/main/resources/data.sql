



-- Inserir registros na tabela "conta"
INSERT INTO conta (nome_responsavel) VALUES ('Fulano');
INSERT INTO conta (nome_responsavel) VALUES ('Sicrano');
INSERT INTO conta (nome_responsavel) VALUES ('Beltrano');
INSERT INTO conta (nome_responsavel) VALUES ('João');
INSERT INTO conta (nome_responsavel) VALUES ('Maria');
INSERT INTO conta (nome_responsavel) VALUES ('José');
INSERT INTO conta (nome_responsavel) VALUES ('Ana');
INSERT INTO conta (nome_responsavel) VALUES ('Pedro');
INSERT INTO conta (nome_responsavel) VALUES ('Carla');
INSERT INTO conta (nome_responsavel) VALUES ('Paulo');

-- Inserir registros na tabela "transferencia"
INSERT INTO transferencia (data_transferencia, valor, tipo, nome_operador_transacao, conta_id)
VALUES ('2015-02-12 09:30:00', 500.00, 'DEPOSITO', NULL, 1);
INSERT INTO transferencia (data_transferencia, valor, tipo, nome_operador_transacao, conta_id)
VALUES ('2015-04-20 14:15:00', 200.00, 'DEPOSITO', NULL, 2);
INSERT INTO transferencia (data_transferencia, valor, tipo, nome_operador_transacao, conta_id)
VALUES ('2015-06-03 11:45:00', -100.00, 'SAQUE', NULL, 1);
INSERT INTO transferencia (data_transferencia, valor, tipo, nome_operador_transacao, conta_id)
VALUES ('2016-01-14 16:30:00', -50.00, 'SAQUE', NULL, 3);
INSERT INTO transferencia (data_transferencia, valor, tipo, nome_operador_transacao, conta_id)
VALUES ('2016-04-25 13:20:00', 300.00, 'TRANSFERENCIA', 'Beltrano', 2);
INSERT INTO transferencia (data_transferencia, valor, tipo, nome_operador_transacao, conta_id)
VALUES ('2016-07-08 08:00:00', -70.00, 'SAQUE', NULL, 4);
INSERT INTO transferencia (data_transferencia, valor, tipo, nome_operador_transacao, conta_id)
VALUES ('2017-02-10 10:30:00', 250.00, 'DEPOSITO', NULL, 3);
INSERT INTO transferencia (data_transferencia, valor, tipo, nome_operador_transacao, conta_id)
VALUES ('2017-06-15 15:45:00', -80.00, 'SAQUE', NULL, 5);
INSERT INTO transferencia (data_transferencia, valor, tipo, nome_operador_transacao, conta_id)
VALUES ('2018-03-20 12:30:00', 400.00, 'TRANSFERENCIA', 'José', 1);
INSERT INTO transferencia (data_transferencia, valor, tipo, nome_operador_transacao, conta_id)
VALUES ('2018-09-05 09:15:00', 120.00, 'DEPOSITO', NULL, 2);
INSERT INTO transferencia (data_transferencia, valor, tipo, nome_operador_transacao, conta_id)
VALUES ('2019-01-07 17:00:00', -60.00, 'SAQUE', NULL, 1);
INSERT INTO transferencia (data_transferencia, valor, tipo, nome_operador_transacao, conta_id)
VALUES ('2019-04-12 11:30:00', 180.00, 'TRANSFERENCIA', 'Beltrano', 2);
INSERT INTO transferencia (data_transferencia, valor, tipo, nome_operador_transacao, conta_id)
VALUES ('2020-02-15 14:45:00', -90.00, 'SAQUE', NULL, 4);
INSERT INTO transferencia (data_transferencia, valor, tipo, nome_operador_transacao, conta_id)
VALUES ('2020-07-20 10:00:00', 300.00, 'DEPOSITO', NULL, 3);
INSERT INTO transferencia (data_transferencia, valor, tipo, nome_operador_transacao, conta_id)
VALUES ('2021-01-25 16:20:00', -120.00, 'SAQUE', NULL, 5);
INSERT INTO transferencia (data_transferencia, valor, tipo, nome_operador_transacao, conta_id)
VALUES ('2021-06-30 13:15:00', 500.00, 'TRANSFERENCIA', 'José', 1);
INSERT INTO transferencia (data_transferencia, valor, tipo, nome_operador_transacao, conta_id)
VALUES ('2022-03-08 08:45:00', 150.00, 'DEPOSITO', NULL, 2);
INSERT INTO transferencia (data_transferencia, valor, tipo, nome_operador_transacao, conta_id)
VALUES ('2022-09-12 11:30:00', -30.00, 'SAQUE', NULL, 1);
INSERT INTO transferencia (data_transferencia, valor, tipo, nome_operador_transacao, conta_id)
VALUES ('2023-04-20 14:00:00', 250.00, 'DEPOSITO', NULL, 3);
INSERT INTO transferencia (data_transferencia, valor, tipo, nome_operador_transacao, conta_id)
VALUES ('2023-07-15 10:45:00', -80.00, 'SAQUE', NULL, 5);
INSERT INTO transferencia (data_transferencia, valor, tipo, nome_operador_transacao, conta_id)
VALUES ('2021-01-01 08:00:00', 50.00, 'SAQUE', 'Lucas Silva', 1);
INSERT INTO transferencia (data_transferencia, valor, tipo, nome_operador_transacao, conta_id)
VALUES ('2021-01-02 10:30:00', 150.00, 'DEPOSITO', 'Laura Costa', 2);
INSERT INTO transferencia (data_transferencia, valor, tipo, nome_operador_transacao, conta_id)
VALUES ('2021-01-03 13:45:00', 20.00, 'SAQUE', 'Pedro Santos', 3);
INSERT INTO transferencia (data_transferencia, valor, tipo, nome_operador_transacao, conta_id)
VALUES ('2021-01-04 15:20:00', 100.00, 'TRANSFERENCIA', 'Fulano', 1);
INSERT INTO transferencia (data_transferencia, valor, tipo, nome_operador_transacao, conta_id)
VALUES ('2021-01-05 09:10:00', 30.00, 'SAQUE', 'Ana Souza', 4);
INSERT INTO transferencia (data_transferencia, valor, tipo, nome_operador_transacao, conta_id)
VALUES ('2021-01-06 12:45:00', 200.00, 'DEPOSITO', 'José Almeida', 3);
INSERT INTO transferencia (data_transferencia, valor, tipo, nome_operador_transacao, conta_id)
VALUES ('2021-01-07 15:00:00', 50.00, 'SAQUE', 'Carla Ferreira', 5);
INSERT INTO transferencia (data_transferencia, valor, tipo, nome_operador_transacao, conta_id)
VALUES ('2021-01-08 11:20:00', 300.00, 'TRANSFERENCIA', 'José', 1);
INSERT INTO transferencia (data_transferencia, valor, tipo, nome_operador_transacao, conta_id)
VALUES ('2021-01-09 14:30:00', 80.00, 'DEPOSITO', 'Sicrano', 2);
INSERT INTO transferencia (data_transferencia, valor, tipo, nome_operador_transacao, conta_id)
VALUES ('2021-01-10 16:45:00', 10.00, 'SAQUE', 'Beltrano', 3);
INSERT INTO transferencia (data_transferencia, valor, tipo, nome_operador_transacao, conta_id)
VALUES ('2021-01-11 08:00:00', 50.00, 'DEPOSITO', 'João', 4);
INSERT INTO transferencia (data_transferencia, valor, tipo, nome_operador_transacao, conta_id)
VALUES ('2021-01-12 09:15:00', 40.00, 'SAQUE', 'Maria', 5);
INSERT INTO transferencia (data_transferencia, valor, tipo, nome_operador_transacao, conta_id)
VALUES ('2021-01-13 12:30:00', 150.00, 'DEPOSITO', 'Paula', 1);
INSERT INTO transferencia (data_transferencia, valor, tipo, nome_operador_transacao, conta_id)
VALUES ('2021-01-14 14:50:00', 90.00, 'SAQUE', 'Daniel', 2);
INSERT INTO transferencia (data_transferencia, valor, tipo, nome_operador_transacao, conta_id)
VALUES ('2021-01-15 16:15:00', 200.00, 'TRANSFERENCIA', 'Beltrano', 3);
INSERT INTO transferencia (data_transferencia, valor, tipo, nome_operador_transacao, conta_id)
VALUES ('2021-01-16 09:30:00', 70.00, 'SAQUE', 'Ana', 4);
INSERT INTO transferencia (data_transferencia, valor, tipo, nome_operador_transacao, conta_id)
VALUES ('2021-01-17 12:45:00', 180.00, 'DEPOSITO', 'Maria', 1);
INSERT INTO transferencia (data_transferencia, valor, tipo, nome_operador_transacao, conta_id)
VALUES ('2021-01-18 15:00:00', 60.00, 'SAQUE', 'Lucas', 5);
INSERT INTO transferencia (data_transferencia, valor, tipo, nome_operador_transacao, conta_id)
VALUES ('2021-01-19 10:10:00', 250.00, 'TRANSFERENCIA', 'José', 3);
INSERT INTO transferencia (data_transferencia, valor, tipo, nome_operador_transacao, conta_id)
VALUES ('2021-01-20 13:20:00', 120.00, 'DEPOSITO', 'Laura', 2)
