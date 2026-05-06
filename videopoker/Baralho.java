
import java.util.Collections;
import java.util.Random;
import java.util.Vector;



public class Baralho extends Vector<Carta> {

    private Random rand;

    public Baralho(int seed) {
        for (Naipe p : Naipe.values())
        {
            for (int i = 2; i <= 14; i++) {
                Carta c = new Carta(i, p);
                this.add(c);
            }
        }
        if (seed == 0)
            rand  = new Random();
        else
            rand  = new Random(seed);
        this.embaralha();
    }

    public void embaralha() {
        Collections.shuffle(this, rand);
    }

    public void retornaBaralho(Mao m){
        for(Carta c: m.getMao()){
            this.add(c);
        }
        for(Carta c:m.getDescartes()){
            this.add(c);
        }
	}
}