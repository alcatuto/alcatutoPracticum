package com.covid.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.covid.baseDatosConexion.ConexionBD;
import com.covid.model.ConfinamientoModel;

public class ConfinamientoDao {

	private Connection connection ;
	private PreparedStatement statement ;
	private boolean estadoOperacion ;
	
	// BUSCAR LISTADO DE CONFINAMIENTO POR ID_PERSONA
		public List<ConfinamientoModel> listarConfinamientos(int idPersona) throws SQLException {
			ResultSet resulSet = null ;
			List<ConfinamientoModel> listaConfinamiento = new ArrayList<>();
			
			String sql = null ;
			estadoOperacion = false ;
			connection = obtenerConexion() ;
			
			try {
				sql = "SELECT * FROM confinamiento WHERE ID_PERSONA=?";
				statement = connection.prepareStatement(sql);
				statement.setInt(1, idPersona);
				resulSet = statement.executeQuery();
				
				while (resulSet.next()) {
					ConfinamientoModel confinamientoModel = new ConfinamientoModel();
					
					confinamientoModel.setID_CONFINAMIENTO(resulSet.getInt(1));
					confinamientoModel.setID_PERSONA(resulSet.getInt(2));
					confinamientoModel.setFECHA_REGISTRO(resulSet.getDate(3));
					confinamientoModel.setOBSERVACIONES(resulSet.getString(4));
					confinamientoModel.setESTADO(resulSet.getString(5));
					
					listaConfinamiento.add(confinamientoModel);
					System.out.println(listaConfinamiento);
				}
			} catch (SQLException e) {
					e.printStackTrace();
				}
			return listaConfinamiento;
		}
		
		//REGISTRAR UN SEGUIMIENTO
		public boolean guardarConfinamiento(ConfinamientoModel confinamientoModel) throws SQLException {
			
			String sql = null ;
			estadoOperacion = false ;
			connection = obtenerConexion();
			
			try {
				connection.setAutoCommit(false);
				sql = "INSERT INTO confinamiento (ID_CONFINAMIENTO, ID_PERSONA, FECHA_REGISTRO, OBSERVACIONES, ESTADO)"
						+ " VALUES (?, ?, ?, ?, ?)";
				statement = connection.prepareStatement(sql);
				
				statement.setString(1, null);
				statement.setInt(2, confinamientoModel.getID_PERSONA());
				statement.setDate(3, confinamientoModel.getFECHA_REGISTRO());
				statement.setString(4, confinamientoModel.getOBSERVACIONES());
				statement.setString(5, confinamientoModel.getESTADO());
				
				estadoOperacion = statement.executeUpdate() > 0;
				
				connection.commit();
				statement.close();
				connection.close();
			} catch (SQLException e) {
					connection.rollback();
					e.printStackTrace();
				}
			return estadoOperacion;
		}

//CONECCIÓN CON LA BD
private Connection obtenerConexion() throws SQLException {
return ConexionBD.getConnection();
}
}
