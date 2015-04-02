/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package classdbpackage;

import classpackage.Conexion;
import classpackage.Empleado;
import classpackage.Persona;

import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.Types;
import java.sql.SQLException;

/**
 *
 * @author Luis Manuel
 */
public class EmpleadoDB 
{
    private Empleado empleado;
    Conexion conexion;
    
    public EmpleadoDB(Empleado empleado)
    {
        this.setEmpleado(empleado);
        this.conexion = new Conexion();
    }
    
    public EmpleadoDB()
    {
        this.conexion = new Conexion();
    }
    
    public String registrarPersona(Empleado empleado)
    {
        Persona persona = empleado.getIdPersona();
        
        String mensajeError = null;
        
        try
        {
            CallableStatement callStatement = this.conexion.getCallStatement();

            callStatement = this.conexion.getConn().prepareCall("{ CALL SP_GESTIONAR_USUARIOS(?,?,?,?,?,?,?, ?,?,?) }");

            //Registrar parámetros de entrada
            callStatement.setString("pcPrimerNombre", persona.getPrimerNombre());
            callStatement.setString("pcSegundoNombre", persona.getSegundoNombre());
            callStatement.setString("pcPrimerApellido", persona.getPrimerApellido());
            callStatement.setString("pcSegundoApellido", persona.getSegundoApellido());
            callStatement.setDate("pdFechaNacimiento", persona.getFechaSQL());
            callStatement.setString("pcDireccion", persona.getDireccion());
            callStatement.setString("pcTelefono", persona.getNumeroTelefono());
            callStatement.setString("pcNombreUsuario", empleado.getNombreDeUsuario());
            callStatement.setString("pcClave", empleado.getClave());
            
            //Registrar parámetro de salida
            callStatement.registerOutParameter("pcMensajeError", Types.VARCHAR);
            
            //Ejecutar PL
            callStatement.execute();
            
            //Obtener parámetro de salida
            mensajeError = callStatement.getString("pcMensajeError");
            
            return mensajeError;
        }
        catch(SQLException e)
        {
            return e.getMessage();
        }
        
    }

    /**
     * @return the empleado
     */
    public Empleado getEmpleado() {
        return empleado;
    }

    /**
     * @param empleado the empleado to set
     */
    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }
    
}
