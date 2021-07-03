package Models.Bo;

import DAO.DaoLivro;
import Excecao.UsoExcecao;
import Models.Vo.VoConsulta;
import Models.Vo.VoLivro;

public class BoLivro implements I_BO 
{
    private VoLivro vo;
    private String erro;
    private DaoLivro dao;

    public BoLivro(VoLivro vo) 
    {
        this.vo = vo;
        this.dao = new DaoLivro(vo);
        this.erro = "";
    }

    @Override
    public boolean cadastrar() throws UsoExcecao 
    {
        if (!this.validar()) 
        {
            return false;
        }
        try 
        {
            this.getDao().setVo(this.getVo());
            if (!this.getDao().cadastrar()) 
            {
                this.setErro("Houve um erro ao salvar as informações do Livro no banco de dados");
                return false;
            }
        } 
        catch (UsoExcecao ex) 
        {
            this.setErro("Houve um erro ao salvar as informações do Livro no banco de dados");
            throw ex;
        }
        return true;
    }
       
    public VoConsulta obterLista() throws UsoExcecao 
    {
        try 
        {
            return this.getDao().obterLista();
        } 
        catch (UsoExcecao ex) 
        {
            this.setErro("Não foi possível obter a lista de livros cadastradas!");
            throw ex;
        }
    }
    
    public int proximoCodigoLivre() throws UsoExcecao 
    {
        try 
        {
            return this.getDao().proximoCodigoLivre();
        } 
        catch (UsoExcecao ex) 
        {
            this.setErro("Erro ao obter o próximo código do Livro!");
            throw ex;
        }
    }

    public boolean validarCodigo() 
    {
        if (this.getVo().getCodigo() <= 0) 
        {
            this.setErro("O Código do Livro deve ser informado!");
            return false;
        }
        return true;
    }

    @Override
    public boolean validar() 
    {
        boolean error = true;
        String msg = "";
        if (!this.validarCodigo()) 
        {
            error = false;
            msg = this.getErro() + "\n";
        }

        if (this.getVo().getTitulo().isEmpty()) 
        {
            msg += "O titulo do Livro deve ser informada!\n";
            error = false;
        }

        if (this.getVo().getTitulo().length() > 40) 
        {
            msg += "O titulo do Livro deve ter no máximo 40 caracteres!\n";
            error = false;
        }
        this.setErro(msg);
        return error;
    }

    public VoLivro getVo() 
    {
        return vo;
    }

    public void setVo(VoLivro vo) 
    {
        this.vo = vo;
    }

    public String getErro() 
    {
        return this.erro;
    }

    public void setErro(String erro) 
    {
        this.erro = erro;
    }

    public DaoLivro getDao() 
    {
        return dao;
    }

    public void setDao(DaoLivro dao) 
    {
        this.dao = dao;
    }
}
