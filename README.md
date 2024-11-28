###Repositório do Projeto Final de POO: Floricultura 


Status: Em desenvolvimento ⚠️



###Autores

<div style="display: flex; justify-content: space-around; align-items: center; text-align: center;">
    <div>
        <img src="https://avatars.githubusercontent.com/u/124272180?v=4" width="115">
        <br><strong>Davi Crisostomo de Sousa</strong>
    </div>
    <div>
        <img src="https://avatars.githubusercontent.com/u/111618683?s=400&u=5e315cba13d4aae69d6fac477a474725ca7b4613&v=4" width="115">
        <br><strong>Gabriel Kalebe dos Santos Sousa</strong>
    </div>
    <div>
        <img src="https://avatars.githubusercontent.com/u/127972306?v=4" width="115">
        <br><strong>Gabriela Vitor Siqueira</strong>
    </div>
    <div>
        <img src="https://avatars.githubusercontent.com/u/163136936?v=4" width="115">
        <br><strong>Guilherme Moreira F. Pimentel</strong>
    </div>
    <div>
        <img src="https://avatars.githubusercontent.com/u/142953027?v=4" width="115">
        <br><strong>Gustavo Peres Domingues Larré</strong>
    </div>
</div>

<div>
    <h2><strong>Objetivo do Projeto</strong></h2>
    <p>
        Este projeto consiste em desenvolver um software para a floricultura Flores Belas, 
        otimizando processos como gerenciamento de clientes, encomendas, locais de entrega e produtos. 
        A solução visa atender especialmente demandas sazonais por meio de uma aplicação desenvolvida exclusivamente 
        em <strong>Java</strong> com a biblioteca <strong>Swing</strong> para interface gráfica.
    </p>

    <h2><strong>Funcionalidades</strong></h2>
    <ul>
        <li><strong>Cadastro de Clientes:</strong> Gerenciar informações como nome, CPF, endereço e contato.</li>
        <li><strong>Gerenciamento de Encomendas:</strong> Registro, atualização e exclusão de encomendas com status como solicitado, enviado e entregue.</li>
        <li><strong>Cadastro de Produtos:</strong> Controle de itens como flores, cartões e chocolates, incluindo tipo e preço.</li>
        <li><strong>Cadastro de Locais de Entrega:</strong> Informações de CEP, cidade e estado para cada local.</li>
        <li><strong>Relatórios e Estatísticas:</strong> Monitoramento de vendas e entregas diretamente pela aplicação.</li>
    </ul>

    <h2><strong>Estrutura do Banco de Dados</strong></h2>
    <h3><strong>Principais Tabelas</strong></h3>
    <ul>
        <li><strong>Cliente:</strong> ID, nome, CPF, CEP, telefone, e-mail.</li>
        <li><strong>Encomenda:</strong> ID, cliente associado, datas de pedido e entrega, local, status.</li>
        <li><strong>Produto:</strong> ID, nome, tipo, preço.</li>
        <li><strong>Local de Entrega:</strong> CEP, cidade, estado.</li>
        <li><strong>Itens de Encomenda:</strong> Produtos associados às encomendas, incluindo quantidade e preço unitário.</li>
    </ul>

    <h2><strong>Arquitetura do Sistema</strong></h2>
    <h3><strong>Camadas do Sistema:</strong></h3>
    <ul>
        <li><strong>Apresentação:</strong> Interface construída com Swing para gerenciar interações com o usuário.</li>
        <li><strong>Lógica de Negócios:</strong> Implementada em Java para controlar fluxos e ações no sistema.</li>
        <li><strong>Banco de Dados:</strong> Estruturado para armazenamento e recuperação de informações de clientes, produtos e encomendas.</li>
    </ul>

    <h3><strong>Diagrama Conceitual</strong></h3>
    <pre>
        Cliente (1) --- (N) Encomendas
        Encomenda (1) --- (N) Itens da Encomenda
        Produto (1) --- (N) Itens da Encomenda
        Encomenda (N) --- (1) Local de Entrega
    </pre>

    <h2><strong>Tecnologias Utilizadas</strong></h2>
    <ul>
        <li><strong>Linguagem:</strong> Java</li>
        <li><strong>Interface Gráfica:</strong> Swing</li>
        <li><strong>Banco de Dados:</strong> MySQL</li>
    </ul>
</div>

