// Escreva código recursivo para contar dígitos de um número

import java.util.Scanner;

public class Ex3{
    
    // criando uma função que retorna a quantidade de digitos de um valor
    public static int digitCounter(int value, int recursionCounter){

        // capturando condições
        boolean itsNegative    = value < 0  && recursionCounter == 0; // caso o valor oferecido seja menor que 0 e a contagem de recursão seja 0, sinal de que é a primeira vez de execução do código
        boolean finalCondition = value < 10                         ; // se atingimos a condição final

        // se o valor oferecido for negativo
        if(itsNegative){

            // retorne a mesma função com a troca de sinal, já que independentemente do sinal, a quantidade de dígitos não muda
            return digitCounter(Math.abs(value), recursionCounter);
        }

        // caso a condição final tenha sido atingida
        else if(finalCondition){

            // retorne a contagem de recursão + 1 (já que a contagem inicia-se em 0) 
            return recursionCounter + 1;
        }

        // caso contrário
        else{

            // chame a função novamente dividindo o valor alvo por 10 (tirando uma casa) e incrementando +1 à contagem de recursão
            return digitCounter(value / 10, recursionCounter + 1);
        }
    }

    // função principal de execução do nosso código
    public static void main(String[] args) {
        
        // atribuindo o método de receber response à variável 'input'
        Scanner input = new Scanner(System.in);


        // ----------

        // perguntando valor ao usuário
        System.out.print("Diga um valor inteiro, positivo ou negativo para encontrarmos sua \u001b[0;33mquantidade\u001b[0m de dígitos: ");

        // atribuindo o valor oferecido
        int userValue = Integer.parseInt(input.nextLine());

        // pulando linha
        System.out.println("");


        // ----------

        // atribuindo resultado da operação
        int result = digitCounter(userValue, 0); // o passo da recursão sempre se inicia com 0

        // exibindo texto com resultado
        System.out.println("O valor \u001b[0;33m" + userValue + "\u001b[0m tem: \u001b[0;32m" + result + "\u001b[0m dígitos...");

        // fechando scanner
        input.close();
    }

}
