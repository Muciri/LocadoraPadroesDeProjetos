package locadora.extrato;

import java.util.Iterator;

import locadora.cliente.Locacao;

public class GeradorExtratoHTML implements GeradorExtrato{
    
    public String gerarExtrato(String nome, double valorTotal, int PontosTotaisDeAlugadorFrequente, Iterator<Locacao> locacoes) {
		final String fimDeLinha = System.getProperty("line.separator");
		int sequencia = 0;
		
		String resultado = "<html><body>"+ fimDeLinha;
		resultado = String.format("<H2>Registro de Locacoes de <EM> %s </EM></H2>", nome) + fimDeLinha;
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
		resultado += String.format("<tfoot><tr><td colspan=\"4\">Valor Acumulado em diárias:</td><td><EM>R$ %8.2f</EM></td></tr></tfoot></table>" + fimDeLinha, valorTotal);
		resultado += "<P>Voce acumulou <EM>" + PontosTotaisDeAlugadorFrequente + " pontos </EM> de alugador frequente</p></body></html> ";
		
		return resultado;
    }
    
}
