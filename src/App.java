import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Cliente> clientes = new ArrayList<>();
        ArrayList<Funcionario> funcionarios = new ArrayList<>();
        ArrayList<Livro> livros = new ArrayList<>();

        boolean executando = true;

        while (executando) {
            System.out.println("\n=== Sistema de Gerenciamento de Biblioteca ===");
            System.out.println("1. Cadastrar Cliente");
            System.out.println("2. Cadastrar Funcionário");
            System.out.println("3. Cadastrar Livro");
            System.out.println("4. Realizar Empréstimo (Cliente)");
            System.out.println("5. Devolver Livro");
            System.out.println("6. Gerenciar Livro (Funcionário)");
            System.out.println("7. Exibir Histórico de Empréstimos (Cliente)");
            System.out.println("8. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer do scanner

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome do cliente: ");
                    String nomeCliente = scanner.nextLine();
                    System.out.print("Digite o CPF do cliente: ");
                    String cpfCliente = scanner.nextLine();
                    Cliente cliente = new Cliente();
                    cliente.setNome(nomeCliente);
                    cliente.setCPF(cpfCliente);
                    clientes.add(cliente);
                    System.out.println("Cliente cadastrado com sucesso!");
                    break;

                case 2:
                    System.out.print("Digite o nome do funcionário: ");
                    String nomeFuncionario = scanner.nextLine();
                    System.out.print("Digite o CPF do funcionário: ");
                    String cpfFuncionario = scanner.nextLine();
                    System.out.print("Digite a matrícula do funcionário: ");
                    String matriculaFuncionario = scanner.nextLine();
                    Funcionario funcionario = new Funcionario();
                    funcionario.setNome(nomeFuncionario);
                    funcionario.setCPF(cpfFuncionario);
                    funcionario.setMatricula(matriculaFuncionario);
                    funcionarios.add(funcionario);
                    System.out.println("Funcionário cadastrado com sucesso!");
                    break;

                case 3:
                    System.out.print("Digite o título do livro: ");
                    String tituloLivro = scanner.nextLine();
                    System.out.print("Digite o autor do livro: ");
                    String autorLivro = scanner.nextLine();
                    Livro livro = new Livro(tituloLivro, autorLivro);
                    livros.add(livro);
                    System.out.println("Livro cadastrado com sucesso!");
                    break;

                case 4:
                    System.out.print("Digite o nome do cliente para realizar o empréstimo: ");
                    String nomeClienteEmprestimo = scanner.nextLine();
                    Cliente clienteEmprestimo = encontrarCliente(clientes, nomeClienteEmprestimo);
                    if (clienteEmprestimo != null) {
                        System.out.print("Digite o título do livro: ");
                        String tituloEmprestimo = scanner.nextLine();
                        Livro livroEmprestimo = encontrarLivro(livros, tituloEmprestimo);
                        if (livroEmprestimo != null && livroEmprestimo.isDisponivel()) {
                            clienteEmprestimo.adicionarEmprestimo(tituloEmprestimo);
                            livroEmprestimo.emprestar();
                        } else {
                            System.out.println("Livro não disponível.");
                        }
                    } else {
                        System.out.println("Cliente não encontrado.");
                    }
                    break;

                case 5:
                    System.out.print("Digite o título do livro a ser devolvido: ");
                    String tituloDevolucao = scanner.nextLine();
                    Livro livroDevolucao = encontrarLivro(livros, tituloDevolucao);
                    if (livroDevolucao != null) {
                        livroDevolucao.devolver();
                    } else {
                        System.out.println("Livro não encontrado.");
                    }
                    break;

                case 6:
                    System.out.print("Digite o nome do funcionário para gerenciar livro: ");
                    String nomeFuncionarioGerenciamento = scanner.nextLine();
                    Funcionario funcionarioGerenciamento = encontrarFuncionario(funcionarios,
                            nomeFuncionarioGerenciamento);
                    if (funcionarioGerenciamento != null) {
                        System.out.print("Digite o título do livro: ");
                        String tituloGerenciamento = scanner.nextLine();
                        funcionarioGerenciamento.gerenciarLivro(tituloGerenciamento);
                    } else {
                        System.out.println("Funcionário não encontrado.");
                    }
                    break;

                case 7:
                    System.out.print("Digite o nome do cliente para exibir o histórico de empréstimos: ");
                    String nomeClienteHistorico = scanner.nextLine();
                    Cliente clienteHistorico = encontrarCliente(clientes, nomeClienteHistorico);
                    if (clienteHistorico != null) {
                        clienteHistorico.exibirHistoricoEmprestimo();
                    } else {
                        System.out.println("Cliente não encontrado.");
                    }
                    break;

                case 8:
                    executando = false;
                    System.out.println("Encerrando o sistema...");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
        scanner.close();
    }

    // Método auxiliar para encontrar cliente pelo nome
    private static Cliente encontrarCliente(ArrayList<Cliente> clientes, String nome) {
        for (Cliente cliente : clientes) {
            if (cliente.getNome().equalsIgnoreCase(nome)) {
                return cliente;
            }
        }
        return null;
    }

    // Método auxiliar para encontrar funcionário pelo nome
    private static Funcionario encontrarFuncionario(ArrayList<Funcionario> funcionarios, String nome) {
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getNome().equalsIgnoreCase(nome)) {
                return funcionario;
            }
        }
        return null;
    }

    // Método auxiliar para encontrar livro pelo título
    private static Livro encontrarLivro(ArrayList<Livro> livros, String titulo) {
        for (Livro livro : livros) {
            if (livro.getTitulo().equalsIgnoreCase(titulo)) {
                return livro;
            }
        }
        return null;
    }
}
