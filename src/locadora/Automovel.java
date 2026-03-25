package locadora;

public class Automovel implements Alugavel{
	public static final int BASICO = 0;   // Carros hatch
	public static final int FAMILIA = 1;  // Carros Sedan ou SUV básico
	public static final int LUXO = 2;     // Carros padrão luxo

	private String descricao;
	private String placa;
	private int ano; // Ano de fabricacao
	private Classificacao classificacao;
	
	public Automovel(String descricao, int ano, String placa, int codigoDoPreco) {
		this.descricao = descricao;
		this.placa = placa;
		this.ano = ano;
		this.setCodigoDoPreco(codigoDoPreco);
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public String getPlaca() {
		return placa;
	}
	
	public int getAno() {
		return ano;
	}
	
	public int getCodigoDoPreco() {
		return this.classificacao.getCodigoDoPreco();
	}
	
	public void setCodigoDoPreco(int codigoDoPreco) {
		switch (codigoDoPreco) {
			case 1:
				this.classificacao = new Familia();
				break;
			case 2:
				this.classificacao = new Luxo();
				break;
			default:
				this.classificacao = new Basico();
				break;
		}
	}

	public double getValorDaLocacao(int diasAlugado) {
		return this.classificacao.valorDeUmaLocacao(diasAlugado);
	}

	public int getPontosDeAlugadorFrequente(int diasAlugado) {
		return this.classificacao.getPontosDeAlugadorFrequente(diasAlugado);
	}
}