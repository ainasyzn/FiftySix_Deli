package henshin.controller;

import java.io.*;
import java.security.NoSuchAlgorithmException;
import javax.servlet.*;
import javax.servlet.http.*;
import henshin.dao.customerDAO;
import henshin.model.customerBean;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Asus
 */
//@WebServlet("/customerController")
public class customerController extends HttpServlet{
    
    private static String REGISTER = "/signup.jsp";
    private static String VIEW = "/viewProfile.jsp";
    private customerDAO dao; //an object to call the class
    String forward = ""; 
    
    public customerController(){
        super();
        dao = new customerDAO();
    }
    
    //post create and update
    //get view and read
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String action = request.getParameter("action");
            
            //lagi banyak things to do, lagi banyaaaakkk action
            /*if(action.equalsIgnoreCase("viewProfile")){ //actions yang customer can do (banyak lagiiiiiiiii)
                forward = VIEW;
                int ID = Integer.parseInt(request.getParameter("custID"));
                customerBean cust = dao.getCustByID(ID); //functions inside dao, kena ada dalam dao
                request.setAttribute("cust", cust);
            }   
            else{*/
                forward = REGISTER;      
            /*}*/
            RequestDispatcher view = request.getRequestDispatcher(forward);
            view.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            customerBean cust = new customerBean();
            //Get all the fields from the form using getParameter
            //getParameter (kena sama dalam form)
            cust.setCustName(request.getParameter("custName"));
            cust.setEmail(request.getParameter("email"));
            cust.setPhoneNo(request.getParameter("phoneNo"));
            cust.setPassword(request.getParameter("password"));
            
            //tengok customer as a whole
            //value from form dia simpan dalam cust as an object
            cust = customerDAO.getCust(cust);
            
            //to check whether customer tu ada ke tak
            //if customer tak wujud, baru dia adddddddddddd
            if(!cust.isValid()){ 
                try {             
                    dao.addCust(cust);
                } catch (NoSuchAlgorithmException ex) {
                    Logger.getLogger(customerController.class.getName()).log(Level.SEVERE, null, ex);
                }
                RequestDispatcher view = request.getRequestDispatcher("/login.jsp");
                view.forward(request, response);
            }
            /*else{ //kalau tak, dia update profile
                dao.updateCustByID(cust);
                RequestDispatcher view = request.getRequestDispatcher(VIEW); //request to show the profile view
                view.forward(request, response);
            }*/
    }

}
