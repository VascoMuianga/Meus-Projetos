package view.Fornecedor;

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
import model.Fornecedor;



public class FornecedorCriar extends JFrame {

	private JPanel contentPane;
	private JTextField codigo;
	private JTextField Nome;
	private JTextField nuit;


	static FornecedorCriar fc = new FornecedorCriar();
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
                    try {
                        fc.setLocationRelativeTo(null);
                        fc.setVisible(true);
                    } catch (Exception e) {
                    }
                });
	}

	/**
	 * Create the frame.
	 */
	public FornecedorCriar() {
		setTitle("Adicionar Um Fornecedor");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 433, 352);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	
		
		JLabel lblCadastrarFornecedor = new JLabel("Cadastrar Fornecedor");
		lblCadastrarFornecedor.setForeground(new Color(255, 215, 0));
		lblCadastrarFornecedor.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblCadastrarFornecedor.setBounds(117, 11, 206, 51);
		contentPane.add(lblCadastrarFornecedor);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(222, 184, 135));
		separator.setBounds(52, 57, 318, 10);
		contentPane.add(separator);
		
		JLabel lblNumeroDeTelefone = new JLabel("C\u00F3digo");
		lblNumeroDeTelefone.setForeground(new Color(0, 0, 0));
		lblNumeroDeTelefone.setBounds(72, 83, 116, 25);
		contentPane.add(lblNumeroDeTelefone);
		lblNumeroDeTelefone.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
		JLabel lblMorada = new JLabel("Nuit");
		lblMorada.setForeground(new Color(0, 0, 0));
		lblMorada.setBounds(72, 197, 109, 25);
		contentPane.add(lblMorada);
		lblMorada.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
		JLabel lblNumeroDoBi = new JLabel("Nome");
		lblNumeroDoBi.setForeground(new Color(0, 0, 0));
		lblNumeroDoBi.setBounds(72, 141, 109, 25);
		contentPane.add(lblNumeroDoBi);
		lblNumeroDoBi.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
		JButton btnLimpar = new JButton("Voltar");
		btnLimpar.addActionListener((ActionEvent e) -> {
                    fc.setVisible(false);
                    GerenciarFornecedor gf = new GerenciarFornecedor();
                    gf.setLocationRelativeTo(null);
                    gf.setVisible(true);
                });
		btnLimpar.setBackground(new Color(255, 215, 0));
		btnLimpar.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnLimpar.setBounds(72, 264, 81, 23);
		contentPane.add(btnLimpar);
		
		codigo = new JTextField();
		codigo.setBounds(72, 105, 270, 25);
		contentPane.add(codigo);
		codigo.setColumns(10);
		
		Nome = new JTextField();
		Nome.setColumns(10);
		Nome.setBounds(72, 161, 270, 25);
		contentPane.add(Nome);
		
		nuit = new JTextField();
		nuit.setBounds(72, 216, 270, 25);
		contentPane.add(nuit);
		nuit.setColumns(10);
		
		JButton button = new JButton("Limpar");
		button.addActionListener((ActionEvent e) -> {
                    nuit.setText(null);
                    Nome.setText(null);
                    codigo.setText(null);
                });
		button.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		button.setBackground(new Color(255, 215, 0));
		button.setBounds(169, 264, 81, 23);
		contentPane.add(button);
		
		JButton btnAdicionar = new JButton("Criar");
		btnAdicionar.addActionListener((ActionEvent e) -> {
                    Fornecedor fornecedor =new Fornecedor(codigo.getText(), Nome.getText(), nuit.getText());
                    try {
                        controller.controllerFornecedor.Salvar(fornecedor);
                    } catch (SQLException ex) {
                        Logger.getLogger(FornecedorCriar.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    codigo.setText("");
                    Nome.setText("");
                    nuit.setText("");
                });
		btnAdicionar.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnAdicionar.setBackground(new Color(255, 215, 0));
		btnAdicionar.setBounds(261, 264, 81, 23);
		contentPane.add(btnAdicionar);
	}

}
