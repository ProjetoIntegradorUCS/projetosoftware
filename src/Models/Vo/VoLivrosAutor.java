package Models.Vo;

public class VoLivrosAutor implements I_VO{
    // atributos
    private int codigoLivro;
    private int codigoAutor;

    // construtor
    public VoLivrosAutor(int codigoLivro, int codigoAutor) 
    {
        this.codigoLivro = codigoLivro;
        this.codigoAutor = codigoAutor;
    }

    // construtor
    public VoLivrosAutor() 
    {
        this.codigoLivro = 0;
        this.codigoAutor = 0;
    }

    // construtor
    public VoLivrosAutor(int codigoLivro) 
    {
        this.codigoLivro = codigoLivro;
    }

    // getters and setters
    public int getCodigoLivro() 
    {
        return codigoLivro;
    }

    public void setCodigoLivro(int codigoLivro) 
    {
        this.codigoLivro = codigoLivro;
    }

    public int getCodigoAutor() 
    {
        return codigoAutor;
    }

    public void setCodigoAutor(int codigoAutor) 
    {
        this.codigoAutor = codigoAutor;
    }

    @Override
    public String toString() 
    {
        return "VoLivrosAutor{" + "codigoLivro=" + codigoLivro + ", codigoAutor=" + codigoAutor + '}';
    }
}
