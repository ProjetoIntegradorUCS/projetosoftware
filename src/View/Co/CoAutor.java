package View.Co;

import Excecao.UsoExcecao;
import View.Gui.GuiAutor;
import javax.swing.JOptionPane;
import Models.Bo.BoAutor;
import Models.Vo.VoAutor;
import projetosoftware.Conversao;

public class CoAutor implements I_CO {

    // atributos
    private VoAutor vo;
    private GuiAutor gui;
    private BoAutor bo;

    // construtor
    public CoAutor(GuiAutor gui) {
        this.gui = gui;
        this.vo = new VoAutor();
        this.bo = new BoAutor(vo);
    }

    @Override
    public void cadastrar() 
    {
        int codigo = Conversao.converteStringToInteiro(this.getGui().getjTextField1().getText());

        this.setVo(new VoAutor(codigo,
                this.getGui().getjTextField2().getText()));

        this.getBo().setVo(this.getVo());
        try 
        {
            if (this.getBo().cadastrar()) 
            {
                JOptionPane.showMessageDialog(this.getGui(), "Autor cadastrada com sucesso",
                        "Cadastrar Autor", JOptionPane.ERROR_MESSAGE);
            } 
            else 
            {
                JOptionPane.showMessageDialog(this.getGui(), this.getBo().getErro(),
                        "Cadastrar Autor", JOptionPane.ERROR_MESSAGE);
            }
        } 
        catch (UsoExcecao ex) 
        {
            JOptionPane.showMessageDialog(this.getGui(), this.getBo().getErro() + "\n"
                    + ex.getMessage(),
                    "Cadastrar Autor", JOptionPane.ERROR_MESSAGE);
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
                    "Cadastrar Autor", JOptionPane.ERROR_MESSAGE);
        }
        this.getGui().getjTextField1().requestFocus();
    }

    public void setCampos() 
    {
        this.getGui().getjTextField1().setText(String.valueOf(this.getVo().getCodigo()));
        this.getGui().getjTextField2().setText(this.getVo().getNome());
        this.getGui().getjTextField2().requestFocus();
    }

    public VoAutor getVo() 
    {
        return vo;
    }

    public void setVo(VoAutor vo) 
    {
        this.vo = vo;
    }

    public GuiAutor getGui() 
    {
        return gui;
    }

    public void setGui(GuiAutor gui) 
    {
        this.gui = gui;
    }

    public BoAutor getBo() 
    {
        return bo;
    }

    public void setBo(BoAutor bo) 
    {
        this.bo = bo;
    }
}
