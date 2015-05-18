package jogador;

import java.util.ArrayList;

import baralho.Carta;
import baralho.Naipe;
import baralho.ValorCarta;

public class MaoDeCartas {
	// Uma MaoDeCartas começa vazia
	// O jogador pode ver as cartas que esta em sua mao
	// O jogador pode adicionar cartas em sua mao
	// O jogador pode escolher e retirar uma carta de sua mao
	private ArrayList<Carta> cartas;

	public MaoDeCartas() {
		this.cartas = new ArrayList<Carta>();
	}

	protected void verMao() {
		if (!cartas.isEmpty()) {
			for (Carta carta : cartas) {
				System.out.println("["+cartas.indexOf(carta)+"]"+ carta.getValorCarta() + " de "
						+ carta.getNaipe() + ",");
			}
		} else {
			System.out.println("Mao vazia!");
		}
	}
	
	protected void addCartaMao(Carta carta){
		cartas.add(carta);
	}
	
	protected Carta escolherCarta(int indexCarta){
		
		try {
			Naipe naipe = cartas.get(indexCarta).getNaipe();
			ValorCarta valorCarta = cartas.get(indexCarta).getValorCarta();
			cartas.remove(indexCarta);
			Carta carta = new Carta(naipe, valorCarta);
			return carta;
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Valor Invalido!");
		}
		
		return null;
	}
	
	protected boolean maoIsEmpty() {
		if (cartas.isEmpty())
			return true;
		else
			return false;
					
	}
}
