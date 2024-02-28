# Exercício 2

**Escreva Código Recursivo Para Multiplicação**


## Nota

O conceito de recursão foi mostrado no [**Ex1-readme.md**](../ex1/Ex1-readme.md),
mas a multiplicação se baseia no seguinte:

São dados dois ou mais valores onde, o primeiro multiplicado pelos próximos nada mais é que
o primeiro somado consigo mesmo pela quantidade de vezes expressa nos números seguintes, por exemplo:

| Operação  | Demonstração      | Resultado |
|:---------:|:-----------------:|:---------:|
| **2 X 5** | 2 + 2 + 2 + 2 + 2 | **10**    |
| **1 X 3** | 1 + 1 + 1         | **3**     |
| **9 X 4** | 9 + 9 + 9 + 9     | **36**    |
| **...**   | ...               | **...**   |

---

Não só isso, mas existe também uma regra para valores negativos, decimais, etc...


### Como Faço Para Introduzir O Conceito Recursivo À Multiplicação?

Considerando que a multiplicação é apenas uma sequência de passos, podemos realizar uma
função que seja recursiva até que determinado critério seja atendido. Veja o arquivo
[**Java.**](./Ex2.java)