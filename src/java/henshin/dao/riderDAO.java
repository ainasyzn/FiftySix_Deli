package henshin.dao;

/**
 *
 * @author Aina Syazana
 */
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
//import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import henshin.model.riderBean;
import henshin.connection.ConnectionManager;
public class riderDAO {
    static Connection currentCon = null;
    static ResultSet rs = null; 
    static PreparedStatement ps = null;
    static Statement stmt = null;
    //field ada dalam table
    static int riderID;
    static String riderName;
    static String identificationNo;
    static String riderPhone;
    static String regDate;
    static String status;
    static String plateNo;
    static String username;
    static String password;
    static int adminID;
    
    public static riderBean getRider(riderBean bean){
        riderID = bean.getRiderID();
        
        //SQL command
        String searchQuery = "SELECT * FROM CUSTOMERS WHERE RIDER_ID ='" + riderID + "'";
        
        try{
            currentCon = ConnectionManager.getConnection();
            stmt = currentCon.createStatement();
            rs = stmt.executeQuery(searchQuery);
            boolean more = rs.next();
            
            //rs tu refer to database
            if(more){
                int id = rs.getInt("RIDER_ID");
                bean.setRiderID(id);
                bean.setValid(true);
            }
            else if(!more){
                bean.setValid(false);
            }
        }
        catch(SQLException ex){ 
            System.out.println("Login failed!" + ex); 
        }
       finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                }
                rs = null;
            }

            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                }
                stmt = null;
            }

            if (currentCon != null) {
                try {
                    currentCon.close();
                } catch (SQLException e) {
                }

                currentCon = null;
            }
        }
        return bean;
    }
    
    public void addRider(riderBean bean) throws NoSuchAlgorithmException{
         riderName = bean.getRiderName();
         identificationNo = bean.getIdentificationNo();
         riderPhone = bean.getRiderPhone();
         regDate = bean.getRegDate();
         status = bean.getStatus();
         plateNo = bean.getPlateNo();
         username = bean.getUsername();
         password = bean.getPassword();
         //nanti check balik
         adminID = 1;
         
         try{
             currentCon = ConnectionManager.getConnection();
             ps = currentCon.prepareStatement("INSERT INTO RIDER (RIDER_NAME, RIDER_IC, RIDER_PHONE, REG_DATE, STATUS, PASSWORD, PLATE_NO, ADMIN_ID, USERNAME) VALUES (?,?,?,?,?,?,?,?,?)");
             //corresponds with the SQL statement^
             ps.setString(1, riderName);
             ps.setString(2, identificationNo);
             ps.setString(3, riderPhone);
             ps.setString(4, regDate);
             ps.setString(5, status);
             ps.setString(6, password);
             ps.setString(7, plateNo);
             ps.setInt(8, adminID);
             ps.setString(9, username);
             
             ps.executeUpdate();
         }
         catch(SQLException ex){ 
            System.out.println("An error occurred!" + ex); 
        }
         finally{
             if(ps != null){
                 try{
                     ps.close();
                 }catch(SQLException e){}
                 ps = null;
             }
             if(currentCon != null){
                 try{
                     currentCon.close();
                 }catch(SQLException e){}
                 currentCon = null;
             }
         }
    }
}
