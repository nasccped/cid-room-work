"""
Use a função desenvolvida acima para,
dada uma lista ordenada de n números
inteiros, uma chave X e dois outros
inteiros Y e Z, retornar o número de
chaves da lista que são maiores ou iguais
a Y e o número de chaves da lista que são
menores ou iguais a Z.
"""

# Tudo que eu preciso é retornar a quantidade
# de items maiores ou iguais a 'Y' e a quantidade
# de items menores ou iguais a 'Z'. Isso acaba
# tornando o argumento 'X' inutilizável. Dessa
# forma, irei considerar que 'X' deva ser a entrada
# para a lista

# função que testa a ordenação de uma lista
def isOrdered(targetList: list[int]) -> bool:

    # atribuindo o range da nossa lista à uma variável
    listRange = len(targetList)

    # fazendo um loop que vai de 1 -> range da nossa lista
    for i in range(1, listRange):

        # se o elemento atual for menor que o anterior, significa que a lista não está ordenada. logo retorne 'False'
        if targetList[i] < targetList[i - 1]: return False

        # retornar um valor aqui faz com que o resto da função não seja executada
        # caso a afirmação acima seja falas, o loop irá continuar
    #

    # se o loop acima tiver sido executado e não ter retornado 'False', significa que a lista está ordenada, logo, retorne 'True'
    return True
#

# função que retorna uma lista em sua forma ordenada
def listOrderer(unorderedList: list[int]) -> list[int]:

    listRange = len(unorderedList)

    # enquanto !isOrdered(nossaLista) == enquanto nossa lista não estiver ordenada
    while (not isOrdered(unorderedList)):

        # fazendo um loop que começa em 1 e termina no último índice de nossa lista
        for i in range(1, listRange):

            # se o elemento atual for menor que o anterior ->
            if unorderedList[i] < unorderedList[i - 1]:

                # criar uma variável temporária para armazenar o valor do elemento atual
                tempVariable = unorderedList[i]

                # alterar o valor do elemento atual para o valor do elemento anterior
                unorderedList[i] = unorderedList[i - 1]

                # alterar o valor do elemento anterior para o valor da variável temporária, ou seja, do elemento atual
                unorderedList[i - 1] = tempVariable

                # deletando a variável que entrou em desuso
                del tempVariable
            #
        #
    #
    
    # retornando a lista já ordenada
    return unorderedList
#

# função que retorna o índice de um elemento dentro de uma lista
def itemSearch(targetList: list[int], targetValue: int) -> int:

    # fazendo um loop for dentro da nossa lista alvo
    for i, item in enumerate(targetList):

        # se o item atual corresponder ao item procurado, retorne o índice desse item
        if item == targetValue: return i
    #
    
    # caso o loop acima tenha sido executado e não tenha retornado nada, significa que o item procurado não está na lista, logo retorne -1
    return -1
#

# função que realiza a contagem de elementos
def leftAndRight(X: list[int], Y: int, Z: int) -> None:
    """
    Essa função receberá como argumento 3 parâmetros:

    1. 'X' : informa a lista onde será realizada a busca
    2. 'Y' : entra como valor inteiro e informa quantos valores são iguais e/ou maiores ao primeiro deste mesmo encontrado na lista
    3. 'Z' : entra como valor inteiro e informa quantos valores são iguais e/ou menores ao primeiro deste mesmo encontrado na lista

    Por conter muitos elementos a serem avaliados, essa função não retorna nada. Apenas exibe texto na tela
    """

    # ordenando a lista
    X = listOrderer(X)

    # obtendo o tamanho da lista, pois será útil posteriormente
    X_LENGTH = len(X)

    # encontrando o índice do Y dentro da lista X
    Y_INDEX = itemSearch(X, Y)

    # encontrando o índice do Z dentro da lista X
    Z_INDEX = itemSearch(X, Z)

    # se o índice de Y for '-1', ou seja, se ele não estiver na lista
    if Y_INDEX == -1:

        # printar texto
        print(f"Infelizmente o valor de 'Y' ({Y}) não está presente na lista, logo, não é possível saber quantos elementos são maiores e/ou iguais à ele...\n") 
    #
    
    # caso contrário
    else:

        # printar texto
        print(f"O índice do valor de 'Y' ({Y}) após a lista ter sido ordenada é de {Y_INDEX}, ou seja, existem {X_LENGTH - Y_INDEX - 1} elementos maiores e/ou iguais ao primeiro '{Y}' encontrado...\n")
    #

    # se o índice de Z for '-1', ou seja, se ele não estiver na lista
    if Z_INDEX == -1:

        # printar texto
        print(f"Infelizmente o valor de 'Z' ({Z}) não está presente na lista, logo, não é possível saber quantos elementos são menores e/ou iguais à ele...\n") 
    #
    
    # caso contrário
    else:

        # printar texto
        print(f"O índice do valor de 'Z' ({Z}) após a lista ter sido ordenada é de {Z_INDEX}, ou seja, existem {Z_INDEX} elementos menores e/ou iguais ao primeiro '{Z}' encontrado...\n")
    #
#

# criando uma função main para ser executado apenas dentro deste mesmo arquivo
def main() -> None:

    # criando a nossa lista com valores desordenados e repetidos
    intList = [1, 3, 2, 2, -3, 4, 76, 2, 1, 11]

    # atribuindo valor à 'Y'. serão procurados todos os valores maiores e/ou iguais a ele
    Y = 2

    # atribuindo valor à 'Z'. serão procurados todos os valores menores e/ou iguais a ele
    Z = 11

    # executando a função de exibição de texto
    leftAndRight(intList, Y, Z)
#

# caso você esteja executando esse script de forma direta:
if __name__ == "__main__":

    # chamando a função principal
    main()
#