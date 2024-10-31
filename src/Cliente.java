import java.util.ArrayList;

public class Cliente extends Pessoa {
    private ArrayList<String> historicoEmprestimo;

    public Cliente() {
        // Inicializa a lista de histórico de empréstimos
        historicoEmprestimo = new ArrayList<>();
    }

    public void adicionarEmprestimo(String emprestimo) {
        historicoEmprestimo.add(emprestimo);
    }

    public void exibirHistoricoEmprestimo() {
        System.out.println("Histórico de Empréstimo:");
        for (String emprestimo : historicoEmprestimo) {
            System.out.println(emprestimo);
        }
    }
}
