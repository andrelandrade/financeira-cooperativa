CREATE TABLE associados(
	uuid UUID PRIMARY KEY,
	documento VARCHAR(14) UNIQUE,
	tipo_pessoa VARCHAR(2),
	nome VARCHAR(50)
);