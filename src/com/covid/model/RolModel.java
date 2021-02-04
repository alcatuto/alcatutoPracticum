package com.covid.model;

public class RolModel {
	private int ID_ROLES ;
	private String NOMBRE ;
	private String DESCRIPCION ;
	private String ESTADO ;
	
	public RolModel() {
		super();
	}

	public RolModel(int iD_ROLES, String nOMBRE, String dESCRIPCION, String eSTADO) {
		super();
		ID_ROLES = iD_ROLES;
		NOMBRE = nOMBRE;
		DESCRIPCION = dESCRIPCION;
		ESTADO = eSTADO;
	}

	public int getID_ROLES() {
		return ID_ROLES;
	}

	public void setID_ROLES(int iD_ROLES) {
		ID_ROLES = iD_ROLES;
	}

	public String getNOMBRE() {
		return NOMBRE;
	}

	public void setNOMBRE(String nOMBRE) {
		NOMBRE = nOMBRE;
	}

	public String getDESCRIPCION() {
		return DESCRIPCION;
	}

	public void setDESCRIPCION(String dESCRIPCION) {
		DESCRIPCION = dESCRIPCION;
	}

	public String getESTADO() {
		return ESTADO;
	}

	public void setESTADO(String eSTADO) {
		ESTADO = eSTADO;
	}

	@Override
	public String toString() {
		return "RolModel [ID_ROLES=" + ID_ROLES + ", NOMBRE=" + NOMBRE + ", DESCRIPCION=" + DESCRIPCION + ", ESTADO="
				+ ESTADO + "]";
	}
	
	

}
