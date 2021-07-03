package View.Co;

import View.Gui.GuiConsulta;
import View.Consulta.GuiMontarJTable;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dialog;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import javax.swing.table.JTableHeader;
import Models.Vo.VoConsulta;

public class CoConsulta {

    private ResultSet rs;
    private GuiConsulta gui;
    private boolean retorno;
    private ArrayList objetoConsulta;
    private int tabelaConsultada;

    public CoConsulta(JFrame parent, boolean modal, ResultSet rs, 
            String title, int tabelaConsultada) {
        this.rs = rs;
        this.gui = new GuiConsulta(parent, true, title);
        this.gui.setModalExclusionType(Dialog.ModalExclusionType.NO_EXCLUDE);
        this.tabelaConsultada = tabelaConsultada;
    }

    public CoConsulta(JFrame parent, boolean modal, VoConsulta lista, 
            String title, int tabelaConsultada) 
    {    
        this.rs = lista.getRs();
        this.gui = new GuiConsulta(parent, true, title);
        this.gui.setModalExclusionType(Dialog.ModalExclusionType.NO_EXCLUDE);
        this.tabelaConsultada = tabelaConsultada;
    }    
    
    public void consultar() 
    {
        GuiMontarJTable iMontarJTable = new GuiMontarJTable(this.getRs());
        try 
        {
            this.setRetorno(false);
            boolean selecao = this.getGui().getjTable().isEnabled();
            this.getGui().setjTable(new JTable(iMontarJTable.criaTabela()));
            this.getGui().getjTable().setFillsViewportHeight(true);
            this.getGui().getjTable().setFont(new java.awt.Font("Arial", 1, 18));
            this.getGui().getjTable().setRowHeight(28);
            this.getGui().getjTable().setBorder(new BevelBorder(1, Color.black, Color.black));
            this.getGui().getjTable().getTableHeader().setBorder(new BevelBorder(1, Color.black, Color.black));
            this.getGui().getjTable().setShowGrid(true);
            JTableHeader header = this.getGui().getjTable().getTableHeader();
            header.setForeground(Color.black);
            header.setFont(new java.awt.Font("Arial", 1, 18));
            this.getGui().getjTable().addMouseListener(new java.awt.event.MouseAdapter() {
                @Override
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    try {
                        jTableMouseClicked(evt);
                    } catch (SQLException ex) {
                        Logger.getLogger(CoConsulta.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });

            // adiciona ao container
            Container pane = this.getGui().getContentPane();
            pane.remove(this.getGui().getjScrollPane());
            this.getGui().setjScrollPane(new JScrollPane(this.getGui().getjTable()));
            this.getGui().getjScrollPane().setBounds(0, 0, 800, 400);
            pane.add(this.getGui().getjScrollPane());
            this.getGui().getjTable().setEnabled(selecao);

            // mostrar tela
            this.getGui().setVisible(true);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this.getGui(), "Não foi possível "
                    + " consultar os dados no banco de dados!\n" + ex,
                    "Consulta de Informações", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void jTableMouseClicked(java.awt.event.MouseEvent evt) throws SQLException 
    {
        int linha = this.getGui().getjTable().getSelectedRow();
        int tamanho = this.getRs().getMetaData().getColumnCount();

        if (linha < 0) 
        {
            this.setRetorno(false);
            return;
        }

        this.setObjetoConsulta(new ArrayList(tamanho));

        this.getRs().beforeFirst();

        while (this.getRs().next()) 
        {
            if (this.getRs().getRow() == linha + 1) 
            {
                for (int i = 1; i < tamanho + 1; i++) 
                {
                    this.getObjetoConsulta().add(this.getRs().getString(i));
                }
                break;
            }
        }

        // sets.....
        this.setRetorno(true);
        this.getGui().setVisible(false);
    }

    public void setSelecaoTabela(boolean selecao) {
        this.getGui().getjTable().setEnabled(selecao);
    }

    public JTable montarTelaConsultar() {
        // variavel de retorno
        JTable tabela = null;
        try {
            // monta jtable
            GuiMontarJTable iMontarJTable = new GuiMontarJTable(this.getRs());

            // criar objeto jtable e configurar
            tabela = new JTable(iMontarJTable.criaTabela());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this.getGui(), "Não foi possível "
                    + " consultar os dados no banco de dados!\n" + ex,
                    "Consulta de Informações", JOptionPane.ERROR_MESSAGE);
        }

        // retorna
        return tabela;
    }

    /**
     * *
     * getters and setters
     *
     * @return
     */
    private ResultSet getRs() {
        return rs;
    }

    private GuiConsulta getGui() {
        return gui;
    }

    public boolean isRetorno() {
        return retorno;
    }

    private void setRetorno(boolean retorno) {
        this.retorno = retorno;
    }

    public ArrayList getObjetoConsulta() {
        return objetoConsulta;
    }

    private void setObjetoConsulta(ArrayList objetoConsulta) {
        this.objetoConsulta = objetoConsulta;
    }
}
