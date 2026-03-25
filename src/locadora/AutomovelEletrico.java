package locadora;

public class AutomovelEletrico extends Automovel {
    private double autonomiaBateria;
    private int tempoDeCarregamento;

    public AutomovelEletrico(String descricao, int ano, String placa, int codigoDoPreco, double autonomiaBateria, int tempoDeCarregamento) {
        super(descricao, ano, placa, codigoDoPreco);
        this.autonomiaBateria = autonomiaBateria;
        this.tempoDeCarregamento = tempoDeCarregamento;
    }

    public double getAutonomiaBateria() {
        return this.autonomiaBateria;
    }

    public void setAutonomiaBateria(double autonomiaBateria) {
        this.autonomiaBateria = autonomiaBateria;
    }

    public int getTempoDeCarregamento() {
        return this.tempoDeCarregamento;
    }

    public void setTempoDeCarregamento(int tempoDeCarregamento) {
        this.tempoDeCarregamento = tempoDeCarregamento;
    }
}
