package View.Co;

import Excecao.UsoExcecao;
import View.Gui.GuiEdicao;
import javax.swing.JOptionPane;
import Models.Bo.BoEdicao;
import Models.Vo.VoEdicao;
import projetosoftware.Conversao;

public class CoEdicao implements I_CO 
{
    private VoEdicao vo;
    private GuiEdicao gui;
    private BoEdicao bo;

    public CoEdicao(GuiEdicao gui) 
    {
        this.gui = gui;
        this.vo = new VoEdicao();
        this.bo = new BoEdicao(vo);
    }

    @Override
    public void cadastrar() 
    {
        int codigoLivro = Conversao.converteStringToInteiro(this.getGui().getjTextField1().getText());
        int edicao = Conversao.converteStringToInteiro(this.getGui().getjTextField2().getText());
        int ano = Conversao.converteStringToInteiro(this.getGui().getjTextField3().getText());
        
        this.setVo(new VoEdicao(codigoLivro,
                                edicao,
                                ano));

        // salvar
        this.getBo().setVo(this.getVo());
        try {
            if (this.getBo().cadastrar()) {
                JOptionPane.showMessageDialog(this.getGui(), "Edicao cadastrada com sucesso",
                        "Cadastrar Edicao", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this.getGui(), this.getBo().getErro(),
                        "Cadastrar Edicao", JOptionPane.ERROR_MESSAGE);
            }
        } 
        catch (UsoExcecao ex) 
        {
            JOptionPane.showMessageDialog(this.getGui(), this.getBo().getErro() + "\n"
                    + ex.getMessage(),
                    "Cadastrar Edicao", JOptionPane.ERROR_MESSAGE);
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
                    "Cadastrar Edicao", JOptionPane.ERROR_MESSAGE);
        }
        this.getGui().getjTextField1().requestFocus();
    }

    public void setCampos() 
    {
        this.getGui().getjTextField1().setText(String.valueOf(this.getVo().getCodigo()));
        this.getGui().getjTextField2().setText(String.valueOf(this.getVo().getEdicao()));
        this.getGui().getjTextField3().setText(String.valueOf(this.getVo().getAno()));
    }

    public VoEdicao getVo() 
    {
        return vo;
    }

    public void setVo(VoEdicao vo) 
    {
        this.vo = vo;
    }

    public GuiEdicao getGui() 
    {
        return gui;
    }

    public void setGui(GuiEdicao gui) 
    {
        this.gui = gui;
    }

    public BoEdicao getBo() 
    {
        return bo;
    }

    public void setBo(BoEdicao bo) 
    {
        this.bo = bo;
    }
}
