import cliente.Cliente;
import contas.Conta;
import contas.ContaCorrente;
import contas.ContaPoupanca;

public class Main {

	public static void main(String[] args) {
		// Caso não seja transferência, será false, se for será true.
		// Essa condição serve para depósito e saque.
		
		Cliente venilton = new Cliente();
		venilton.setNome("Venilton");
		
		Conta cCorrente = new ContaCorrente(venilton);
		Conta cPoupanca = new ContaPoupanca(venilton);

		cCorrente.depositar(100, false, cCorrente.tipoConta());
		cCorrente.transferir(100, cPoupanca);

		cCorrente.imprimirExtrato();
		cPoupanca.imprimirExtrato();

		venilton.getHistorico().exibir();
	}

}
