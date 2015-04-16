/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classdbpackage;

import classpackage.Conexion;
import classpackage.Enfermedades;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import javax.swing.JDialog;


/**
 *
 * @author ClaudioPaz
 */
public class EnfermedadDB {
 
    private Enfermedades emfermedad;
    Conexion conexion;
    
    public EnfermedadDB(){
        conexion = new Conexion();
    }
    
    public ArrayList<Enfermedades> ObtenerEnfermedadesEnfermedadDB(){
        
        ArrayList<Enfermedades> Enfermedades = new ArrayList<Enfermedades>();
        
        Connection cn = null;
        CallableStatement cl = null;
        ResultSet rs = null;
        
        try
        {
            String call ="{call SP_Obtener_enfermedades()}";
            cn = Conexion.getConexion();
            cl = cn.prepareCall(call);
            // La sentencia la alamacenamos en un result set
            rs = cl.executeQuery();
            /*
                Consultamos si hay datos con el while para recorrer y meterlos en la lista
            */
            while(rs.next()){
                
                Enfermedades.add(new Enfermedades(rs.getInt(" idEnfermedad"),rs.getString("Descripcion")));
                
            }
            Conexion.cerrarCall(cl);
            Conexion.cerrarConexion(cn);
        }catch(SQLException e){
            e.getSQLState();
            e.printStackTrace();
        }
        return Enfermedades;
    }
}
