package View.Co;

import Excecao.UsoExcecao;
import View.Gui.GuiLivrosAutor;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import Models.Bo.BoLivrosAutor;
import Models.Vo.VoConsulta;
import Models.Vo.VoLivrosAutor;
import projetosoftware.Conversao;

public class CoLivrosAutor implements I_CO 
{
    private VoLivrosAutor vo;
    private GuiLivrosAutor gui;
    private BoLivrosAutor bo;

    public CoLivrosAutor(GuiLivrosAutor gui) 
    {
        this.gui = gui;
        this.vo = new VoLivrosAutor();
        this.bo = new BoLivrosAutor(vo);
    }

    @Override
    public void cadastrar() 
    {
        int codigoLivro = Conversao.converteStringToInteiro(this.getGui().getjTextField1().getText());
        int codigoAutor = Conversao.converteStringToInteiro(this.getGui().getjTextField2().getText());
        this.setVo(new VoLivrosAutor(codigoLivro, codigoAutor));

        // salvar
        this.getBo().setVo(this.getVo());
        try {
            if (this.getBo().cadastrar()) 
            {
                JOptionPane.showMessageDialog(this.getGui(), "LivrosAutor cadastrado com sucesso",
                        "Cadastrar Livro", JOptionPane.ERROR_MESSAGE);
            } 
            else 
            {
                JOptionPane.showMessageDialog(this.getGui(), this.getBo().getErro(),
                        "Cadastrar Lista", JOptionPane.ERROR_MESSAGE);
            }
        } 
        catch (UsoExcecao ex) 
        {
            JOptionPane.showMessageDialog(this.getGui(), this.getBo().getErro() + "\n"
                    + ex.getMessage(),
                    "Cadastrar Lista", JOptionPane.ERROR_MESSAGE);
        }
        this.limpar();
    }
    
    public void limpar() 
    {
        int codigo;
        try 
        {
            codigo = this.getBo().proximoCodigoLivre();
            this.getGui().getjTextField1().setText(String.valueOf(codigo));
            this.getGui().getjTextField2().setText("");
        } 
        catch (UsoExcecao ex) 
        {
            JOptionPane.showMessageDialog(this.getGui(), this.getBo().getErro() + "\n"
                    + ex.getMessage(),
                    "Cadastrar LivrosAutor", JOptionPane.ERROR_MESSAGE);
        }
        this.getGui().getjTextField1().requestFocus();
    }

    public void setCampos() 
    {
        this.getGui().getjTextField1().setText(String.valueOf(this.getVo().getCodigoLivro()));
        this.getGui().getjTextField2().setText(String.valueOf(this.getVo().getCodigoAutor()));
        this.getGui().getjTextField2().requestFocus();
    }

    public VoLivrosAutor getVo() 
    {
        return vo;
    }

    public void setVo(VoLivrosAutor vo) 
    {
        this.vo = vo;
    }

    public GuiLivrosAutor getGui() 
    {
        return gui;
    }

    public void setGui(GuiLivrosAutor gui) 
    {
        this.gui = gui;
    }

    public BoLivrosAutor getBo() 
    {
        return bo;
    }

    public void setBo(BoLivrosAutor bo) 
    {
        this.bo = bo;
    }
}
