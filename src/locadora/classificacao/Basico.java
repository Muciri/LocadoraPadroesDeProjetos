package locadora.classificacao;

public class Basico extends Classificacao {
    @Override
    public double valorDeUmaLocacao(int diasAlugado) {
        return diasAlugado * 90.0;
    }

    @Override
    public int getCodigoDoPreco() {
        return 0;
    }
}
