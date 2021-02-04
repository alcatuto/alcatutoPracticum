package com.covid.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.covid.baseDatosConexion.ConexionBD;
import com.covid.model.PersonaModel;

public class PersonaDao {

	private Connection connection ;
	private PreparedStatement statement ;
	private boolean estadoOperacion ;
			
	public boolean guardarPersona(PersonaModel personaModel) throws SQLException {
		String sql = null ;
		estadoOperacion = false ;
		connection = obtenerConexion();
		System.out.println("ingresando a personaDAO");
		try {
			
			connection.setAutoCommit(false);
			sql = "INSERT INTO personas (ID_PERSONA, IDENTIFICACION, NOMBRES, APELLIDOS, EDAD, PROVINCIA, CANTON, GENERO, CELULAR, EMAIL,"
					+ "LATITUD, LONGUITUD, ESTADO ) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
			statement = connection.prepareStatement(sql);
			
			statement.setString(1, null); //ID_PERSONA
			statement.setString(2, personaModel.getIDENTIFICACION());
			statement.setString(3, personaModel.getNOMBRES());
			statement.setString(4, personaModel.getAPELLIDOS());
			statement.setString(5, personaModel.getEDAD());
			statement.setString(6, personaModel.getPROVINCIA());
			statement.setString(7, personaModel.getCANTON());
			statement.setString(8, personaModel.getGENERO());
			statement.setString(9, personaModel.getCELULAR());
			statement.setString(10, personaModel.getEMAIL());
			statement.setFloat(11, personaModel.getLATITUD());
			statement.setFloat(12, personaModel.getLONGUITUD());
			statement.setString(13, personaModel.getESTADO());
			
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
	
	//READ USUARIO
		public List<PersonaModel> listarPersonas() throws SQLException {
			ResultSet resulSet = null ;
			List<PersonaModel> listaPersonas = new ArrayList<>();
			
			String sql = null ;
			estadoOperacion = false ;
			connection = obtenerConexion() ;
			try {
				sql = "SELECT * FROM personas WHERE ESTADO='ACTIVO'" ;
				statement = connection.prepareStatement(sql);
				resulSet = statement.executeQuery(sql);
				
				while (resulSet.next()) {
					PersonaModel personaModel = new PersonaModel();
					
					personaModel.setID_PERSONA(resulSet.getInt(1));
					personaModel.setIDENTIFICACION(resulSet.getString(2));;
					personaModel.setNOMBRES(resulSet.getString(3));
					personaModel.setAPELLIDOS(resulSet.getString(4));
					personaModel.setEDAD(resulSet.getString(5));
					personaModel.setPROVINCIA(resulSet.getString(6));
					personaModel.setCANTON(resulSet.getString(7));
					personaModel.setGENERO(resulSet.getString(8));
					personaModel.setCELULAR(resulSet.getString(9));
					personaModel.setEMAIL(resulSet.getString(10));
					personaModel.setLATITUD(resulSet.getFloat(11));
					personaModel.setLONGUITUD(resulSet.getFloat(12));
					personaModel.setESTADO(resulSet.getString(13));
					
					listaPersonas.add(personaModel);
				}
			} catch (SQLException e) {
					e.printStackTrace();
				}
			return listaPersonas;
		}
		
		// BUSCAR PERSONA POR ID_PERSONA
		public PersonaModel obtenerPersona(int idPersona) throws SQLException {
			ResultSet resulSet = null ;
			PersonaModel personaModel = new PersonaModel();
			
			String sql = null ;
			estadoOperacion = false ;
			connection = obtenerConexion() ;
			try {
				sql = "SELECT * FROM personas WHERE ID_PERSONA=?" ;
				statement = connection.prepareStatement(sql);
				statement.setInt(1, idPersona);
				
				resulSet = statement.executeQuery();
				
				if (resulSet.next()) {
					personaModel.setID_PERSONA(resulSet.getInt(1));
					personaModel.setIDENTIFICACION(resulSet.getString(2));
					personaModel.setNOMBRES(resulSet.getString(3));
					personaModel.setAPELLIDOS(resulSet.getString(4));
					personaModel.setEDAD(resulSet.getString(5));
					personaModel.setPROVINCIA(resulSet.getString(6));
					personaModel.setCANTON(resulSet.getString(7));
					personaModel.setGENERO(resulSet.getString(8));
					personaModel.setCELULAR(resulSet.getString(9));
					personaModel.setEMAIL(resulSet.getString(10));
					personaModel.setLATITUD(resulSet.getFloat(11));
					personaModel.setLONGUITUD(resulSet.getFloat(12));
					personaModel.setESTADO(resulSet.getString(13));
				}
			} catch (SQLException e) {
					e.printStackTrace();
				}
			return personaModel;
		}
		

//	CONECCIÓN CON LA BD
	private Connection obtenerConexion() throws SQLException {
		return ConexionBD.getConnection();
	}
}
