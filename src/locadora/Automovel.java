package locadora;

public class Automovel {
	public static final int BASICO = 0;   // Carros hatch
	public static final int FAMILIA = 1;  // Carros Sedan ou SUV b�sico
	public static final int LUXO = 2;     // Carros padrão luxo

	private String descricao;
	private String placa;
	private int ano; // Ano de fabricacao
	private int codigoDoPreco;
	
	public Automovel(String descricao, int ano, String placa, int codigoDoPreco) {
		this.descricao = descricao;
		this.placa = placa;
		this.ano = ano;
		this.codigoDoPreco = codigoDoPreco;
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
		return codigoDoPreco;
	}
	
	public void setCodigoDoPreco(int codigoDoPreco) {
		this.codigoDoPreco = codigoDoPreco;
	}

	public double valorDeUmaLocacao(int diasAlugado) {
		double valorLocacao = 0.0;
		
		switch(this.getCodigoDoPreco()) {
			case Automovel.BASICO: // R$ 90.00 por dia
				valorLocacao = diasAlugado * 90.0;
				break;

			case Automovel.FAMILIA: // R$ 130.00 por dia
				valorLocacao = diasAlugado * 130.0;
				break;

			case Automovel.LUXO: // R$ 200.00 por dia
				valorLocacao = diasAlugado * 200.0;
				
				// Adiciona um desconto de 10% se alugar o carro por mais de 4 dias
				if(diasAlugado > 4) {
					valorLocacao *= 0.9;
				}
				break;
		} 

		return valorLocacao;
	}

	public int getPontosDeAlugadorFrequente(int diasAlugado) {
		int pontos = 1;
		
		// adiciona bonus para locação de um carro de luxo por pelo menos 3 dias
		if(this.getCodigoDoPreco() == Automovel.LUXO && diasAlugado > 2) {
			pontos += 2;
		}
		
		return pontos;
	}
}