### Description 
---
Fazer uma API POST em NodeJS que receba um payload de uma transação (idempotencyId, amount, type: credit /debit).

Essa rota deve executar uma função que coloca a transação em uma AWS SQS (fila), usando SDK da AWS.

Suba também uma função AWS Lambda conectada nessa SQS que pegue cada mensagem e salve num banco de dados AWS DynamoDB.

Crie um script de teste para criar 100 transações diferentes e fazer a requisição POST.

Crie uma tela simples usando Next.JS que exiba essas transações salvas no DynamoDB, a partir de uma rota GET.
---
### Starting
Passos desenvolvidos

1. Configuração do projeto Spring Boot no VSCode
2. Criação da API POST em Node.js usando Express
3. Configuração da AWS SDK e integração com SQS e DynamoDB no Node.js
4. Criação da função AWS Lambda para consumir a SQS e salvar no DynamoDB
5. Script de teste para criar 100 transações diferentes e fazer a requisição POST
6. Criação de uma tela simples usando Next.js para exibir as transações salvas no DynamoDB
