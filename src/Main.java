
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Cliente cliente = null;
        Conta contaCorrente = null;
        Conta contaPoupanca = null;

        int opcao;

        do {
            System.out.println("\n=== MENU DO BANCO ===");
            System.out.println("1. Criar Cliente");
            System.out.println("2. Criar Conta Corrente");
            System.out.println("3. Criar Conta Poupança");
            System.out.println("4. Depositar na Conta Corrente");
            System.out.println("5. Transferir para Conta Poupança");
            System.out.println("6. Imprimir Extratos");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir quebra de linha

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome do cliente: ");
                    String nome = scanner.nextLine();
                    cliente = new Cliente();
                    cliente.setNome(nome);
                    System.out.println("Cliente criado com sucesso!");
                    break;

                case 2:
                    if (cliente == null) {
                        System.out.println("Crie um cliente antes de criar uma conta.");
                    } else {
                        contaCorrente = new ContaCorrente(cliente);
                        System.out.println("Conta Corrente criada com sucesso!");
                    }
                    break;

                case 3:
                    if (cliente == null) {
                        System.out.println("Crie um cliente antes de criar uma conta.");
                    } else {
                        contaPoupanca = new ContaPoupanca(cliente);
                        System.out.println("Conta Poupança criada com sucesso!");
                    }
                    break;

                case 4:
                    if (contaCorrente == null) {
                        System.out.println("Crie uma Conta Corrente antes de depositar.");
                    } else {
                        System.out.print("Digite o valor a depositar: ");
                        double valorDeposito = scanner.nextDouble();
                        contaCorrente.depositar(valorDeposito);
                        System.out.println("Depósito realizado com sucesso!");
                    }
                    break;

                case 5:
                    if (contaCorrente == null || contaPoupanca == null) {
                        System.out.println("Certifique-se de criar as contas antes de transferir.");
                    } else {
                        System.out.print("Digite o valor a transferir: ");
                        double valorTransferencia = scanner.nextDouble();
                        contaCorrente.transferir(valorTransferencia, contaPoupanca);
                        System.out.println("Transferência realizada com sucesso!");
                    }
                    break;

                case 6:
                    if (contaCorrente != null) {
                        System.out.println("Extrato da Conta Corrente:");
                        contaCorrente.imprimirExtrato();
                    } else {
                        System.out.println("Conta Corrente ainda não foi criada.");
                    }

                    if (contaPoupanca != null) {
                        System.out.println("Extrato da Conta Poupança:");
                        contaPoupanca.imprimirExtrato();
                    } else {
                        System.out.println("Conta Poupança ainda não foi criada.");
                    }
                    break;

                case 0:
                    System.out.println("Saindo do sistema. Até mais!");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);

        scanner.close();
    }
}
