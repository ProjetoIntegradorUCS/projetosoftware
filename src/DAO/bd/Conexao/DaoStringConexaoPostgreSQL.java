package DAO.bd.Conexao;

import Models.Vo.VoConexao;

public class DaoStringConexaoPostgreSQL implements DaoStringConexao 
{
    @Override
    public String getStringConexao(VoConexao vo) 
    {
        String url = "jdbc:postgresql://" + vo.getHost() +
                ":" + vo.getPorta() + "/" + vo.getBaseDados();
        System.out.println(url);
        return url;
    }

    @Override
    public VoConexao getConfiguracaoDefault() 
    {
        VoConexao vo = new VoConexao();

        vo.setSgbd("PostgreSQL");
        vo.setHost("slinf30.ucs.br");
        vo.setPorta("5432");
        vo.setBaseDados("inf0211");
        vo.setUsuario("alunos");
        vo.setSenha("postgres");
        vo.setClassDriver("org.postgresql.Driver");

        return vo;
    }

    @Override
    public VoConexao getConfiguracaoAlternativa() 
    {
        VoConexao vo = new VoConexao();

        vo.setSgbd("PostgreSQL");
        vo.setHost("localhost");
        vo.setPorta("5432");
        vo.setBaseDados("projetointegrador");
        vo.setUsuario("postgres");
        vo.setSenha("postgres");
        vo.setClassDriver("org.postgresql.Driver");

        return vo;
    }
}