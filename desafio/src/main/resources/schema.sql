CREATE TABLE planos (
    id BIGINT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    taxa_contratacao BIGINT NOT NULL,
    taxa_dependentes BIGINT NOT NULL
);

CREATE TABLE clientes (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    cpf VARCHAR(11) NOT NULL UNIQUE,
    data_nascimento DATE NOT NULL,
    telefone VARCHAR(15),
    endereco_completo VARCHAR(255),
    plano_id BIGINT
);
