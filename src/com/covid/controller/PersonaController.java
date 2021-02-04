package com.covid.controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.covid.Dao.ConfinamientoDao;
import com.covid.Dao.PersonaDao;
import com.covid.model.ConfinamientoModel;
import com.covid.model.PersonaModel;


/**
 * Servlet implementation class PersonaController
 */
@WebServlet( urlPatterns = {"/PersonaController"} )
public class PersonaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PersonaController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String opcion = request.getParameter("opcion") ;
		
		if (opcion.equals("nuevoRegistro")) {
			System.out.println("usted presionó opcion nuevo Registro");
									
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("View/ViewPersona/RegistroContagiado.jsp");
			requestDispatcher.forward(request, response);
		}else
			if (opcion.equals("agregarInfo")) {
				System.out.println("usted ingreso a ver el confinamiento");
				int id= Integer.parseInt(request.getParameter("ID_PERSONA"));
				System.out.println("ver inf id= " + id);
						
				PersonaDao personaDao = new PersonaDao();
				PersonaModel personaModel = new PersonaModel();
				ConfinamientoDao confinamientoDao = new ConfinamientoDao();
				List<ConfinamientoModel> listarConfinamiento = new ArrayList<>();
						
				try {
					personaModel = personaDao.obtenerPersona(id);
					System.out.println(personaModel);
							
					listarConfinamiento = confinamientoDao.listarConfinamientos(id);
					for (ConfinamientoModel confinamiento : listarConfinamiento) {
						System.out.println(confinamiento);
					}
							
					request.setAttribute("listarPersona", personaModel);
					request.setAttribute("listarConfinamiento", listarConfinamiento);
							
					RequestDispatcher requestDispatcher = request.getRequestDispatcher("View/ViewPersona/Confinamiento.jsp");
					requestDispatcher.forward(request, response);
							
				} catch (SQLException e) {
						e.printStackTrace();
					}
			}else
				if (opcion.equals("verApi")) {
					PersonaDao personaDao = new PersonaDao();
					List<PersonaModel> listarPersonas = new ArrayList<>();
					
					try {
						listarPersonas = personaDao.listarPersonas();
						for (PersonaModel persona : listarPersonas) {
							System.out.println(persona);
						}
						
						request.setAttribute("listarPersonas", listarPersonas);
						
						RequestDispatcher requestDispatcher = request.getRequestDispatcher("View/ViewPersona/ApiGoogleMap.jsp");
						requestDispatcher.forward(request, response);
						System.out.println("usted presiono opcion listar");
						
					} catch (SQLException e) {
							e.printStackTrace();
						}
				}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String opcion = request.getParameter("opcion");
		
		if (opcion.equals("guardarPersona")) {
			//int banderaExtranjero = 0;
			System.out.println("INGRESANDO A GUARDar");
			PersonaDao personaDao = new PersonaDao();
			PersonaModel personaModel = new PersonaModel();
			
			personaModel.setIDENTIFICACION(request.getParameter("text_cedula"));
			personaModel.setNOMBRES(request.getParameter("text_nombres"));
			personaModel.setAPELLIDOS(request.getParameter("text_apellidos"));
			personaModel.setGENERO(request.getParameter("combobox_genero"));
			personaModel.setPROVINCIA(request.getParameter("combobox_provincias"));
			personaModel.setCANTON(request.getParameter("text_canton"));
			personaModel.setEDAD(request.getParameter("text_edad"));
			personaModel.setCELULAR(request.getParameter("text_celular"));
			personaModel.setEMAIL(request.getParameter("text_email"));
			personaModel.setLATITUD(Float.parseFloat(request.getParameter("text_latitud")));
			personaModel.setLONGUITUD(Float.parseFloat(request.getParameter("text_longuitud")));
			personaModel.setESTADO("ACTIVO");
		    	
		    System.out.println(personaModel.toString());
			
			
			try {
				personaDao.guardarPersona(personaModel);
				System.out.println("registro guardado");
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("View/ViewPersona/RegistroContagiado.jsp");
				requestDispatcher.forward(request, response);
			} catch (SQLException e) {
					e.printStackTrace();
				}
		}else
			if (opcion.equals("guardarConfinamiento")) {
				int idPersona = Integer.parseInt(request.getParameter("id_persona")) ;
				System.out.println("INGRESANDO A GUARDar Confinamiento:  " + idPersona);
				
				ConfinamientoDao confinamientoDao = new ConfinamientoDao();
				ConfinamientoModel confinamientoModel = new ConfinamientoModel();
				
				//confinamientoModel.setID_PERSONA(Integer.parseInt(request.getParameter("id_persona")));
				confinamientoModel.setID_PERSONA(idPersona);
				Calendar cal = Calendar.getInstance(); 
				Date fechaActual = new Date(cal.getTimeInMillis());
				confinamientoModel.setFECHA_REGISTRO(fechaActual);
				confinamientoModel.setOBSERVACIONES(request.getParameter("text_observacion"));
				confinamientoModel.setESTADO(request.getParameter("combobox_estado"));
			    	
			    System.out.println(confinamientoModel.toString());
				
				try {
					confinamientoDao.guardarConfinamiento(confinamientoModel);
					System.out.println("registro guardado");
					ListarConfinamientos(request, response, idPersona);
					//ListarConfinamientos(request, response);
					
					//RequestDispatcher requestDispatcher = request.getRequestDispatcher("View/ViewPersona/MapaContagiado.jsp");
					//requestDispatcher.forward(request, response);
				} catch (SQLException e) {
						e.printStackTrace();
					}
			}
	}
	
	public void ListarConfinamientos(HttpServletRequest request, HttpServletResponse response, int idPersona) throws ServletException, IOException {
		ConfinamientoDao confinamientoDao = new ConfinamientoDao();
		List<ConfinamientoModel> listar = new ArrayList<>();
		PersonaDao personaDao = new PersonaDao();
		PersonaModel personaModel = new PersonaModel();
		try {
			personaModel = personaDao.obtenerPersona(idPersona);
			listar = confinamientoDao.listarConfinamientos(idPersona);
			for (ConfinamientoModel confinamiento : listar) {
				System.out.println(confinamiento);
			}
			
			request.setAttribute("listarPersona", personaModel);
			request.setAttribute("listarConfinamiento", listar);
			
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("View/ViewPersona/Confinamiento.jsp");
			requestDispatcher.forward(request, response);
			System.out.println("usted presiono opcion listar");
			
		} catch (SQLException e) {
				e.printStackTrace();
		}
	}
	

}
