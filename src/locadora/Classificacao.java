package locadora;

public abstract class Classificacao {
	public static final int BASICO = 0;   // Carros hatch
	public static final int FAMILIA = 1;  // Carros Sedan ou SUV básico
	public static final int LUXO = 2;     // Carros padrão luxo
    public static final int PREMIUM = 3; // Carros Premium
    protected int pontoSimples = 1;
    protected int pontoExtra = 2;

    abstract double valorDeUmaLocacao(int diasAlugado);
    abstract int getCodigoDoPreco();
    int getPontosDeAlugadorFrequente(int diasAlugado){
        return this.pontoSimples;
    };
}
