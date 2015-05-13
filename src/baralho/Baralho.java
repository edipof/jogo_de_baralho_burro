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
		Iterator<Carta> cartaIterator = baralho.iterator();
	    while (cartaIterator.hasNext()){
	      Carta aCarta = cartaIterator.next();
	      System.out.println(aCarta.getValorCarta() + " de " + aCarta.getNaipe());
	    }
	}
	
	public Carta getCarta(){
		Naipe naipe = baralho.get(0).getNaipe();
		ValorCarta valorCarta = baralho.get(0).getValorCarta();
		baralho.remove(0);
		Carta carta = new Carta(naipe, valorCarta);
		return carta;
	}
	
	public Boolean temCarta(){
		if(!baralho.isEmpty())
			return true;
		return false;
	}
}
