package contas;

import cliente.Cliente;

public class ContaPoupanca extends Conta {

	public ContaPoupanca(Cliente cliente) {
		super(cliente);
	}

	@Override
	public void imprimirExtrato() {
		System.out.printf("%n=============================================%n");
		System.out.printf("       === Extrato Conta Poupança ===%n");
		super.imprimirInfosComuns();
	}
    
	@Override
	public String tipoConta() {
		return "Conta Poupança";
	}

	@Override
	public double getSaldo() {
		return saldo;
	}
}
