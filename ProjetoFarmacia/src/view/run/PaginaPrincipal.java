package view.run;

import java.awt.EventQueue;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import view.OutrasTelas.EfectuarVendas;
import view.OutrasTelas.StockMinimo;

public class PaginaPrincipal extends JFrame {

	private JPanel contentPane;
	static PaginaPrincipal pp = new PaginaPrincipal();
        //aqui
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
                    try {
                        
                        pp.setVisible(true);
                        pp.setLocationRelativeTo(null);
                    } catch (Exception e) {
                    }
                });
	}
//ate aqui
	/**
	 * Create the frame (vasco).
         * 
         * 
         * 
         * 
         * public class Biblioteca{
         * 
         * private Livro livro;
         *  
         * 
         * public Biblioteca(){}
         * 
         * public Biblioteca( Livro livro){
         * 
         *      Livro livro=l;
         * 
         * }
         * }
	 */
	public PaginaPrincipal() {
            
		setTitle("Main Menu");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 572, 444);
		contentPane = new JPanel();
		Icon icone=new ImageIcon("C:\\Users\\V_Muianga\\Documents\\NetBeansProjects\\ProjetoFarmacia\\src\\img\\3.jpg");
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnGerenciarClientes = new JButton("Efecturar Vendas");
		btnGerenciarClientes.addActionListener((ActionEvent e) -> {
                    EfectuarVendas ev;
                    try {
                        ev = new EfectuarVendas();
                        ev.setLocationRelativeTo(null);
                        pp.setVisible(false);
                        ev.setVisible(true);
                    } catch (SQLException ex) {
                        Logger.getLogger(PaginaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                });
		btnGerenciarClientes.setBackground(new Color(240, 230, 140));
		btnGerenciarClientes.setFont(new Font("SansSerif", Font.PLAIN, 17));
		btnGerenciarClientes.setBounds(149, 30, 254, 42);
		contentPane.add(btnGerenciarClientes);
		
                
		JButton btnGerenciarProdutos = new JButton("Gerenciar Produtos");
		btnGerenciarProdutos.addActionListener((ActionEvent e) -> {
                    view.Produto.GerenciarProduto gp = new view.Produto.GerenciarProduto();
                    gp.setLocationRelativeTo(null);
                    pp.setVisible(false);
                    gp.setVisible(true);
                });
		btnGerenciarProdutos.setBackground(new Color(240, 230, 140));
		btnGerenciarProdutos.setFont(new Font("SansSerif", Font.PLAIN, 17));
		btnGerenciarProdutos.setBounds(149, 95, 254, 42);
		contentPane.add(btnGerenciarProdutos);
		
		JButton btnGerenciarArmazns = new JButton("Gerenciar Armazem");
		btnGerenciarArmazns.addActionListener((ActionEvent e) -> {
                    view.Armazem.GerenciarArmazens ga = new view.Armazem.GerenciarArmazens();
                    ga.setLocationRelativeTo(null);
                    pp.setVisible(false);
                    ga.setVisible(true);
                });
		btnGerenciarArmazns.setBackground(new Color(255, 215, 0));
		btnGerenciarArmazns.setFont(new Font("SansSerif", Font.PLAIN, 17));
		btnGerenciarArmazns.setBounds(149, 150, 254, 42);
		contentPane.add(btnGerenciarArmazns);
		
		JButton btnGerenciarForenecedores = new JButton("Gerenciar Forenecedores");
		btnGerenciarForenecedores.addActionListener((ActionEvent e) -> {
                    view.Fornecedor.GerenciarFornecedor gf = new view.Fornecedor.GerenciarFornecedor();
                    gf.setLocationRelativeTo(null);
                    pp.setVisible(false);
                    gf.setVisible(true);
                });
		btnGerenciarForenecedores.setBackground(new Color(240, 230, 140));
		btnGerenciarForenecedores.setFont(new Font("SansSerif", Font.PLAIN, 17));
		btnGerenciarForenecedores.setBounds(149, 205, 254, 42);
		contentPane.add(btnGerenciarForenecedores);
		
		
		JButton btnFiltroFdrStock = new JButton("stock ");
		btnFiltroFdrStock.addActionListener((ActionEvent e) -> {
                    StockMinimo sm;
                    try {
                        sm = new StockMinimo();
                        pp.setVisible(false);
                        sm.setLocationRelativeTo(null);
                        sm.setVisible(true);
                    } catch (SQLException ex) {
                        Logger.getLogger(PaginaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                });
		btnFiltroFdrStock.setFont(new Font("SansSerif", Font.PLAIN, 17));
		btnFiltroFdrStock.setBackground(new Color(255, 215, 0));
		btnFiltroFdrStock.setBounds(149, 255, 254, 40);
		contentPane.add(btnFiltroFdrStock);

		Date data=new Date();
		JLabel lblNewLabel = new JLabel(""+data);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setForeground(Color.black);
		lblNewLabel.setBounds(10, 350, 188, 25);
		contentPane.add(lblNewLabel);

		JLabel label = new JLabel(icone);
		label.setBounds(0, 0, 556, 406);
		contentPane.add(label);
		
		
	}
}
