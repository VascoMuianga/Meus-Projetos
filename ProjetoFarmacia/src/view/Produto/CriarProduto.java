/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.Produto;

import controller.controllerArmazem;
import controller.controllerFornecedor;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import model.Armazem;
import model.Fornecedor;
import model.Produto;

/**
 *
 * @author V_Muianga
 */
public class CriarProduto extends JFrame {
    
    private JPanel contentPane;
	//ControlaProdutos cp = new ControlaProdutos();
	private JTextField codigo;
	private JTextField nomeDoProduto;
	private JTextField PrecoUnitario;
	
	private JTextField stock;
	
	//static ProdutoCriar pc = new ProdutoCriar();
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
                    try {
                        CriarProduto pc = new CriarProduto();
                        pc.setLocationRelativeTo(null);
                        pc.setVisible(true);
                    } catch (Exception e) {
                    }
                });
	}

	
	public CriarProduto() throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 433, 352);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 417, 314);
		contentPane.add(panel);
		
		JLabel lblCadastrarProduto = new JLabel("Cadastrar Produto");
		lblCadastrarProduto.setForeground(new Color(255, 215, 0));
		lblCadastrarProduto.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblCadastrarProduto.setBounds(132, 0, 173, 51);
		panel.add(lblCadastrarProduto);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(222, 184, 135));
		separator.setBounds(10, 51, 397, 10);
		panel.add(separator);
		
		JLabel lblCdigo = new JLabel("C\u00F3digo:");
		lblCdigo.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblCdigo.setBounds(44, 62, 109, 25);
		panel.add(lblCdigo);
		
		codigo = new JTextField();
		codigo.setColumns(10);
		codigo.setBounds(163, 65, 207, 20);
		panel.add(codigo);
		
		JLabel lblPreoUnitrio = new JLabel("Pre\u00E7o unit\u00E1rio:");
		lblPreoUnitrio.setForeground(Color.BLACK);
		lblPreoUnitrio.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblPreoUnitrio.setBounds(44, 111, 116, 25);
		panel.add(lblPreoUnitrio);
		
		
		
		JLabel lblNomeDoProduto = new JLabel("Nome do produto:");
		lblNomeDoProduto.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNomeDoProduto.setBounds(44, 84, 109, 25);
		panel.add(lblNomeDoProduto);
		
		JLabel lblStock = new JLabel("Stock(Quantidade):");
		lblStock.setForeground(Color.BLACK);
		lblStock.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblStock.setBounds(44, 159, 109, 25);
		panel.add(lblStock);
		
		nomeDoProduto = new JTextField();
		nomeDoProduto.setColumns(10);
		nomeDoProduto.setBounds(163, 89, 207, 20);
		panel.add(nomeDoProduto);
		
		PrecoUnitario = new JTextField();
		PrecoUnitario.setColumns(10);
		PrecoUnitario.setBounds(163, 114, 207, 20);
		panel.add(PrecoUnitario);
		
		
		
		stock = new JTextField();
		stock.setColumns(10);
		stock.setBounds(163, 162, 207, 20);
		panel.add(stock);
		
		JButton button_2 = new JButton("Voltar");
		button_2.addActionListener((ActionEvent e) -> {
                    GerenciarProduto gp = new GerenciarProduto();
                    gp.setLocationRelativeTo(null);
                    //pc.setVisible(false);
                    gp.setVisible(true);
                });
		button_2.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		button_2.setBackground(new Color(255, 215, 0));
		button_2.setBounds(271, 269, 98, 23);
		panel.add(button_2);
		
		JLabel lblArmazem = new JLabel("Armazem:");
		lblArmazem.setForeground(Color.BLACK);
		lblArmazem.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblArmazem.setBounds(44, 185, 109, 25);
		panel.add(lblArmazem);
		
		JLabel lblFornecedor = new JLabel("Fornecedor:");
		lblFornecedor.setForeground(Color.BLACK);
		lblFornecedor.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblFornecedor.setBounds(44, 215, 109, 25);
		panel.add(lblFornecedor);
		
		final JComboBox armazenar = new JComboBox();
		armazenar.setModel(new DefaultComboBoxModel(new String[] {"Seleccione um armaz\u00E9m"}));
		armazenar.setBackground(Color.WHITE);
		armazenar.setBounds(163, 185, 207, 25);
		panel.add(armazenar);
		
		final JComboBox fornecedor = new JComboBox();
		fornecedor.setModel(new DefaultComboBoxModel(new String[] {"Selecione Um Fornecedor"}));
		fornecedor.setBounds(163, 215, 207, 25);
		panel.add(fornecedor);
		
		//Preecher os 2 comboBox
                controller.controllerArmazem arm=new controllerArmazem();
                
                controller.controllerFornecedor forne = new controllerFornecedor();
		for (Armazem ar:controllerArmazem.listar()) {
			armazenar.addItem(ar.toString2());
                        
		}
		for (Fornecedor f:controllerFornecedor.listar()) {
			fornecedor.addItem(f.toString2());
		}
		
		
		JButton button = new JButton("Limpar");
		button.addActionListener((ActionEvent e) -> {
                    codigo.setText(null);
                    nomeDoProduto.setText(null);
                    PrecoUnitario.setText(null);
                    
                    stock.setText(null);
                });
		button.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		button.setBackground(new Color(255, 215, 0));
		button.setBounds(44, 269, 98, 23);
		panel.add(button);
		
		JButton button_1 = new JButton("Gravar");
		button_1.addActionListener((ActionEvent e) -> {
                    Produto  produto = new Produto (codigo.getText(),
                            nomeDoProduto.getText(),
                            PrecoUnitario.getText(),
                            
                            stock.getText(),
                            (String)armazenar.getSelectedItem(),
                            (String)fornecedor.getSelectedItem());
                    
                    try {
                        
                        controller.controllerProduto.Salvar(produto);
                    } catch (SQLException ex) {
                        Logger.getLogger(CriarProduto.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    codigo.setText(null);
                    nomeDoProduto.setText(null);
                    PrecoUnitario.setText(null);
                    
                    stock.setText(null);
                });
		button_1.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		button_1.setBackground(new Color(255, 215, 0));
		button_1.setBounds(152, 269, 109, 23);
		panel.add(button_1);
	}
}
