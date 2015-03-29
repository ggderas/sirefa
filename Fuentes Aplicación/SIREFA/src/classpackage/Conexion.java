/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classpackage;

import java.sql.*;
import java.sql.PreparedStatement;

/**
 *
 * @author Luis Manuel
 */
public class Conexion 
{
   private static String DRIVER = "com.mysql.jdbc.Driver";  
   private static String HOSTURL = "jdbc:mysql://localhost:3306/sirefa";

   //Credenciales 
   private static String USER = "root";
   static final String PASS = "";
   
   private Connection conn;
   private CallableStatement callStatement;
   private PreparedStatement prepStatement;
   private ResultSet reader;
   
   public Conexion()
   {
       try
       {
           Class.forName(DRIVER);
           this.conn = DriverManager.getConnection(HOSTURL, USER, PASS);
       }
       catch(Exception e)
       {
           System.out.println(e.getMessage());
       }
   }

    /**
     * @return the DRIVER
     */
    public static String getDRIVER() {
        return DRIVER;
    }

    /**
     * @param aDRIVER the DRIVER to set
     */
    public static void setDRIVER(String aDRIVER) {
        DRIVER = aDRIVER;
    }

    /**
     * @return the HOSTURL
     */
    public static String getHOSTURL() {
        return HOSTURL;
    }

    /**
     * @param aHOSTURL the HOSTURL to set
     */
    public static void setHOSTURL(String aHOSTURL) {
        HOSTURL = aHOSTURL;
    }

    /**
     * @return the USER
     */
    public static String getUSER() {
        return USER;
    }

    /**
     * @param aUSER the USER to set
     */
    public static void setUSER(String aUSER) {
        USER = aUSER;
    }
   
   
   


    /**
     * @return the conn
     */
    public Connection getConn() {
        return conn;
    }

    /**
     * @param conn the conn to set
     */
    public void setConn(Connection conn) {
        this.conn = conn;
    }

    /**
     * @return the callStatement
     */
    public CallableStatement getCallStatement() {
        return callStatement;
    }

    /**
     * @param callStatement the callStatement to set
     */
    public void setCallStatement(CallableStatement callStatement) {
        this.callStatement = callStatement;
    }

    /**
     * @return the prepStatement
     */
    public PreparedStatement getPrepStatement() {
        return prepStatement;
    }

    /**
     * @param prepStatement the prepStatement to set
     */
    public void setPrepStatement(PreparedStatement prepStatement) {
        this.prepStatement = prepStatement;
    }

    /**
     * @return the reader
     */
    public ResultSet getReader() {
        return reader;
    }

    /**
     * @param reader the reader to set
     */
    public void setReader(ResultSet reader) {
        this.reader = reader;
    }
   
}
