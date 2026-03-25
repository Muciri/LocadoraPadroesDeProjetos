package locadora.classificacao;

public class Familia extends Classificacao{
    @Override
    public double valorDeUmaLocacao(int diasAlugado) {
        return diasAlugado * 130.0;
    }

    @Override
    public int getCodigoDoPreco() {
        return 1;
    }
}
