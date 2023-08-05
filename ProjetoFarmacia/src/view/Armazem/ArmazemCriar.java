package view.Armazem;

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
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import model.Armazem;

public class ArmazemCriar extends JFrame {

    private JPanel contentPane;
    private JTextField codigo;
    private JTextField nome;
    static ArmazemCriar ac = new ArmazemCriar();

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                ac.setLocationRelativeTo(null);
                ac.setVisible(true);
            } catch (Exception e) {
            }
        });
    }

    /**
     * Create the frame.
     */
    public ArmazemCriar() {
        setTitle("Adicionar Um Armazem");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 433, 352);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 255, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblCadastrarArmazem = new JLabel("Cadastrar Armazem");
        lblCadastrarArmazem.setForeground(new Color(255, 215, 0));
        lblCadastrarArmazem.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lblCadastrarArmazem.setBounds(130, 11, 173, 51);
        contentPane.add(lblCadastrarArmazem);

        JSeparator separator = new JSeparator();
        separator.setForeground(new Color(222, 184, 135));
        separator.setBounds(52, 57, 318, 10);
        contentPane.add(separator);

        JLabel lblNumeroDeTelefone = new JLabel("C\u00F3digo");
        lblNumeroDeTelefone.setForeground(new Color(0, 0, 0));
        lblNumeroDeTelefone.setBounds(72, 86, 116, 25);
        contentPane.add(lblNumeroDeTelefone);
        lblNumeroDeTelefone.setFont(new Font("Times New Roman", Font.PLAIN, 16));

        JLabel lblNumeroDoBi = new JLabel("Nome");
        lblNumeroDoBi.setForeground(new Color(0, 0, 0));
        lblNumeroDoBi.setBounds(72, 177, 109, 25);
        contentPane.add(lblNumeroDoBi);
        lblNumeroDoBi.setFont(new Font("Times New Roman", Font.PLAIN, 16));

        JButton btnLimpar = new JButton("Voltar");
        btnLimpar.addActionListener((ActionEvent e) -> {
            ac.setVisible(false);
            GerenciarArmazens gf = new GerenciarArmazens();
            gf.setLocationRelativeTo(null);
            gf.setVisible(true);
        });
        btnLimpar.setBackground(new Color(255, 215, 0));
        btnLimpar.setFont(new Font("Times New Roman", Font.PLAIN, 13));
        btnLimpar.setBounds(72, 264, 81, 23);
        contentPane.add(btnLimpar);

        JButton button = new JButton("Limpar");
        button.addActionListener((ActionEvent e) -> {
            nome.setText(null);
            codigo.setText(null);
        });
        button.setFont(new Font("Times New Roman", Font.PLAIN, 13));
        button.setBackground(new Color(255, 215, 0));
        button.setBounds(169, 264, 81, 23);
        contentPane.add(button);

        JButton btnAdicionar = new JButton("Criar");
        btnAdicionar.addActionListener((ActionEvent e) -> {
            Armazem armazem = new Armazem(codigo.getText(), nome.getText());
            
            codigo.setText("");
            nome.setText("");
            
            try {
                controller.controllerArmazem.Salvar(armazem);
            } catch (SQLException ex) {
                Logger.getLogger(ArmazemCriar.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        btnAdicionar.setFont(new Font("Times New Roman", Font.PLAIN, 13));
        btnAdicionar.setBackground(new Color(255, 215, 0));
        btnAdicionar.setBounds(261, 264, 81, 23);
        contentPane.add(btnAdicionar);

        codigo = new JTextField();
        codigo.setBounds(67, 112, 278, 34);
        contentPane.add(codigo);
        codigo.setColumns(10);

        nome = new JTextField();
        nome.setColumns(10);
        nome.setBounds(67, 201, 278, 34);
        contentPane.add(nome);
    }
}
