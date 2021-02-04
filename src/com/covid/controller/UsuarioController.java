package com.covid.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.covid.Dao.PersonaDao;
import com.covid.Dao.UsuarioDao;
import com.covid.model.PersonaModel;
import com.covid.model.RolModel;
import com.covid.model.UsuarioModel;

/**
 * Servlet implementation class UsuarioController
 */
@WebServlet( urlPatterns = {"/UsuarioController"} )
public class UsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UsuarioController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String opcion = request.getParameter("opcion") ;
				
		if (opcion.equals("nuevoUsuario")) {
			System.out.println("usted presionó opcion nuevo Usuario");
			UsuarioDao usuarioDao = new UsuarioDao();
			List<RolModel> listarRoles = new ArrayList<>();
					
			try {
				listarRoles = usuarioDao.listarRoles();
				for (RolModel rol : listarRoles) {
					System.out.println(rol);
				}
						
				request.setAttribute("listarRoles", listarRoles);
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("View/ViewUsuario/NuevoUsuario.jsp");
				requestDispatcher.forward(request, response);
						
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else
		if(opcion.equals("editarUsuario")){
			int id= Integer.parseInt(request.getParameter("ID_USUARIO"));
			System.out.println("editar id= " + id);
					
			UsuarioDao usuarioDao = new UsuarioDao();
			UsuarioModel usuarioModel = new UsuarioModel();
			List<RolModel> listarRoles = new ArrayList<>();
					
			try {
				usuarioModel = usuarioDao.obtenerUsuario(id);
				System.out.println(usuarioModel);
						
				listarRoles = usuarioDao.listarRoles();
				for (RolModel rol : listarRoles) {
					System.out.println(rol);
				}
						
				request.setAttribute("listarUsuario", usuarioModel);
				request.setAttribute("listarRoles", listarRoles);
						
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("View/ViewUsuario/EditarUsuario.jsp");
				requestDispatcher.forward(request, response);
						
			} catch (SQLException e) {
					e.printStackTrace();
				}
		}else
		if (opcion.equals("eliminarUsuario")) {
			UsuarioModel usuarioModel = new UsuarioModel();
			UsuarioDao usuarioDao = new UsuarioDao();
					
			usuarioModel.setID_USUARIO(Integer.parseInt(request.getParameter("ID_USUARIO")));
			usuarioModel.setESTADO("ELIMINADO");
					
			try {
				usuarioDao.eliminarUsuario(usuarioModel);
				System.out.println("registro eliminado");
				ControlUsuarios(request, response);
			} catch (SQLException e) {
					e.printStackTrace();
				}
		}else
		if (opcion.equals("listarUsu")) {
			try {
				ControlUsuarios(request, response);
			} catch (Exception e) {
					e.printStackTrace();
				}				
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String opcion = request.getParameter("opcion");
		if (opcion.equals("login")) {
			
			UsuarioDao usuarioDao = new UsuarioDao();
			UsuarioModel usuarioModel = new UsuarioModel();
			
			String nombreUsuario = request.getParameter("txt_Usuario");
			String contrasena = request.getParameter("txt_Contrasena");
			
			System.out.println("usuario tecleado : " + nombreUsuario + "  su claves tecleado : " + contrasena);
			try {
				usuarioModel = usuarioDao.autenticarUsuario(nombreUsuario, contrasena);
				System.out.println(usuarioModel);
				System.out.println(usuarioModel.getID_USUARIO());
				if (usuarioModel.getID_ROLES() == 1 && usuarioModel.getESTADO().equals("ACTIVO") == true ) {
					System.out.println("ADMINISTRADOR");
					ControlUsuarios(request, response);
				}
				if (usuarioModel.getID_ROLES() == 2 && usuarioModel.getESTADO().equals("ACTIVO") == true ) {
					System.out.println("MEDICO");
					verContagiados(request, response);
				}
			} catch (SQLException e) {
					e.printStackTrace();
					System.out.println("usted NO SE PUDO LOGEAR");
				}
		}else
		if (opcion.equals("guardarUsuario")) {
			UsuarioDao usuarioDao = new UsuarioDao();
			UsuarioModel usuarioModel = new UsuarioModel();
				
			usuarioModel.setIDENTIFICACION(request.getParameter("text_cedula"));
			usuarioModel.setNOMBRES(request.getParameter("text_nombres"));
			usuarioModel.setAPELLIDOS(request.getParameter("text_apellidos"));
			usuarioModel.setCIUDAD(request.getParameter("text_ciudad"));
			usuarioModel.setDIRECCION(request.getParameter("text_direccion"));
			usuarioModel.setGENERO(request.getParameter("combobox_genero"));
			usuarioModel.setID_ROLES(Integer.parseInt(request.getParameter("combobox_roles")));
			usuarioModel.setCELULAR(request.getParameter("text_celular"));
			usuarioModel.setEMAIL(request.getParameter("text_email"));
			usuarioModel.setUSUARIO(request.getParameter("text_usuario"));
			usuarioModel.setCLAVE(request.getParameter("text_clave"));
			usuarioModel.setESTADO("ACTIVO");
			
			try {
				usuarioDao.guardarUsuario(usuarioModel);
				System.out.println("registro guardado");
				ControlUsuarios(request, response);
			} catch (SQLException e) {
					e.printStackTrace();
				}
		}
	}
	
	public void ControlUsuarios(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UsuarioDao usuarioDao = new UsuarioDao();
		List<UsuarioModel> listarUsuarios = new ArrayList<>();
		
		try {
			listarUsuarios = usuarioDao.listarUsuarios();
			for (UsuarioModel usuario : listarUsuarios) {
				System.out.println(usuario);
			}
			
			request.setAttribute("listarUsuarios", listarUsuarios);
			
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("View/ViewUsuario/Usuarios.jsp");
			requestDispatcher.forward(request, response);
			System.out.println("usted presiono opcion listar");
			
		} catch (SQLException e) {
				e.printStackTrace();
		}
	}
	
	public void verContagiados(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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