package view.Fornecedor;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


public class FornecedorListar extends JFrame {

    private JPanel contentPane;
   
    JTable table;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                FornecedorListar fl = new FornecedorListar();
                fl.setLocationRelativeTo(null);
                fl.setVisible(true);
            } catch (Exception e) {
            }
        });
    }

    /**
     * Create the frame.
     * @throws java.sql.SQLException
     */
    public FornecedorListar() throws SQLException {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 591, 436);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 255, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

	controller.controllerFornecedor.listar();
		//cabecalho da tabela
	final String [] colunas={"Codigo","Nome","NUIT"};
		
         Object[][]dados= new Object[controller.controllerFornecedor.listar().size()][3];
         for (int i = 0; i < controller.controllerFornecedor.listar().size(); i++) {
         dados[i][0]=controller.controllerFornecedor.listar().get(i).getCodigo();
         dados[i][2]=controller.controllerFornecedor.listar().get(i).getNuit();
         dados[i][1]=controller.controllerFornecedor.listar().get(i).getNome();
         
         }
		
        table = new JTable(dados,colunas);
        table.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        table.setBounds(10, 24, 503, 57);
        contentPane.add(table);

        JScrollPane barraRolagem = new JScrollPane(table);
        barraRolagem.setBounds(10, 185, 555, 166);
        contentPane.add(barraRolagem);

		/////////////////
        JLabel lblListaDeTodos = new JLabel("Lista de todos os Fornecedores registados");
        lblListaDeTodos.setForeground(new Color(255, 215, 0));
        lblListaDeTodos.setBackground(new Color(255, 255, 255));
        lblListaDeTodos.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        lblListaDeTodos.setBounds(124, 17, 360, 37);
        contentPane.add(lblListaDeTodos);

        JSeparator separator = new JSeparator();
        separator.setForeground(new Color(210, 180, 140));
        separator.setBackground(new Color(255, 215, 0));
        separator.setBounds(22, 65, 543, 14);
        contentPane.add(separator);

        final JTextField nome = new JTextField();
        nome.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                nome.setText(null);
            }
        });
        
        JButton btnPaginaPrincipal = new JButton("Voltar");
        btnPaginaPrincipal.addActionListener((ActionEvent e) -> {
            try {
                new FornecedorListar().setVisible(false);
                GerenciarFornecedor gf = new GerenciarFornecedor();
                gf.setLocationRelativeTo(null);
                gf.setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(FornecedorListar.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        btnPaginaPrincipal.setBackground(new Color(255, 255, 255));
        btnPaginaPrincipal.setBounds(221, 362, 144, 23);
        contentPane.add(btnPaginaPrincipal);
    }

    public boolean checkLogin(String nome, String vNome) {
        return nome.equalsIgnoreCase(vNome) && vNome.equalsIgnoreCase(nome);
    }

}
