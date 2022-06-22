package agenda2.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import agenda2.model.Contato;

public class ContatoDAO implements IPersistenceDAO{

	IConnection conexao;
	
	public ContatoDAO() {
		conexao = new MySQLDatabaseConnection(); 
	}
	
	@Override
	public void adicionarItem(Contato c) {
		// TODO Auto-generated method stub
		Connection conn = conexao.getConnection();
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement("INSERT INTO AGENDA2.CONTATO VALUES (?, ?, ?, ?);");
			ps.setInt(1, 0);
			ps.setString(2, c.getNome());
			ps.setString(3, c.getEmail());
			ps.setString(4, c.getTelefone());
			ps.execute();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public ResultSet localizarItem(String email) {
		// TODO Auto-generated method stub
		Connection conn = conexao.getConnection();
		PreparedStatement ps;
		ResultSet consulta;
		try {
			ps = conn.prepareStatement("SELECT * FROM CONTATO WHERE EMALI LIKE ?;");
			ps.setString(1, email);
			consulta = ps.executeQuery();
			return consulta;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void atualizarItem(Contato c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletarItem(Contato c) {
		// TODO Auto-generated method stub
		
	}

}
