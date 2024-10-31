public class Funcionario extends Pessoa {
    private String matricula;

    // Construtor padrão
    public Funcionario() {}

    // Método getter para a matrícula
    public String getMatricula() {
        return matricula;
    }

    // Método setter para a matrícula
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    // Método para realizar empréstimo
    public void realizarEmprestimo(String livro) {
        System.out.println("Funcionário " + getNome() + " realizou o empréstimo do livro: " + livro);
    }

    // Método para gerenciar livro
    public void gerenciarLivro(String livro) {
        System.out.println("Funcionário " + getNome() + " gerenciou o livro: " + livro);
    }

    // Método para exibir descrição, incluindo a matrícula
    @Override
    public void descricao() {
        super.descricao();  // Chama o método descricao() da classe Pessoa
        System.out.println("Matrícula: " + matricula);
    }
}
