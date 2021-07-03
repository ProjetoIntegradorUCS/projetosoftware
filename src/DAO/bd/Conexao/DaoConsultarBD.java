package DAO.bd.Conexao;

import Excecao.ExcecaoSGBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DaoConsultarBD 
{
    DaoConectarBD bd;
    Connection conexao;

    public DaoConsultarBD(DaoConectarBD bd) 
    {
        this.bd = bd;
    }
    
    public PreparedStatement getStatement(String sql) throws SQLException, ExcecaoSGBD, ClassNotFoundException 
    {
        PreparedStatement comando;
        conexao = bd.getConexao();
        comando = conexao.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

        return comando;
    }
    
    public void executaSQL(PreparedStatement ps) throws SQLException, ExcecaoSGBD, ClassNotFoundException 
    {
        ps.executeUpdate();
        this.executaSQL("commit");
    }
    
    public ResultSet consulta(String sql) throws SQLException, ExcecaoSGBD, ClassNotFoundException 
    {
        PreparedStatement comando = null;
        ResultSet consulta = null;
        conexao = bd.getConexao();

        comando = conexao.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        consulta = comando.executeQuery();

        return consulta;
    }
    
    public ResultSet consulta(PreparedStatement comando) throws SQLException, ExcecaoSGBD, ClassNotFoundException 
    {
        ResultSet consulta;
        conexao = bd.getConexao();
        consulta = comando.executeQuery();

        return consulta;
    }    
    
    public void executaSQL(String sql) throws SQLException, ExcecaoSGBD, ClassNotFoundException 
    {
        PreparedStatement comando = null;
        conexao = bd.getConexao();

        comando = conexao.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        comando.executeUpdate();
    }
}
