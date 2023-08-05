package view.Produto;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

public class ListarProduto extends JFrame {

    JTable table;
    private JPanel contentPane;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                ListarProduto pl = new ListarProduto();
                pl.setLocationRelativeTo(null);
                pl.setVisible(true);
            } catch (Exception e) {
            }
        });
    }

    public ListarProduto() throws SQLException {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 591, 436);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 255, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        controller.controllerProduto.listar();
        //cabecalho da tabela
        final String[] colunas = {"Armazem", "Nome", "Codigo", "Preco", "Stock", "Fornecedor"};

        Object[][] dados = new Object[controller.controllerProduto.listar().size()][7];
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
        barraRolagem.setBounds(10, 140, 555, 166);
        contentPane.add(barraRolagem);

		/////////////////
        JLabel lblListaDeTodos = new JLabel("Lista de todos os Produtos registados");
        lblListaDeTodos.setForeground(new Color(255, 215, 0));
        lblListaDeTodos.setBackground(new Color(255, 255, 255));
        lblListaDeTodos.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        lblListaDeTodos.setBounds(158, 17, 272, 37);
        contentPane.add(lblListaDeTodos);

        JSeparator separator = new JSeparator();
        separator.setForeground(new Color(210, 180, 140));
        separator.setBackground(new Color(255, 215, 0));
        separator.setBounds(22, 65, 543, 14);
        contentPane.add(separator);

       
        JButton btnPaginaPrincipal = new JButton("Voltar");
        btnPaginaPrincipal.addActionListener((ActionEvent e) -> {
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
        btnPaginaPrincipal.setBackground(new Color(255, 255, 255));
        btnPaginaPrincipal.setBounds(221, 340, 144, 23);
        contentPane.add(btnPaginaPrincipal);
    }

    public boolean checkLogin(String nome, String vNome) {
        return nome.equalsIgnoreCase(vNome) && vNome.equalsIgnoreCase(nome);
    }

}
