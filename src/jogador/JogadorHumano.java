package jogador;


public class JogadorHumano extends Jogador {
	
	private String nome;
	
	public JogadorHumano(String nome, int identificador){
		this.nome = nome;
		super.setId(identificador);
	}
	
	@Override
	public String getNome() {
		return nome;
	}


}
