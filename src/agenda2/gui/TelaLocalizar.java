package agenda2.gui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import agenda2.persistence.ContatoDAO;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.BevelBorder;

public class TelaLocalizar extends JFrame {

	private JTextField textField;
	private JTable table;
	private ContatoDAO dao;
	private String[] columnNames = { "ID", "Nome", "Email", "Telefone" };
	private Object[][] dataTable = {};
	private DefaultTableModel tableModel = new DefaultTableModel(dataTable, columnNames);
	private JScrollPane scrollPane;
	
	public TelaLocalizar() {

		dao = new ContatoDAO();
		setSize(450, 400);
		getContentPane().setLayout(null);

		JLabel lblEmail = new JLabel("E-mail: ");
		lblEmail.setBounds(10, 29, 46, 14);
		getContentPane().add(lblEmail);

		textField = new JTextField();
		textField.setBounds(58, 26, 366, 20);
		getContentPane().add(textField);
		textField.setColumns(10);

		JPanel panel = new JPanel();
		panel.setBounds(10, 59, 414, 137);
		getContentPane().add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		

		scrollPane = new JScrollPane(table = new JTable(tableModel));
		scrollPane.setViewportBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

		panel.add(scrollPane);
		loadData();
		
		JButton btnLocalizar = new JButton("Localizar");
		btnLocalizar.setBounds(10, 227, 89, 23);
		btnLocalizar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				loadData();
			}
		});
		getContentPane().add(btnLocalizar);
	}

	public static DefaultTableModel buildTableModel(ResultSet rs) throws SQLException {

		ResultSetMetaData metaData = rs.getMetaData();

		// names of columns
		Vector<String> columnNames = new Vector<String>();
		int columnCount = metaData.getColumnCount();
		for (int column = 1; column <= columnCount; column++) {
			columnNames.add(metaData.getColumnName(column));
		}

		// data of the table
		Vector<Vector<Object>> data = new Vector<Vector<Object>>();
		while (rs.next()) {
			Vector<Object> vector = new Vector<Object>();
			for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
				vector.add(rs.getObject(columnIndex));
			}
			data.add(vector);
		}

		return new DefaultTableModel(data, columnNames);

	}
	
	private void loadData() {
        
        
            ResultSet rs = dao.localizarItem(textField.getText());
            ResultSetMetaData metaData;
			try {
				metaData = rs.getMetaData();
				// Names of columns
	            Vector<String> columnNames = new Vector<String>();
	            int columnCount = metaData.getColumnCount();
	            for (int i = 1; i <= columnCount; i++) {
	                columnNames.add(metaData.getColumnName(i));
	            }

	            // Data of the table
	            Vector<Vector<Object>> data = new Vector<Vector<Object>>();
	            while (rs.next()) {
	                Vector<Object> vector = new Vector<Object>();
	                for (int i = 1; i <= columnCount; i++) {
	                    vector.add(rs.getObject(i));
	                }
	                data.add(vector);
	            }
	            tableModel.setDataVector(data, columnNames);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

            

            
    }
}
