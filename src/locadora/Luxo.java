package locadora;

public class Luxo extends Classificacao{
    @Override
    public double valorDeUmaLocacao(int diasAlugado) {
        double valorLocacao = diasAlugado * 200.0;
				
        // Adiciona um desconto de 10% se alugar o carro por mais de 4 dias
        if(diasAlugado > 4) {
            valorLocacao *= 0.9;
        }
        return valorLocacao;
    }

    @Override
    public int getCodigoDoPreco() {
        return 2;
    }

    @Override
    public int getPontosDeAlugadorFrequente(int diasAlugado) {
        int pontos = this.pontoSimples;
        
        if(diasAlugado > 4) {
            pontos += this.pontoExtra;
        }
        return pontos;
    }
}
