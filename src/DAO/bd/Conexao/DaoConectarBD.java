package DAO.bd.Conexao;

import Excecao.ExcecaoSGBD;
import Models.Vo.VoConexao;
import java.sql.*;

public class DaoConectarBD 
{
    private VoConexao voConexao;
    private Connection conexao;

    private DaoConectarBD(VoConexao voConexao, Connection conexao) 
    {
        this.voConexao = voConexao;
        this.conexao = conexao;
    }

    public DaoConectarBD() throws ExcecaoSGBD, ClassNotFoundException, SQLException 
    {
       this(null, null);
    }

    public Connection conectar() throws ExcecaoSGBD, java.lang.ClassNotFoundException, SQLException 
    {
        this.voConexao = new DaoStringConexaoPostgreSQL().getConfiguracaoAlternativa();

        if ((this.getVoConexao() == null) || (this.getVoConexao().getBaseDados() == null) || 
            (this.getVoConexao().getHost() == null) || (this.getVoConexao().getPorta() == null) || 
            (this.getVoConexao().getSenha() == null) || (this.getVoConexao().getSgbd() == null) || 
            (this.getVoConexao().getUsuario() == null)) 
        {
            throw new ExcecaoSGBD("Não foi possível conectar com o SGBD com as" +
                    " informações " + this.getVoConexao());
        }

        DaoStringConexao conexaoConfig = new DaoStringConexaoPostgreSQL();
        String url = conexaoConfig.getStringConexao(this.getVoConexao());
        Class.forName(this.getVoConexao().getClassDriver());

        conexao = DriverManager.getConnection(url,
                this.getVoConexao().getUsuario(),
                this.getVoConexao().getSenha());
        conexao.setAutoCommit(false);

        return conexao;
    }

    public void desConectar() throws SQLException 
    {
        conexao.close();
    }

    public VoConexao getVoConexao() 
    {
        return voConexao;
    }

    public void setVoConexao(VoConexao voConexao) 
    {
        this.voConexao = voConexao;
    }

    public Connection getConexao() 
    {
        return conexao;
    }
}
