package Models.Vo;

public class VoEdicao implements I_VO
{
    private int codigoLivro;
    private int edicao;
    private int ano;

    public VoEdicao(int codigoLivro, int edicao, int ano) 
    {
        this.codigoLivro = codigoLivro;
        this.edicao = edicao;
        this.ano = ano;
    }

    public VoEdicao() 
    {
        this.codigoLivro = 0;
        this.edicao = 0;
        this.ano = 0;
    }

    // construtor
    public VoEdicao(int codigoLivro) 
    {
        this.codigoLivro = codigoLivro;
    }

    // getters and setters
    public int getCodigo() 
    {
        return codigoLivro;
    }

    public void setCodigo(int codigoLivro) 
    {
        this.codigoLivro = codigoLivro;
    }

    public int getEdicao() 
    {
        return edicao;
    }
    
    public void setEdicao(int edicao)
    {
        this.edicao = edicao;
    }
    
    public int getAno()
    {
        return ano;
    }
    public void setAno(int ano) 
    {
        this.ano = ano;
    }

    @Override
    public String toString() 
    {
        return "VoAutor{" + "codigoLivro=" + codigoLivro + ", edicao=" + edicao + ", ano=" + ano + '}';
    }
}
