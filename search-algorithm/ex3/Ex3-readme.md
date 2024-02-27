# Exercício 3

O exercício 3 consiste no seguinte:

**Refaça as funções de `busca sequencial` e `busca
binária` assumindo que a lista possui chaves que podem
ocorrer múltiplas vezes na lista. Neste caso, você deve
retornar uma `lista com todas as posições onde a chave
foi encontrada`. Se a chave não for encontrada na lista,
retornar uma lista vazia.**


## Contexto


### Busca Sequencial

A busca sequencial é o algoritmo mais simples
de busca. A partir do primeiro item da lista,
simplesmente passamos de item para item,
seguindo o pedido sequencial subjacente até
encontrar o que estamos procurando ou ficar
sem itens. Se ficarmos sem itens, descobrimos
que o item que procuramos não estava presente.
Percorra a lista comparando a chave com os
valores dos elementos em cada uma das posições.
Se a chave for igual a algum dos elementos,
retorne a posição correspondente na lista. Se
a lista toda foi percorrida e a chave não for
encontrada, retorne o valor −1.


### Busca Binária:

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