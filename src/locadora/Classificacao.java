package locadora;

public abstract class Classificacao {
    abstract double valorDeUmaLocacao(int diasAlugado);
    abstract int getCodigoDoPreco();
    int getPontosDeAlugadorFrequente(int diasAlugado){
        return 1;
    };
}
