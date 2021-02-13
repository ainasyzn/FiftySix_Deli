package henshin.controller;

import java.io.*;
import java.security.NoSuchAlgorithmException;
import javax.servlet.*;
import javax.servlet.http.*;
import henshin.dao.riderDAO;
import henshin.model.riderBean;
import java.util.logging.Level;
import java.util.logging.Logger;
        

/**
 *
 * @author Aina Syazana
 */
public class riderController extends HttpServlet{
    private static String REGISTER = "/a-admin/add-rider.jsp";
    private static String VIEW = "/manage-rider.jsp";
    private riderDAO dao; //an object to call the class
    String forward = ""; 
    
     public riderController(){
        super();
        dao = new riderDAO();
    }
     
     @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            riderBean rider = new riderBean();
            //Get all the fields from the form using getParameter
            //getParameter (kena sama dalam form)
            rider.setRiderName(request.getParameter("riderName"));
            rider.setIdentificationNo(request.getParameter("riderIC"));
            rider.setPlateNo(request.getParameter("plateNo"));
            rider.setRiderPhone(request.getParameter("riderPhone"));
            rider.setRegDate(request.getParameter("regDate"));
            rider.setStatus(request.getParameter("status"));
            
            //tengok customer as a whole
            //value from form dia simpan dalam cust as an object
            rider = riderDAO.getRider(rider);
            
            //to check whether customer tu ada ke tak
            //if customer tak wujud, baru dia adddddddddddd
            if(!rider.isValid()){ 
                try {             
                    dao.addRider(rider);
                } catch (NoSuchAlgorithmException ex) {
                    Logger.getLogger(customerController.class.getName()).log(Level.SEVERE, null, ex);
                }
                RequestDispatcher view = request.getRequestDispatcher("manage-rider.jsp");
                view.forward(request, response);
            }
            /*else{ //kalau tak, dia update profile
                dao.updateCustByID(cust);
                RequestDispatcher view = request.getRequestDispatcher(VIEW); //request to show the profile view
                view.forward(request, response);
            }*/
    }
}
