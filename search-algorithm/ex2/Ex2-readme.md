# Exercício 2

O exercício 2 consiste no seguinte:

**Faça uma versão da pesquisa binária que, dada
uma lista ordenada de n números inteiros e distintos
e uma chave X, retorne quantos números da lista `são
maiores do que X` e `quantos são menores do que X`.**

## Contexto:

A busca binária é um algoritmo mais eficiente.
Entretanto, requer que a lista esteja ordenada pelos
valores da chave de busca. A ideia do algoritmo é a
seguinte: verifica-se se a chave de busca é igual ao
valor da posição do meio da lista. Caso seja igual,
devolva esta posição. Caso o valor desta posição seja
maior que a chave, então repita o processo, mas
considere uma lista reduzida, com os elementos do
começo da lista até a posição anterior a do meio.
Caso o valor desta posição seja menor que chave, então
repita o processo, mas considere uma lista reduzida,
com os elementos da posição seguinte a do meio até o
final da lista.