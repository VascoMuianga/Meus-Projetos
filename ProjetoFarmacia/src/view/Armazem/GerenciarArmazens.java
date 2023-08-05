package view.Armazem;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import view.run.PaginaPrincipal;

public class GerenciarArmazens extends JFrame {

    private JPanel contentPane;
    static GerenciarArmazens ga = new GerenciarArmazens();

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                ga.setLocationRelativeTo(null);
                ga.setVisible(true);
            } catch (Exception e) {
            }
        });
    }

    /**
     * Create the frame.
     */
    public GerenciarArmazens() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 572, 444);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton btnCriarCliente = new JButton("Criar Armazem");
        btnCriarCliente.addActionListener((ActionEvent e) -> {
            ArmazemCriar ac = new ArmazemCriar();
            ac.setLocationRelativeTo(null);
            ac.setVisible(true);
        });
        btnCriarCliente.setForeground(new Color(0, 0, 0));
        btnCriarCliente.setFont(new Font("SansSerif", Font.PLAIN, 17));
        btnCriarCliente.setBackground(new Color(255, 215, 0));
        btnCriarCliente.setBounds(143, 112, 254, 42);
        contentPane.add(btnCriarCliente);

        JButton btnEditarCliente = new JButton("Editar Armazem");
        btnEditarCliente.addActionListener((ActionEvent e) -> {
            ArmazemEditar ae;
            try {
                ae = new ArmazemEditar();
                ae.setLocationRelativeTo(null);
                ae.setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(GerenciarArmazens.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        btnEditarCliente.setForeground(new Color(0, 0, 0));
        btnEditarCliente.setFont(new Font("SansSerif", Font.PLAIN, 17));
        btnEditarCliente.setBackground(new Color(255, 215, 0));
        btnEditarCliente.setBounds(143, 218, 254, 42);
        contentPane.add(btnEditarCliente);

        JButton btnRemoverCliente = new JButton("Listar Armazem");
        btnRemoverCliente.addActionListener((ActionEvent e) -> {
            ArmazemListar al;
            try {
                al = new ArmazemListar();
                al.setLocationRelativeTo(null);
                al.setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(GerenciarArmazens.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        btnRemoverCliente.setForeground(new Color(0, 0, 0));
        btnRemoverCliente.setFont(new Font("SansSerif", Font.PLAIN, 17));
        btnRemoverCliente.setBackground(new Color(238, 232, 170));
        btnRemoverCliente.setBounds(143, 165, 254, 42);
        contentPane.add(btnRemoverCliente);

        JButton btnMenuPrincipal = new JButton("Menu Principal");
        btnMenuPrincipal.addActionListener((ActionEvent e) -> {
            PaginaPrincipal pp = new PaginaPrincipal();
            pp.setVisible(true);
            pp.setLocationRelativeTo(null);
        });
        btnMenuPrincipal.setForeground(new Color(0, 0, 0));
        btnMenuPrincipal.setFont(new Font("SansSerif", Font.PLAIN, 17));
        btnMenuPrincipal.setBackground(new Color(240, 230, 140));
        btnMenuPrincipal.setBounds(143, 271, 254, 42);
        contentPane.add(btnMenuPrincipal);

        Icon icone = new ImageIcon("C:\\Users\\V_Muianga\\Documents\\NetBeansProjects\\ProjetoFarmacia\\src\\img\\3.jpg");
        JLabel label = new JLabel(icone);
        label.setBounds(0, 0, 556, 406);
        contentPane.add(label);
    }

}
