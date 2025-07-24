package contas;

public interface IConta {
	// Caso não seja transferência, será false, se for será true.

	boolean sacar(double valor, boolean transferencia);
	
	void depositar(double valor, boolean transferencia, String tipoConta);
	
	void transferir(double valor, IConta contaDestino);
	
	void imprimirExtrato();

	String tipoConta();

	double getSaldo();
}