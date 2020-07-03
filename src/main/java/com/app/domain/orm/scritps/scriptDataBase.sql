/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Rodolfo Santana <RWS Informática>
 * Created: 27/06/2020
 */
-- -- --

--PARA LIMPEZA DAS TABELAS
-- DELETE FROM sistema;
-- DELETE FROM usuario;
-- DELETE FROM pessoa;
--
DROP TABLE sistema;
DROP TABLE usuario;
DROP TABLE pessoa;

CREATE TABLE pessoa (  id SERIAL NOT NULL PRIMARY KEY,
                        email VARCHAR(100) NULL UNIQUE,
                        nomecompleto VARCHAR(100) NULL,
                        sexo VARCHAR(30) NULL,
                        fonecelular VARCHAR(20) NULL UNIQUE,
                        dtnascimento VARCHAR(30) NULL,
                        logradouro VARCHAR(100) NULL,
                        numero VARCHAR(10) NULL,
                        complemento VARCHAR(50) NULL,
                        bairro VARCHAR(50) NULL,
                        cidade VARCHAR(60) NULL,
                        estado VARCHAR(30) NULL,
                        cep VARCHAR(20) NULL,
                        dtregistro VARCHAR(30) NULL DEFAULT TO_CHAR(CURRENT_TIMESTAMP,'DD/MM/YYYY HH:MM:SS'));
CREATE INDEX idx_Pessoa_nomeCompleto ON pessoa (nomecompleto);

CREATE TABLE usuario (  id SERIAL NOT NULL PRIMARY KEY,
                        idpessoa BIGINT NOT NULL,
                        senha VARCHAR(100) NULL,
                        token VARCHAR(300) NULL,
                        superuser VARCHAR(12) NULL,
                        dtregistro VARCHAR(30) NULL DEFAULT TO_CHAR(CURRENT_TIMESTAMP,'DD/MM/YYYY HH:MM:SS'));

CREATE TABLE sistema (  id SERIAL NOT NULL PRIMARY KEY,
                        nome VARCHAR(100) NULL,
                        tipo VARCHAR(30) NULL,
                        descricao VARCHAR(300) NULL,
                        linguagem VARCHAR(50) NULL,
                        dtregistro VARCHAR(30) NULL DEFAULT TO_CHAR(CURRENT_TIMESTAMP,'DD/MM/YYYY HH:MM:SS'));


