package Models.Vo;

public class VoLivro implements I_VO{
    // atributos
    private int codigo;
    private String titulo;

    // construtor
    public VoLivro(int codigo, String titulo) 
    {
        this.codigo = codigo;
        this.titulo = titulo;
    }

    // construtor
    public VoLivro() 
    {
        this.codigo = 0;
        this.titulo = "";
    }

    // construtor
    public VoLivro(int codigo) 
    {
        this.codigo = codigo;
    }

    // getters and setters
    public int getCodigo() 
    {
        return codigo;
    }

    public void setCodigo(int codigo) 
    {
        this.codigo = codigo;
    }

    public String getTitulo() 
    {
        return titulo;
    }

    public void setTitulo(String titulo) 
    {
        this.titulo = titulo;
    }

    @Override
    public String toString() 
    {
        return "VoAutor{" + "codigo=" + codigo + ", titulo=" + titulo + '}';
    }
}
