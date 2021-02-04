package com.covid.model;

import java.sql.Date;

public class ConfinamientoModel {
	private int ID_CONFINAMIENTO ;
	private int ID_PERSONA ;
	private Date FECHA_REGISTRO ;
	private String OBSERVACIONES;
	private String ESTADO;
	
	public ConfinamientoModel() {
		super();
	}

	public ConfinamientoModel(int iD_CONFINAMIENTO, int iD_PERSONA, Date fECHA_REGISTRO, String oBSERVACIONES,
			String eSTADO) {
		super();
		ID_CONFINAMIENTO = iD_CONFINAMIENTO;
		ID_PERSONA = iD_PERSONA;
		FECHA_REGISTRO = fECHA_REGISTRO;
		OBSERVACIONES = oBSERVACIONES;
		ESTADO = eSTADO;
	}

	public int getID_CONFINAMIENTO() {
		return ID_CONFINAMIENTO;
	}

	public void setID_CONFINAMIENTO(int iD_CONFINAMIENTO) {
		ID_CONFINAMIENTO = iD_CONFINAMIENTO;
	}

	public int getID_PERSONA() {
		return ID_PERSONA;
	}

	public void setID_PERSONA(int iD_PERSONA) {
		ID_PERSONA = iD_PERSONA;
	}

	public Date getFECHA_REGISTRO() {
		return FECHA_REGISTRO;
	}

	public void setFECHA_REGISTRO(Date fECHA_REGISTRO) {
		FECHA_REGISTRO = fECHA_REGISTRO;
	}

	public String getOBSERVACIONES() {
		return OBSERVACIONES;
	}

	public void setOBSERVACIONES(String oBSERVACIONES) {
		OBSERVACIONES = oBSERVACIONES;
	}

	public String getESTADO() {
		return ESTADO;
	}

	public void setESTADO(String eSTADO) {
		ESTADO = eSTADO;
	}

	@Override
	public String toString() {
		return "ConfinamientoModel [ID_CONFINAMIENTO=" + ID_CONFINAMIENTO + ", ID_PERSONA=" + ID_PERSONA
				+ ", FECHA_REGISTRO=" + FECHA_REGISTRO + ", OBSERVACIONES=" + OBSERVACIONES + ", ESTADO=" + ESTADO
				+ "]";
	}
	

}
