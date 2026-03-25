package locadora.cliente;

import locadora.alugavel.Alugavel;

public class Locacao {
	private Alugavel carro;
	private int diasAlugado;
	
	public Locacao(Alugavel carro, int diasAlugado) {
		this.carro = carro;
		this.diasAlugado = diasAlugado;
	}
	
	public Alugavel getCarro() {
		return carro;
	}
	
	public int getDiasAlugado() {
		return diasAlugado;
	}

	public double valorDeUmaLocacao() {
		return this.carro.getValorDaLocacao(this.getDiasAlugado());
	}

	public int getPontosDeAlugadorFrequente() {
		return carro.getPontosDeAlugadorFrequente(this.getDiasAlugado());
	}
}
