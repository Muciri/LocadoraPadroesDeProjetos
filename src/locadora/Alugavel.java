package locadora;

public interface Alugavel {
    public String getDescricao();
    public int getAno();
    public double getValorDaLocacao(int diasAlugada);
    public int getPontosDeAlugadorFrequente(int diasAlugada);
}
