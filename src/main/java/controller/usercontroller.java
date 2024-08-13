package controller;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.userdao;
import model.user;

/**
 * Servlet implementation class usercontroller
 */
@WebServlet("/usercontroller")
public class usercontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public usercontroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		String action  =request.getParameter("action");
		if (action.equalsIgnoreCase("register")) {
		 user u = new user();
		 u.setName(request.getParameter("name"));
		 u.setContact(Long.parseLong(request.getParameter("contact")));
		 u.setAddress(request.getParameter("address"));
		 u.setEmail(request.getParameter("email"));
		 u.setPassword(request.getParameter("password"));
		 System.out.println(u);
		 
		 userdao.inseruser(u);
		    request.setAttribute("msg", "data inserted successfully");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		else if (action.equalsIgnoreCase("login")) {
			user u =new user();
			 u.setEmail(request.getParameter("email"));
			 u.setPassword(request.getParameter("password"));
			 user u1 = userdao.checkLogin(u);
			if(u1== null) {
				request.setAttribute("validate", "email or password is incorrect");
				request.getRequestDispatcher("login.jsp").forward(request, response);
				
			}
			else {
			 		HttpSession session = request.getSession();
			 		session.setAttribute("data",u1);
			 		request.getRequestDispatcher("home.jsp").forward(request, response);
			}
			 		
			
			
		}
		else if (action.equalsIgnoreCase("edit")) {
			int id = Integer.parseInt(request.getParameter("id"));
			user u = userdao.getUserById(id);
			request.setAttribute("user", u);
			request.getRequestDispatcher("update.jsp").forward(request, response);
		}
		else if(action.equalsIgnoreCase("update")){
		user u = new user();
		u.setId(Integer.parseInt(request.getParameter("id")));
		u.setName(request.getParameter("name"));
		u.setContact(Long.parseLong(request.getParameter("contact")));
		u.setAddress(request.getParameter("address"));
		u.setEmail(request.getParameter("email"));
		u.setPassword(request.getParameter("password"));
		userdao.updateuser(u);
		response.sendRedirect("home.jsp");
	}
		else if (action.equalsIgnoreCase("delete")) {
         			int id=Integer.parseInt(request.getParameter("id"));
         			userdao.deleteUser(id);
         			response.sendRedirect("home.jsp");
		}
		
	}
	
	

}
