INSERT INTO planos (id, nome, taxa_contratacao, taxa_dependentes)
VALUES (1, 'Bronze', 1000, 500);

INSERT INTO planos (id, nome, taxa_contratacao, taxa_dependentes)
VALUES (2, 'Prata', 2000, 1000);

INSERT INTO planos (id, nome, taxa_contratacao, taxa_dependentes)
VALUES (3, 'Ouro', 3000, 1500);

INSERT INTO clientes (id, nome, cpf, data_nascimento, telefone, endereco_completo, plano_id)
VALUES (1, 'João da Silva', '12345678901', '1980-05-20', '11987654321', 'Rua Nova Europa, 123, São Paulo, SP', null);

INSERT INTO clientes (id, nome, cpf, data_nascimento, telefone, endereco_completo, plano_id)
VALUES (2, 'Maria Santos', '09876543210', '1990-10-15', '21998765432', 'Avenida Brasil, 456, Rio de Janeiro, RJ', null);
