package View.Gui;

import View.Co.CoLivrosAutor;
import javax.swing.JButton;
import javax.swing.JDialog;
import projetosoftware.ProjetoSoftware;

public class GuiLivrosAutor extends javax.swing.JDialog 
{
    private CoLivrosAutor co;
    private JButton jButton5;

    public GuiLivrosAutor(java.awt.Frame parent, boolean modal) 
    {
        super(parent, modal);
        initComponents();
        this.co = new CoLivrosAutor(this);
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null); 
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        codigoCampo = new javax.swing.JTextField();
        Fechar = new javax.swing.JButton();
        tituloCampo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        Cadastrar = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        CadastrarAutor = new javax.swing.JMenu();
        CadastrarLivro = new javax.swing.JMenu();
        CadastrarEdicao = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de LivrosAutor");

        jLabel1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel1.setText("Código");
        jLabel1.setToolTipText("Informação obrigatória!");

        codigoCampo.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        codigoCampo.setText("jTextField1");
        codigoCampo.setToolTipText("Informe o código da cidade para consulta!");
        codigoCampo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                codigoCampoFocusLost(evt);
            }
        });
        codigoCampo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                codigoCampoActionPerformed(evt);
            }
        });

        Fechar.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        Fechar.setText("Fechar");
        Fechar.setToolTipText("Fecha esta janela!");
        Fechar.setBorderPainted(false);
        Fechar.setContentAreaFilled(false);
        Fechar.setFocusable(false);
        Fechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FecharActionPerformed(evt);
            }
        });

        tituloCampo.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        tituloCampo.setText("jTextField2");
        tituloCampo.setToolTipText("Digite o nome da cidade!");

        jLabel2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel2.setText("Titulo");
        jLabel2.setToolTipText("Informação obrigatória!");

        Cadastrar.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        Cadastrar.setText("Cadastrar");
        Cadastrar.setToolTipText("Salva ou altera as informações de um produto!");
        Cadastrar.setBorderPainted(false);
        Cadastrar.setContentAreaFilled(false);
        Cadastrar.setFocusable(false);
        Cadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CadastrarActionPerformed(evt);
            }
        });

        CadastrarAutor.setText("Cadastrar Autor");
        CadastrarAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CadastrarAutorActionPerformed(evt);
            }
        });
        jMenuBar1.add(CadastrarAutor);

        CadastrarLivro.setText("Cadastrar Livro");
        jMenuBar1.add(CadastrarLivro);

        CadastrarEdicao.setText("Cadastrar Edição");
        jMenuBar1.add(CadastrarEdicao);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(53, 53, 53)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(codigoCampo, javax.swing.GroupLayout.DEFAULT_SIZE, 321, Short.MAX_VALUE)
                            .addComponent(tituloCampo)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Cadastrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Fechar)))
                .addGap(47, 47, 47))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(codigoCampo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tituloCampo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Cadastrar)
                    .addComponent(Fechar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CadastrarActionPerformed
        // TODO add your handling code here:
        this.getCo().cadastrar();
    }//GEN-LAST:event_CadastrarActionPerformed

    private void FecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FecharActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_FecharActionPerformed

    private void codigoCampoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_codigoCampoFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_codigoCampoFocusLost

    private void codigoCampoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codigoCampoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_codigoCampoActionPerformed

    private void CadastrarAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CadastrarAutorActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_CadastrarAutorActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Cadastrar;
    private javax.swing.JMenu CadastrarAutor;
    private javax.swing.JMenu CadastrarEdicao;
    private javax.swing.JMenu CadastrarLivro;
    private javax.swing.JButton Fechar;
    private javax.swing.JTextField codigoCampo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JTextField tituloCampo;
    // End of variables declaration//GEN-END:variables

    public CoLivrosAutor getCo() 
    {
        return co;
    }

    public void setCo(CoLivrosAutor co) 
    {
        this.co = co;
    }

    public javax.swing.JButton getjButton3() 
    {
        return Cadastrar;
    }

    public void setjButton3(javax.swing.JButton jButton3) 
    {
        this.Cadastrar = jButton3;
    }

    public javax.swing.JButton getjButton5() 
    {
        return jButton5;
    }

    public void setjButton5(javax.swing.JButton jButton5) 
    {
        this.jButton5 = jButton5;
    }

    public javax.swing.JButton getjButton6() {
        return Fechar;
    }

    public void setjButton6(javax.swing.JButton jButton6) 
    {
        this.Fechar = jButton6;
    }

    public javax.swing.JTextField getjTextField1() 
    {
        return codigoCampo;
    }

    public void setjTextField1(javax.swing.JTextField jTextField1) 
    {
        this.codigoCampo = jTextField1;
    }

    public javax.swing.JTextField getjTextField2() 
    {
        return tituloCampo;
    }

    public void setjTextField2(javax.swing.JTextField jTextField2) 
    {
        this.tituloCampo = jTextField2;
    }
}
