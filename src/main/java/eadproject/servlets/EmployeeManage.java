package eadproject.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONObject;

import eadproject.entity.Employee;
import com.db.utils.DbConnection;

@WebServlet(urlPatterns ={"/employee/delete/*","/employee/update-page" ,"/employee/update/*"})
public class EmployeeManage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EmployeeManage() {
        super();
        // TODO Auto-generated constructor stub

    }

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    	System.out.println("asdasdasdasdasd");
    	String id = req.getParameter("id").toString();
    	System.out.println("id is "+id);
		try {
			Connection con = DbConnection.connectDB();
			String sqlQuery = "select * from employees where id='"+req.getParameter("id").toString()+"'";
			Statement stmt = con.createStatement();
			ResultSet result = stmt.executeQuery(sqlQuery);
			ArrayList<Employee> employees = new ArrayList<>();
            while (result.next()) {
            	 Employee emp = new Employee();
            		
            		emp.setNic( result.getString("nic"));
            		emp.setId( result.getInt("id"));
            		emp.setName( result.getString("name"));
            		emp.setDepartment( result.getString("department"));
            		emp.setDesignation( result.getString("designation"));
            		employees.add(emp);

            }
			req.setAttribute("userList",employees);
			String nic = employees.get(0).getNic();
			System.out.println(nic);
			RequestDispatcher disp = req.getRequestDispatcher("/WEB-INF/editEmployee.jsp");
			disp.forward(req, res);

		
		} catch (Exception e) {
			System.out.println("Something went wrong " + e);
			res.sendRedirect("index.jsp");
		}
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.print("put request");
		System.out.println("post request");
		String id = req.getParameter("id").toString();
		String name = req.getParameter("name");
		String nic = req.getParameter("nic");
		String designation = req.getParameter("designation");
		String department = req.getParameter("department");
		if(nic.isEmpty() == true || name.isEmpty() == true || designation.isEmpty() == true || department.isEmpty() == true) {
			System.out.println("All fields must be Fill");
			res.sendRedirect("index.jsp");
		}else {			
		//DB operation
			try {
				Connection con = DbConnection.connectDB();
		
				String sqlQuery = "update employees set nic='"+ nic +"' , name='"+name+"' ,department='"+ department +
						 "', designation='"+designation+"' where id="+id;
				Statement stmt = con.createStatement();
				stmt.executeUpdate(sqlQuery);
		
				res.sendRedirect("/Eadproject/fetch?");
			} catch (Exception e) {
				System.out.println("Something went wrong " + e);
				res.sendRedirect("index.jsp");
			}
			
		}
	}

	protected void doDelete(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
		String id = req.getParameter("id").toString();

		try {
			Connection cons = DbConnection.connectDB();
	
			String sqlQuerys = "delete from employees where id='"+id+"';";
			Statement stmts = cons.createStatement();
			stmts.executeUpdate(sqlQuerys);
			res.setStatus(200);
		} catch (Exception e) {
			System.out.println("Something went wrong " + e);
			res.sendRedirect("index.jsp");
		}
	}

}
