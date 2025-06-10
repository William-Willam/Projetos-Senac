# Sistema de Gerenciamento de Projetos e Tarefas

Este projeto foi desenvolvido como parte do Desafio Individual da Competição SENAC Tecnologia.

## Tecnologias Utilizadas
- React (Vite)
- Node.js + Express
- MySQL

# Gerenciador de Tarefas — Explicação das Tecnologias

Este documento explica as tecnologias, frameworks e bibliotecas utilizadas no backend e frontend do projeto **gerenciador-de-tarefas**.

---

## Backend

O backend deste projeto está localizado na pasta [`gerenciador-de-tarefas/backend`](./backend) e foi desenvolvido utilizando as seguintes tecnologias:

- **Node.js** — Ambiente de execução JavaScript para o servidor.
- **Express** — Framework web para Node.js, responsável por gerenciar rotas e requisições HTTP.
- **MySQL2** — Cliente para conectar e interagir com bancos de dados MySQL.
- **bcrypt** — Utilizado para hash de senhas, garantindo maior segurança dos dados dos usuários.
- **jsonwebtoken** — Para autenticação via tokens JWT, permitindo sessões seguras e APIs protegidas.
- **dotenv** — Gerenciamento de variáveis de ambiente, mantendo informações sensíveis fora do código-fonte.
- **cors** — Habilita o Cross-Origin Resource Sharing, permitindo que o frontend acesse o backend mesmo estando em domínios diferentes.
- **nodemon** (dev dependency) — Ferramenta para reiniciar automaticamente o servidor durante o desenvolvimento.

**Estrutura típica das pastas do backend:**
- `config/` — Configurações do projeto (ex.: conexão com banco de dados, variáveis de ambiente).
- `controllers/` — Funções que recebem as requisições e enviam respostas.
- `middleware/` — Middlewares para autenticação, tratamento de erros, etc.
- `models/` — Modelos das entidades/tabelas do banco de dados.
- `routes/` — Definição das rotas da API.
- `server.js` — Arquivo principal que inicializa o servidor.

---

## Frontend

O frontend está localizado em [`gerenciador-de-tarefas/frontend`](./frontend) e foi desenvolvido com:

- **React** — Biblioteca JavaScript para criação de interfaces de usuário reativas e componentizadas.
- **React Router DOM** — Para navegação entre páginas e rotas no frontend.
- **Axios** — Cliente HTTP para consumir as APIs do backend.
- **Bootstrap** — Framework CSS para estilização e responsividade da interface.
- **React Scripts** — Scripts e ferramentas de build, serve e testes do React.
- **Testing Library** — Conjunto de ferramentas para testes automatizados de componentes React.
- **Web Vitals** — Monitoramento de métricas essenciais de desempenho da aplicação.

**Estrutura típica das pastas do frontend:**
- `src/` — Código-fonte principal da aplicação React.
- `public/` — Arquivos públicos e estáticos (ex.: `index.html`, imagens, favicon).

---

## Resumo

- **Backend:** Node.js, Express, MySQL2, JWT, Bcrypt, CORS, Dotenv.
- **Frontend:** React, React Router, Axios, Bootstrap.

Essas escolhas proporcionam uma arquitetura moderna, escalável e segura para um gerenciador de tarefas full-stack.

---
