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

	public String extrato() {
		final String fimDeLinha = System.getProperty("line.separator");
		int sequencia = 0;

		Iterator<Locacao> locacoes = carrosAlugados.iterator();
		String resultado = "Registro de Locações de " + getNome() + fimDeLinha;
		resultado += String.format("Seq Automovel             Ano  Diarias   Valor Pago"+fimDeLinha);
		resultado += String.format("=== ==================== ===== ========= ==========="+fimDeLinha);

		while(locacoes.hasNext()) {
			Locacao cada = locacoes.next();

			// mostra valores para esta locação
			sequencia++;
			resultado += String.format("%02d. %-20s  %4d    %2d     R$ %8.2f"+fimDeLinha,sequencia, cada.getCarro().getDescricao(),cada.getCarro().getAno(), cada.getDiasAlugado(), cada.valorDeUmaLocacao() );
		} // while

		// adiciona rodapé
		resultado += "====================================================" + fimDeLinha;
		resultado += String.format("Valor Acumulado em diárias............:  R$ %8.2f" + fimDeLinha, getValorTotal());
		resultado += "Voce acumulou " + getPontosTotaisDeAlugadorFrequente() +
              " pontos de locador frequente";

		return resultado;
	}

	public String extratoHTML() {
		final String fimDeLinha = System.getProperty("line.separator");
		int sequencia = 0;
		
		Iterator<Locacao> locacoes = carrosAlugados.iterator();
		String resultado = "<html><body>"+ fimDeLinha;
		resultado = String.format("<H2>Registro de Locacoes de <EM> %s </EM></H2>", getNome()) + fimDeLinha;
		resultado += "<table border=\"1\"><tr><th>Seq</th><th>Automóvel</th><th>Ano</th><th>Diárias</th><th>Valor</th></tr>" + fimDeLinha;
		
		while(locacoes.hasNext()) {
			Locacao cada = locacoes.next();
			// mostra valores para este Locacao
			sequencia++;
			resultado +=
			String.format("<tr><th>%02d.</th><th>%s</th><th>%4d</th><th>%2d</th><th>R$ %8.2f</th></tr>" + fimDeLinha, sequencia,
			cada.getCarro().getDescricao(),cada.getCarro().getAno(),
			cada.getDiasAlugado(), cada.valorDeUmaLocacao() );
		} // while
		
		// adiciona rodapé
		resultado += String.format("<tfoot><tr><td colspan=\"4\">Valor Acumulado em diárias:</td><td><EM>R$ %8.2f</EM></td></tr></tfoot></table>" + fimDeLinha, getValorTotal());
		resultado += "<P>Voce acumulou <EM>" + getPontosTotaisDeAlugadorFrequente() + " pontos </EM> de alugador frequente</p></body></html> ";
		
		return resultado;
	}
}