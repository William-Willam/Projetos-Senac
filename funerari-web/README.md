# Sistema de Gestão de Funerária

## Descrição

Este projeto é uma aplicação web para uma funerária, desenvolvida utilizando **React (Vite)**, **Node.js** e **Firebase**. O sistema tem como objetivo fornecer uma plataforma para gerenciar informações de produtos, interações com clientes e facilitar a comunicação via WhatsApp. A aplicação inclui funcionalidades de autenticação, cadastro de produtos, painel administrativo e uma página de contato integrada com o Formspree.

## Funcionalidades

- **Landing Page**: Página inicial com informações sobre a funerária.
- **Login e Cadastro**: Sistema de autenticação com Firebase.
- **Catálogo de Produtos**: Exibição de produtos da funerária, como caixões.
- **Painel Administrativo**: Interface para gerenciar produtos e informações da funerária.
- **Página de Contato**: Formulário de contato com categorias, integração com Formspree e botão para contato via WhatsApp.

## Tecnologias Utilizadas

- **Frontend**: 
  - React (Vite)
  - CSS para estilização
- **Backend**:
  - Node.js (para integrações futuras, se necessário)
  - Firebase (para autenticação e banco de dados)
- **Integrações**:
  - Formspree (para envio de formulários de contato)
  - WhatsApp API (para redirecionamento de mensagens)

## Como Rodar o Projeto

### Pré-requisitos

Certifique-se de ter as seguintes ferramentas instaladas:

- [Node.js](https://nodejs.org/) (versão 14 ou superior)
- [Firebase CLI](https://firebase.google.com/docs/cli) (se for fazer deploy no Firebase)

### Instalação

1. Clone o repositório:
   ```bash
   git clone https://github.com/seu-usuario/projeto-funeraria.git
   cd projeto-funeraria

2. Instale as dependências do frontend:
    cd frontend
    npm install

3. Para rodar o projeto no modo de desenvolvimento:  
    npm run dev

## Estrutura de Pastas
/frontend
  /src
    /components
      - Login.jsx
      - Cadastro.jsx
      - Catálogo.jsx
      - PainelAdmin.jsx
      - Contato.jsx
    /assets
      - Imagens, ícones, etc.
    /styles
      - Arquivos CSS
    /Firebase
        -config.js
        -auth.js
        -banco-usuario.js
  package.json
