package com.covid.model;

public class UsuarioModel {
	
	private int ID_USUARIO ;
	private int ID_ROLES ;
	private String IDENTIFICACION ;
	private String NOMBRES ;
	private String APELLIDOS ;
	private String GENERO ;
	private String CIUDAD ;
	private String DIRECCION ;
	private String CELULAR ;
	private String EMAIL ;
	private String USUARIO ;
	private String CLAVE ;
	private String ESTADO ;
	
	public UsuarioModel() {
		super();
	}
	
	public UsuarioModel(int iD_USUARIO, int iD_ROLES, String iDENTIFICACION, String nOMBRES, String aPELLIDOS,
			String gENERO, String cIUDAD, String dIRECCION, String cELULAR, String eMAIL, String uSUARIO,
			String cLAVE, String eSTADO) {
		super();
		ID_USUARIO = iD_USUARIO;
		ID_ROLES = iD_ROLES;
		IDENTIFICACION = iDENTIFICACION;
		NOMBRES = nOMBRES;
		APELLIDOS = aPELLIDOS;
		GENERO = gENERO;
		CIUDAD = cIUDAD;
		DIRECCION = dIRECCION;
		CELULAR = cELULAR;
		EMAIL = eMAIL;
		USUARIO = uSUARIO;
		CLAVE = cLAVE;
		ESTADO = eSTADO;
	}

	public int getID_USUARIO() {
		return ID_USUARIO;
	}

	public void setID_USUARIO(int iD_USUARIO) {
		ID_USUARIO = iD_USUARIO;
	}

	public int getID_ROLES() {
		return ID_ROLES;
	}

	public void setID_ROLES(int iD_ROLES) {
		ID_ROLES = iD_ROLES;
	}

	public String getIDENTIFICACION() {
		return IDENTIFICACION;
	}

	public void setIDENTIFICACION(String iDENTIFICACION) {
		IDENTIFICACION = iDENTIFICACION;
	}

	public String getNOMBRES() {
		return NOMBRES;
	}

	public void setNOMBRES(String nOMBRES) {
		NOMBRES = nOMBRES;
	}

	public String getAPELLIDOS() {
		return APELLIDOS;
	}

	public void setAPELLIDOS(String aPELLIDOS) {
		APELLIDOS = aPELLIDOS;
	}

	public String getGENERO() {
		return GENERO;
	}

	public void setGENERO(String gENERO) {
		GENERO = gENERO;
	}

	public String getCIUDAD() {
		return CIUDAD;
	}

	public void setCIUDAD(String cIUDAD) {
		CIUDAD = cIUDAD;
	}

	public String getDIRECCION() {
		return DIRECCION;
	}

	public void setDIRECCION(String dIRECCION) {
		DIRECCION = dIRECCION;
	}

	public String getCELULAR() {
		return CELULAR;
	}

	public void setCELULAR(String cELULAR) {
		CELULAR = cELULAR;
	}

	public String getEMAIL() {
		return EMAIL;
	}

	public void setEMAIL(String eMAIL) {
		EMAIL = eMAIL;
	}

	public String getUSUARIO() {
		return USUARIO;
	}

	public void setUSUARIO(String uSUARIO) {
		USUARIO = uSUARIO;
	}

	public String getCLAVE() {
		return CLAVE;
	}

	public void setCLAVE(String cLAVE) {
		CLAVE = cLAVE;
	}

	public String getESTADO() {
		return ESTADO;
	}

	public void setESTADO(String eSTADO) {
		ESTADO = eSTADO;
	}

	@Override
	public String toString() {
		return "UsuarioModel [ID_USUARIO=" + ID_USUARIO + ", ID_ROLES=" + ID_ROLES + ", IDENTIFICACION="
				+ IDENTIFICACION + ", NOMBRES=" + NOMBRES + ", APELLIDOS=" + APELLIDOS + ", GENERO=" + GENERO
				+ ", CIUDAD=" + CIUDAD + ", DIRECCION=" + DIRECCION + ", CELULAR="
				+ CELULAR + ", EMAIL=" + EMAIL + ", USUARIO=" + USUARIO + ", CLAVE=" + CLAVE + ", ESTADO=" + ESTADO
				+ "]";
	}
}