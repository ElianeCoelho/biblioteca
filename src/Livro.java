public class Livro {
    private String titulo;
    private String autor;
    private boolean disponivel;

    // Construtor padrão
    public Livro(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
        this.disponivel = true;  // O livro é inicializado como disponível
    }

    // Método getter para o título
    public String getTitulo() {
        return titulo;
    }

    // Método getter para o autor
    public String getAutor() {
        return autor;
    }

    // Método para verificar se o livro está disponível
    public boolean isDisponivel() {
        return disponivel;
    }

    // Método para emprestar o livro
    public void emprestar() {
        if (disponivel) {
            disponivel = false;
            System.out.println("O livro \"" + titulo + "\" foi emprestado.");
        } else {
            System.out.println("O livro \"" + titulo + "\" não está disponível para empréstimo.");
        }
    }

    // Método para devolver o livro
    public void devolver() {
        if (!disponivel) {
            disponivel = true;
            System.out.println("O livro \"" + titulo + "\" foi devolvido e agora está disponível.");
        } else {
            System.out.println("O livro \"" + titulo + "\" já está disponível.");
        }
    }
}

