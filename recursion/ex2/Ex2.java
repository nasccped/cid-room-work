// Escreva Código Recursivo Para Multiplicação

// importando scanner para obter respostas do usuário
import java.util.Scanner;

public class Ex2{

    // criando função para cálculo de multiplicação com recursão
    public static int multiFunction(int valueA, int valueB){

        // área destinada a pegar condições de valores inseridos
        boolean zeroPresence = valueA == 0 || valueB == 0; // se pelo menos um dos valores for 0
        boolean bothNegative = valueA <  0 && valueB <  0; // se os dois valores forem negativos
        boolean halfNegative = valueA <  0 || valueB <  0; // se pelo menos um dos valores for negativo
        boolean onePresence  = valueA == 1 || valueB == 1; // se pelo menos um do valor for 1

        // caso haja 0
        if(zeroPresence){

            // qualquer número multiplicado por 0 é igual 0, logo:
            return 0;
        }

        // caso ambos sejam negativos
        else if(bothNegative){

            // qualquer número negativo multiplicado por outro negativo é igual a multiplicação dos mesmos quando positivos, logo:
            return multiFunction(Math.abs(valueA), Math.abs(valueB));
        }

        // caso pelo menos um seja negativo
        else if(halfNegative){

            /*
             * um número negativo multiplicado por outro positivo e a mesma coisa que multiplicar os dois em sua forma positiva
             * e no fim obter o resultado trivial, mas em seu valor negativo, logo:
            */
            return (-1 * multiFunction(Math.abs(valueA), Math.abs(valueB)));
        }

        // caso pelo menos um dos valores seja 1
        else if(onePresence){

            // retorne o valor 'A' caso 'B' seja = 1, se não, retorne o valor 'B'
            return (valueB == 1) ? valueA : valueB;
        }

        // caso nenhuma condição seja atendida
        else{

            /*
             * retorne o valor 'A' somado ao resultado dessa mesma função com decremento no valor 'B' até que saia
             * da recursão e obtenha-se um valor final
            */
            return valueA + multiFunction(valueA, (valueB - 1));
        }

    }

    // função principal de execução do nosso código
    public static void main(String[] args) {
        
        // atribuindo o método de receber response à variável 'input'
        Scanner input = new Scanner(System.in);


        // ----------

        // texto inicial
        System.out.println("Vamos realizar uma \u001b[0;33mmultiplicação\u001b[0m:\n");

        // pergunta para o primeiro valor
        System.out.print("Primeiro, diga um valor inteiro, positivo ou negativo para o \u001b[0;33mprimeiro\u001b[0m número: ");

        // atribuindo o primeiro valor
        int firstValue = Integer.parseInt(input.nextLine());

        // pulando linha
        System.out.println("");


        // ----------

        // pergunta para o segundo valor
        System.out.print("Agora, diga um valor inteiro, positivo ou negativo para o \u001b[0;33msegundo\u001b[0m número: ");

        // atribuindo o segundo valor
        int lastValue = Integer.parseInt(input.nextLine());

        // pulando linha
        System.out.println("");


        // ----------

        // atribuindo resultado da operação
        int result = multiFunction(firstValue, lastValue);


        // exibindo texto com resultado
        System.out.println("O resultado foi: \u001b[0;32m" + result + "\u001b[0m");

        // fechando scanner
        input.close();
    }
    
}
