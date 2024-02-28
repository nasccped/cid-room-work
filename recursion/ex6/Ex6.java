/*
 * Escreva código recursivo para par e ímpar sabendo que zero é
 * par, mas não é ímpar. Um número positivo é par se seu antecessor
 * é ímpar. Um número positivo é ímpar se seu antecessor é par. Um
 * número negativo é par (ou ímpar) se o seu oposto for par (ou ímpar).
*/

import java.util.Scanner;

public class Ex6{
    
    // função que testa se o valor inteiro oferecido é par ou ímpar
    public static String evenOdd(int value, String defaultName){

        // condição para quando o valor oferecido for negativo
        boolean itsNegative = value < 0;

        // caso seja negativo
        if(itsNegative){

            // retorne a mesma função mas com o valor em positivo
            return evenOdd(Math.abs(value), defaultName);
        }

        // se o valor for igual 0 (condição final)
        else if(value == 0){

            // se o defaultName estiver como 'par'
            if(defaultName == "par"){

                // retorne 'par', já que 0 é par
                return "par";
            }

            // se o defaultName estiver como 'ímpar'
            else{

                // retorne 'ímpar', já que contradiz a condição indicada acima
                return "ímpar";
            }
        }

        // caso nenhuma condição tenha sido atingida
        else{

            // retorne a mesma função com decremente no valor e alternação entre às possibilidades de retorno (par e impar)
            return evenOdd(value - 1, (defaultName == "par") ? "ímpar" : "par");
        }
    }

    public static void main(String[] args) {
        
        // atribuindo o método de receber response à variável 'input'
        Scanner input = new Scanner(System.in);


        // ----------

        // perguntando valor ao usuário
        System.out.print("Diga um valor inteiro, positivo ou negativo: ");

        // atribuindo o valor oferecido
        int userValue = Integer.parseInt(input.nextLine());

        // pulando linha
        System.out.println("");


        // ----------

        // atribuindo resultado da operação
        String result = evenOdd(userValue, "par");

        // exibindo texto com resultado
        System.out.println("O número \u001b[1;33m'" + userValue + "'\u001b[0m é \u001b[1;32m" + result + "\u001b[0m");

        // fechando scanner
        input.close();
    }
}
