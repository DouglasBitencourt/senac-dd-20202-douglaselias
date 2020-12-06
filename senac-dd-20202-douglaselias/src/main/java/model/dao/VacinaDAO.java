package model.dao;



import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.vo.VacinaVO;



public class VacinaDAO {
	private static final int _ESTAGIO_INICIAL 			= 1;
	private static final int __ESTAGIO_TESTE 				= 2;
	private static final int _STAGE_MASS_APPLICATION 	= 3;
	private static final String _QUERY 	= "SELECT vac.id as id, vac.country as country, stg.name as stage, vac.search_start_date as start_date, per.name as researcher "
										+ "FROM vacinas as vac "
										+ "INNER JOIN stages as stg on stg.id = vac.stage_id "
										+ "INNER JOIN researchers as res on res.id = vac.researcher_id "
										+ "INNER JOIN person as per on per.id = res.person_id ";
	

	public VacinaVO salvar(VacinaVO vacina) {
		Connection conn 		= Banco.getConnection();		
		String sql 				= "INSERT INTO vaccines (pais, estagio_id, dtinicio, pesquisador_id) " 
								+ "VALUES (?,?,?,?) ";	
		PreparedStatement query = Banco.getPreparedStatementWithGeneratedKeys(conn, sql);
		
		try {
			query.setString(1, vacina.getPais());
			query.setString(2, vacina.getEstagio());
			Date dtInicio = java.sql.Date.valueOf(vacina.getDtInicio());
			query.setDate(3, dtInicio);
			query.setString(4, vacina.getPesquisador().getNome());
			
			int codeReturn = query.executeUpdate();
			
			if(codeReturn == Banco.CODE_RETURN_SUCCESS) {
				ResultSet rs 	= query.getGeneratedKeys();
				int keyGenerate = rs.getInt(1);
				
				vacina.setId(keyGenerate);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao inserir vacina.\nCausa: " + e.getMessage());
		} finally {
			Banco.closeStatement(query);
			Banco.closeConnection(conn);
		}
		
		return vacina;
	}
	
	public boolean atualizar(VacinaVO vacina) {
		String sql 				= "UPDATE vacinas "
								+ "SET pais=?, estagio_id=?, dtinicio=?, pesquisador_id=? " 
								+ "WHERE ID=? ";
		Connection conn 		= Banco.getConnection();
		PreparedStatement query = Banco.getPreparedStatement(conn, sql);	
		boolean changed 		= false;
		
		try {
			query.setString(1, vacina.getPais());
			query.setString(2, vacina.getEstagio());
			Date dtInicio = java.sql.Date.valueOf(vacina.getDtInicio());
			query.setDate(3, dtInicio);
			query.setString(4, vacina.getPesquisador().getNome());
			query.setInt(5, vacina.getId());
			
			int codeReturn 	= query.executeUpdate();
			changed 		= (codeReturn == Banco.CODE_RETURN_SUCCESS);
		} catch (SQLException e) {
			System.out.println("Erro ao alterar vacina.\nCausa: " + e.getMessage());
		} finally {
			Banco.closeStatement(query);
			Banco.closeConnection(conn);
		}
		
		return changed;
	}
	
	public boolean delete(int idvacina) {
		Connection conn 		= Banco.getConnection();
		String sql 				= "DELETE FROM vaccines WHERE id=? ";		
		PreparedStatement query = Banco.getPreparedStatement(conn, sql);
		boolean excluido 		= false;
		
		try {
			query.setInt(1, idvacina);
			
			int codeReturn 	= query.executeUpdate();
			excluido 		= (codeReturn == Banco.CODE_RETURN_SUCCESS);
		} catch (SQLException e) {
			System.out.println("Erro ao excluir vacina (id: " + idvacina + ") .\nCausa: " + e.getMessage());
		}finally {
			Banco.closeStatement(query);
			Banco.closeConnection(conn);
		}
		
		return excluido;
	}
	
	public VacinaVO show(int id) {
		String sql						= VacinaDAO._QUERY + " WHERE vac.id = ?";
		VacinaVO vacina		 		= null;
		Connection conn 				= Banco.getConnection();
		PreparedStatement query 		= Banco.getPreparedStatement(conn, sql);
		
		try {
			query.setInt(1, id);
			
			ResultSet rs = query.executeQuery();
			
			if(rs.next()) {
				vacina =_buildVacina(rs);
			}
		} catch (SQLException e) {
		System.out.println("Erro ao consultar vacina por ID (id: " + id + ") .\nCausa: " + e.getMessage());
		}
		
		return vacina;
	}
	
	public List<VacinaVO> all() {
		Connection conn 					= Banco.getConnection();
		PreparedStatement query 			= Banco.getPreparedStatement(conn, this._QUERY);
		List<VacinaVO> vacinas 			= new ArrayList<VacinaVO>();
		
		try {
			ResultSet rs = query.executeQuery();
			
			while(rs.next()) {
				VacinaVO vacina = _buildVacina(rs);
				vacinas.add(vacina);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao consultar todas as vacinas.\nCausa: " + e.getMessage());
		}finally {
			Banco.closeStatement(query);
			Banco.closeConnection(conn);
		}
		
		return vacinas;
	}
	
	public ArrayList<String> getStages() {
		Connection conn 			= Banco.getConnection();
		String sql 					= "SELECT name FROM stages";
		PreparedStatement query 	= Banco.getPreparedStatement(conn, sql);
		ArrayList<String> stages 	= new ArrayList<String>();
		
		try {
			ResultSet rs = query.executeQuery();
			while(rs.next()) {
				stages.add(rs.getString("name"));
			}
		} catch (SQLException e) {
			System.out.println("Erro ao consultar todos os estágios .\nCausa: " + e.getMessage());
		} finally {
			Banco.closeStatement(query);
			Banco.closeConnection(conn);
		}

		return stages;
	}
	
	private VacinaVO _buildVacina(ResultSet rs) throws SQLException {
		VacinaVO vacina = new VacinaVO();
		
		vacina.setId(rs.getInt("id"));
		vacina.setPais(rs.getString("pais"));
		vacina.setEstagio(rs.getString("estagio"));
		vacina.getPesquisador().setNome(rs.getString("pesquisador"));
		Date startDateSQL = rs.getDate("dtinicio");
		LocalDate dtInicio = startDateSQL.toLocalDate();
		vacina.setDtInicio(dtInicio);
		
		return vacina;
	}
}
