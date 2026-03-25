package locadora;

public class Automovel implements Alugavel{
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
		this.classificacao = ClassificacaoFactory.createClassificacao(codigoDoPreco);
	}
	
	public double getValorDaLocacao(int diasAlugado) {
		return this.classificacao.valorDeUmaLocacao(diasAlugado);
	}

	public int getPontosDeAlugadorFrequente(int diasAlugado) {
		return this.classificacao.getPontosDeAlugadorFrequente(diasAlugado);
	}
}