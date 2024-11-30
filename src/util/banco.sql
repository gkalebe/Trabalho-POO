CREATE TABLE cliente (
                         id_cliente INT PRIMARY KEY AUTO_INCREMENT,
                         nome VARCHAR(100) NOT NULL,
                         cpf varchar(25) UNIQUE NOT NULL,
                         cep VARCHAR(25) NOT NULL,
                         cidade VARCHAR(50) NOT NULL,
                         estado VARCHAR(25) NOT NULL,
                         telefone VARCHAR(25),
                         email VARCHAR(100)
);


CREATE TABLE local_entrega (
                              id_local INT PRIMARY KEY AUTO_INCREMENT,
                              cep VARCHAR(25) NOT NULL,
                              cidade VARCHAR(50) NOT NULL,
                              estado CHAR(25) NOT NULL
);


CREATE TABLE encomenda (
                        id_encomenda INT PRIMARY KEY AUTO_INCREMENT,
                        id_cliente INT NOT NULL,
                        data_encomenda DATE NOT NULL,
                        data_entrega DATE,
                        id_local INT NOT NULL,
                        status ENUM('Solicitado', 'Cancelado', 'Enviado', 'Entregue') DEFAULT 'Solicitado',
                        FOREIGN KEY (id_cliente) REFERENCES cliente(id_cliente),
                        FOREIGN KEY (id_local) REFERENCES local_entrega(id_local)
);

CREATE TABLE produto (
                         id_produto INT PRIMARY KEY AUTO_INCREMENT,
                         nome VARCHAR(100) NOT NULL,
                         tipo VARCHAR(50),
                         preco DECIMAL(10, 2) NOT NULL,
                         quantidade INT NOT NULL
);


CREATE TABLE item_encomenda (
                               id_item INT PRIMARY KEY AUTO_INCREMENT,
                               id_encomenda INT NOT NULL,
                               id_produto INT NOT NULL,
                               quantidade INT NOT NULL,
                               preco_unitario DECIMAL(10, 2) NOT NULL,
                               FOREIGN KEY (id_encomenda) REFERENCES encomenda(id_encomenda),
                               FOREIGN KEY (id_produto) REFERENCES produto(id_produto)
);