# Builder Pattern - Pedido de Lanche / Pizza

## Sobre o Projeto

Este projeto foi desenvolvido como **atividade prática da disciplina de Padrões de Projeto** do curso de **Análise e Desenvolvimento de Sistemas (ADS)**.

O objetivo da atividade é aplicar o **padrão de projeto Builder** em Java para a construção de objetos complexos de forma organizada, legível e segura.

O sistema simula a criação de pedidos em uma hamburgueria/pizzaria, permitindo diferentes combinações de opções (tipo de lanche, tamanho, forma de pagamento, entrega, entre outros) enquanto garante que **todas as regras de negócio sejam respeitadas**.

As validações são realizadas no método `build()` da classe `PedidoBuilder`. Caso alguma regra seja violada, uma `IllegalStateException` é lançada com uma mensagem explicativa.

---

## Estrutura do Projeto

O projeto possui duas classes principais.

### Classe `Pedido`

Representa o pedido final criado pelo sistema.

Características:

- Classe **imutável**
- Atributos definidos como `final`
- Não possui métodos setters
- Possui o método `printResumo()` para exibir os dados do pedido de forma organizada

Campos principais:

- tipo
- tamanho
- pagamento
- itens
- tipoPao
- tipoMassa
- bordaRecheada
- entrega
- enderecoEntrega
- cupom
- observacao
- trocoPara

---

### Classe `PedidoBuilder`

Responsável por construir o objeto `Pedido` utilizando o padrão **Builder**.

A classe implementa uma **fluent interface**, permitindo a criação do pedido com métodos encadeados, tornando o código mais legível.

Alguns métodos disponíveis:

- `tipoHamburguer()`
- `tipoPizza()`
- `tamanhoP()`
- `tamanhoM()`
- `tamanhoG()`
- `pagarComPix()`
- `pagarComCartao()`
- `pagarComDinheiro()`
- `comTrocoPara(double valor)`
- `entregaDelivery(String endereco)`
- `entregaRetirada()`
- `tipoPao(String pao)`
- `tipoMassa(String massa)`
- `comBordaRecheada()`
- `semBordaRecheada()`
- `addItem(String item)`
- `comCupom(String cupom)`
- `comObservacao(String observacao)`
- `build()`

---

## Validações Implementadas

As seguintes regras são verificadas no método `build()`.

### Regras gerais

- `tipo` deve ser **HAMBURGUER** ou **PIZZA**
- `tamanho` deve ser **P**, **M** ou **G**
- `pagamento` deve ser **PIX**, **CARTAO** ou **DINHEIRO**
- o pedido deve possuir **pelo menos 1 item**

### Regras por tipo

**Hambúrguer**

- `tipoPao` é obrigatório
- `tipoMassa` deve ser `null`
- `bordaRecheada` não é permitida

**Pizza**

- `tipoMassa` é obrigatório
- `tipoPao` deve ser `null`
- `bordaRecheada` pode ser `true` ou `false`

### Regras de entrega

- Se entrega = **DELIVERY**, `enderecoEntrega` é obrigatório
- Se entrega = **RETIRADA**, `enderecoEntrega` não deve ser utilizado

### Regras de pagamento

- Se pagamento ≠ **DINHEIRO**, `trocoPara` deve ser `null`
- Se pagamento = **DINHEIRO**, `trocoPara` deve ser maior que 0

Caso alguma regra seja violada, o método `build()` lança uma `IllegalStateException`.

---

## Testes Implementados no Main

O programa contém alguns cenários de teste para demonstrar o funcionamento do Builder e das validações.

### Caso 1 – Hambúrguer válido

- Tipo: HAMBURGUER
- Pão: BRIOCHE
- Tamanho: M
- Item: X-Bacon
- Pagamento: PIX
- Entrega: DELIVERY
- Observação: sem cebola

### Caso 2 – Pizza válida

- Tipo: PIZZA
- Massa: FINA
- Tamanho: G
- Item: Pizza Calabresa
- Borda recheada
- Pagamento: CARTAO
- Entrega: RETIRADA
- Cupom: 10OFF

### Caso 3 – Pagamento em dinheiro com troco

- Pagamento: DINHEIRO
- Troco para: 100

### Caso 4 – Pedido inválido

Um erro proposital é criado para demonstrar o funcionamento das validações.

A exceção é capturada no `main` e exibida no console.

Exemplo:

```
Erro esperado: <mensagem da exceção>
```

---

## Objetivo da Atividade

- Aplicar o padrão de projeto **Builder**
- Praticar a criação de **objetos imutáveis**
- Implementar **validações de regras de negócio**
- Utilizar **exceções para controle de erros**
- Desenvolver código mais **legível e organizado**
