/*
 * Usando as funções recursivas de fatorial e de exponenciação,
 * escrever o código para resolver a somatória 1+x+x2/2!+x3/3!+...+xn/n!
 * Veja que esta fórmula pode ser interpretada como x^0/0! +
 * x¹/1!+x²/2!+x³/3!+...+xº/n! ou ⅀0..n xn/n!
*/

import java.util.Scanner;

public class Ex7 {

    // função que cálcula fatorial
    public static int factorial(int value){

        // se o valor inserido como argumento for igual 0
        if(value == 0){

            // retorne 1, pois fatorial de 0 é 1
            return 1;
        }

        // se for menor do que zero (um valor negativo)
        if(value < 0){

            // retorne o valor atual multiplicado pelo próximo incrementado em 1 até chegar a 0!
            return value * factorial(value + 1);
        }

        // caso contrário (valor positivo)
        else{

            // retorne o valor atual multiplicado pelo antecessor decrementado em 1 até chegar a 0!
            return value * factorial(value - 1);
        }
    }

    // função que calcula exponenciação
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

    // função que calcula a fórmula citada (Epsilon)
    public static long epsilonCalculator(int baseValue, int times){

        // se a quantidade de vezes de repetição for menor que zero (negativa)
        if(times < 0){

            // torne-a positiva
            return epsilonCalculator(baseValue, Math.abs(times));
        }

        // se o valor base for menor que zero (negativo)
        else if(baseValue < 0){

            // torne-o positivo
            return epsilonCalculator(Math.abs(baseValue), times);
        }

        // se a quantidade de vezes for igual 0
        else if(times == 0){

            // retorne 1, pois qualquer número elevado a 0 é 1, o fatorial de 0 é 1, e 1 dividido por 1 é 1
            return 1;
        }

        // se a quantidade de vezes for maior que zero
        else{

            // retorne essa etapa da fórmula + restante da recursão
            return (long) (exponentiationCalculator(baseValue, times) / factorial(times)) + epsilonCalculator(baseValue, times - 1);
        }
    }

    // função principal do nosso código
    public static void main(String[] args) {
        
        // atribuindo o método de receber response à variável 'input'
        Scanner input = new Scanner(System.in);


        // ----------

        // perguntando valor ao usuário
        System.out.print("Diga um valor inteiro que represente a \u001b[1;33mbase\u001b[0m da fórmula: ");

        // atribuindo o valor oferecido
        int baseValue = Integer.parseInt(input.nextLine());

        // pulando linha
        System.out.println("");
    

        // ----------

        // perguntando valor ao usuário
        System.out.print("Agora, diga um valor inteiro que represente a \u001b[1;33mquantidade de vezes\u001b[0m da fórmula: ");

        // atribuindo o valor oferecido
        int timesValue = Integer.parseInt(input.nextLine());

        // pulando linha
        System.out.println("");


        // ----------

        // atribuindo resultado da operação
        long result = epsilonCalculator(baseValue, timesValue);

        // exibindo texto com resultado
        System.out.println("O resultado da operação foi: \u001b[1;32m" + result + "\u001b[0m");

        // fechando scanner
        input.close();
    }
}
