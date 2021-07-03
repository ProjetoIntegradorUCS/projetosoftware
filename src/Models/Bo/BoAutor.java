package Models.Bo;

import DAO.DaoAutor;
import Excecao.UsoExcecao;
import Models.Vo.VoAutor;

public class BoAutor implements I_BO 
{

    // atributos
    private VoAutor vo;
    private String erro;
    private DaoAutor dao;

    // construtor
    public BoAutor(VoAutor vo) 
    {
        this.vo = vo;
        this.dao = new DaoAutor(vo);
        this.erro = "";
    }

    @Override
    public boolean cadastrar() throws UsoExcecao 
    {
        // validar os campos
        if (!this.validar()) 
        {
            return false;
        }
        try 
        {
            this.getDao().setVo(this.getVo());
            if (!this.getDao().cadastrar()) 
            {
                this.setErro("Houve um erro ao salvar as informações de Autor no banco de dados");
                return false;
            }
        } 
        catch (UsoExcecao ex) 
        {
            this.setErro("Houve um erro ao salvar as informações de Autor no banco de dados");
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
            this.setErro("Erro ao obter o próximo código do Autor!");
            throw ex;
        }
    }

    public boolean validarCodigo() 
    {
        if (this.getVo().getCodigo() <= 0) 
        {
            this.setErro("O Código do Autor deve ser informado!");
            return false;
        }
        return true;
    }

    @Override
    public boolean validar() {
        boolean error = true;
        String msg = "";
        // testa o valor do código
        if (!this.validarCodigo()) {
            error = false;
            msg = this.getErro() + "\n";
        }

        // testa o valor do descrição
        if (this.getVo().getNome().isEmpty()) 
        {
            msg += "O nome do Autor deve ser informada!\n";
            error = false;
        }

        if (this.getVo().getNome().length() > 40) 
        {
            msg += "O nome do Autor deve ter no máximo 40 caracteres!\n";
            error = false;
        }
        this.setErro(msg);
        return error;
    }

    public VoAutor getVo() 
    {
        return vo;
    }

    public void setVo(VoAutor vo) 
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

    public DaoAutor getDao() 
    {
        return dao;
    }

    public void setDao(DaoAutor dao) 
    {
        this.dao = dao;
    }
}
