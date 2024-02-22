"""
Refaça as funções de busca sequencial substituindo o for por while.
"""

# criando a função de busca
def itemSearch(targetList: list[int], targetValue: int) -> int:
    """
    A função irá receber dois argumentos:

    1. 'targetList'  : uma lista de valores Integers
    2. 'targetValue' : o valor procurado

    Obrigatoriamente, a função irá retornar um valor inteiro, sendo ele
    o valor (maior ou igual à 0) que representa o índice do item
    procurado dentro da lista, ou '-1' para caso o valor não seja encontrado
    """

    # inicializando uma variável para armazenar o tamanho da nossa lista - 1 (pois toda lista começa a sua contagem em 0 e termina no [nº total de elementos - 1])
    listRange = (len(targetList) - 1)

    # inicializando uma variável para ser utilizada no loop while
    loopVariable = 0

    # realizando loop para: "enquanto variável de loop for maior que -1". basicamente loop infinito
    while (loopVariable > (-1)):

        # se o elemento da lista alvo (determinado por um índice obtido com a variável 'loopVariable') for igual ao item procurado, retorne o valor desse índice (automaticamente encerra o loop e a função)
        if targetList[loopVariable] == targetValue: return loopVariable

        # caso contrário, se a variável de loop for menor que o tamanho total da lista, incremente +1 à essa mesma variável
        elif loopVariable < listRange: loopVariable += 1

        # caso as duas afirmações acima sejam falsas, encerre o loop com a keyword 'break'
        else: break
    #
    
    # irá retornar -1 apenas se o loop acima tiver sido quebrado por meio de um 'break', ou seja, se o valor alvo não tiver sido encontrado
    return -1
#


# criando uma função main para ser executado apenas dentro deste mesmo arquivo
def main() -> None:

    # criando uma lista de valores inteiro para testarmos o nosso código
    # é a mesma lista utilizada nos exemplos, a fim de visulizar o melhor funcionamento do código >>>
    intList = [20, 5, 15, 24, 67, 45, 1, 76, 21, 11]

    # o item que iremos procurar
    intTarget = 45

    # atribuindo o valor retornado da função de busca baseado na lista e no valor alvo, à uma variável
    intTargetIndex = itemSearch(intList, intTarget)

    # caso tenha sido obtido o índice:
    if intTargetIndex != -1:

        # printar texto
        print("O valor " + str(intTarget) + " \033[0;32m" + "foi encontrado" + "\033[0m " + "dentro da lista!")

        print("O seu índice é: " + str(intTargetIndex))
    #
    
    # caso contrário
    else:

        # printar texto
        print("O valor alvo " + str(intTarget) + " \033[0;31m" + "não foi encontrado" + "\033[0m " + "dentro da lista!")

        print("O seu índice foi retornado como: " + str(intTargetIndex))
    #
#

# caso você esteja executando esse script de forma direta:
if __name__ == "__main__":

    # chamar a função principal
    main()
#