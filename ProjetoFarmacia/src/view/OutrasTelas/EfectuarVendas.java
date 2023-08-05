package view.OutrasTelas;

import java.awt.EventQueue;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.BorderFactory;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import model.Produto;
import view.run.PaginaPrincipal;

public class EfectuarVendas extends JFrame {

    private JPanel contentPane;
    private JTable table;
    private JLabel lblListaDe;
    private JLabel lblProdutosSeleccionados;
    private JPanel panel;
    private JLabel lblSeleccioneOProduto;
    private JButton btnAdicionarProduto;
    private JLabel lblQuantidade;
    private JTextField qtd;
    private JPanel panel_2;
    private JLabel lblValorPeloProduto;
    private JPanel panel_3;
    private JButton button_1;
    private JPanel panel_4;
    private JLabel lblTotsl;
    private JComboBox produto;
    private JLabel precoTotal;
    private JLabel valorPeloProduto;
    private JButton btnVoltar;
    private JTextPane txtpnOyu;
    private JTable table_1;
    static double somaStockQtd=0;
    static double quantidade;
    static String  id;
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                EfectuarVendas ev = new EfectuarVendas();
                ev.setLocationRelativeTo(null);
                ev.setVisible(true);
            } catch (Exception e) {
            }
        });
    }

    /**
     * Create the frame.
     * @throws java.sql.SQLException
     */
    public EfectuarVendas() throws SQLException {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 646, 596);
        contentPane = new JPanel();
        contentPane.setForeground(new Color(0, 0, 0));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        //listarprodutos
        controller.controllerProduto.listar();
        //////////////////////////////////////////

        double validaStock = 0;
        System.out.println(validaStock);
        String[] colunas = {"Nome", "Preco"};

        Object[][] dados = new Object[controller.controllerProduto.listar().size()][2];
        for (int i = 0; i < controller.controllerProduto.listar().size(); i++) {
            validaStock = Double.parseDouble(controller.controllerProduto.listar().get(i).getStock());
            if (validaStock > 0) {
                dados[i][0] = controller.controllerProduto.listar().get(i).getNomeProduto();
                dados[i][1] = controller.controllerProduto.listar().get(i).getPreco() + " MT";

            }
        }

        table = new JTable(dados, colunas);
        table.setBounds(10, 100, 288, 213);
        contentPane.add(table);

        JScrollPane barraRolagem = new JScrollPane(table);
        barraRolagem.setBounds(10, 100, 288, 213);
        contentPane.add(barraRolagem);

        //////////////////////////////////////////
        Icon icone = new ImageIcon("C:\\Users\\V_Muianga\\Documents\\NetBeansProjects\\ProjetoFarmacia\\src\\img\\5.png");
        JLabel lblNewLabel = new JLabel(icone);
        lblNewLabel.setBounds(0, 0, 630, 70);
        contentPane.add(lblNewLabel);

        lblListaDe = new JLabel("Lista de produtos:");
        lblListaDe.setFont(new Font("Times New Roman", Font.PLAIN, 13));
        lblListaDe.setBounds(10, 81, 140, 14);
        contentPane.add(lblListaDe);

        lblProdutosSeleccionados = new JLabel("Produtos seleccionados:");
        lblProdutosSeleccionados.setFont(new Font("Times New Roman", Font.PLAIN, 13));
        lblProdutosSeleccionados.setBounds(332, 81, 140, 14);
        contentPane.add(lblProdutosSeleccionados);

        panel = new JPanel();
        panel.setBackground(new Color(255, 255, 255));
        panel.setLayout(null);
        panel.setBorder(BorderFactory.createTitledBorder("Seleccione o Produto"));
        panel.setBounds(0, 324, 332, 131);
        contentPane.add(panel);

        lblQuantidade = new JLabel("Quantidade:");
        lblQuantidade.setFont(new Font("Times New Roman", Font.PLAIN, 13));
        lblQuantidade.setBounds(161, 28, 95, 14);
        panel.add(lblQuantidade);

        qtd = new JTextField("");
        qtd.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                qtd.setText(null);
            }
        });
        qtd.setColumns(10);
        qtd.setBounds(236, 23, 86, 25);
        panel.add(qtd);
        //double quantidade= Integer.parseInt((String)qtd.getText());

        produto = new JComboBox();
        produto.setModel(new DefaultComboBoxModel(new String[] {"Selecione Produto"}));
        produto.setBackground(new Color(255, 255, 255));
        produto.setBounds(10, 24, 127, 26);
        panel.add(produto);

        for (Produto p : controller.controllerProduto.listar()) {
                    
                    
                    produto.addItem(p.toString2());
                

            }
            
                for (Produto p : controller.controllerProduto.listar()) {
                    
                    if (validaStock > 0) {
                        
                        validaStock = Double.parseDouble(p.getStock());
                    }
              
            }
      //  }

        panel_2 = new JPanel();
        panel_2.setLayout(null);
        panel_2.setBounds(0, 452, 332, 64);
        contentPane.add(panel_2);

        lblValorPeloProduto = new JLabel("VALOR PELO PRODUTO");
        lblValorPeloProduto.setBounds(10, 11, 143, 14);
        panel_2.add(lblValorPeloProduto);

        valorPeloProduto = new JLabel("0,00 MT");
        valorPeloProduto.setForeground(new Color(0, 0, 0));
        valorPeloProduto.setFont(new Font("Tahoma", Font.PLAIN, 26));
        valorPeloProduto.setBounds(10, 16, 242, 48);
        panel_2.add(valorPeloProduto);

        panel_3 = new JPanel();
        panel_3.setLayout(null);
        panel_3.setBackground(Color.DARK_GRAY);
        panel_3.setBounds(0, 520, 640, 44);
        contentPane.add(panel_3);

        btnVoltar = new JButton("Voltar");
        btnVoltar.addActionListener((ActionEvent e) -> {
            try {
                new EfectuarVendas().setVisible(false);
                PaginaPrincipal pp = new PaginaPrincipal();
                pp.setVisible(true);
                pp.setLocationRelativeTo(null);
            } catch (SQLException ex) {
                Logger.getLogger(EfectuarVendas.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        btnVoltar.setForeground(Color.LIGHT_GRAY);
        btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 13));
        btnVoltar.setBackground(Color.DARK_GRAY);
        btnVoltar.setBounds(10, 11, 79, 23);
        panel_3.add(btnVoltar);

        panel_4 = new JPanel();
        panel_4.setLayout(null);
        panel_4.setBackground(Color.DARK_GRAY);
        panel_4.setBounds(342, 332, 288, 184);
        contentPane.add(panel_4);

        lblTotsl = new JLabel("TOTAL:");
        lblTotsl.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblTotsl.setForeground(Color.WHITE);
        lblTotsl.setBounds(22, 22, 168, 14);
        panel_4.add(lblTotsl);

        precoTotal = new JLabel("0,00 MT");
        precoTotal.setForeground(new Color(255, 215, 0));
        precoTotal.setFont(new Font("Times New Roman", Font.BOLD, 39));
        precoTotal.setBounds(36, 70, 242, 48);
        panel_4.add(precoTotal);

        JLabel lblIvaAcrescido = new JLabel("IVA acrescido");
        lblIvaAcrescido.setBounds(203, 159, 75, 14);
        panel_4.add(lblIvaAcrescido);

        /////////////////////
        final String[] coluna = {"Nome", "Preco"};

        Object[][] dado = new Object[controller.controllerProduto.listar().size()][2];

        table_1 = new JTable(dado, coluna);
        table_1.setBounds(332, 100, 288, 213);
        contentPane.add(table_1);

        JScrollPane barra = new JScrollPane(table_1);
        barra.setBounds(332, 100, 288, 213);
        contentPane.add(barra);

        ///////////////
        List<Produto> listaS = new ArrayList();

        List<Double> total = new ArrayList();
         
        btnAdicionarProduto = new JButton("Adicionar Produto");
        btnAdicionarProduto.addActionListener((ActionEvent e) -> {
            String n1 = (String) produto.getSelectedItem();
            System.out.println(n1);
            
            String n2;
            
            
            
            double calculaProdutoActual = 0;
            
            String qt=qtd.getText();
            quantidade = Double.parseDouble(qt);
            double calcultotal = 0;
            try {
                Object[][] dado1 = new Object[controller.controllerProduto.listar().size()][3];
                for (int i = 0; i < controller.controllerProduto.listar().size(); i++) {
                    n2 = controller.controllerProduto.listar().get(i).getPreco();
                    id=controller.controllerProduto.listar().get(i).getCodigo();
                    somaStockQtd = Double.parseDouble(controller.controllerProduto.listar().get(i).getStock());
                    if (somaStockQtd>0) {
                        
                        
                        if (quantidade < somaStockQtd) {
                            
                            
                                listaS.add(controller.controllerProduto.listar().get(i));
                                calculaProdutoActual = quantidade * (Double.parseDouble(controller.controllerProduto.listar().get(i).getPreco()));
                                total.add(calculaProdutoActual);
                            
                            
                        } else {
                            
                            JOptionPane.showMessageDialog(null, "Nao ha stock suficiente",
                                    "", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
                for (int j = 0; j < listaS.size(); j++) {
                    n2 = controller.controllerProduto.listar().get(j).getPreco();
                    dado1[j][1] = listaS.get(j).getPreco() + "MT";
                    dado1[j][0] = listaS.get(j).getNomeProduto();
                }
                table_1 = new JTable(dado1, coluna);
                table_1.setBounds(332, 100, 288, 213);
                contentPane.add(table_1);
                JScrollPane barra1 = new JScrollPane(table_1);
                barra1.setBounds(332, 100, 288, 213);
                contentPane.add(barra1);
            }catch (SQLException | NumberFormatException | HeadlessException e2) {
                // TODO: handle exception
            }
            try {
                for (Produto listar : controller.controllerProduto.listar()) {
                    if (quantidade < 0) {
                        
                        JOptionPane.showMessageDialog(null, "A quantidade nao deve ser negativa",
                                "", JOptionPane.ERROR_MESSAGE);
                    }
                    break;
                }
            } catch (SQLException | HeadlessException e2) {
                // TODO: handle exception
            }
            
            for (Produto listaS1 : listaS) {
                calcultotal = calculaProdutoActual;
            }
            precoTotal.setText("" + calcultotal + " MT");
            valorPeloProduto.setText("" + calculaProdutoActual + " MT");
        });
        btnAdicionarProduto.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        btnAdicionarProduto.setBounds(104, 63, 157, 44);
        panel.add(btnAdicionarProduto);
        btnAdicionarProduto.setForeground(new Color(255, 215, 0));
        btnAdicionarProduto.setBackground(Color.WHITE);

        button_1 = new JButton("FINALIZAR COMPRA");
        button_1.addActionListener((ActionEvent e) -> {
            table_1 = new JTable();
            table_1.setBounds(332, 100, 288, 213);
            contentPane.add(table_1);
            JScrollPane barra1 = new JScrollPane(table_1);
            barra1.setBounds(332, 100, 288, 213);
            contentPane.add(barra1);
            qtd.setText(null);
            valorPeloProduto.setText("0,00 MT");
            precoTotal.setText("0,00 MT");
            listaS.clear();
            int qutDb=(int)(somaStockQtd-quantidade);
            try {
                controller.controllerVenda.editar(id, qutDb);
            } catch (SQLException ex) {
                Logger.getLogger(EfectuarVendas.class.getName()).log(Level.SEVERE, null, ex);
            }
            JOptionPane.showMessageDialog(null, "OBRIGADO PELA PREFERENCIA \n PROXIMO CLITENE",
                    "", JOptionPane.PLAIN_MESSAGE);
        });
        button_1.setForeground(new Color(255, 215, 0));
        button_1.setFont(new Font("Tahoma", Font.BOLD, 23));
        button_1.setBackground(Color.DARK_GRAY);
        button_1.setBounds(163, 11, 332, 22);
        panel_3.add(button_1);

    }

    public boolean checkLogin(String nome, String vNome) {
        return nome.equalsIgnoreCase(vNome) && vNome.equalsIgnoreCase(nome);
    }
}
