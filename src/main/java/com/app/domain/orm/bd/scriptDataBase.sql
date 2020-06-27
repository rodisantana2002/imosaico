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
-- -- SQLLite
CREATE TABLE pessoa (  id SERIAL NOT NULL PRIMARY KEY,
                        situacao VARCHAR(30) NULL,
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
                        dtregistro VARCHAR(30)  NULL);
CREATE INDEX idx_Pessoa_nomeCompleto ON pessoa (nomecompleto);


-- CREATE TABLE usuario (  id SERIAL NOT NULL PRIMARY KEY,
--                         idpessoa
--                         senha VARCHAR(300) NULL,
--                         dtregistro VARCHAR(30)  NULL,
--                         token VARCHAR(100) NULL,
--                         superuser VARCHAR(12) NULL);
-- CREATE INDEX idx_Usuario_nomeCompleto ON usuario (nomecompleto);