# Sistema de Gestão de Funerária

## Descrição

Este projeto é uma aplicação web para uma funerária, desenvolvida utilizando **React (Vite)**, **Node.js** e **Firebase**. O sistema tem como objetivo fornecer uma plataforma para gerenciar informações de produtos, interações com clientes e facilitar a comunicação via WhatsApp. A aplicação inclui funcionalidades de autenticação, cadastro de produtos, painel administrativo e uma página de contato integrada com o Formspree.

## Funcionalidades

- **Landing Page**: Página inicial com informações sobre a funerária.
- **Login e Cadastro**: Sistema de autenticação com Firebase Authentication.
- **Catálogo de Produtos**: Exibição de produtos da funerária, como caixões, flores e serviços.
- **Painel Administrativo**: Interface para gerenciar produtos e informações da funerária.
- **Página de Contato**: Formulário com categorias, envio via Formspree e botão de redirecionamento para WhatsApp.

## Tecnologias Utilizadas

### Frontend
- React (com Vite)
- CSS (estilização manual ou bibliotecas utilitárias)
- React Router Dom (navegação entre páginas)

### Backend
- Node.js (para futuras integrações e expansão)
- Firebase:
  - Firebase Authentication (login e cadastro)
  - Firebase Firestore (armazenamento de dados dos produtos)
  - Firebase Hosting (hospedagem gratuita)

### Integrações
- Formspree (envio de formulários de contato)
- WhatsApp API (contato direto com atendimento)

## Estrutura de Pastas

```
/frontend
  /src
    /components
      - Login.jsx
      - Cadastro.jsx
      - Catalogo.jsx
      - PainelAdmin.jsx
      - Contato.jsx
    /assets
      - Imagens, ícones, etc.
    /styles
      - Arquivos CSS
    /Firebase
      - config.js
      - auth.js
      - banco-usuario.js
```

## Como Rodar o Projeto

### Pré-requisitos

- [Node.js](https://nodejs.org/) (v14 ou superior)
- [Firebase CLI](https://firebase.google.com/docs/cli)

### Instalação

1. Clone o repositório:
   ```bash
   git clone https://github.com/seu-usuario/projeto-funeraria.git
   cd projeto-funeraria
   ```

2. Instale as dependências:
   ```bash
   cd frontend
   npm install
   ```

3. Rode o projeto em modo desenvolvimento:
   ```bash
   npm run dev
   ```

## Deploy no Firebase Hosting

1. Faça login no Firebase:
   ```bash
   firebase login
   ```

2. Inicie o projeto Firebase:
   ```bash
   firebase init
   ```

   Durante a configuração:
   - Selecione **Hosting**
   - Use o diretório `dist` como pasta pública
   - Responda **Yes** para *"Configure as a single-page app?"*
   - Responda **No** para GitHub deploy (se não quiser CI/CD agora)

3. Gere os arquivos finais:
   ```bash
   npm run build
   ```

4. Faça o deploy:
   ```bash
   firebase deploy
   ```

Após o deploy, o terminal mostrará a URL pública do seu projeto, como:

```
Project deployed at: https://funerariasenac.web.app
```

## Observações

- Certifique-se de configurar as regras de segurança do Firebase Firestore corretamente para permitir leitura e escrita de acordo com os usuários autenticados.
- As imagens podem ser salvas localmente em `/src/assets/` ou hospedadas externamente (como via Firebase Storage ou links CDN).

## Autor

Projeto desenvolvido por [William dos Santos Rodrigues] — para fins de portfólio e aprendizado.