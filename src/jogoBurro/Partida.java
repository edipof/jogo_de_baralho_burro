package jogoBurro;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

import jogador.Jogador;
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
	private static Carta cartaMesa = null;
	//Lista de jogadores
	private LinkedList<Jogador> listaJogadores = new LinkedList<Jogador>();
	//Lista auxiliar para armazenar jogadores
	private ArrayList<Jogador> auxListJogadores = new ArrayList<Jogador>();
	//Jogador Aux vencedor da rodada
	private Jogador jogadorVencedorRodada = null;
	private Boolean fimDeJogo = false;
	
	public void addJogador(Jogador jogador){
		listaJogadores.add(jogador);
	}
	
	private Boolean isJogadaValida(Carta carta){
		//verica se a jogada eh valida
		if(cartaMesa == null || carta.getNaipe().equals(
				cartaMesa.getNaipe()))
			return true;
		else {
			System.out.println("Jogada Invalida!");
			return false;
		}
	}
	
	private void listaDeQuemJogou(Jogador jogador){
		auxListJogadores.add(jogador);
	}
	
	private Boolean isMaiorCartaDaRodada(Carta carta){
		if(cartaMesa == null ||cartaMesa.getValorCarta().getValorCarta() < 
				carta.getValorCarta().getValorCarta() ){
			cartaMesa = carta;
			return true;
		}
		return false;
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
		//s.close();
		
		return carta;
	}
	
	private void rodada(){
		Carta carta = new Carta();
		Scanner s = new Scanner(System.in);
		String palavra = new String();
		for (Jogador jogador : listaJogadores) {
			System.out.println("Jogada do " + jogador.getNome());
			if(cartaMesa != null)
				System.out.println("Carta na mesa: " + cartaMesa.
						getValorCarta()+" de " + cartaMesa.getNaipe());
			if (jogador instanceof JogadorHumano) {
				System.out.println("Escolha uma carta de sua mao para jogar");
				carta = jogadaJogadorHumano(jogador);
				if(!isJogadaValida(carta) || listaJogadores.indexOf(jogador) > 0){
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
				}
			}
			//adicionando a lista de quem ja jogou
			if(isMaiorCartaDaRodada(carta)){
				if(jogadorVencedorRodada != null)
					listaDeQuemJogou(jogadorVencedorRodada);
				jogadorVencedorRodada = jogador;
			}else
				listaDeQuemJogou(jogador);
		}
		//s.close();
		//limpando a lista
		listaJogadores.clear();
		listaJogadores.addFirst(jogadorVencedorRodada);
		for (Jogador jog : auxListJogadores){
			listaJogadores.addLast(jog);
		}
		System.out.println(listaJogadores.getFirst().
				getNome() + " venceu essa rodada!");
		
		for (Jogador jogador : listaJogadores){
			if(jogador.maoJogadorIsEmpty()){
				fimDeJogo = true;
				break;
			}
		}
	}
	
	private void distribuirCartasIniciais(){
		for (Jogador jogador : listaJogadores) {
			for (int i = 0; i < 4; i++) {
				jogador.addCartaMao(baralho.getCarta());
			}
		}
	}
	private Jogador getVencedor(){
		for (Jogador jogador : listaJogadores) {
			if(jogador.maoJogadorIsEmpty())
				return jogador;
		}
		return null;
	}
	public void novaPartida(int numJogadores){
		baralho.embaralhar();
		
		for (int i = 0; i < numJogadores; i++){
			Jogador jogador = new JogadorHumano("jogador"+i, i);
			listaJogadores.add(jogador);
		}
		distribuirCartasIniciais();
		while(baralho.temCarta()){
			rodada();
			if(fimDeJogo)
				break;
		}
		System.out.println(getVencedor().getNome()+ 
				"venceu o jogo!");
	}
}
