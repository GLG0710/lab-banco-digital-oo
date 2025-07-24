package historicoTransacao;

// Tipo Transação: Saque, Depósito ou Transferência
// Tipo Conta: Conta Corrente ou Conta Poupança
// Valor, Saldo Atual e Saldo Anterior: Valores envolvidos na Transação

public record RegistroTransacao(String tipoTransacao, String tipoConta, double valor, double saldoAtual, double saldoAnterior) {
    public RegistroTransacao {
        if (tipoTransacao.equals("Saque")) {
            saldoAnterior = saldoAtual + valor;
        } else if (tipoTransacao.equals("Depósito")) {
            saldoAnterior = saldoAtual - valor;
        }
    }

    @Override
    public final String toString() {
        return String.format(
            "Tipo da Transação: %s%n"+
            "Valor Transferido: %.2f%n"+
            "Saldo atual da %s: %.2f%n"+
            "Saldo anterior da %s: %.2f%n" +
            "---------------------------------------------%n",
            tipoTransacao, valor, tipoConta, saldoAtual, tipoConta, saldoAnterior
            );
    }
}