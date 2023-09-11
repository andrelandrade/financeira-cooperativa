CREATE TABLE boletos(
	uuid UUID PRIMARY KEY,
	associado UUID,
	valor DECIMAL(10,2),
	documento_pagador VARCHAR(14),
	nome_pagador VARCHAR(50),
	nome_fantasia_pagador VARCHAR(50),
	situacao VARCHAR(20),
	UNIQUE (uuid, associado)
);