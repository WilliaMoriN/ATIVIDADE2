package jdbcactivity;
public class Produto {
    private int id;
    private String nome;
    private double valor;
    private String Status;

    public Produto() {
    }

    public Produto(int id, String nome, double valor, String Status) {
        this.id = id;
        this.nome = nome;
        this.valor = valor;
        this.Status = Status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }
}
