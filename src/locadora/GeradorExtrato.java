package locadora;

import java.util.Iterator;

public interface GeradorExtrato {
    String gerarExtrato(String nome, double valorTotal, int PontosTotaisDeAlugadorFrequente, Iterator<Locacao> locacoes);
}
