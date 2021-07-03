package DAO;

import DAO.bd.Conexao.Conexao;
import Excecao.UsoExcecao;
import Excecao.ExcecaoSGBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Models.Vo.VoConsulta;
import Models.Vo.VoLivro;
import projetosoftware.ProjetoSoftware;

public class DaoLivro implements I_DAO 
{
    private VoLivro vo;

    public DaoLivro(VoLivro vo) 
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
                sql = "update livro "
                        + "set titulo      = ?, "
                        + "where codigo  = ?";

                PreparedStatement ps = this.getConexao().getBd().getStatement(sql);

                ps.setInt(3, vo.getCodigo());
                ps.setString(1, vo.getTitulo());
                this.getConexao().getBd().executaSQL(ps);
            } 
            else 
            {
                sql = "insert into livro (codigo, titulo)"
                        + " values (?, ?)";

                PreparedStatement ps = this.getConexao().getBd().getStatement(sql);

                vo.setCodigo(this.proximoCodigoLivre());

                ps.setInt(1, vo.getCodigo());
                ps.setString(2, vo.getTitulo());

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
            String sql = "select * from livro where codigo = " + this.getVo().getCodigo();
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
    
    public VoConsulta obterLista() throws UsoExcecao {
        try {
            // consultar o código
            String sql = "select titulo from livro ORDER BY titulo ASC;";

            // executar sql
            ResultSet rs = this.getConexao().getBd().consulta(sql);

            // cria lista de cidades
            return new VoConsulta(rs);
        } catch (ClassNotFoundException | SQLException | ExcecaoSGBD e) {
            throw new UsoExcecao(e.getMessage());
        }
    }
    public int proximoCodigoLivre() throws UsoExcecao 
    {
        try 
        {
            String sql = "select max(codigo) from livro";
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

    public VoLivro getVo() 
    {
        return vo;
    }

    public void setVo(VoLivro vo) 
    {
        this.vo = vo;
    }

    public Conexao getConexao() 
    {
        return ProjetoSoftware.getConexao();
    }
}
