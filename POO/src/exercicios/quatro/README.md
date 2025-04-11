# Programação Orientada a Objetos - Capítulo 4

## Estrutura do Projeto

O projeto está organizado em pacotes dentro do diretório `src/exercicios/quatro`, contendo:

- Classes de domínio (`domain`): Representam os conceitos e entidades do sistema
- Classes de teste (`test`): Contêm os métodos `main()` para execução e teste das classes de domínio

## Exercícios

### Exercício Base: Sistema Bancário Simples

**Classes:**
- `Conta`: Representa uma conta bancária com operações básicas
- `Data`: Classe auxiliar para manipular datas

**Funcionalidades:**
- Sacar e depositar valores
- Calcular rendimento (10% do saldo)
- Recuperar dados formatados para impressão
- Manipulação de datas

**Arquivo de teste:** `ContaTest.java`

### Programa 1: Sistema de Gerenciamento de Pessoas

**Classes:**
- `Pessoa`: Representa uma pessoa com nome e idade

**Funcionalidades:**
- Fazer aniversário (incrementar idade)
- Imprimir dados da pessoa
- Modificar nome e idade (métodos setter)

**Arquivo de teste:** `PessoaTest.java`

### Programa 2: Sistema de Gerenciamento de Portas

**Classes:**
- `Porta`: Representa uma porta física com propriedades e comportamentos

**Funcionalidades:**
- Abrir e fechar a porta
- Verificar se a porta está aberta
- Definir cor da porta
- Alterar dimensões (altura, largura e espessura)
- Imprimir características da porta

**Arquivo de teste:** `PortaTest.java`

### Programa 3: Sistema de Gerenciamento de Casa

**Classes:**
- `Casa`: Representa uma casa com cor e três portas

**Funcionalidades:**
- Pintar a casa
- Abrir e fechar portas específicas
- Contar quantas portas estão abertas
- Imprimir dados da casa e estado das portas

**Arquivo de teste:** `CasaTest.java`

## Como Executar

Cada programa possui sua própria classe de teste com um método `main()`. Para executar:

1. Compile os arquivos Java:
   ```
   javac exercicios/quatro/program*/test/*.java
   ```

2. Execute o programa desejado:
   ```
   java exercicios.quatro.program1.test.PessoaTest
   java exercicios.quatro.program2.test.PortaTest
   java exercicios.quatro.program3.test.CasaTest
   java exercicios.quatro.test.ContaTest
   ```