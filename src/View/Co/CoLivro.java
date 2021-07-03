package View.Co;

import Excecao.UsoExcecao;
import View.Gui.GuiLivro;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import Models.Bo.BoLivro;
import Models.Vo.VoConsulta;
import Models.Vo.VoLivro;
import projetosoftware.Conversao;

public class CoLivro implements I_CO 
{
    private VoLivro vo;
    private GuiLivro gui;
    private BoLivro bo;

    public CoLivro(GuiLivro gui) 
    {
        this.gui = gui;
        this.vo = new VoLivro();
        this.bo = new BoLivro(vo);
    }

    @Override
    public void cadastrar() 
    {
        int codigo = Conversao.converteStringToInteiro(this.getGui().getjTextField1().getText());

        this.setVo(new VoLivro(codigo,
                this.getGui().getjTextField2().getText()));

        // salvar
        this.getBo().setVo(this.getVo());
        try {
            if (this.getBo().cadastrar()) 
            {
                JOptionPane.showMessageDialog(this.getGui(), "Livro cadastrado com sucesso",
                        "Cadastrar Livro", JOptionPane.ERROR_MESSAGE);
            } 
            else 
            {
                JOptionPane.showMessageDialog(this.getGui(), this.getBo().getErro(),
                        "Cadastrar Livro", JOptionPane.ERROR_MESSAGE);
            }
        } 
        catch (UsoExcecao ex) 
        {
            JOptionPane.showMessageDialog(this.getGui(), this.getBo().getErro() + "\n"
                    + ex.getMessage(),
                    "Cadastrar Livro", JOptionPane.ERROR_MESSAGE);
        }
        this.limpar();
    }
    
    public void obterLista() 
    {
        try 
        {
            VoConsulta lista = this.getBo().obterLista();

            String title = "Consulta lista de Livros";
            CoConsulta controllerConsulta = new CoConsulta((JFrame) this.getGui().getParent(),
                    true, lista, title, 1);

            controllerConsulta.consultar();

            if (controllerConsulta.isRetorno()) 
            {
                ArrayList objeto = controllerConsulta.getObjetoConsulta();

                this.setVo(new VoLivro(Integer.parseInt(objeto.get(0).toString()),
                        objeto.get(1).toString()));

                this.getBo().setVo(this.getVo());
                this.setCampos();
            }
        } 
        catch (UsoExcecao ex) 
        {
            JOptionPane.showMessageDialog(this.getGui(), this.getBo().getErro() + "\n"
                    + ex.getMessage(),
                    "Cadastrar Cidade", JOptionPane.ERROR_MESSAGE);
        }
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
                    "Cadastrar Livro", JOptionPane.ERROR_MESSAGE);
        }
        this.getGui().getjTextField1().requestFocus();
    }

    public void setCampos() 
    {
        this.getGui().getjTextField1().setText(String.valueOf(this.getVo().getCodigo()));
        this.getGui().getjTextField2().setText(this.getVo().getTitulo());
        this.getGui().getjTextField2().requestFocus();
    }

    public VoLivro getVo() 
    {
        return vo;
    }

    public void setVo(VoLivro vo) 
    {
        this.vo = vo;
    }

    public GuiLivro getGui() 
    {
        return gui;
    }

    public void setGui(GuiLivro gui) 
    {
        this.gui = gui;
    }

    public BoLivro getBo() 
    {
        return bo;
    }

    public void setBo(BoLivro bo) 
    {
        this.bo = bo;
    }
}
