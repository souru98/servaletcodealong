package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.Blog;
import utility.ConnectionManager;

public class BlogDaoImpl implements BlogDaoInterface{
	static int i = 0;
	
	
	private static final String INSERT_BLOG_SQL="INSERT INTO BLOG(blogId,blogTitle,blogDescription,postedOn)VALUES(seq_blog.nextval,?,?,?)";
	private static final String SELECT_ALL_BLOGS="select * from BLOG";
	private static final String DELETE_BLOG_BY_ID ="delete from BLOG where blogId=?";
	private static final String SELECT_BLOG_BY_ID = "select blogId,blogname,blogDiscription,postedOn from blog where blogId =?";
	private static final String UPDATE_BLOG = "update blog set  blogName = ?, blogDiscription = ?, postedOn = ? where blogId = ?";
	
	
	@Override
	public void insertBlog(Blog blog) throws SQLException {
		// TODO Auto-generated method stub
		
		System.out.println(INSERT_BLOG_SQL);
		try{
			Connection con = ConnectionManager.getConnection();
			PreparedStatement ps= con.prepareStatement(INSERT_BLOG_SQL);
//			ps.setInt(1, blog.getBlogId());
			ps.setString(1, blog.getBlogTitle());
			ps.setString(2,blog.getBlogDescription());
			ps.setDate(3,java.sql.Date.valueOf(blog.getPostedOn()));
			System.out.println(ps);
			ps.executeUpdate();
			con.close();
		}
		catch(SQLException | ClassNotFoundException e) 
		{
		System.out.println(e);
		}
	}

	@Override
	public Blog selectBlog(int blogId) {
		// TODO Auto-generated method stub
		Blog blog = null;
		System.out.println(blogId);

		try (Connection connection = ConnectionManager.getConnection();				
			PreparedStatement ps = connection.prepareStatement(SELECT_BLOG_BY_ID)) {
			ps.setInt(1, blogId);
			System.out.println(ps);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int Id = rs.getInt("blogId");
				String blogTitle = rs.getString("blogname");
				String blogDescription = rs.getString("blogDiscription");
				LocalDate postedOn = rs.getDate("postedOn").toLocalDate();
				
				blog = new Blog();
				blog.setBlogId(Id);
				blog.setBlogTitle(blogTitle);
				blog.setBlogDescription(blogDescription);
				blog.setPostedOn(postedOn);
				
			}
		} catch (SQLException | ClassNotFoundException exception) {
			System.out.println(exception);
		}
		return blog;
	}

	@Override
	public List<Blog> selectAllBlogs() {
		// TODO Auto-generated method stub
		
		Blog blog =null;
		List<Blog> blogList=new ArrayList<>();
		
		try {
			Connection con = null;
			try {
				con = ConnectionManager.getConnection();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    PreparedStatement ps = con.prepareStatement(SELECT_ALL_BLOGS);
		    System.out.println(ps);
		    ResultSet rs = ps.executeQuery();
		    while(rs.next()) {
		    	int Id=rs.getInt("blogId");
		    	String blogTitle=rs.getString("blogTitle");
		    	String blogDescription=rs.getString("blogDescription");
		    	LocalDate postedOn = rs.getDate("postedOn").toLocalDate();
		    	
		    	blog= new Blog();
		    	blog.setBlogId(Id);
		    	blog.setBlogTitle(blogTitle);
		    	blog.setBlogDescription(blogDescription);
		    	blog.setPostedOn(postedOn);
		    	blogList.add(blog);	
		    }
		}
		catch(SQLException e) {
			
		System.out.println(e);	
			
		}
		return blogList ;
	}

	@Override
	public boolean deleteBlog(int id) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		System.out.println(id);
		boolean rowDeleted;
		try ( Connection con = ConnectionManager.getConnection();
		     PreparedStatement ps = con.prepareStatement(DELETE_BLOG_BY_ID)){
	         ps.setInt(1, id);
	         rowDeleted=ps.executeUpdate()>0;
	         Blog blog = new Blog();
	 		blog.setBlogId(i--);
		} 
		return rowDeleted;
	}

	@Override
	public boolean updateBlog(int id) throws SQLException {
		// TODO Auto-generated method stub
          boolean rowUpdated = false;
          Blog blog = null;
		
		try {

			Connection connection = ConnectionManager.getConnection();
			PreparedStatement ps = connection.prepareStatement(UPDATE_BLOG); 
			ResultSet rs = ps.executeQuery();
		    while(rs.next()) {
		    	int Id=rs.getInt("blogId");
		    	String blogTitle=rs.getString("blogTitle");
		    	String blogDescription=rs.getString("blogDescription");
		    	LocalDate postedOn = rs.getDate("postedOn").toLocalDate();
		    	
		    	blog= new Blog();
		    	blog.setBlogId(Id);
		    	blog.setBlogTitle(blogTitle);
		    	blog.setBlogDescription(blogDescription);
		    	blog.setPostedOn(postedOn);
		    		
		    }
			rowUpdated = ps.executeUpdate() > 0;
			System.out.println(rowUpdated);
		}catch(Exception exception){
			System.out.println(exception);
		}
		return rowUpdated;
	}

	

}
