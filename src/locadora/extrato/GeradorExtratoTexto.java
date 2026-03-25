package locadora.extrato;

import java.util.Iterator;

import locadora.cliente.Locacao;

public class GeradorExtratoTexto implements GeradorExtrato {

	public String gerarExtrato(String nome, double valorTotal, int PontosTotaisDeAlugadorFrequente, Iterator<Locacao> locacoes) {
		final String fimDeLinha = System.getProperty("line.separator");
		int sequencia = 0;

		//Iterator<Locacao> locacoes = carrosAlugados.iterator();
		String resultado = "Registro de Locações de " + nome + fimDeLinha;
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
		resultado += String.format("Valor Acumulado em diárias............:  R$ %8.2f" + fimDeLinha, valorTotal);
		resultado += "Voce acumulou " + PontosTotaisDeAlugadorFrequente +
              " pontos de locador frequente";

		return resultado;
	}
}
