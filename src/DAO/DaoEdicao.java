package DAO;

import DAO.bd.Conexao.Conexao;
import Excecao.UsoExcecao;
import Excecao.ExcecaoSGBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Models.Vo.VoEdicao;
import projetosoftware.ProjetoSoftware;

public class DaoEdicao implements I_DAO 
{
    private VoEdicao vo;

    public DaoEdicao(VoEdicao vo) 
    {
        this.vo = vo;
    }

    @Override
    public boolean cadastrar() throws UsoExcecao 
    {
        try 
        {
            String sql;
            if (this.existeCodigo()) 
            {
                sql = "update edicao "
                        + "set edicao      = ?, "
                        + "where codigoLivro  = ?";

                PreparedStatement ps = this.getConexao().getBd().getStatement(sql);

                ps.setInt(3, vo.getCodigo());
                ps.setInt(1, vo.getEdicao());
                ps.setInt(3, vo.getAno());
                this.getConexao().getBd().executaSQL(ps);
            } 
            else 
            {
                sql = "insert into edicao (codigoLivro, edicao, ano)"
                        + " values (?, ?, ?)";

                PreparedStatement ps = this.getConexao().getBd().getStatement(sql);

                vo.setCodigo(this.proximoCodigoLivre());

                ps.setInt(1, vo.getCodigo());
                ps.setInt(2, vo.getEdicao());
                ps.setInt(3, vo.getAno());

                this.getConexao().getBd().executaSQL(ps);
            }
        } 
        catch (ClassNotFoundException | SQLException | ExcecaoSGBD e) 
        {
            throw new UsoExcecao(e.getMessage());
        }
        return true;
    }

    public boolean existeCodigo() throws UsoExcecao 
    {
        try 
        {
            String sql = "select * from edicao where codigoLivro = " + this.getVo().getCodigo();
            ResultSet rs = this.getConexao().getBd().consulta(sql);

            while (rs.next()) 
            {
                return true;
            }
        } 
        catch (ClassNotFoundException | SQLException | ExcecaoSGBD e) 
        {
            throw new UsoExcecao(e.getMessage());
        }
        return false;
    }

    public int proximoCodigoLivre() throws UsoExcecao 
    {
        try 
        {
            String sql = "select max(codigoLivro) from edicao";
            ResultSet rs = this.getConexao().getBd().consulta(sql);

            while (rs.next()) 
            {
                int codigo = rs.getInt(1) + 1;
                return codigo;
            }
        } 
        catch (ClassNotFoundException | SQLException | ExcecaoSGBD e) 
        {
            throw new UsoExcecao(e.getMessage());
        }
        return 1;
    }

    public VoEdicao getVo() 
    {
        return vo;
    }

    public void setVo(VoEdicao vo) 
    {
        this.vo = vo;
    }

    public Conexao getConexao() 
    {
        return ProjetoSoftware.getConexao();
    }
}
