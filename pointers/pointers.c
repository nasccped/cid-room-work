//
// Desenvolva um c�digo em C para gerenciar informa��es sobre alunos de um curso sobre Star Wars.
// 
// Crie uma struct para representar cada aluno, contendo nome, n�mero de matr�cula e notas das
// avalia��es do curso (s�o tr�s avalia��es, uma sobre os planetas, outra sobre os Jedi e uma
// sobre o enredo).
//
// Use aloca��o din�mica para criar um array de structs de pelo menos 10 alunos.
// 
// Implemente fun��es que recebam esse array (ou um ponteiro para ela) como argumento para calcular
// m�dias e exibir informa��es.
//
// Considere o uso de callbacks para usar duas t�cnicas diferentes de
// c�lculo de m�dia. N�o se esque�a de liberar a mem�ria alocada ao final do programa
//

// passo a passo:
// 1. chamar as bibliotecas necess�rias:
#include <stdio.h>
#include <stdlib.h>
#include <locale.h>

// 2. criar a struct aluno
struct Aluno{
    
    // aluno ir� conter:
    char  nome[50] ; // o nome
    int   matricula; // o numero de matriicula
    float notas[3] ; // tr�s notas, uma para cada avalia��o citada anteriormente
};

// 3. fun��o para calcular m�dia
void calcularMedia(float valor1, float valor2, float valor3){

    // atribuindo resultado
    float result = (valor1 + valor2 + valor3) / 3;

    // printando resultado
    printf("\033[1;34mM�dia obtida:\033[0m %.2f\n", result);
}

// 4. fun��o para printar dados
void exibirDados(struct Aluno obj){

    // exibindo nome e matr�cula
    printf("\033[1;33mNome:\033[0m %s ", obj.nome);
    printf("\t\033[1;33mMatr�cula:\033[0m %d\n", obj.matricula);
    printf("\033[1;33mNotas:\033[0m\t");

    // exibindo as tr�s notas
    for(int i = 0; i < 3; i++){

        printf(" %.2f ", obj.notas[i]);
    }

    printf("\n");

    // exibindo o calculo de m�dia
    calcularMedia(obj.notas[0], obj.notas[1], obj.notas[2]);

    printf("\n\n");
}


// 5. usar aloca��o din�mica para criar um array de 10 alunos
int main(void){

    // fun��o para poder printar caracteres especiais e acentuados
    setlocale(LC_ALL, "Portuguese_Brazil");

    // n�mero de aluno criados:
    int numeroDeAlunos = 10;

    // aloca��o de mem�ria
    struct Aluno *alunos = (struct Aluno *)malloc(numeroDeAlunos * sizeof(struct Aluno));

    // adicionando 10 alunos ao nosso array
    for(int i = 0; i < 10; i++){

        sprintf(alunos[i].nome, "Aluno(a) %d", i + 1); // setando nome
        alunos[i].matricula = 1001 + i               ; // settando matricula

        // settando 3 notas aleat�rias para calcular a m�dia
        for(int j = 0; j < 3; j++){

            // atribuindo um flutuante aleat�rio
            alunos[i].notas[j] = rand() % 11;
        }
    }

    // exibindo dados para cada aluno dentro da nossa array de alunos
    for(int i =0; i < 10; i++){

        exibirDados(alunos[i]);
    }

    // liberando dados
    free(alunos);

    return 0;
}