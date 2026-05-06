

public class Carta {

    private Naipe naipe;
    private int valor;

    public Carta(int valor, Naipe naipe){
        this.naipe = naipe;
        this.valor = valor;
    }

    public Naipe getNaipe(){
        return this.naipe;
    }

    public int getValor(){
        return this.valor;
    }

    @Override
    public String toString() {
        String s = "+-----+\n|     |\n| ";
        switch (this.valor) {
            case 11:
                s+= "J ";
                break;
            case 12:
                s+= "Q ";
                break;
            case 13:
                s+= "K ";
                break;
            case 14:
                s+= "A ";
                break;
            case 10:
                s+="10";
                break;
            default:
                s+= Integer.toString(this.valor)+" ";
                break;
        }
        switch(this.naipe){
            case C:
                s+= "\u2665 |\n";
                break;
            case P:
                s+= "\u2663 |\n";
                break;
            case O:
                s+= "\u2666 |\n";
                break;
            case E:
                s+=  "\u2660 |\n";
                break;
        }

        s+= "|     |\n+-----+\n";

        return s;
    }

}