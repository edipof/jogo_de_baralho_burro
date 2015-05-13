package baralho;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
public class Baralho {

	private ArrayList<Carta> baralho;

	public Baralho() {
		this.baralho = new ArrayList<Carta>();
		for (int i = 0; i < 13; i++) {
			ValorCarta valor = ValorCarta.values()[i];

			for (int j = 0; j < 4; j++) {
				Carta carta = new Carta(Naipe.values()[j], valor);
				this.baralho.add(carta);
			}
		}
		
	}
	
	public void embaralhar(){
		Collections.shuffle(baralho);
	}
	
	public void imprimirBaralho(){
		Iterator<Carta> cardIterator = baralho.iterator();
	    while (cardIterator.hasNext())
	    {
	      Carta aCard = cardIterator.next();
	      System.out.println(aCard.getValorCarta() + " de " + aCard.getNaipe());
	    }
	}

}
