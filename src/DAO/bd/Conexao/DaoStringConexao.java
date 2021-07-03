package DAO.bd.Conexao;

import Models.Vo.VoConexao;

public interface DaoStringConexao 
{
    public String getStringConexao(VoConexao vo);
    public VoConexao getConfiguracaoDefault();
    public VoConexao getConfiguracaoAlternativa();
}
