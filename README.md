# Conversor de Moedas e Unidades

Aplicativo de console em **Java** que reúne dois conversores em um único menu: um **conversor de unidades** (distância, tempo e temperatura) e um **conversor de câmbio com cotações em tempo real**.

## Para que serve

- Converter rapidamente valores entre unidades comuns, sem precisar de calculadora.
- Consultar a cotação atual de uma moeda (ex.: dólar, euro, bitcoin em reais) e converter um valor usando essa cotação.

## O que o programa faz

Ao iniciar, o menu principal oferece duas opções:

### 1. Conversor unitário
- **Km ↔ Metros**
- **Segundos ↔ Minutos**
- **Graus (Celsius) ↔ Kelvin**

### 2. Conversor de câmbio (tempo real)
1. Consulta a [AwesomeAPI](https://docs.awesomeapi.com.br/api-de-moedas) e lista os pares de moedas disponíveis (os 20 primeiros).
2. Você digita a sigla do par, por exemplo `USD-BRL`, `EUR-BRL` ou `BTC-BRL`.
3. O programa mostra o nome da moeda, **compra (bid)**, **venda (ask)**, **máxima**, **mínima** do dia e a data/hora da atualização.
4. Em seguida você informa um valor e o programa calcula a conversão usando o valor de compra (bid).

## Tecnologias

- Java 21
- Maven
- [Gson](https://github.com/google/gson) para ler o JSON da API
- `java.net.http.HttpClient` para as requisições

## Como executar

Pré-requisitos: **JDK 21** e **Maven**. O câmbio precisa de conexão com a internet.

```bash
git clone https://github.com/guilherf/ConversorDeMoedasUnitario.git
cd ConversorDeMoedasUnitario
mvn compile exec:java -Dexec.mainClass=net.bifewagyu.Main
```

Também dá para abrir o projeto no IntelliJ IDEA e executar a classe `Main`.

## Estrutura

```
src/main/java/net/bifewagyu/
├── Main.java                         # menu principal
├── cambios/
│   ├── ConexcaoAPICambio.java        # chamadas à API e conversão de moeda
│   └── Moedas.java                   # modelo com os campos da cotação
└── convesorUnitario/
    └── ConversorUnitario.java        # conversões de km, tempo e temperatura
```

## Autor

Guilherme Ferreira — [@guilherf](https://github.com/guilherf)
