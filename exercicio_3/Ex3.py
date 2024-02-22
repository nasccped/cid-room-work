"""
Refaça as funções de busca sequencial e
busca binária assumindo que a lista
possui chaves que podem ocorrer múltiplas
vezes na lista. Neste caso, você deve
retornar uma lista com todas as posições
onde a chave foi encontrada. Se a chave
não for encontrada na lista, retornar
uma lista vazia.
"""
# Não entendi ao certo do porque utilizar a função de busca binária para tal desafio
# fazer apenas com a sequencial seria muito mais simples
# sem contar que a binária exige que a lista alvo esteja ordenada, coisa que se
# for o caso, acaba prejudicando no critério de avaliação da repetição de valores


# criando uma função de busca sequencial
def sequentialSearch(targetList: list[int], targetValue: int, startPoint: int = 0) -> int:
    """
    A função atual pode receber até três argumentos:

    1. 'targetLit'   : lista alvo onde o elemento será procurado
    2. 'targetValue' : elemento que deverá ser procurado dentro da lista
    3. 'startPoint'  : índice inicial para a procura dentro da lista

    Esse último se faz importante já que com ele conseguiremos ignorar os
    itens que já foram encontrados e poderemos passar para o próximo

    A função irá retornar obrigatoriamente um valor inteiro, podendo ser
    um valor maior/igual a zero que represente o índice do elemento procurado,
    ou também '-1' para representar a ausência do elemento procurado dentro
    da lista
    """

    # obtendo o tamanho máximo da lista a partir da função len()
    maxLength = len(targetList)

    # fazendo um loop que dentro do escopo: (índice inicial, índice final - 1)
    for i in range(startPoint, maxLength):

        # caso o elemento da lista baseado no índice atual seja igual ao valor buscado, retorne o índice obtido
        if targetList[i] == targetValue: return i

        # caso contrário, o loop continua até que se encerre
    #
    
    # caso não tenha sido obtido nenhum retorno durante o loop, retorne -1 para indicar a ausência do item procurado
    return -1
#

# criando um função para obter os índices onde determinado elemento se repete
def repetitionFinder(targetList: list[int], targetValue: int) -> list[int]:
    """
    Já essa função, receberá dois argumentos, sendo eles:

    1. 'targetList'  : a lista alvo onde iremos procurar o elemento
    2. 'targetValue' : o elemento que será procurado dentro da lista

    Essa função tem como objetivo trazer os índices onde o elemento procurado
    se repete, fazendo uso da função criada anteriormente.

    A função irá retornar uma lista que pode conter um ou mais valores que
    representem o índice do item procurado, ou se não, uma lista vazia,
    caso o elemento não tenha sido encontrado
    """

    # criando uma variável para armazenar os índices obtidos
    returnable = []

    # criando um ponteiro que servirá para determinar em qual ponto da lista estamos
    pointer = 0

    # enquanto ponteiro for menor que tamanho máximo da lista ->
    while pointer < len(targetList):

        # atribua o valor retornado da função à uma variável
        currentIndex = sequentialSearch(targetList, targetValue, pointer)

        # caso o valor seja '-1' (elemento não está presente na lista)
        if currentIndex == -1:
            
            # pare o loop (se não tem mais nenhum elemento procurado, não faz sentido continuar o loop)
            break
        #

        # caso o valor seja outro
        else:
            
            # atribua o valor do índice atual + 1 para procurar a partir do seguinte elemento na próxima iteração
            pointer = currentIndex + 1

            # adicione o índice atual à nossa lista
            returnable.append(currentIndex)
        #
    #
    
    # retorne a lista antes criada
    return returnable
#

# criando uma função main para ser executado apenas dentro deste mesmo arquivo
def main():

    # criando uma lista de inteiros com valores repetidos a fim de testar o nosso programa
    intList = [2, 3, 4, 4, 5, 6, 4, 4, 7, 4, 9]

    # atribuindo o item procurado à uma variável
    intTarget = 4

    # lista de índices onde pudemos encontrar o nosso valor alvo
    finalList = repetitionFinder(intList, intTarget)

    # se o tamanho da lista for 0, ou seja, se o item procurado não estiver na 'intList'
    if len(finalList) == 0:

        # printar texto
        print("Infelizmente, o valor " + str(intTarget) + " \033[0;31m" + "não está presente" + "\033[0m " + "na lista alvo!\n")

        print(finalList)
    #
    
    # caso contrário
    else:

        # printar texto
        print("À seguir, uma lista dos índices onde o elemento" + " \033[0;32m'" + str(intTarget) + "'\033[0m " + "se repetem:\n")

        print(finalList)
    #
#

# caso você esteja executando esse script de forma direta:
if __name__ == "__main__":

    # chamar a função principal
    main()
#