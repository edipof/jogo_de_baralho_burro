package Jogador;


public class JogadorHumano extends Jogador {
	
	private String nome;
	
	public JogadorHumano(String nome){
		this.nome = nome;
	}
	
	@Override
	public String getNome() {
		return nome;
	}


}
