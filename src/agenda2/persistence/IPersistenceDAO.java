package agenda2.persistence;

import java.sql.ResultSet;

import agenda2.model.Contato;

public interface IPersistenceDAO {

	
	public void adicionarItem(Contato c);
	
	public ResultSet localizarItem(String email);
	
	public void atualizarItem(Contato c);
	
	public void deletarItem(Contato c);
	
}
