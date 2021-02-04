package com.covid.model;

public class PersonaModel {
	
	private int ID_PERSONA ;
	private String IDENTIFICACION ;
	private String NOMBRES ;
	private String APELLIDOS ;
	private String GENERO ;
	private String PROVINCIA ;
	private String CANTON ;
	private String EDAD ;
	private String CELULAR ;
	private String EMAIL ;
	private float LATITUD ;
	private float LONGUITUD ;
	private String ESTADO ;
	
	public PersonaModel() {
		super();
	}

	public PersonaModel(int iD_PERSONA, String iDENTIFICACION, String nOMBRES, String aPELLIDOS, String gENERO,
			String pROVINCIA, String cANTON, String eDAD, String cELULAR, String eMAIL, float lATITUD, float lONGUITUD,
			String eSTADO) {
		super();
		ID_PERSONA = iD_PERSONA;
		IDENTIFICACION = iDENTIFICACION;
		NOMBRES = nOMBRES;
		APELLIDOS = aPELLIDOS;
		GENERO = gENERO;
		PROVINCIA = pROVINCIA;
		CANTON = cANTON;
		EDAD = eDAD;
		CELULAR = cELULAR;
		EMAIL = eMAIL;
		LATITUD = lATITUD;
		LONGUITUD = lONGUITUD;
		ESTADO = eSTADO;
	}

	public int getID_PERSONA() {
		return ID_PERSONA;
	}

	public void setID_PERSONA(int iD_PERSONA) {
		ID_PERSONA = iD_PERSONA;
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

	public String getPROVINCIA() {
		return PROVINCIA;
	}

	public void setPROVINCIA(String pROVINCIA) {
		PROVINCIA = pROVINCIA;
	}

	public String getCANTON() {
		return CANTON;
	}

	public void setCANTON(String cANTON) {
		CANTON = cANTON;
	}

	public String getEDAD() {
		return EDAD;
	}

	public void setEDAD(String eDAD) {
		EDAD = eDAD;
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

	public float getLATITUD() {
		return LATITUD;
	}

	public void setLATITUD(float lATITUD) {
		LATITUD = lATITUD;
	}

	public float getLONGUITUD() {
		return LONGUITUD;
	}

	public void setLONGUITUD(float lONGUITUD) {
		LONGUITUD = lONGUITUD;
	}

	public String getESTADO() {
		return ESTADO;
	}

	public void setESTADO(String eSTADO) {
		ESTADO = eSTADO;
	}

	@Override
	public String toString() {
		return "PersonaModel [ID_PERSONA=" + ID_PERSONA + ", IDENTIFICACION=" + IDENTIFICACION + ", NOMBRES=" + NOMBRES
				+ ", APELLIDOS=" + APELLIDOS + ", GENERO=" + GENERO + ", PROVINCIA=" + PROVINCIA + ", CANTON=" + CANTON
				+ ", EDAD=" + EDAD + ", CELULAR=" + CELULAR + ", EMAIL=" + EMAIL + ", LATITUD=" + LATITUD
				+ ", LONGUITUD=" + LONGUITUD + ", ESTADO=" + ESTADO + "]";
	}
}
