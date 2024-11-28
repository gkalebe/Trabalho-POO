Repositório do Projeto Final de POO: Floricultura Flores Belas 🌸
Status: Em desenvolvimento ⚠️



Autores
<img src="https://avatars.githubusercontent.com/u/124272180?v=4" width=115><br><sub>Davi Crisostomo de Sousa</sub>	<img src="https://avatars.githubusercontent.com/u/111618683?s=400&u=5e315cba13d4aae69d6fac477a474725ca7b4613&v=4" width=115><br><sub>Gabriel Kalebe dos Santos Sousa</sub>	<img src="https://avatars.githubusercontent.com/u/127972306?v=4" width=115><br><sub>Gabriela Vitor Siqueira</sub>	<img src="https://avatars.githubusercontent.com/u/163136936?v=4" width=115><br><sub>Guilherme Moreira F. Pimentel</sub>	<img src="https://avatars.githubusercontent.com/u/142953027?v=4" width=115><br><sub>Gustavo Peres Domingues Larré</sub>
Objetivo do Projeto
Este projeto consiste em desenvolver um software para a floricultura Flores Belas, otimizando processos como gerenciamento de clientes, encomendas, locais de entrega e produtos. A solução visa atender especialmente demandas sazonais por meio de uma aplicação desenvolvida exclusivamente em Java com a biblioteca Swing para interface gráfica.

Funcionalidades
Cadastro de Clientes: Gerenciar informações como nome, CPF, endereço e contato.
Gerenciamento de Encomendas: Registro, atualização e exclusão de encomendas com status como solicitado, enviado e entregue.
Cadastro de Produtos: Controle de itens como flores, cartões e chocolates, incluindo tipo e preço.
Cadastro de Locais de Entrega: Informações de CEP, cidade e estado para cada local.
Relatórios e Estatísticas: Monitoramento de vendas e entregas diretamente pela aplicação.
Estrutura do Banco de Dados
Principais Tabelas
Cliente: ID, nome, CPF, CEP, telefone, e-mail.
Encomenda: ID, cliente associado, datas de pedido e entrega, local, status.
Produto: ID, nome, tipo, preço.
Local de Entrega: CEP, cidade, estado.
Itens de Encomenda: Produtos associados às encomendas, incluindo quantidade e preço unitário.
Arquitetura do Sistema
Camadas do Sistema:

Apresentação: Interface construída com Swing para gerenciar interações com o usuário.
Lógica de Negócios: Implementada em Java para controlar fluxos e ações no sistema.
Banco de Dados: Estruturado para armazenamento e recuperação de informações de clientes, produtos e encomendas.
Diagrama Conceitual


Cliente (1) --- (N) Encomendas
Encomenda (1) --- (N) Itens da Encomenda
Produto (1) --- (N) Itens da Encomenda
Encomenda (N) --- (1) Local de Entrega
Tecnologias Utilizadas
Linguagem: Java
Interface Gráfica: Swing
Banco de Dados: MySQL
