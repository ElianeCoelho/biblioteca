public class Pessoa {
    private String nome;
    private String cpf;

    // Construtor padrão
    public Pessoa() {}

    // Método getter para o nome
    public String getNome() {
        return nome; // Corrigi para retornar o nome, não o CPF
    }

    // Método setter para o nome
    public void setNome(String nome) {
        this.nome = nome;
    }

    // Método getter para o CPF
    public String getCPF() {
        return cpf;
    }

    // Método setter para o CPF
    public void setCPF(String cpf) {
        this.cpf = cpf;
    }

    // Método para exibir a descrição
    public void descricao() {
        System.out.println("Nome: " + nome);
        System.out.println("CPF: " + cpf);
    }
}
