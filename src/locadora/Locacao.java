package locadora;

public class Locacao {
	private Automovel carro;
	private int diasAlugado;
	
	public Locacao(Automovel carro, int diasAlugado) {
		this.carro = carro;
		this.diasAlugado = diasAlugado;
	}
	
	public Automovel getCarro() {
		return carro;
	}
	
	public int getDiasAlugado() {
		return diasAlugado;
	}

	public double valorDeUmaLocacao() {
		double valorLocacao = 0.0;
		
		switch(carro.getCodigoDoPreco()) {
			case Automovel.BASICO: // R$ 90.00 por dia
				valorLocacao = this.getDiasAlugado() * 90.0;
				break;

			case Automovel.FAMILIA: // R$ 130.00 por dia
				valorLocacao = this.getDiasAlugado() * 130.0;
				break;

			case Automovel.LUXO: // R$ 200.00 por dia
				valorLocacao = this.getDiasAlugado() * 200.0;
				
				// Adiciona um desconto de 10% se alugar o carro por mais de 4 dias
				if(this.getDiasAlugado() > 4) {
					valorLocacao *= 0.9;
				}
				break;
		} 

		return valorLocacao;
	}

	public int adicionaPontosDeLocadorFrequente() {
		int pontos = 1;
		
		// adiciona bonus para locação de um carro de luxo por pelo menos 3 dias
		if(carro.getCodigoDoPreco() == Automovel.LUXO &&
			this.getDiasAlugado() > 2) {
			pontos += 2;
		}
		
		return pontos;
	}
}
