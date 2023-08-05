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
import view.Armazem.GerenciarArmazens;

//import gerenciarFornecedores.ControlaFornecedor;
//import gerenciarFornecedores.Fornecedores;
public class FornecedorEditar extends JFrame {

    private JPanel contentPane;
    JTable table;
    

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                FornecedorEditar fe = new FornecedorEditar();
                fe.setLocationRelativeTo(null);
                fe.setVisible(true);
            } catch (Exception e) {
            }
        });
    }

    /**
     * Create the frame.
     * @throws java.sql.SQLException
     */
    public FornecedorEditar() throws SQLException {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 591, 448);
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
        barraRolagem.setBounds(10, 213, 555, 166);
        contentPane.add(barraRolagem);

		/////////////////
        JLabel lblListaDeTodos = new JLabel("Editar os Fornecedoes");
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
        nome.setBounds(239, 95, 204, 23);
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
        codigo.setBounds(327, 67, 116, 23);
        contentPane.add(codigo);

        

        JButton btnPaginaPrincipal = new JButton("Voltar");
        btnPaginaPrincipal.addActionListener((ActionEvent e) -> {
            FornecedorEditar fe;
            try {
                fe = new FornecedorEditar();
                fe.setVisible(false);
                GerenciarArmazens ga = new GerenciarArmazens();
                ga.setLocationRelativeTo(null);
                ga.setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(FornecedorEditar.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        btnPaginaPrincipal.setBackground(new Color(255, 255, 255));
        btnPaginaPrincipal.setBounds(218, 387, 144, 23);
        contentPane.add(btnPaginaPrincipal);

        JButton remover = new JButton("Remover");
        remover.addActionListener((ActionEvent e) -> {
            String n1 = codigo.getText();
            try {
                for (int i = 0; i < controller.controllerFornecedor.listar().size(); i++) {
                    
                    if (n1.equals(controller.controllerFornecedor.listar().get(i).getCodigo())) {
                        
                        controller.controllerFornecedor.deletar(n1);
                        ///////////////////////////////////////////////////////
                        
                        
                    }
                }
                Object[][] dados1 = new Object[controller.controllerFornecedor.listar().size()][3];
                for (int j = 0; j < controller.controllerFornecedor.listar().size(); j++) {
                    dados1[j][0] = controller.controllerFornecedor.listar().get(j).getCodigo();
                    dados1[j][2] = controller.controllerFornecedor.listar().get(j).getNuit();
                    dados1[j][1] = controller.controllerFornecedor.listar().get(j).getNome();
                }
                table = new JTable(dados1, colunas);
                table.setFont(new Font("Times New Roman", Font.PLAIN, 14));
                table.setBounds(10, 24, 503, 57);
                contentPane.add(table);
                JScrollPane barraRolagem1 = new JScrollPane(table);
                barraRolagem1.setBounds(10, 185, 555, 166);
                contentPane.add(barraRolagem1);
            }catch (Exception e2) {
                // TODO: handle exception
                }
        });
        remover.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        remover.setBackground(new Color(255, 215, 0));
        remover.setBounds(453, 67, 100, 23);
        contentPane.add(remover);
        ////////////////////////////
        
        
        final JTextField nuit = new JTextField();
        nuit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                nuit.setText(null);
            }
        });
        nuit.setText("Insira o nuit");
        nuit.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        nuit.setColumns(10);
        nuit.setBounds(239, 125, 204, 23);
        contentPane.add(nuit);
        
        JButton editar = new JButton("Editar");
        editar.addActionListener((ActionEvent e) -> {
            String n1 = codigo.getText();
            String n2 ,n3;
            n2 = nome.getText();
            n3=nuit.getText();
            try {
                for (int i = 0; i < controller.controllerFornecedor.listar().size(); i++) {
                    if (n1.equals(controller.controllerFornecedor.listar().get(i).getCodigo())) {
                        controller.controllerFornecedor.editar(n1, n2, n3);
                        ///////////////////////////////////////////////////////
                        final String[] colunas1 = {"Codigo","Nome","NUIT"};
                        Object[][] dados1 = new Object[controller.controllerFornecedor.listar().size()][3];
                        for (int j = 0; j < controller.controllerFornecedor.listar().size(); j++) {
                            dados1[j][0] = controller.controllerFornecedor.listar().get(j).getCodigo();
                            dados1[j][2] = controller.controllerFornecedor.listar().get(j).getNuit();
                            dados1[j][1] = controller.controllerFornecedor.listar().get(j).getNome();
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

        

        editar.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        editar.setBackground(new Color(255, 215, 0));
        editar.setBounds(453, 123, 100, 23);
        contentPane.add(editar);

        

        JButton btnLimpar = new JButton("Buscar");
        btnLimpar.addActionListener((ActionEvent e) -> {
            String n1 = codigo.getText();
            String n2,n3;
            try {
                for (int i = 0; i < controller.controllerFornecedor.listar().size(); i++) {
                    // txtnome.setText(nome);
                    n2 = controller.controllerFornecedor.listar().get(i).getNome();
                    n3 = controller.controllerFornecedor.listar().get(i).getNuit();
                    if (n1.equals(controller.controllerFornecedor.listar().get(i).getCodigo())) {
                        
                        
                        codigo.setText(n1);
                        nome.setText(n2);
                        nuit.setText(n3);
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(FornecedorEditar.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        btnLimpar.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        btnLimpar.setBackground(new Color(255, 215, 0));
        btnLimpar.setBounds(453, 152, 100, 23);
        contentPane.add(btnLimpar);

        
        
        //btnLimpar.setEnabled(false);
        ButtonGroup bg = new ButtonGroup();

        //
    }

    public boolean checkLogin(String nome, String vNome) {
        return nome.equalsIgnoreCase(vNome) && vNome.equalsIgnoreCase(nome);
    }
}
