package jogoBurro;

import java.util.ArrayList;

import jogador.Jogador;
import baralho.Baralho;
import baralho.Carta;
/*
 * Burro

	O objetivo do jogo é ficar sem nenhuma carta na mão. 
	O último jogador que permanecer com alguma carta perde, e é o "burro". 
	
	Esse jogo não tem número limite de jogadores.
	
	1º - 	Cada jogador recebe cinco cartas.
	
	2º - 	O jogador à esquerda do distribuidor começa jogando na mesa a carta mais alta que tiver na mão, de qualquer naipe, 
			por exemplo, um 8 de copas; o segundo jogador tem de jogar outra carta de copas no "monte". 
			Se tiver uma carta de copas, o jogo prossegue com o próximo jogador, se não, ele compra do "bolo" (baralho) 
			até obter uma carta de copas.
			
	3º -	Ganha o direito a iniciar a próxima rodada o jogador que colocar a carta mais alta na mesa. 
*/
public class Partida {
	//O jogo so tem um baralho
	private static Baralho baralho = new Baralho();
	private static ArrayList<Carta> mesa = new ArrayList<Carta>();
	
	private void instanciarJogadores(){
		//intanciar jogadores
		//Humano ou bot
	}
	
	private Boolean verificaSeJogadaEhValida(){
		//verica se a jogada eh valida
		return null;
	}
	
	private Jogador vencedorDaRodada(Jogador jogador){
		//retorna o vencedor da rodada
		//System.out.println(jogador.getNome() + " venceu essa rodada!");
		return null;
	}
	public void novaPartida(int numJogadores){
		baralho.embaralhar();
	}
}
