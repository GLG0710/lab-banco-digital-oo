package contas;

import cliente.Cliente;
import historicoTransacao.RegistroTransacao;

public abstract class Conta implements IConta {
	
	private static final int AGENCIA_PADRAO = 33;
	private static int SEQUENCIAL = 1;

	protected int agencia;
	protected int numero;
	protected double saldo;
	protected Cliente cliente;

	public Conta(Cliente cliente) {
		this.agencia = Conta.AGENCIA_PADRAO;
		this.numero = SEQUENCIAL++;
		this.cliente = cliente;
	}

	@Override
	public boolean sacar(double valor, boolean transferencia) {
		if (valor < saldo) {
			System.out.println("---------------------------------------------");
			System.out.println("Saldo insuficiente.");
			System.out.println("---------------------------------------------");
			return false; //Não tinha saldo
		} else {
			saldo -= valor;
			if (!transferencia) {
				System.out.println("---------------------------------------------");
					System.out.printf("Valor sacado: %.2f%n", valor);
					System.out.printf("Saldo atual: %.2f%n", saldo);
				System.out.println("---------------------------------------------");

				//Registrando Operação:
				cliente.getHistorico().adicionarRegistro(new RegistroTransacao("Saque", null, valor, saldo, 0));
			}
			return true; //Tinha saldo
		}
	}

	@Override
	public void depositar(double valor, boolean transferencia, String tipoConta) {
		saldo += valor;
		if (!transferencia) {
			System.out.println("---------------------------------------------");
			System.out.printf("Valor depositado na %s: %.2f%n", tipoConta, valor);
			System.out.printf("Saldo atual: %.2f%n", saldo);
			System.out.println("---------------------------------------------");

			//Registrando Operação:
			cliente.getHistorico().adicionarRegistro(new RegistroTransacao("Depósito", tipoConta, valor, saldo, 0));
		} else {
			System.out.println("---------------------------------------------");
			System.out.printf("Valor transferido para %s: %.2f%n", tipoConta, valor);
			System.out.println("---------------------------------------------");
		}
	}

	@Override
	public void transferir(double valor, IConta contaDestino) {
		boolean saqueConcluido = this.sacar(valor, true);
		if (saqueConcluido) {
			contaDestino.depositar(valor, true, contaDestino.tipoConta());

			//Registrando Operação:
			cliente.getHistorico().adicionarRegistro(new RegistroTransacao("Transferência", contaDestino.tipoConta(), valor, contaDestino.getSaldo(), 0));
		}
	}

	public int getAgencia() {
		return agencia;
	}

	public int getNumero() {
		return numero;
	}

	protected void imprimirInfosComuns() {
		System.out.println("---------------------------------------------");
		System.out.printf("Titular: %s%n", this.cliente.getNome());
		System.out.printf("Agencia: %d%n", this.agencia);
		System.out.printf("Numero: %d%n", this.numero);
		System.out.printf("Saldo: %.2f%n", this.saldo);
	System.out.println("---------------------------------------------");
	}
}
