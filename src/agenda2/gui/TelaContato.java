package agenda2.gui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import agenda2.model.Contato;
import agenda2.persistence.ContatoDAO;
import agenda2.persistence.IPersistenceDAO;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class TelaContato extends JFrame{
	
	private JTextField txfNome;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel lblNome;
	private JLabel lblEmail;
	private JLabel lblTelefone;
	private JButton btnSalvar;
	private JButton btnFechar;
	private IPersistenceDAO dao;
	private JButton btnLocalizar;

	
	public TelaContato() {
		
		dao = new ContatoDAO();
		
		
		setSize(400, 310);
		setTitle("Minha Aplicação");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		lblNome = new JLabel("Nome: ");
		lblNome.setBounds(10, 36, 46, 14);
		getContentPane().add(lblNome);
		
		txfNome = new JTextField();
		txfNome.setBounds(59, 33, 315, 20);
		getContentPane().add(txfNome);
		txfNome.setColumns(10);
		
		lblEmail = new JLabel("E-mail:");
		lblEmail.setBounds(10, 90, 46, 14);
		getContentPane().add(lblEmail);
		
		textField = new JTextField();
		textField.setBounds(59, 87, 315, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(10, 149, 46, 14);
		getContentPane().add(lblTelefone);
		
		textField_1 = new JTextField();
		textField_1.setBounds(66, 146, 308, 20);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(10, 212, 89, 53);
		btnSalvar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dao.adicionarItem(new Contato(0, txfNome.getText(), textField.getText(), textField_1.getText()));
			}
		});
		
		getContentPane().add(btnSalvar);
		
		btnFechar = new JButton("Fechar");
		btnFechar.setBounds(285, 212, 89, 53);
		getContentPane().add(btnFechar);
		
		btnLocalizar = new JButton("Localizar");
		btnLocalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TelaLocalizar().setVisible(true);
			}
		});
		btnLocalizar.setBounds(109, 212, 89, 53);
		getContentPane().add(btnLocalizar);
		
		setVisible(true);
	}
}
