package Models.Bo;

import DAO.DaoLivrosAutor;
import Excecao.UsoExcecao;
import Models.Vo.VoConsulta;
import Models.Vo.VoLivrosAutor;

public class BoLivrosAutor implements I_BO 
{
    private VoLivrosAutor vo;
    private String erro;
    private DaoLivrosAutor dao;

    public BoLivrosAutor(VoLivrosAutor vo) 
    {
        this.vo = vo;
        this.dao = new DaoLivrosAutor(vo);
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
                this.setErro("Houve um erro ao salvar as informações da lista no banco de dados");
                return false;
            }
        } 
        catch (UsoExcecao ex) 
        {
            this.setErro("Houve um erro ao salvar as informações da lista no banco de dados");
            throw ex;
        }
        return true;
    }
       
    
    public int proximoCodigoLivre() throws UsoExcecao 
    {
        try 
        {
            return this.getDao().proximoCodigoLivre();
        } 
        catch (UsoExcecao ex) 
        {
            this.setErro("Erro ao obter o próximo código da lista!");
            throw ex;
        }
    }

    public boolean validarCodigo() 
    {
        if (this.getVo().getCodigoLivro() <= 0) 
        {
            this.setErro("O Código da lista deve ser informado!");
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

        this.setErro(msg);
        return error;
    }

    public VoLivrosAutor getVo() 
    {
        return vo;
    }

    public void setVo(VoLivrosAutor vo) 
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

    public DaoLivrosAutor getDao() 
    {
        return dao;
    }

    public void setDao(DaoLivrosAutor dao) 
    {
        this.dao = dao;
    }
}
