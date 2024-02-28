// Escreva código recursivo para somar números de 0 a n

import java.util.Scanner;

public class Ex4 {
    
    // criando função recursiva para retornar a soma de todos os dígitos até que chegue em 0
    public static int numberCounter(int targetValue){

        // testando algumas condições
        boolean itsNegative    = targetValue <  0;
        boolean finalCondition = targetValue == 0;

        // se o valor for negativo 
        if(itsNegative){

            //printar texto de erro
            System.out.println("\u001b[0;31mValor menor que zero, logo, inválido!\u001b[0m\n");

            // retorne -1 para expressar a exceção
            return -1;
        }

        // caso a condição final tenha sido atingida
        else if(finalCondition){

            // retorne o valor atual de 'targetValue': 0
            return 0;
        }

        // caso contrário
        else{

            // retorne o valor atual de 'targetValue' somado à essa mesma função com decremento no argumento 'targetValue'
            return targetValue + numberCounter(targetValue - 1);
        }
    }

    // função principal que irá executar o nosso código
    public static void main(String[] args) {
        
        // atribuindo o método de receber response à variável 'input'
        Scanner input = new Scanner(System.in);


        // ----------

        // perguntando valor ao usuário
        System.out.print("Diga um valor inteiro e positivo para encontrarmos o \u001b[0;33mvalor resultante\u001b[0m da operação: ");

        // atribuindo o valor oferecido
        int userValue = Integer.parseInt(input.nextLine());

        // pulando linha
        System.out.println("");


        // ----------

        // atribuindo resultado da operação
        int result = numberCounter(userValue);

        // exibindo texto com resultado
        System.out.println("Resultado da operação obtido a partir de '" + userValue + "' como valor: \u001b[0;32m" + result + "\u001b[0m");

        // fechando scanner
        input.close();
    }
}
