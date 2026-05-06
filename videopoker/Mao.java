

import java.util.Scanner;
import java.util.Vector;

public class Mao{
    private Carta[] mao = new Carta[5];
    private Vector<Carta> descartes = new Vector<Carta>();

    public void setMao(Baralho b){
		descartes.clear();
        for(int i = 0; i < 5; i++){
            mao[i] = b.remove(0);
        }
    }

    public void setMao(Baralho b, String troca){
        Scanner sc = new Scanner(troca);
		boolean[] vet = new boolean[mao.length];
		int i = 0;
		while ( sc.hasNextInt()) 
		{
			i = sc.nextInt() - 1;
			if (i >= 0 && i < mao.length )
				vet[i] = true;
		}
		sc.close();
        i=0;
		for (boolean v: vet)
		{
			if (i >= mao.length ) break;
			if ( v ) {
                descartes.add(mao[i]);
                mao[i] = b.remove(0);
            }
			i++;
		}
    }

	public Carta[] getMao(){
		return this.mao;
	}

	public Vector<Carta> getDescartes(){
		return this.descartes;
	}


    @Override
    public String toString() {
        String s = "\n";
		for (int i = 0; i < 5; i++)
		{
			int base = i * 8;
			for (Carta d: this.mao )
			{
				String p = d.toString();
				// System.out.println(p);
				s += p.substring(base, base+7);
				s += " ";
			}
			s+= "\n";
		}
        s+="  (1)     (2)     (3)     (4)     (5)\n";
		return s;
    }
}
