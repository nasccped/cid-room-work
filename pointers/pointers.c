//
// Desenvolva um código em C para gerenciar informações sobre alunos de um curso sobre Star Wars.
// 
// Crie uma struct para representar cada aluno, contendo nome, número de matrícula e notas das
// avaliações do curso (são três avaliações, uma sobre os planetas, outra sobre os Jedi e uma
// sobre o enredo).
//
// Use alocação dinâmica para criar um array de structs de pelo menos 10 alunos.
// 
// Implemente funções que recebam esse array (ou um ponteiro para ela) como argumento para calcular
// médias e exibir informações.
//
// Considere o uso de callbacks para usar duas técnicas diferentes de
// cálculo de média. Não se esqueça de liberar a memória alocada ao final do programa
//

// passo a passo:
// 1. chamar as bibliotecas necessárias:
#include <stdio.h>
#include <stdlib.h>
#include <locale.h>

// 2. criar a struct aluno
struct Aluno{
    
    // aluno irá conter:
    char  nome[50] ; // o nome
    int   matricula; // o numero de matriicula
    float notas[3] ; // três notas, uma para cada avaliação citada anteriormente
};

// 3. função para calcular média
void calcularMedia(float valor1, float valor2, float valor3){

    // atribuindo resultado
    float result = (valor1 + valor2 + valor3) / 3;

    // printando resultado
    printf("\033[1;34mMédia obtida:\033[0m %.2f\n", result);
}

// 4. função para printar dados
void exibirDados(struct Aluno obj){

    // exibindo nome e matrícula
    printf("\033[1;33mNome:\033[0m %s ", obj.nome);
    printf("\t\033[1;33mMatrícula:\033[0m %d\n", obj.matricula);
    printf("\033[1;33mNotas:\033[0m\t");

    // exibindo as três notas
    for(int i = 0; i < 3; i++){

        printf(" %.2f ", obj.notas[i]);
    }

    printf("\n");

    // exibindo o calculo de média
    calcularMedia(obj.notas[0], obj.notas[1], obj.notas[2]);

    printf("\n\n");
}


// 5. usar alocação dinâmica para criar um array de 10 alunos
int main(void){

    // função para poder printar caracteres especiais e acentuados
    setlocale(LC_ALL, "Portuguese_Brazil");

    // número de aluno criados:
    int numeroDeAlunos = 10;

    // alocação de memória
    struct Aluno *alunos = (struct Aluno *)malloc(numeroDeAlunos * sizeof(struct Aluno));

    // adicionando 10 alunos ao nosso array
    for(int i = 0; i < 10; i++){

        sprintf(alunos[i].nome, "Aluno(a) %d", i + 1); // setando nome
        alunos[i].matricula = 1001 + i               ; // settando matricula

        // settando 3 notas aleatórias para calcular a média
        for(int j = 0; j < 3; j++){

            // atribuindo um flutuante aleatório
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