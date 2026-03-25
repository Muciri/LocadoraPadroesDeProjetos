package locadora.classificacao;

public class ClassificacaoFactory {
    public static Classificacao createClassificacao(int codigoDoPreco) {
		switch (codigoDoPreco) {
			case 1:
				return new Familia();
			case 2:
				return new Luxo();
			case 3:
				return new Premium();
			default:
				return new Basico();
		}
    }
}
