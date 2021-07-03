package Models.Bo;

import DAO.DaoEdicao;
import Excecao.UsoExcecao;
import Models.Vo.VoEdicao;

public class BoEdicao implements I_BO 
{
    private VoEdicao vo;
    private String erro;
    private DaoEdicao dao;

    public BoEdicao(VoEdicao vo) 
    {
        this.vo = vo;
        this.dao = new DaoEdicao(vo);
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
                this.setErro("Houve um erro ao salvar as informações de Edicao no banco de dados");
                return false;
            }
        } 
        catch (UsoExcecao ex) 
        {
            this.setErro("Houve um erro ao salvar as informações de Edicao no banco de dados");
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
            this.setErro("Erro ao obter o próximo código do Edicao!");
            throw ex;
        }
    }

    public boolean validarCodigo() 
    {
        if (this.getVo().getCodigo() <= 0) 
        {
            this.setErro("O Código do Edicao deve ser informado!");
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

    public VoEdicao getVo() 
    {
        return vo;
    }

    public void setVo(VoEdicao vo) 
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

    public DaoEdicao getDao() 
    {
        return dao;
    }

    public void setDao(DaoEdicao dao) 
    {
        this.dao = dao;
    }
}
