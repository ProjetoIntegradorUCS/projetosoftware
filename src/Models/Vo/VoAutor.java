package Models.Vo;

public class VoAutor implements I_VO{
    // atributos
    private int codigo;
    private String nome;

    // construtor
    public VoAutor(int codigo, String nome) 
    {
        this.codigo = codigo;
        this.nome = nome;
    }

    // construtor
    public VoAutor() 
    {
        this.codigo = 0;
        this.nome = "";
    }

    // construtor
    public VoAutor(int codigo) { this.codigo = codigo; }

    // getters and setters
    public int getCodigo() { return codigo; }

    public void setCodigo(int codigo) { this.codigo = codigo; }

    public String getNome() { return nome; }

    public void setNome(String nome) { this.nome = nome; }

    @Override
    public String toString() 
    {
        return "VoAutor{" + "codigo=" + codigo + ", nome=" + nome + '}';
    }
}
