package locadora;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Cliente {
	private String nome;
	private List<Locacao> carrosAlugados = new ArrayList<Locacao>();

	public Cliente(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void adicionaLocacao(Locacao locacao) {
		carrosAlugados.add(locacao);
	}

	private double getValorTotal() {
		double valorTotal = 0.0;
		Iterator<Locacao> locacoes = carrosAlugados.iterator();

		while(locacoes.hasNext()) {
			Locacao cada = locacoes.next();
			valorTotal += cada.valorDeUmaLocacao();

		} // while

		return valorTotal;
	}

	private int getPontosTotaisDeAlugadorFrequente() {
		int pontosDeLocadorFrequente = 0;
		Iterator<Locacao> locacoes = carrosAlugados.iterator();

		while(locacoes.hasNext()) {
			Locacao cada = locacoes.next();
			pontosDeLocadorFrequente += cada.getPontosDeAlugadorFrequente();

		} // while

		return pontosDeLocadorFrequente;
	}

	public String extrato(GeradorExtrato gerador) {
		return gerador.gerarExtrato(nome, getValorTotal(), getPontosTotaisDeAlugadorFrequente(), carrosAlugados.iterator());
	}
}