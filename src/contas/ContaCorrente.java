package contas;

import cliente.Cliente;

public class ContaCorrente extends Conta {
	public ContaCorrente(Cliente cliente) {
		super(cliente);
	}

	@Override
	public void imprimirExtrato() {
		System.out.printf("%n=============================================%n");
		System.out.printf("       === Extrato Conta Corrente ===%n");
		super.imprimirInfosComuns();
	}
	
	@Override
	public String tipoConta() {
		return "Conta Corrente";
	}

	@Override
	public double getSaldo() {
		return saldo;
	}
}
