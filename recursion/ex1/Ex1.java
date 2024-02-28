// Escreva código recursivo para exponenciação

// importando biblioteca para avaliar a response do usuário
import java.util.Scanner;

public class Ex1{

    /*
     * criando uma função que calcula exponenciação por meio de recursão
     * 
     * o resultado retornado será do tipo double considerando a possibilidade
     * de ser entregue um expoente de valor negativo (realizada operações semelhantes
     * a raízes)
    */
    public static double exponentiationCalculator(int base, int exponent){

        // caso a base seja igual a 0
        if(base == 0){

            /*
             * 0 pode ser multiplicado, independentemente do valor ou da quantidade de vezes
             * sempre irá retornar 0
             * logo:
            */
            return 0;
        }

        // caso o expoente seja igual a 0
        else if(exponent == 0){

            /*
             * apesar de ser contra a lógica, o resultado será 1
             * logo:
            */
            return 1;
        }

        // caso o expoente seja igual a 1
        else if(exponent == 1){

            /*
             * qualquer número elevado à 1 é igual ele mesmo
             * logo:
            */
            return base;
        }

        // caso o expoente seja igual a -1
        else if(exponent == -1){

            /*
             * retornar 1 dividido pela base, que no caso, é a formula simplificada
             * para operações em que o expoente é -1
            */
            return 1 / base;
        }

        // caso o expoente seja maior que 1
        else if(exponent > 1){

            /*
             * retorne a base (que não muda) veze essa mesma função com decremento de
             * 1 inteiro no expoente
             * dessa forma, mesmo que seja um expoente muito alto, as bases irão se
             * multiplicar até que o expoente se torne 1, logo, uma operação exponencial
            */
            return base * exponentiationCalculator(base, (exponent - 1));
        }

        /*
         * caso contrário:
         * considerando que recebamos apenas valores inteiros como expoentes, e também,
         * todas as condições anteriormente citadas, o único cenário que sobrou foi
         * caso o expoente seja negativo, dessa forma é so fazermos o mesmo de cima,
         * mas incrementando o expoente
        */
        else{

            /*
             * retorne o valor com exponente = -1 multiplicado pelos seus sucessores
             * até que exponent = -1
            */
            return (1 / base) * exponentiationCalculator(base, (exponent + 1));
        }
    }

    // função main para execução do nosso código:
    public static void main(String[] args) {
        /*
         * apesar de completamente correto e bem estruturado,
         * caso seja inserido um valor negativo como expoente
         * o programa irá retornar 0.0 e não o valor real,
         * confesso que não sei o porquê disso acontecer
        */
        
        // atribuindo o método de receber response à variável 'input'
        Scanner input = new Scanner(System.in);

        // ----------

        // printando texto para perguntar base
        System.out.print("Primeiro, diga um valor inteiro, positivo ou negativo, que corresponderá à \u001b[1;33mBase\u001b[0m da nossa operação: ");

        // esperando valor para base
        int baseValue = Integer.parseInt(input.nextLine());

        // pulando linha
        System.out.println("");

        // ----------

        // printando texto para perguntar expoente
        System.out.print("Agora, diga um valor inteiro, positivo ou negativo, que corresponderá ao \u001b[1;33mExpoente\u001b[0m da nossa operação: ");

        // esperando valor para expoente
        int exponentValue = Integer.parseInt(input.nextLine());

        // pulando linha
        System.out.println("\n");

        // ----------

        // atribuindo resultado à uma variável
        double value = exponentiationCalculator(baseValue, exponentValue);

        // printando resultado
        System.out.println("O resultado da operação foi: \u001b[1;32m" + value + "\u001b[0m");

        // fechando input
        input.close();
    }
}