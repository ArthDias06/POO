import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        String number = scan.nextLine();
        String[] numbers = number.split(" ");//Separa os inputs dados pelos espaços
        Tabuleiro tab = new Tabuleiro(numbers);//Criação do objeto de Tabuleiro
        String moves = scan.nextLine();
        tab.PrintTabuleiro();
        for(int i = 0; i < moves.length(); i++){
            if(moves.charAt(i) == 'u'){
                tab.UpMove();
            }
            else if(moves.charAt(i) == 'l'){
                tab.LeftMove();
            }
            else if(moves.charAt(i) == 'r'){
                tab.RightMove();
            }   
            else if(moves.charAt(i) == 'd'){
                tab.DownMove();
            }
            tab.PrintTabuleiro();
        }
        System.out.println("Posicao final: "+tab.Solucao());
        scan.close();
    }
}