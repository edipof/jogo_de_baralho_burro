import java.util.Scanner;

import jogador.Jogador;
import jogador.JogadorHumano;
import baralho.Baralho;


public class Main {

	private static Scanner s;

	public static void main(String[] args) {
		Jogador jogador = new JogadorHumano("Edipo");
		Baralho baralho = new Baralho();
		baralho.embaralhar();
		
		for (int i = 0; i < 4; i++) {
			jogador.addCartaMao(baralho.getCarta());
		}
		jogador.verMao();
		s = new Scanner(System.in);
		int valor = s.nextInt();
		
		while(jogador.jogarCartaMao(valor) == null){
			try {
				valor = s.nextInt();
			} catch (NumberFormatException e) {
				System.out.println("Apenas numeros");
			}
		}
			
		
		System.out.println("\n");
		jogador.verMao();
	}

}
