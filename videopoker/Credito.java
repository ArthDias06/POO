
import java.util.Vector;

public class Credito{
    private int creditos;

    public Credito(int c){
        this.creditos = c;
    }

    public int getCredito(){
        return this.creditos;
    }

    public void setCredito(int c){
        this.creditos = c;
    }

    public void pontos(Mao m, Credito c, int n){
        if(checkRoyalStraightFlush(m)){
            System.out.println("Parabéns. Você acrescentou $"+(n*200)+" ao seu saldo");
            c.setCredito(n*200+c.getCredito());
        }
        else if(checkStraightFlush(m)){
            System.out.println("Parabéns. Você acrescentou $"+(n*100)+" ao seu saldo");
            c.setCredito(n*100+c.getCredito());
        }
        else if(checkRepeticao(m, 3)){
            System.out.println("Parabéns. Você acrescentou $"+(n*50)+" ao seu saldo");
            c.setCredito(n*50+c.getCredito());
        }
        else if(checkFullHand(m)){
            System.out.println("Parabéns. Você acrescentou $"+(n*20)+" ao seu saldo");
            c.setCredito(n*20+c.getCredito());
        }
        else if(checkFlush(m)){
            System.out.println("Parabéns. Você acrescentou $"+(n*10)+" ao seu saldo");
            c.setCredito(n*10+c.getCredito());
        }
        else if(checkStraight(m)){
            System.out.println("Parabéns. Você acrescentou $"+(n*5)+" ao seu saldo");
            c.setCredito(n*5+c.getCredito());
        }
        else if(checkRepeticao(m, 2)){
            System.out.println("Parabéns. Você acrescentou $"+(n*2)+" ao seu saldo");
            c.setCredito(n*2+c.getCredito());
        }
        else if(checkDoisPares(m)){
            System.out.println("Parabéns. Você acrescentou $"+(n)+" ao seu saldo");
            c.setCredito(n+c.getCredito());
        }
        else{
            System.out.println("Peninha... não ganhou nada nessa rodada");
        }
    }

    public Boolean checkRoyalStraightFlush(Mao m){
        Vector<Integer> validas = new Vector<>();
        for(int i =10; i < 15; i++){
            validas.add(i);
        }
        Carta[] cartas = m.getMao();
        for(Carta c : cartas){
            for(int i = 0; i < validas.size(); i++){
                if(c.getValor() == validas.get(i)){
                    validas.remove(i);
                    break;
                }
            }
        }
        if(validas.size() != 0){
            return false;
        }

        if(!checkFlush(m)){
            return false;
        }
        return true;
    }

    public Boolean checkStraightFlush(Mao m){
        if(!checkStraight(m)){
            return false;
        }

        if(!checkFlush(m)){
            return false;
        }
        return true;
    }

    public Boolean checkFullHand(Mao m){
        if(checkRepeticao(m, 2) && checkRepeticao(m, 1)){
            return true;
        }
        return false;
    }

    public Boolean checkFlush(Mao m){
        Carta[] cartas = m.getMao();
        for(int j =0; j<5; j++){
            if(cartas[0].getNaipe() != cartas[j].getNaipe()){
                return false;
            }
        }
        return true;
    }

    public Boolean checkStraight(Mao m){
        Carta[] cartas = m.getMao();
        int menor = cartas[0].getValor();
        for(int i =0; i < cartas.length; i++){
            if(menor > cartas[i].getValor()){
                menor = cartas[i].getValor();
            }
        }

        Boolean flag;
        for(int i =1; i< 5; i++){
            flag = false;
            for(int j =0; j<5; j++){
                if(cartas[j].getValor() == menor+i){
                    flag = true;
                    break;
                }
            }
            if(!flag){
                return false;
            }
        }
        return true;
    }

    public Boolean checkRepeticao(Mao m, int num){
        int cont;
        Carta[] cartas = m.getMao();
        for(int i = 0; i < 5; i++){
            cont = 0;
            for(int j = 0; j < 5; j++){
                if(cartas[i].getValor() == cartas[j].getValor()){
                    cont++;
                }
            }
            if(cont == num+1){
                return true;
            }
        }
        return false;
    }

    public Boolean checkDoisPares(Mao m){
        int cont = 0, num = 0;
        Carta[] cartas = m.getMao();
        for(int i = 0; i < 4; i++){
            for(int j = i+1; j < 5; j++){
                if(cartas[i].getValor() == cartas[j].getValor() && num!=cartas[i].getValor()){
                    if(cont == 0){
                        cont++;
                        num = cartas[i].getValor();
                    }
                    else return true;
                    break;
                }
            }
        }
        return false;
    }
}