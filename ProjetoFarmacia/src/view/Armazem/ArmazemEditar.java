package view.Armazem;

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


public class ArmazemEditar extends JFrame {

    private static JPanel contentPane;

    /**
     * Launch the application.
     * @param args
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                ArmazemEditar ae = new ArmazemEditar();
                ae.setLocationRelativeTo(null);
                ae.setVisible(true);
            } catch (Exception e) {
            }
        });
    }
    JTable table;

    public ArmazemEditar() throws SQLException {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 591, 436);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 255, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        controller.controllerArmazem.listar();
        //cabecalho da tabela
        final String[] colunas = {"Codigo", "Nome"};

        final Object[][] dados = new Object[controller.controllerArmazem.listar().size()][2];
        for (int i = 0; i < controller.controllerArmazem.listar().size(); i++) {
            dados[i][0] = controller.controllerArmazem.listar().get(i).getCodigo();
            dados[i][1] = controller.controllerArmazem.listar().get(i).getNome();
        }
        table = new JTable(dados, colunas);
        table.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        table.setBounds(10, 24, 503, 57);
        contentPane.add(table);

        JScrollPane barraRolagem = new JScrollPane(table);
        barraRolagem.setBounds(10, 185, 555, 166);
        contentPane.add(barraRolagem);

        /////////////////
        JLabel lblListaDeTodos = new JLabel("Editar os Armazens");
        lblListaDeTodos.setForeground(new Color(255, 215, 0));
        lblListaDeTodos.setBackground(new Color(255, 255, 255));
        lblListaDeTodos.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        lblListaDeTodos.setBounds(199, 11, 272, 37);
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
        nome.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        nome.setText("Insira o nome");
        nome.setBounds(267, 119, 204, 20);
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
        codigo.setBounds(267, 89, 204, 20);
        contentPane.add(codigo);

        JButton btnbuscar = new JButton("Buscar");
        btnbuscar.addActionListener((ActionEvent e) -> {
            String n1 = codigo.getText();
            
            System.out.println(n1);
            String n2;
            
            try {
                for (int i = 0; i < controller.controllerArmazem.listar().size(); i++) {
                    // txtnome.setText(nome);
                    n2 = controller.controllerArmazem.listar().get(i).getNome();
                    System.out.println(n2);
                    if (n1.equals(controller.controllerArmazem.listar().get(i).getCodigo())) {
                        
                        
                        codigo.setText(n1);
                        nome.setText(n2);
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(ArmazemEditar.class.getName()).log(Level.SEVERE, null, ex);
            }
        } //public
        );
        btnbuscar.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        btnbuscar.setBackground(new Color(255, 215, 0));
        btnbuscar.setBounds(267, 150, 89, 23);
        contentPane.add(btnbuscar);

        

        JButton btnPaginaPrincipal = new JButton("Voltar");
        btnPaginaPrincipal.addActionListener((ActionEvent e) -> {
            //ae.setVisible(false);
            GerenciarArmazens ga = new GerenciarArmazens();
            ga.setLocationRelativeTo(null);
            ga.setVisible(true);
        });
        btnPaginaPrincipal.setBackground(new Color(255, 255, 255));
        btnPaginaPrincipal.setBounds(221, 362, 144, 23);
        contentPane.add(btnPaginaPrincipal);

        JButton remover = new JButton("Remover");
        remover.addActionListener((ActionEvent e) -> {
            String n1 = codigo.getText();
            try {
                for (int i = 0; i < controller.controllerArmazem.listar().size(); i++) {
                    if (n1.equals(controller.controllerArmazem.listar().get(i).getCodigo())) {
                        controller.controllerArmazem.deletar(n1);
                        ///////////////////////////////////////////////////////
                        Object[][] dados1 = new Object[controller.controllerArmazem.listar().size()][2];
                        for (int j = 0; j < controller.controllerArmazem.listar().size(); j++) {
                            dados1[j][0] = controller.controllerArmazem.listar().get(j).getCodigo();
                            dados1[j][1] = controller.controllerArmazem.listar().get(j).getNome();
                        }
                        table = new JTable(dados1, colunas);
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
        remover.setBounds(476, 88, 89, 23);
        contentPane.add(remover);

        JButton editar = new JButton("Editar");
        editar.addActionListener((ActionEvent e) -> {
            String n1 = codigo.getText();
            int n = Integer.parseInt(n1);
            String n2;
            n2 = nome.getText();
            try {
                for (int i = 0; i < controller.controllerArmazem.listar().size(); i++) {
                    if (n1.equals(controller.controllerArmazem.listar().get(i).getCodigo())) {
                        controller.controllerArmazem.editar(n, n1, n2);
                        ///////////////////////////////////////////////////////
                        Object[][] dados1 = new Object[controller.controllerArmazem.listar().size()][2];
                        for (int j = 0; j < controller.controllerArmazem.listar().size(); j++) {
                            dados1[j][0] = controller.controllerArmazem.listar().get(j).getCodigo();
                            dados1[j][1] = controller.controllerArmazem.listar().get(j).getNome();
                        }
                        table = new JTable(dados1, colunas);
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
        editar.setBounds(476, 118, 89, 23);
        contentPane.add(editar);
        ButtonGroup bg = new ButtonGroup();

    }

    public boolean checkLogin(String nome, String vNome) {
        return nome.equalsIgnoreCase(vNome) && vNome.equalsIgnoreCase(nome);
    }
}
