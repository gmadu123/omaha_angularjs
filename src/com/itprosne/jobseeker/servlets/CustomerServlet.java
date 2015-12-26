package com.itprosne.jobseeker.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//import com.g2force.jobseeker.web.models.UserDTO;
//import com.g2force.jobseeker.web.servlets.String;
import com.itprosne.jobseeker.customer.CustomerService;
import com.itprosne.jobseeker.customer.pojos.Customer;

/**
 * Servlet implementation class UserProfileServlet
 */
@WebServlet("/UserProfileServlet")
public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		CustomerService teluguGuy = new CustomerService();
		List<Customer> mycustomers =   teluguGuy.getCustomerProfileByFirstName("A");
		
		request.setAttribute("customers", mycustomers);
		
		String nextJSP = "/JSP/actors.jsp";
		
		request.getRequestDispatcher(nextJSP).forward(request, response);
		
		/*StringBuffer sb = new StringBuffer();
		for(Customer c : mycustomers){
			String finalInfo = c.getfName() + " - " + c.getlName() + " - "+ c.getEmail();
			sb.append(finalInfo);
		}
		//String finalInfo = mycustomer.getfName() + " - " + mycustomer.getlName() + " - "+ mycustomer.getEmail();
		
		// TODO Auto-generated method stub
		response.getWriter().append(sb.toString()); */
	}
	
	
	
	//String nextJSP = "/JSP/login.jsp";

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
