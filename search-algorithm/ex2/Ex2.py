"""
Faça uma versão da pesquisa binária que,
dada uma lista ordenada de n números inteiros
e distintos e uma chave X, retorne quantos
números da lista são maiores do que X e
quantos são menores do que X.
"""

# criando a função de busca binária
def binarySearch(targetList: list[int], targetValue: int, startPoint: int = 0, endPoint: int | None = None) -> int:
    """
    A função poderá receber quatro elementos, sendo eles:

    1. 'targetList'  : uma lista de valores Integers
    2. 'targetValue' : o valor que será procurado dentro da nossa lista
    3. 'startPoint'  : qual será o índice inicial que iremos procurar em nossa lista
    4. 'endPoint'    : qual será o índice final que iremos procurar em nossa lista

    Obrigatoriamente, a função irá retornanr um Integer, podendo ser -1 (caso o elemento procurado
    não esteja presente na lista) ou o índice do elemento
    """

    # se o endPoint estiver settado como None, ou seja, se for a primeira vez de execução da função recursiva
    if endPoint == None:

        # endPoint será igual ao tamanho da lista - 1 (o último índice)
        endPoint = len(targetList) - 1
    #

    # settando índice do meio apartir de divisão perfeita ('//' em python)
    midIndex = (startPoint + endPoint) // 2

    # se o item da lista alvo, a partir do índice anteriormente settado, for igual ao item que procuramos:
    if targetList[midIndex] == targetValue:

        # retorne esse índice
        return midIndex
    #

    # se o ponto de começo for superior ao de final, significa que já verificamos todos os elementos possíveis:
    elif startPoint > endPoint:
        
        # logo, o elemento não está na lista, então retorne '-1'
        return -1
    #

    # caso o elemento obtido a partir do índice determinado for menor que o elemento que procuramos, significa que o item procurado está à direita do item atual
    elif targetList[midIndex] < targetValue:
        
        # logo, retorne o valor que será obtido por meio da recursividade, utilizando a mesma função mas para pesquisar apenas do índice atual até o endPoint
        return binarySearch(targetList, targetValue, midIndex + 1, endPoint)
    #

    # caso o elemento obtido a partir do índice determinado for maior que o elemento que procuramos, significa que o item procurado está à esquerda do item atual
    elif targetList[midIndex] > targetValue:
        
        # logo, retorne o valor que será obtido por meio da recursividade, utilizando a mesma função mas para pesquisar apenas do índice atual até o endPoint
        return binarySearch(targetList, targetValue, startPoint, midIndex)
    #

    # caso entremos em uma situação que fuja de todos os cenários anteriormente citados:
    else:
        
        # retorne '-1' para indicar a ausência do elemento procurado
        return -1
    #
#

# criando função que conta elementos à esquerda e à direita
def itemCounter(referenceList: list[int], itemIndex: int) -> dict[str : int | bool | None]:
    """
    Essa função, por sua vez, receberá dois argumentos:

    1. 'referenceList' : lista referência, onde iremos utilizar a sua length (tamanho) para calcular a quantidade de elementos à direita
    2. 'itemIndex'     : o índice do número que estamos indicando. Servirá para calcularmos os elementos à esquerda / direita
    """

    # variável (dicionário) chamada retornável, na qual armazena 3 dados
    returnable = {
        "is on the list" :  None, # um booleano   (se o valor procurado está ou não na lista)
        "on the left"    :  None, # um integer    (quantidade de elementos à esquerda)
        "on the right"   :  None  # outro integer (quantidade de elementos à direita)
    }

    # se o índice do elemento procurado for '-1', ou seja, se não estiver presente na lista:
    if itemIndex == -1:

        # presença do elemento procurado na lista = falso
        returnable["is on the list"] = False

        # também se torna dispensável trocarmos os valores da quantidade de elementos à esquerda / direita, já que eles não poderão ser contados
    #
    
    # caso contrário (se o elemento estiver na lista)
    else:

        # presença do elemento procurado na lista = verdadeiro
        returnable["is on the list"] = True

        # quantidade de itens à esquerda = índice do item procurado, pois a contagem em listas começa em 0
        returnable["on the left"] = itemIndex

        # quantidade de itens à direita = tamanho total da lista - índice do item procurado - 1 (para desconsiderar o item alvo)
        returnable["on the right"] = len(referenceList) - itemIndex - 1
    #
    
    # retornando o dicionário
    return returnable
#

# criando uma função main para ser executado apenas dentro deste mesmo arquivo
def main() -> None:

    # criando uma lista de valores inteiro para testarmos o nosso código
    # é a mesma lista utilizada nos exemplos, a fim de visulizar o melhor funcionamento do código >>>
    intList = [1, 5, 11, 15, 20, 21, 24, 45, 67, 76]

    # elemento que estamos procurando
    intTarget = 45

    # armazenando o índice de elemento procurado em relação a lista
    intIndex = binarySearch(intList, intTarget)

    # armazenando os dados obtidos referente ao relacionamento entre a lista e o elemento procurado
    leftAndRight = itemCounter(intList, intIndex)

    # caso o elemento procurado não esteja na lista
    if leftAndRight["is on the list"] == False:

        # printar texto
        print("O valor " + str(intTarget) + "\033[0;31m" + " não foi encontrado " + "\033[0m" +"na lista!")

        print("Logo," + "\033[0;31m" + " não é possível " + "\033[0m" + "determinar quantos elementos temos à esquerda e/ou direita.")
    #
        
    # caso o elemento esteja na lista
    else:

        # printar texto
        print("O valor " + str(intTarget) + "\033[0;32m" + " foi encontrado " + "\033[0m" +"na lista!")

        print("À esquerda do item" + "\033[0;32m" + f" '{intTarget}'" + "\033[0m" + ", temos: " + str(leftAndRight["on the left"]) + " elementos.")

        print("À direita do item" + "\033[0;32m" + f" '{intTarget}'" + "\033[0m" + ", temos: " + str(leftAndRight["on the right"]) + " elementos.")
    #
#

# caso você esteja executando esse script de forma direta:'    
if __name__ == "__main__":

    # chamar a função principal
    main()
#