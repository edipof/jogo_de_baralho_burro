package JogoBurro;

import java.util.ArrayList;

import baralho.Carta;

public class Mesa {
	
	private static Mesa instancia;
	
	//private ArrayList<Carta> cartasMesa = new ArrayList<Carta>();
	
	//para implementar o singleton
	private Mesa(){}

	//obter instancia mesa
	public static Mesa getInstancia() {
		if(instancia == null)
			instancia = new Mesa();
		
		return instancia;
	}
	
	
}
