



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
VALUES ('2021-01-01 09:00:00', 100.00, 'DEPOSITO', NULL, 1);
INSERT INTO transferencia (data_transferencia, valor, tipo, nome_operador_transacao, conta_id)
VALUES ('2021-01-02 14:30:00', 50.00, 'DEPOSITO', NULL, 2);
INSERT INTO transferencia (data_transferencia, valor, tipo, nome_operador_transacao, conta_id)
VALUES ('2021-01-03 10:45:00', -20.00, 'SAQUE', NULL, 1);
INSERT INTO transferencia (data_transferencia, valor, tipo, nome_operador_transacao, conta_id)
VALUES ('2021-01-04 11:20:00', -10.00, 'SAQUE', NULL, 3);
INSERT INTO transferencia (data_transferencia, valor, tipo, nome_operador_transacao, conta_id)
VALUES ('2021-01-05 15:10:00', 200.00, 'TRANSFERENCIA', 'Beltrano', 2);
INSERT INTO transferencia (data_transferencia, valor, tipo, nome_operador_transacao, conta_id)
VALUES ('2021-01-06 08:45:00', -30.00, 'SAQUE', NULL, 4);
INSERT INTO transferencia (data_transferencia, valor, tipo, nome_operador_transacao, conta_id)
VALUES ('2021-01-07 12:00:00', 150.00, 'DEPOSITO', NULL, 3);
INSERT INTO transferencia (data_transferencia, valor, tipo, nome_operador_transacao, conta_id)
VALUES ('2021-01-08 16:20:00', -50.00, 'SAQUE', NULL, 5);
INSERT INTO transferencia (data_transferencia, valor, tipo, nome_operador_transacao, conta_id)
VALUES ('2021-01-09 13:30:00', 300.00, 'TRANSFERENCIA', 'José', 1);
INSERT INTO transferencia (data_transferencia, valor, tipo, nome_operador_transacao, conta_id)
VALUES ('2021-01-10 10:15:00', 80.00, 'DEPOSITO', NULL, 2);
