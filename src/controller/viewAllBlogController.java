package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BlogDaoImpl;
import model.Blog;

/**
 * Servlet implementation class viewAllBlogController
 */
@WebServlet("/allblogs")
public class viewAllBlogController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public viewAllBlogController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	System.out.println("view all blogs");
	System.out.println("Getting all blog post");
	
	BlogDaoImpl blogDao= new BlogDaoImpl();
	List<Blog> listBlog=blogDao.selectAllBlogs();
	
	for(Blog bloglist:listBlog) {
		System.out.println(bloglist.getBlogId());
		System.out.println(bloglist.getBlogDescription());
		System.out.println(bloglist.getBlogTitle());
		System.out.println(bloglist.getPostedOn());
	}
	request.setAttribute("listBlog", listBlog);
	RequestDispatcher rd =this.getServletContext().getRequestDispatcher("/WEB-INF/views/blogView.jsp");
	rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
