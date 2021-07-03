package DAO;

import DAO.bd.Conexao.Conexao;
import Excecao.UsoExcecao;
import Excecao.ExcecaoSGBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Models.Vo.VoAutor;
import projetosoftware.ProjetoSoftware;

public class DaoAutor implements I_DAO 
{
    private VoAutor vo;

    public DaoAutor(VoAutor vo) 
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
                sql = "update autor "
                        + "set nome      = ?, "
                        + "where codigo  = ?";

                PreparedStatement ps = this.getConexao().getBd().getStatement(sql);

                ps.setInt(3, vo.getCodigo());
                ps.setString(1, vo.getNome());
                this.getConexao().getBd().executaSQL(ps);
            } 
            else 
            {
                sql = "insert into autor (codigo, nome)"
                        + " values (?, ?)";

                PreparedStatement ps = this.getConexao().getBd().getStatement(sql);

                vo.setCodigo(this.proximoCodigoLivre());

                ps.setInt(1, vo.getCodigo());
                ps.setString(2, vo.getNome());

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
            String sql = "select * from autor where codigo = " + this.getVo().getCodigo();
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
            String sql = "select max(codigo) from autor";
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

    public VoAutor getVo() 
    {
        return vo;
    }

    public void setVo(VoAutor vo) 
    {
        this.vo = vo;
    }

    public Conexao getConexao() 
    {
        return ProjetoSoftware.getConexao();
    }
}
