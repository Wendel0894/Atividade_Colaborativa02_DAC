CREATE TABLE Cliente(
    Id SERIAL PRIMARY KEY,
    Nome VARCHAR(100),
    CPF VARCHAR(11)
);

CREATE TABLE Produto(
    Id SERIAL PRIMARY KEY,
    Descricao TEXT,
    VALOR INT 
);
