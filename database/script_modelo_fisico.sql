clienteCREATE TABLE cliente(
cpf VARCHAR (20) NOT NULL PRIMARY KEY,
nome VARCHAR(50) NOT NULL,
sobrenome VARCHAR (100) NOT NULL,
email VARCHAR(100) NOT NULL

);


CREATE TABLE servico (
codigo_serviço int NOT NULL AUTO_INCREMENT PRIMARY KEY,
modalidade_serviço VARCHAR (20) NOT NULL,
valor_servico DOUBLE NOT NULL,
data_realizacao DATE NOT NULL

);

CREATE TABLE pagamento (
nota_fiscal int NOT NULL AUTO_INCREMENT PRIMARY KEY,
forma_pagamento VARCHAR (20) NOT NULL,
parcelas int NOT NULL,
valor_servico DOUBLE NOT NULL

);

CREATE TABLE pg_cliente (
cpf_cliente VARCHAR (20) NOT NULL,
nota_fiscal int NOT NULL,
PRIMARY KEY (cpf_cliente, nota_fiscal),
FOREIGN KEY (cpf_cliente) REFERENCES cliente(cpf),
FOREIGN KEY (nota_fiscal) REFERENCES pagamento(nota_fiscal)
);

CREATE TABLE serv_cliente (
cpf_cliente VARCHAR (20) NOT NULL,
codigo_servico int NOT NULL,
PRIMARY KEY (cpf_cliente, codigo_servico),
FOREIGN KEY (cpf_cliente) REFERENCES cliente(cpf),
FOREIGN KEY (codigo_servico) REFERENCES servico(codigo_servico)
);

CREATE TABLE pg_servico (
nota_fiscal int NOT NULL,
codigo_servico int NOT NULL,
PRIMARY KEY (nota_fiscal, codigo_servico),
FOREIGN KEY (nota_fiscal) REFERENCES pagamento(nota_fiscal),
FOREIGN KEY (codigo_servico) REFERENCES servico(codigo_servico)
);



