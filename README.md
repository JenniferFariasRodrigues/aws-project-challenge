### Descrição
---
Fazer uma API POST em NodeJS que receba um payload de uma transação (idempotencyId, amount, type: credit /debit).

Essa rota deve executar uma função que coloca a transação em uma AWS SQS (fila), usando SDK da AWS.

Suba também uma função AWS Lambda conectada nessa SQS que pegue cada mensagem e salve num banco de dados AWS DynamoDB.

Crie um script de teste para criar 100 transações diferentes e fazer a requisição POST.
Crie uma tela simples usando Next.JS que exiba essas transações salvas no DynamoDB, a partir de uma rota GET.


---
### Passos desenvolvidos
# Pasta aws_cdk
Início através do localhost fazendo deploy das stacks para a aws localmente.

# Pasta aws-project-challenge
Código segundo acesso via nuvem de forma virtual.

```bash
- Configuração do projeto Spring Boot no VSCode.
controlador TransactionController.java para lidar com as requisições POST
-Criação da API POST em Node.js usando Express
-Configuração da AWS SDK e integração com SQS e DynamoDB no Node.js
-Criação da função AWS Lambda para consumir a SQS e salvar no DynamoDB
Classe SQSProcessorLambda.java
- Script de teste para criar 100 transações diferentes e fazer a requisição POST
Código de teste ProjectApplicationTests.java para criar 100 transações diferentes e fazer a requisição POST.
- Criação de uma tela simples usando Next.js para exibir as transações salvas no DynamoDB
Diretório next.js com subdretório pages e api contendo funções transactions.js e transactionController.js, respectivamente.Para exibir as transações salvas no DynamoDB.

