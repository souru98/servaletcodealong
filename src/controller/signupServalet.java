package controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import model.user;

/**
 * Servlet implementation class signupServalet
 */
@WebServlet(urlPatterns= {"/signup"})
public class signupServalet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public signupServalet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	RequestDispatcher rd =this.getServletContext().getRequestDispatcher("/WEB-INF/views/signupView.jsp");
	rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		String confirmpassword=request.getParameter("confirmpassword");
		LocalDate date = LocalDate.now();
		user user =new user();
		user.setEmail(email);
		user.setPassword(password);
		UserDao userdao= new UserDao();
		user.setDate(date);
		int checkUser = 0;
		try {
			checkUser = userdao.signup(user);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(checkUser!=0) 
		{
			System.out.println(user.getEmail());
			System.out.println(user.getPassword());
			System.out.println(user.getDate());
			request.setAttribute("message", "Registration successful");
			RequestDispatcher rd =this.getServletContext().getRequestDispatcher("/WEB-INF/views/signupView.jsp");
			rd.forward(request, response);
		}
		else
		{
			request.setAttribute("message", "Check Your Credentials");
			RequestDispatcher rd =this.getServletContext().getRequestDispatcher("/WEB-INF/views/signupView.jsp");
			rd.forward(request, response);
		}
		
		
	}

}
