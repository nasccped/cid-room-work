// Escreva código recursivo para calcular MDC

import java.util.Scanner;

public class Ex5 {
    
    // função que cálcula o MDC entre dois valores
    public static int gcmCalculator(int valueA, int valueB){

        // se valor A for menor que zero(negativo)
        if(valueA < 0){

            // torneo positivo
            valueA *= -1;
        }

        // se valor B for menor que zero(negativo)
        if(valueB < 0){

            // torneo positivo
            valueB *= -1;
        }

        // se o valor b for diferente de zero
        if(valueB != 0){

            // retorne a função, mas com o valor B no lugar do valor A, e o resto da divisão de A por B no lugar do valor B
            return gcmCalculator(valueB, valueA % valueB);
        }

        // caso contrário
        else{

            // chegamos ao fim de nossa recursão, logo, retorne o valor A (ele agora é o resultado de nosso MDC)
            return valueA;
        }
    }

    // função principal que irá executar o nosso código java
    public static void main(String[] args) {

        // atribuindo o método de receber response à variável 'input'
        Scanner input = new Scanner(System.in);


        // ----------

        // perguntando valor ao usuário
        System.out.print("Diga um valor inteiro, positivo ou negativo: ");

        // atribuindo o valor oferecido
        int value1 = Integer.parseInt(input.nextLine());

        // pulando linha
        System.out.println("");


        // ----------

        // perguntando valor ao usuário
        System.out.print("Diga o próximo valor inteiro, positivo ou negativo: ");

        // atribuindo o valor oferecido
        int value2 = Integer.parseInt(input.nextLine());

        // pulando linha
        System.out.println("");


        // ----------

        // atribuindo resultado da operação
        int result = gcmCalculator(value1, value2);

        // exibindo texto com resultado
        System.out.println("O MDC resultante para o valor \u001b[1;33m'" + value1 + "'\u001b[0m e \u001b[1;33m'" + value2 + "'\u001b[0m é: \u001b[1;32m" + result + "\u001b[0m");

        // fechando scanner
        input.close();
    }
}
