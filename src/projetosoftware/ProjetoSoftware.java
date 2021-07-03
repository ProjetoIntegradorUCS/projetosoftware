package projetosoftware;

import Excecao.ExcecaoSGBD;
import View.Gui.GuiAutor;
import View.Gui.GuiLivro;
import View.Gui.GuiEdicao;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import DAO.bd.Conexao.Conexao;

public class ProjetoSoftware 
{
    public static Conexao conexao;
    private GuiAutor guiAutor;
    private GuiLivro guiLivro;
    private GuiEdicao guiEdicao;
    
    public ProjetoSoftware() 
    {
        guiAutor  = new GuiAutor(new JFrame(), true);
        guiLivro  = new GuiLivro(new JFrame(), true);
        guiEdicao = new GuiEdicao(new JFrame(), true);
        
        conexao = new Conexao();
    }

    private void conectar() 
    {
        try 
        {
            conexao.conectar();
        } 
        catch (ExcecaoSGBD | ClassNotFoundException | SQLException ex) 
        {
            JOptionPane.showMessageDialog(this.getGuiAutor(),
                    "Não foi possível estabelecer uma conexão com o banco de dados!"
                    + "\nO sistema será encerrado",
                    "Conexão com o Banco de Dados", JOptionPane.ERROR_MESSAGE);
            System.exit(-1);
        }
    }

    public void desconectar() 
    {
        try 
        {
            conexao.desconectar();
            JOptionPane.showConfirmDialog(this.getGuiAutor(),
                    "Conexão com o banco de dados foi encerrada com sucesso",
                    "Conexão com o SGBD", JOptionPane.DEFAULT_OPTION);
        } 
        catch (SQLException ex) 
        {
            JOptionPane.showConfirmDialog(this.getGuiAutor(),
                    "Conexão com o banco de dados não foi encerrada com sucesso",
                    "Conexão com o SGBD", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void mostrarTelaAutor() 
    {
        this.getGuiEdicao().setVisible(false);
        this.getGuiLivro().setVisible(false);
        
        this.getGuiAutor().getCoAutor().limpar();
        this.getGuiAutor().setVisible(true);
    }
    
    public void mostrarTelaLivro()
    {
        this.getGuiEdicao().setVisible(false);
        this.getGuiAutor().setVisible(false);
        
        this.getGuiLivro().getCo().limpar();
        this.getGuiLivro().setVisible(true);
    }
    
    public void mostrarTelaEdicao()
    {
        this.getGuiLivro().setVisible(false);
        this.getGuiAutor().setVisible(false);
        
        this.getGuiEdicao().getCo().limpar();
        this.getGuiEdicao().setVisible(true);
    }
    
    public static Conexao getConexao() 
    {
        return conexao;
    }

    public GuiAutor getGuiAutor() 
    {
        return guiAutor;
    }
    
    public GuiLivro getGuiLivro()
    {
        return guiLivro;
    }
    
    public GuiEdicao getGuiEdicao() 
    {
        return guiEdicao;
    }
    
    public static void main(String[] args) 
    {
        ProjetoSoftware ps = new ProjetoSoftware();
        ps.conectar();
        ps.mostrarTelaLivro();
        ps.desconectar();
    }
}
