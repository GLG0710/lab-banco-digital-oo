package cliente;

import historicoTransacao.HistoricoTransacao;

public class Cliente {
	HistoricoTransacao historico = new HistoricoTransacao();

	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public HistoricoTransacao getHistorico() {
		return historico;
	}

}
