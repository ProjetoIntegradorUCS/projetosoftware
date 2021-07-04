package DAO;

import DAO.bd.Conexao.Conexao;
import Excecao.UsoExcecao;
import Excecao.ExcecaoSGBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Models.Vo.VoLivrosAutor;
import projetosoftware.ProjetoSoftware;

public class DaoLivrosAutor implements I_DAO 
{
    private VoLivrosAutor vo;

    public DaoLivrosAutor(VoLivrosAutor vo) 
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
                sql = "update livrosAutor "
                        + "set codigoLivro      = ?, "
                        + "where codigoAutor  = ?";

                PreparedStatement ps = this.getConexao().getBd().getStatement(sql);

                ps.setInt(3, vo.getCodigoLivro());
                ps.setInt(1, vo.getCodigoAutor());
                this.getConexao().getBd().executaSQL(ps);
            } 
            else 
            {
                sql = "insert into livrosAutor (codigoLivro, codigoAutor)"
                        + " values (?, ?)";

                PreparedStatement ps = this.getConexao().getBd().getStatement(sql);

                vo.setCodigoLivro(this.proximoCodigoLivre());

                ps.setInt(1, vo.getCodigoLivro());
                ps.setInt(2, vo.getCodigoAutor());

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
            String sql = "select * from livrosAutor where codigoLivro = " + this.getVo().getCodigoLivro();
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
            String sql = "select max(codigoLivro) from livrosAutor";
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

    public VoLivrosAutor getVo() 
    {
        return vo;
    }

    public void setVo(VoLivrosAutor vo) 
    {
        this.vo = vo;
    }

    public Conexao getConexao() 
    {
        return ProjetoSoftware.getConexao();
    }
}
