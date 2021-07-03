package DAO.bd.Conexao;

import Excecao.ExcecaoSGBD;
import java.sql.SQLException;

public class Conexao 
{
    private DaoConectarBD conexao;
    private DaoConsultarBD bd;

    public Conexao() {
    }

    public void conectar() throws ExcecaoSGBD, ClassNotFoundException, SQLException
    {
        if (this.getConexao() == null) 
        {
            this.setConexao(new DaoConectarBD());
            this.setBd(new DaoConsultarBD(this.getConexao()));
            this.getConexao().conectar();
        }
    }

    public void desconectar() throws SQLException
    {
        this.getConexao().desConectar();
    }

    public DaoConectarBD getConexao() 
    {
        return conexao;
    }

    private void setConexao(DaoConectarBD conexao) 
    {
        this.conexao = conexao;
    }

    public DaoConsultarBD getBd() 
    {
        return bd;
    }

    private void setBd(DaoConsultarBD bd) 
    {
        this.bd = bd;
    }
}
