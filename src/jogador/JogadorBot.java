package jogador;

import baralho.Baralho;
import baralho.Carta;


public class JogadorBot extends Jogador{

	private int idBot;
	
	public JogadorBot(int numero) {
		super();
		this.idBot = numero;
	}
	
	@Override
	public String getNome() {
		return "Bot " + getIdBot();
	}

	public int getIdBot() {
		return idBot;
	}

	public void cartaMaoBot(Baralho baralho){
		
	
	}

}
