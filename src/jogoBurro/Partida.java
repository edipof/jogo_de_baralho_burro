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
	private Carta maiorCarta = new Carta();
	
	private static Scanner s = new Scanner(System.in);
	
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
		if(cartaMesa == null ||maiorCarta.getValorCarta().getValorCarta() < 
				carta.getValorCarta().getValorCarta() ){
			cartaMesa = carta;
			maiorCarta = carta;
			return true;
		}
		cartaMesa = carta;
		return false;
	}
	
	private Carta jogadaJogadorHumano(Jogador jogador){
		int valor;
		jogador.verMao();
		System.out.println("Digite o valor referente a carta que voce deseja jogar!");
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
		return carta;
	}
	
	private void rodada(){
		Boolean jogadaValida = false;
		Carta carta = new Carta();
		String palavra = new String("");
		//para cada jogador
		for (Jogador jogador : listaJogadores) {
			if(fimDeJogo)
				break;
			System.out.println("\nJogada do " + jogador.getNome());
			//se existir alguma carta na mesa avisa 
			if(cartaMesa != null)
				System.out.println("Carta na mesa: " + cartaMesa.
						getValorCarta()+" de " + cartaMesa.getNaipe());
			//se o jogador tiver a mao vazia eh ignorado
			if(jogador.maoJogadorIsEmpty()){
				continue;
			}else
				//se for instancia de jogador humano
				if (jogador instanceof JogadorHumano) {
					System.out.println("Escolha uma carta de sua mao para jogar");
					//se for a jogada do primeiro jogador
					if(cartaMesa == null){
						carta = jogadaJogadorHumano(jogador);
						maiorCarta = carta;
					}else{//a partir do segundo jogador
						jogador.verMao();
						//aguardando digitara valor correto
						while(!palavra.equals("j") && !palavra.equals("c")){
							System.out.println("Compre uma carta [c] ou escolha uma carta de sua mao [j].");
							palavra = s.next();
						}
						if(palavra.equals("c")){
							while(true){
								System.out.println("Carta na mesa: " + cartaMesa.getValorCarta()+" de " + cartaMesa.getNaipe());
								jogador.addCartaMao(baralho.getCarta());
								jogador.verMao();
								System.out.println("Compre uma carta [c] ou escolha uma carta de sua mao [j].");
								palavra = s.next();
								if(palavra.equals("j")){
									carta = jogadaJogadorHumano(jogador);
									break;
								}
							}
						}else if(palavra.equals("j")){
							carta = jogadaJogadorHumano(jogador);
						}
						
						if(!isJogadaValida(carta))
							jogador.addCartaMao(carta);
						else jogadaValida = true;
						//enquanto nao fizer uma jogada valida
						while(!jogadaValida){
							if(cartaMesa != null)
								System.out.println("Carta na mesa: " + cartaMesa.getValorCarta()+" de " + cartaMesa.getNaipe());
							System.out.println("Compre uma carta [c] ou escolha uma carta de sua mao [j].");
							palavra = s.next();
							switch (palavra) {
							case "c":
								System.out.println("Carta na mesa: " + cartaMesa.getValorCarta()+" de " + cartaMesa.getNaipe());
								jogador.addCartaMao(baralho.getCarta());
								jogador.verMao();
								break;
							case "j":
								carta = jogadaJogadorHumano(jogador);
								if(!isJogadaValida(carta))
									jogador.addCartaMao(carta);
								else 
									jogadaValida = true;
								jogador.verMao();
								break;
							default:
								break;
							}
						}
						jogadaValida = false;
						palavra = "";
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
		//limpando a lista
		listaJogadores.clear();
		//add vencedor no topo da lista
		listaJogadores.addFirst(jogadorVencedorRodada);
		for (Jogador jog : auxListJogadores){
			listaJogadores.addLast(jog);
		}
		System.out.println("\n\n");
		System.out.println(listaJogadores.getFirst().
				getNome() + " venceu essa rodada!");
		
		cartaMesa = null;
		jogadorVencedorRodada = null;
		auxListJogadores.clear();
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
	
	public void novaPartida(int numJogadores, ArrayList<String> nomes){
		System.out.println("Jogo de cartas Burro!! Apenas uma pessoa não sera Burro! :)");
		baralho.embaralhar();
		
		for (int i = 0; i < numJogadores; i++){
			Jogador jogador = new JogadorHumano(nomes.get(i), i);
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
		for (Jogador jogador : listaJogadores) {
			if(!jogador.equals(getVencedor())){
				System.out.println(jogador.getNome() + " tem " + jogador.sizeMao() + " anos de burro!!!");
			}
		}
		s.close();
	}
}
