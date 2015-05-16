package jogoBurro;

import java.util.LinkedList;
import java.util.Scanner;

import jogador.Jogador;
import jogador.JogadorBot;
import jogador.JogadorHumano;
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
	//Armazena a carta que está no topo da mesa
	private static Carta cartaMesa = new Carta();
	//Lista de jogadores
	private LinkedList<Jogador> listaJogadores = new LinkedList<Jogador>();
	
	public void addJogador(Jogador jogador){
		listaJogadores.add(jogador);
	}
	
	private Boolean isJogadaValida(Carta carta){
		//verica se a jogada eh valida
		if(cartaMesa == null || carta.getNaipe().equals(
				cartaMesa.getNaipe()))
			return true;
		System.out.println("Jogada Invalida!");
		return false;
	}
	
	private Jogador vencedorDaRodada(Jogador jogador){
		//retorna o vencedor da rodada
		//System.out.println(jogador.getNome() + " venceu essa rodada!");
		return null;
	}
	
	private Carta jogadaJogadorHumano(Jogador jogador){
		Scanner s;
		int valor;
		jogador.verMao();
		s = new Scanner(System.in);
		valor = s.nextInt();
		Carta carta = jogador.jogarCartaMao(valor);
		while(carta == null){
			try {
				valor = s.nextInt();
				carta = jogador.jogarCartaMao(valor);
			} catch (NumberFormatException e) {
				System.out.println("Apenas numeros");
			}
		}
		s.close();
		
		return carta;
	}
	
	private Carta jogadaJogadorBot(Jogador jogador){
		//TODO
		return null;
	}
	
	private void rodada(){
		Carta carta = new Carta();
		
		for (Jogador jogador : listaJogadores) {
			if (jogador instanceof JogadorHumano) {
				Scanner s = new Scanner(System.in);
				String palavra = new String();
				carta = jogadaJogadorHumano(jogador);
				while(!isJogadaValida(carta)){
					System.out.println("Compre uma carta [c] ou escolha uma carta de sua mao [j].");
					palavra = s.next();
					switch (palavra) {
					case "c":
						jogador.addCartaMao(baralho.getCarta());
						jogador.verMao();
						break;
					case "j":
						carta = jogadaJogadorHumano(jogador);
						jogador.verMao();
						break;
					default:
						break;
					}
				}
				s.close();
				//falta ver quem venceu a rodada
			}else if(jogador instanceof JogadorBot){
				carta = jogadaJogadorBot(jogador);
				while(!isJogadaValida(carta)){}
			}
			
		}
	}
	/*-Adicionar os jogadores;
	-Distribuir as cartas iniciais (4 cartas);
	rodada{
		-Jogador de id 1 começa jogando uma carta;
		-iterar até todos jogadores jogarem
		-- Para jogar é preciso que a carta seja do mesmo naipe (isJogadaValida())
		-- Se !isJogadaValida() comprar cartas até sair uma carta do naipe desejado
		-- Vencedor da rodada é quem jogar a carta de maior valor
	}
	*/
	
	private void distribuirCartasIniciais(){
		for (Jogador jogador : listaJogadores) {
			for (int i = 0; i < 4; i++) {
				jogador.addCartaMao(baralho.getCarta());
			}
		}
	}
	
	public void novaPartida(int numJogadores){
		baralho.embaralhar();
		
		distribuirCartasIniciais();
		
		while(baralho.temCarta()){
			rodada();
		}
		
	}
}
