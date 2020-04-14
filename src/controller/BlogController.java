package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BlogDaoImpl;
import model.Blog;

/**
 * Servlet implementation class BlogController
 */
@WebServlet(urlPatterns= {"/new"})
public class BlogController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BlogController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
	System.out.println("Getting into Add New Blog");
	RequestDispatcher rd=this.getServletContext().getRequestDispatcher("/WEB-INF/views/blogListView.jsp");
	rd.forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	System.out.println("Entering to post");
	String blogTitle=request.getParameter("title");
	String blogDescription=request.getParameter("message");
	LocalDate PostedOn= LocalDate.now();
	
	Blog blog=new Blog();
	blog.setBlogTitle(blogTitle);
	blog.setBlogDescription(blogDescription);
	blog.setPostedOn(PostedOn);
	
	BlogDaoImpl blogdao=new BlogDaoImpl();
	try {
		blogdao.insertBlog(blog);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	response.sendRedirect("allblogs");
	}

}
