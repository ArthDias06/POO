

import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.print("Semente: ");
        int seed = scan.nextInt();
        System.out.print("Saldo inicial: ");
        int c = scan.nextInt();
        Credito cred = new Credito(c);
        String in = "";
        Baralho bar = new Baralho(seed);
        Mao m = new Mao();
        String cartas;
        Verificacao v = new Verificacao();
        scan.nextLine();
        while(cred.getCredito() > 0 && !in.equals("F")){
            System.out.println("Saldo atual: $"+cred.getCredito());
            System.out.print("Digite o valor da aposta of 'F' para terminar ==> ");
            in = scan.nextLine();
            if(v.eInteiro(in))
                c = Integer.parseInt(in);
            else continue;
            if(c > cred.getCredito()){
                System.out.println("Saldo insuficiente. Tecle enter para continuar");
                scan.nextLine();
                continue;
            }
            cred.setCredito(cred.getCredito()-c);
            bar.embaralha();
            m.setMao(bar);
            System.out.print(m);
            for(int i  = 0; i < 2; i++){
                System.out.print("Digite o número das cartas que você deseja trocar, separados por espaços: ");
                cartas = scan.nextLine();
                m.setMao(bar, cartas);
                System.out.print(m);
            }
            cred.pontos(m, cred, c);
            System.out.println("Tecle enter para continuar");
            scan.nextLine();
            bar.retornaBaralho(m);
        }
        if(cred.getCredito() <= 0){
            System.out.println("Seu saldo acabou. Tente jogar outra vez.");
        }else{
            System.out.println("Terminando o jogo... Parabéns você ainda tem saldo de $"+cred.getCredito());
        }
        scan.close();
    }
}