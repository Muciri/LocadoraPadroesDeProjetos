package locadora.extrato;

import java.util.Iterator;

import locadora.cliente.Locacao;

public interface GeradorExtrato {
    String gerarExtrato(String nome, double valorTotal, int PontosTotaisDeAlugadorFrequente, Iterator<Locacao> locacoes);
}
