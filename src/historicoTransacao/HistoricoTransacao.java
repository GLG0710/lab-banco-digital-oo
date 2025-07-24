package historicoTransacao;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class HistoricoTransacao {
	private final List<RegistroTransacao> historico;

	public HistoricoTransacao() {
		this.historico = new ArrayList<>();
	}

	public void adicionarRegistro(RegistroTransacao registro) {
		historico.add(registro);
	}

	public void exibirPorTipo(String tipo) {
		Predicate<RegistroTransacao> filtroTipo = registro -> registro.tipoTransacao().equals(tipo);

		historico.stream().filter(filtroTipo).forEach(System.out::println);
	}

	public void exibir() {
		System.out.printf("%n=============================================%n");
		System.out.printf("       === HISTÓRICO DE TRANSAÇÕES ===%n");
		System.out.println("---------------------------------------------");
		historico.stream().forEach(System.out::print);
	}
}
