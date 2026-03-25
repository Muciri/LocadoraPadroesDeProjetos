package locadora.classificacao;

public class Premium extends Classificacao {
    @Override
    public double valorDeUmaLocacao(int diasAlugado) {
        return diasAlugado * 320.0;
    }

    @Override
    public int getCodigoDoPreco() {
        return 3;
    }
    
    @Override
    public int getPontosDeAlugadorFrequente(int diasAlugado) {
        return diasAlugado; 
    }
}
