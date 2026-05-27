CREATE DATABASE IF NOT EXISTS clinica_vet_amigos;
USE clinica_vet_amigos;

-- =====================================
-- TABELA DE USUÁRIOS (LOGIN)
-- =====================================
CREATE TABLE usuarios (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    usuario VARCHAR(100) NOT NULL UNIQUE,
    senha VARCHAR(255) NOT NULL
);

-- =====================================
-- TABELA DE ANIMAIS
-- =====================================
CREATE TABLE animais (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    especie VARCHAR(100) NOT NULL,
    raca VARCHAR(100),
    peso DECIMAL(5,2),
    idade INT,
    tutor VARCHAR(100),
    telefone VARCHAR(20)
);

-- =====================================
-- TABELA DE VETERINÁRIOS
-- =====================================
CREATE TABLE veterinarios (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    especialidade VARCHAR(100),
    telefone VARCHAR(20),
    email VARCHAR(100),
    usuario VARCHAR(50),
	senha VARCHAR(100)
);

-- =====================================
-- TABELA DE CONSULTAS
-- =====================================
CREATE TABLE consultas (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    descricao VARCHAR(255),
    data_consulta DATE,
    horario TIME,

    animal_id BIGINT,
    veterinario_id BIGINT,

    CONSTRAINT fk_animal
        FOREIGN KEY (animal_id)
        REFERENCES animais(id)
        ON DELETE CASCADE,

    CONSTRAINT fk_veterinario
        FOREIGN KEY (veterinario_id)
        REFERENCES veterinarios(id)
        ON DELETE CASCADE
);

-- =====================================
-- INSERT LOGIN PADRÃO
-- =====================================
INSERT INTO usuarios(usuario, senha)
VALUES ('admin', '123');

-- =====================================
-- INSERTS DE TESTE
-- =====================================

INSERT INTO animais(nome, especie, raca, peso, idade, tutor, telefone)
VALUES
('Rex', 'Cachorro', 'Labrador', 25.5, 5, 'Carlos', '47999999999'),
('Mimi', 'Gato', 'Persa', 4.2, 2, 'Ana', '47988888888');

INSERT INTO veterinarios(nome, especialidade, telefone, email, usuario, senha)
VALUES
('Dr. João', 'Cirurgia', '47977777777', 'joao@vet.com', 'joao', '123'),
('Dra. Maria', 'Clínica Geral', '47966666666', 'maria@vet.com', 'maria', '123');

INSERT INTO consultas(descricao, data_consulta, horario, animal_id, veterinario_id)
VALUES
('Consulta de rotina', '2026-05-26', '14:00:00', 1, 1),
('Vacinação', '2026-05-27', '10:30:00', 2, 2);

-- =====================================
-- VERIFICAR DADOS
-- =====================================

SELECT * FROM usuarios;
SELECT * FROM animais;
SELECT * FROM veterinarios;
SELECT * FROM consultas;