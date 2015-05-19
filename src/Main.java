//import java.util.Scanner;

//import jogador.Jogador;
//import jogador.JogadorHumano;
import java.util.ArrayList;
import java.util.Scanner;

import jogoBurro.Partida;
//import baralho.Baralho;
//import baralho.Carta;

public class Main {

	public static void main(String[] args) {

		ArrayList<String> nomes = new ArrayList<String>();
		Scanner s = new Scanner(System.in);
		System.out.println("Digite o numero de Jogadores desejado: ");
		int numJogadores = s.nextInt();
		while(numJogadores < 2){
			System.out.println("Para uma partida ocorrer eh preciso ao menos dois jogadores!");
			numJogadores = s.nextInt();
		}
			
		for (int i = 0; i < numJogadores; i++) {
			System.out.println("Digite o nome do Jogador " + (i+1) + ":");
			nomes.add(s.next());
		}
		
		Partida partida = new Partida();
		partida.novaPartida(numJogadores,nomes);
		s.close();
	}

}
