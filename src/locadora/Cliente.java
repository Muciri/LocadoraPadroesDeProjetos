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

	private double valorDeUmaLocacao(Locacao locacao) {
		double valorLocacao = 0.0;
		
		switch(locacao.getCarro().getCodigoDoPreco()) {
			case Automovel.BASICO: // R$ 90.00 por dia
				valorLocacao = locacao.getDiasAlugado() * 90.0;
				break;

			case Automovel.FAMILIA: // R$ 130.00 por dia
				valorLocacao = locacao.getDiasAlugado() * 130.0;
				break;

			case Automovel.LUXO: // R$ 200.00 por dia
				valorLocacao = locacao.getDiasAlugado() * 200.0;
				
				// Adiciona um desconto de 10% se alugar o carro por mais de 4 dias
				if(locacao.getDiasAlugado() > 4) {
					valorLocacao *= 0.9;
				}
				break;
		} 

		return valorLocacao;
	}

	private double adicionaPontosDeLocadorFrequente(Locacao locacao) {
		double pontos = 1;
		
		// adiciona bonus para locação de um carro de luxo por pelo menos 3 dias
		if(locacao.getCarro().getCodigoDoPreco() == Automovel.LUXO &&
			locacao.getDiasAlugado() > 2) {
			pontos += 2;
		}
		
		return pontos;
	}

	public String extrato() {
		final String fimDeLinha = System.getProperty("line.separator");
		double valorTotal = 0.0;
		int pontosDeLocadorFrequente = 0;
		int sequencia = 0;

		Iterator<Locacao> locacoes = carrosAlugados.iterator();
		String resultado = "Registro de Locações de " + getNome() + fimDeLinha;
		resultado += String.format("Seq Automovel             Ano  Diarias   Valor Pago"+fimDeLinha);
		resultado += String.format("=== ==================== ===== ========= ==========="+fimDeLinha);

		while(locacoes.hasNext()) {
			Locacao cada = locacoes.next();
			double valorCorrente = valorDeUmaLocacao(cada);

			// trata de pontos de locador frequente
			pontosDeLocadorFrequente += adicionaPontosDeLocadorFrequente(cada);

			// mostra valores para esta locação
			sequencia++;
			resultado += String.format("%02d. %-20s  %4d    %2d     R$ %8.2f"+fimDeLinha,sequencia, cada.getCarro().getDescricao(),cada.getCarro().getAno(), cada.getDiasAlugado(), valorCorrente );
			valorTotal += valorCorrente;

		} // while

		// adiciona rodapé
		resultado += "====================================================" + fimDeLinha;
		resultado += String.format("Valor Acumulado em diárias............:  R$ %8.2f" + fimDeLinha, valorTotal);
		resultado += "Voce acumulou " + pontosDeLocadorFrequente +
              " pontos de locador frequente";

		return resultado;
	}

}