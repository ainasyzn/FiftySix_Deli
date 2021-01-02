
package henshin.dao;

/**
 *
 * @author Asus
 */
//import java.util.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
//import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import henshin.model.customerBean;
import henshin.connection.ConnectionManager;

public class customerDAO {
    static Connection currentCon = null;
    static ResultSet rs = null; 
    static PreparedStatement ps = null;
    static Statement stmt = null;
    //field ada dalam table
    static int custID;
    static String custName;
    static String email;
    static String password;
    static String regDate;
    static String phoneNo;
    static String deliveryAddress;
    
    //methods yang guna dalam controller, the implementations letak kat sini
    //sebab diaaaaaa check an object 
    public static customerBean getCust(customerBean bean){
        custID = bean.getCustID();
        
        //SQL command
        String searchQuery = "SELECT * FROM CUSTOMERS WHERE CUST_ID ='" + custID + "'";
        
        try{
            currentCon = ConnectionManager.getConnection();
            stmt = currentCon.createStatement();
            rs = stmt.executeQuery(searchQuery);
            boolean more = rs.next();
            
            //rs tu refer to database
            if(more){
                int id = rs.getInt("CUST_ID");
                bean.setCustID(id);
                bean.setValid(true);
            }
            else if(!more){
                bean.setValid(false);
            }
        }
        catch(Exception ex){ 
            System.out.println("Login failed!" + ex); 
        }
       finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (Exception e) {
                }
                rs = null;
            }

            if (stmt != null) {
                try {
                    stmt.close();
                } catch (Exception e) {
                }
                stmt = null;
            }

            if (currentCon != null) {
                try {
                    currentCon.close();
                } catch (Exception e) {
                }

                currentCon = null;
            }
        }

        return bean;
    }
    
    public void addCust(customerBean bean) throws NoSuchAlgorithmException{
         custName = bean.getCustName();
         email = bean.getEmail();
         password = bean.getPassword();
         regDate = bean.getRegDate();
         phoneNo = bean.getPhoneNo();
         deliveryAddress = bean.getDeliveryAddress();
         
         try{
             currentCon = ConnectionManager.getConnection();
             ps = currentCon.prepareStatement("INSERT INTO CUSTOMERS (CUST_NAME, EMAIL, CUST_PASSWORD, PHONE_NO) VALUES (?,?,?,?)");
             //corresponds with the SQL statement^
             ps.setString(1, custName);
             ps.setString(2, email);
             ps.setString(3, password);
             ps.setString(4, phoneNo);
             ps.executeUpdate();
         }
         catch(Exception ex){ 
            System.out.println("An error occurred!" + ex); 
        }
         finally{
             if(ps != null){
                 try{
                     ps.close();
                 }catch(Exception e){}
                 ps = null;
             }
             if(currentCon != null){
                 try{
                     currentCon.close();
                 }catch(Exception e){}
                 currentCon = null;
             }
         }
    }
    
}
