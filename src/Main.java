//import java.util.Scanner;

//import jogador.Jogador;
//import jogador.JogadorHumano;
import jogoBurro.Partida;
//import baralho.Baralho;
//import baralho.Carta;


public class Main {

	//private static Scanner s;
	//private static Baralho baralho = new Baralho();

	public static void main(String[] args) {
		
		Partida partida = new Partida();
		partida.novaPartida(4);
		/* 
		 * Jogador jogador = new JogadorHumano("Edipo");
		 
		
		baralho.embaralhar();
		
		for (int i = 0; i < 4; i++) {
			jogador.addCartaMao(baralho.getCarta());
		}
		jogador.verMao();
		s = new Scanner(System.in);
		
		System.out.println("Agora vamos comprar cartas");
		String palavra = new String();
		
		while(!palavra.equals("s")){
			System.out.println("Deseja comprar uma carta? Pressione 'c' ou 'j' para jogar");
			palavra = s.next();
			switch (palavra) {
			case "c":
				jogador.addCartaMao(baralho.getCarta());
				jogador.verMao();
				break;
			case "j":
				Scanner c;
				int valor;
				jogador.verMao();
				c = new Scanner(System.in);
				System.out.println("Digite o valor");
				valor = c.nextInt();
				Carta carta = jogador.jogarCartaMao(valor);
				while(carta == null){
					try {
						valor = c.nextInt();
						carta = jogador.jogarCartaMao(valor);
					} catch (NumberFormatException e) {
						System.out.println("Apenas numeros");
					}
				}
				//c.close();
				jogador.verMao();
				break;
			default:
				break;
			}
			
		}
		System.out.println("saiu");
		*/
	}

}
