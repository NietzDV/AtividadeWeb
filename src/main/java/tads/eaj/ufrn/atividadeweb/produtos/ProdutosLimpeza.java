package tads.eaj.ufrn.atividadeweb.produtos;

public class ProdutosLimpeza {
    private String marca;
    private String tipo; // sabão em pó, alvejante etc...
    private int estoque;
    private double preco;
    private double peso;
    private int ID;


    public ProdutosLimpeza(int ID, String marca, String tipo, int estoque, float preco, int peso) {
        this.marca = marca;
        this.tipo = tipo;
        this.estoque = estoque;
        this.preco = preco;
        this.peso = peso;
        this.ID = ID;
    }


    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }


    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    @Override
    public String toString() {
        return "ProdutosLimpeza{" +
                "marca='" + marca + '\'' +
                ", tipo='" + tipo + '\'' +
                ", estoque=" + estoque +
                ", preco=" + preco +
                ", peso=" + peso +
                ", ID=" + ID +
                '}';
    }
}
