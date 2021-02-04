package com.covid.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.covid.baseDatosConexion.ConexionBD;
import com.covid.model.RolModel;
import com.covid.model.UsuarioModel;

public class UsuarioDao {

	private Connection connection ;
	private PreparedStatement statement ;
	private boolean estadoOperacion ;

	//REGISTRAR UN USUARIO
	public boolean guardarUsuario(UsuarioModel usuarioModel) throws SQLException {
		
		String sql = null ;
		estadoOperacion = false ;
		connection = obtenerConexion();
		
		try {
			connection.setAutoCommit(false);
			sql = "INSERT INTO usuarios (ID_USUARIO, ID_ROLES, IDENTIFICACION, NOMBRES, APELLIDOS, "
					+ "GENERO, CIUDAD, DIRECCION, CELULAR, EMAIL, USUARIO, CLAVE, ESTADO) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			statement = connection.prepareStatement(sql);
			
			statement.setString(1, null);
			statement.setInt(2, usuarioModel.getID_ROLES());
			statement.setString(3, usuarioModel.getIDENTIFICACION());
			statement.setString(4, usuarioModel.getNOMBRES());
			statement.setString(5, usuarioModel.getAPELLIDOS());
			statement.setString(6, usuarioModel.getGENERO());
			statement.setString(7, usuarioModel.getCIUDAD());
			statement.setString(8, usuarioModel.getDIRECCION());
			statement.setString(9, usuarioModel.getCELULAR());
			statement.setString(10, usuarioModel.getEMAIL());
			statement.setString(11, usuarioModel.getUSUARIO());
			statement.setString(12, usuarioModel.getCLAVE());
			statement.setString(13, usuarioModel.getESTADO());
			
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
	
	//MODIFICAR INFORMACION DEL USUARIO
	public boolean editarUsuario(UsuarioModel usuarioModel) throws SQLException {
		String sql = null ;
		estadoOperacion = false ;
		connection = obtenerConexion() ;
		try {
			connection.setAutoCommit(false);
			sql = "UPDATE usuarios SET ID_ROLES=? , IDENTIFICACION=? , NOMBRES=? , APELLIDOS=? ,"
					+ "GENERO=? , CIUDAD=? , DIRECCION=? , CELULAR=? , EMAIL=? , USUARIO=? , CLAVE=? , ESTADO=? WHERE ID_USUARIO=?";
			statement = connection.prepareStatement(sql);
			
			statement.setInt(1, usuarioModel.getID_ROLES());
			statement.setString(2, usuarioModel.getIDENTIFICACION());
			statement.setString(3, usuarioModel.getNOMBRES());
			statement.setString(4, usuarioModel.getAPELLIDOS());
			statement.setString(5, usuarioModel.getGENERO());
			statement.setString(6, usuarioModel.getCIUDAD());
			statement.setString(7, usuarioModel.getDIRECCION());
			statement.setString(8, usuarioModel.getCELULAR());
			statement.setString(9, usuarioModel.getEMAIL());
			statement.setString(10, usuarioModel.getUSUARIO());
			statement.setString(11, usuarioModel.getCLAVE());
			statement.setString(12, usuarioModel.getESTADO());
			statement.setInt(13, usuarioModel.getID_USUARIO());
			
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
	
	//DELETE USUARIO
	public boolean eliminarUsuario(UsuarioModel usuarioModel) throws SQLException {
		String sql = null ;
		estadoOperacion = false ;
		connection = obtenerConexion() ;
		try {
			connection.setAutoCommit(false);
			sql = "UPDATE usuarios SET ESTADO=? WHERE ID_USUARIO=?";
			statement = connection.prepareStatement(sql);
			
			statement.setString(1, usuarioModel.getESTADO());
			statement.setInt(2, usuarioModel.getID_USUARIO());
			
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
	public List<UsuarioModel> listarUsuarios() throws SQLException {
		ResultSet resulSet = null ;
		List<UsuarioModel> listaUsuarios = new ArrayList<>();
		
		String sql = null ;
		estadoOperacion = false ;
		connection = obtenerConexion() ;
		try {
			sql = "SELECT * FROM usuarios WHERE ESTADO='ACTIVO'" ;
			statement = connection.prepareStatement(sql);
			resulSet = statement.executeQuery(sql);
			
			while (resulSet.next()) {
				UsuarioModel usuarioModel = new UsuarioModel();
				
				usuarioModel.setID_USUARIO(resulSet.getInt(1));
				usuarioModel.setID_ROLES(resulSet.getInt(2));
				usuarioModel.setIDENTIFICACION(resulSet.getString(3));
				usuarioModel.setNOMBRES(resulSet.getString(4));
				usuarioModel.setAPELLIDOS(resulSet.getString(5));
				usuarioModel.setGENERO(resulSet.getString(6));
				usuarioModel.setCIUDAD(resulSet.getString(7));
				usuarioModel.setDIRECCION(resulSet.getString(8));
				usuarioModel.setCELULAR(resulSet.getString(9));
				usuarioModel.setEMAIL(resulSet.getString(10));
				usuarioModel.setUSUARIO(resulSet.getString(11));
				usuarioModel.setCLAVE(resulSet.getString(12));
				usuarioModel.setESTADO(resulSet.getString(13));
				
				listaUsuarios.add(usuarioModel);
			}
		} catch (SQLException e) {
				e.printStackTrace();
			}
		return listaUsuarios;
	}
	
	// BUSCAR USUARIO POR ID_USUARIO
	public UsuarioModel obtenerUsuario(int idUsuario) throws SQLException {
		ResultSet resulSet = null ;
		UsuarioModel usuarioModel = new UsuarioModel();
		
		String sql = null ;
		estadoOperacion = false ;
		connection = obtenerConexion() ;
		try {
			sql = "SELECT * FROM usuarios WHERE ID_USUARIO=?" ;
			statement = connection.prepareStatement(sql);
			statement.setInt(1, idUsuario);
			
			resulSet = statement.executeQuery();
			
			if (resulSet.next()) {
				usuarioModel.setID_USUARIO(resulSet.getInt(1));
				usuarioModel.setID_ROLES(resulSet.getInt(2));
				usuarioModel.setIDENTIFICACION(resulSet.getString(3));
				usuarioModel.setNOMBRES(resulSet.getString(4));
				usuarioModel.setAPELLIDOS(resulSet.getString(5));
				usuarioModel.setGENERO(resulSet.getString(6));
				usuarioModel.setCIUDAD(resulSet.getString(7));
				usuarioModel.setDIRECCION(resulSet.getString(8));
				usuarioModel.setCELULAR(resulSet.getString(9));
				usuarioModel.setEMAIL(resulSet.getString(10));
				usuarioModel.setUSUARIO(resulSet.getString(11));
				usuarioModel.setCLAVE(resulSet.getString(12));
				usuarioModel.setESTADO(resulSet.getString(13));
			}
		} catch (SQLException e) {
				e.printStackTrace();
			}
		return usuarioModel;
	}
	
	//	CONECCIÓN CON LA BD
	private Connection obtenerConexion() throws SQLException {
		return ConexionBD.getConnection();
	}
	
	//READ ROLES
	public List<RolModel> listarRoles() throws SQLException {
		ResultSet resulSet = null ;
		List<RolModel> listaRoles = new ArrayList<>();
		
		String sql = null ;
		estadoOperacion = false ;
		connection = obtenerConexion() ;
		try {
			sql = "SELECT * FROM roles" ;
			statement = connection.prepareStatement(sql);
			resulSet = statement.executeQuery(sql);
			
			while (resulSet.next()) {
				RolModel rolModel = new RolModel();
				rolModel.setID_ROLES(resulSet.getInt(1));
				rolModel.setNOMBRE(resulSet.getString(2));
				rolModel.setDESCRIPCION(resulSet.getString(3));
				rolModel.setESTADO(resulSet.getString(4));
				
				listaRoles.add(rolModel);
			} 
		} catch (SQLException e) {
				e.printStackTrace();
			}
		return listaRoles;
	}
	
	// LOGIN DE USUARIO
	public UsuarioModel autenticarUsuario(String Usuario, String Clave) throws SQLException {	
		ResultSet resulSet = null ;
		UsuarioModel usuarioModel = new UsuarioModel();
			
		String sql = null ;
		estadoOperacion = false ;
		connection = obtenerConexion() ;	
		try {
			sql = "SELECT * FROM usuarios WHERE USUARIO=? AND CLAVE=?" ;
			statement = connection.prepareStatement(sql);
			statement.setString(1, Usuario);
			statement.setString(2, Clave);
				
			System.out.println("estamos en USUARIO DAO : " + Usuario + "  " + Clave);
			resulSet = statement.executeQuery();
			
			if (resulSet.next()) {		
				usuarioModel.setID_USUARIO(resulSet.getInt(1));
				usuarioModel.setID_ROLES(resulSet.getInt(2));
				usuarioModel.setIDENTIFICACION(resulSet.getString(3));
				usuarioModel.setNOMBRES(resulSet.getString(4));
				usuarioModel.setAPELLIDOS(resulSet.getString(5));
				usuarioModel.setGENERO(resulSet.getString(6));
				usuarioModel.setCIUDAD(resulSet.getString(7));
				usuarioModel.setDIRECCION(resulSet.getString(8));
				usuarioModel.setCELULAR(resulSet.getString(9));
				usuarioModel.setEMAIL(resulSet.getString(10));
				usuarioModel.setUSUARIO(resulSet.getString(11));
				usuarioModel.setCLAVE(resulSet.getString(12));
				usuarioModel.setESTADO(resulSet.getString(13));
			}	
		} catch (SQLException e) {
				e.printStackTrace();
			}	
		return usuarioModel;
	}
}