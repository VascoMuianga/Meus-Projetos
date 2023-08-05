package view.Produto;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class EditarProduto extends JFrame {

    private JPanel contentPane;

    /**
     * Launch the application.
     * @param args
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                EditarProduto pr = new EditarProduto();
                pr.setLocationRelativeTo(null);
                pr.setVisible(true);
            } catch (Exception e) {
            }
        });
    }

    JTable table;

    public EditarProduto() throws SQLException {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 591, 468);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 255, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        controller.controllerProduto.listar();
        //cabecalho da tabela
        final String[] colunas = {"Armazem", "Nome", "Codigo", "Preco", "Stock", "Fornecedor"};

        Object[][] dados = new Object[controller.controllerProduto.listar().size()][6];
        for (int i = 0; i < controller.controllerProduto.listar().size(); i++) {
            dados[i][5] = controller.controllerProduto.listar().get(i).getFornecedor();
            dados[i][3] = controller.controllerProduto.listar().get(i).getPreco() + "MT";
            dados[i][1] = controller.controllerProduto.listar().get(i).getNomeProduto();
            
            dados[i][4] = controller.controllerProduto.listar().get(i).getStock();
            dados[i][2] = controller.controllerProduto.listar().get(i).getCodigo();
            dados[i][0] = controller.controllerProduto.listar().get(i).getArmazem();

        }

        table = new JTable(dados, colunas);
        table.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        table.setBounds(10, 24, 503, 57);
        contentPane.add(table);

        JScrollPane barraRolagem = new JScrollPane(table);
        barraRolagem.setBounds(10, 185, 555, 166);
        contentPane.add(barraRolagem);

        /////////////////
        JLabel lblListaDeTodos = new JLabel("Editar  Produto");
        lblListaDeTodos.setForeground(new Color(255, 215, 0));
        lblListaDeTodos.setBackground(new Color(255, 255, 255));
        lblListaDeTodos.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        lblListaDeTodos.setBounds(199, 0, 272, 26);
        contentPane.add(lblListaDeTodos);

        JSeparator separator = new JSeparator();
        separator.setForeground(new Color(210, 180, 140));
        separator.setBackground(new Color(255, 215, 0));
        separator.setBounds(22, 29, 543, 14);
        contentPane.add(separator);

        final JTextField nome = new JTextField();
        nome.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                nome.setText(null);
            }
        });
        nome.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        nome.setText("Insira o nome");
        nome.setBounds(239, 65, 204, 23);
        contentPane.add(nome);
        nome.setColumns(10);

        final JTextField codigo = new JTextField();
        codigo.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                codigo.setText(null);
            }
        });
        codigo.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        codigo.setText("Insira o codigo");
        codigo.setColumns(10);
        codigo.setBounds(327, 37, 116, 23);
        contentPane.add(codigo);

        

        JButton btnPaginaPrincipal = new JButton("Voltar");
        btnPaginaPrincipal.addActionListener((ActionEvent e) -> {
            EditarProduto pr;
            try {
                pr = new EditarProduto();
                pr.setVisible(false);
                GerenciarProduto ga = new GerenciarProduto();
                ga.setLocationRelativeTo(null);
                ga.setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(EditarProduto.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        btnPaginaPrincipal.setBackground(new Color(255, 255, 255));
        btnPaginaPrincipal.setBounds(225, 300, 144, 23);
        contentPane.add(btnPaginaPrincipal);

        JButton remover = new JButton("Remover");
        remover.addActionListener((ActionEvent e) -> {
            String n1 = codigo.getText();
            try {
                for (int i = 0; i < controller.controllerProduto.listar().size(); i++) {
                    if (n1.equals(controller.controllerProduto.listar().get(i).getCodigo())) {
                        controller.controllerProduto.deletar(n1);
                        ///////////////////////////////////////////////////////
                        final String[] colunas1 = {"Armazem", "Nome", "Codigo", "Preco", "Stock", "Fornecedor"};
                        Object[][] dados1 = new Object[controller.controllerProduto.listar().size()][6];
                        for (int j = 0; j < controller.controllerProduto.listar().size(); j++) {
                            dados1[i][5] = controller.controllerProduto.listar().get(j).getFornecedor();
                            dados1[i][3] = controller.controllerProduto.listar().get(j).getPreco() + "MT";
                            dados1[i][1] = controller.controllerProduto.listar().get(j).getNomeProduto();
                            
                            dados1[i][4] = controller.controllerProduto.listar().get(j).getStock();
                            dados1[i][2] = controller.controllerProduto.listar().get(j).getCodigo();
                            dados1[i][0] = controller.controllerProduto.listar().get(j).getArmazem();
                        }
                        table = new JTable(dados1, colunas1);
                        table.setFont(new Font("Times New Roman", Font.PLAIN, 14));
                        table.setBounds(10, 24, 503, 57);
                        contentPane.add(table);
                        JScrollPane barraRolagem1 = new JScrollPane(table);
                        barraRolagem1.setBounds(10, 185, 555, 166);
                        contentPane.add(barraRolagem1);
                    }
                }
            }catch (Exception e2) {
                // TODO: handle exception
            }
        });
        remover.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        remover.setBackground(new Color(255, 215, 0));
        remover.setBounds(453, 60, 100, 23);
        contentPane.add(remover);
        ////////////////////////////
        
        final JTextField quantidade;

        

        final JTextField stock = new JTextField();
        stock.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                stock.setText(null);
            }
        });
        stock.setText("Insira Insira a quantidade em stock");
        stock.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        stock.setColumns(10);
        stock.setBounds(239, 153, 204, 23);
        contentPane.add(stock);

        
        final JTextField preco = new JTextField();
        preco.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                preco.setText(null);
            }
        });
        preco.setText("Insira o pre\u00E7o");
        preco.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        preco.setColumns(10);
        preco.setBounds(239, 123, 204, 23);
        contentPane.add(preco);

        JButton btnLimpar = new JButton("Busca");
        btnLimpar.addActionListener((ActionEvent e) -> {
            String n1 = codigo.getText();
            String n2, n3, n4, n5, n6, n7;
            try {
                for (int i = 0; i < controller.controllerProduto.listar().size(); i++) {
                    // txtnome.setText(nome);
                    n2 = controller.controllerProduto.listar().get(i).getNomeProduto();
                    n3 = controller.controllerProduto.listar().get(i).getPreco();
                   
                    n5 = controller.controllerProduto.listar().get(i).getStock();
                    n6 = controller.controllerProduto.listar().get(i).getArmazem();
                    n7 = controller.controllerProduto.listar().get(i).getFornecedor();
                    
                    if (n1.equals(controller.controllerProduto.listar().get(i).getCodigo())) {
                        
                        codigo.setText(n1);
                        nome.setText(n2);
                        preco.setText(n3);
                        
                        stock.setText(n5);
                        
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(EditarProduto.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        btnLimpar.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        btnLimpar.setBackground(new Color(255, 215, 0));
        btnLimpar.setBounds(453, 150, 100, 23);
        contentPane.add(btnLimpar);

        JButton btnEditar = new JButton("Editar");
        btnEditar.addActionListener((ActionEvent e) -> {
            String n1 = codigo.getText();
            String n2= nome.getText();
            String n3=preco.getText();
            
            String n5=stock.getText();
            try {
                for (int i = 0; i < controller.controllerProduto.listar().size(); i++) {
                    if (n1.equals(controller.controllerProduto.listar().get(i).getCodigo())) {
                        controller.controllerProduto.editar(n1, n2, n3, n5);
                        final String[] colunas1 = {"Armazem", "Nome", "Codigo", "Preco", "Stock", "Fornecedor"};
                        Object[][] dados1 = new Object[controller.controllerProduto.listar().size()][6];
                        for (int j = 0; j < controller.controllerProduto.listar().size(); j++) {
                            dados1[i][5] = controller.controllerProduto.listar().get(j).getFornecedor();
                            dados1[i][3] = controller.controllerProduto.listar().get(j).getPreco() + "MT";
                            dados1[i][1] = controller.controllerProduto.listar().get(j).getNomeProduto();
                            
                            dados1[i][4] = controller.controllerProduto.listar().get(j).getStock();
                            dados1[i][2] = controller.controllerProduto.listar().get(j).getCodigo();
                            dados1[i][0] = controller.controllerProduto.listar().get(j).getArmazem();
                        }
                        table = new JTable(dados1, colunas1);
                        table.setFont(new Font("Times New Roman", Font.PLAIN, 14));
                        table.setBounds(10, 24, 503, 57);
                        contentPane.add(table);
                        JScrollPane barraRolagem1 = new JScrollPane(table);
                        barraRolagem1.setBounds(10, 185, 500, 166);
                        contentPane.add(barraRolagem1);
                    }
                }
            }catch (SQLException ex) {
                Logger.getLogger(EditarProduto.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        btnEditar.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        btnEditar.setBackground(new Color(255, 215, 0));
        btnEditar.setBounds(453, 105, 100, 23);
        contentPane.add(btnEditar);

        //btnLimpar.setEnabled(false);
        ButtonGroup bg = new ButtonGroup();

       JButton btnPaginaPrincipa = new JButton("Voltar");
        btnPaginaPrincipa.addActionListener((ActionEvent e) -> {
            ListarProduto pl;
            try {
                pl = new ListarProduto();
                pl.setVisible(false);
                GerenciarProduto ga = new GerenciarProduto();
                ga.setLocationRelativeTo(null);
                ga.setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(ListarProduto.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        btnPaginaPrincipa.setBackground(new Color(255, 255, 255));
        btnPaginaPrincipa.setBounds(221, 380, 144, 23);
        contentPane.add(btnPaginaPrincipa);
    }

    public boolean checkLogin(String nome, String vNome) {
        return nome.equalsIgnoreCase(vNome) && vNome.equalsIgnoreCase(nome);
    }
}
