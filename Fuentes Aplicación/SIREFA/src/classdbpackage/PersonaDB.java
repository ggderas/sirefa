/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package classdbpackage;

import classpackage.Conexion;
import classpackage.Persona;
import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.SQLException;

/**
 *
 * @author Luis Manuel
 */
public class PersonaDB 
{
    private Persona persona;
    Conexion conexion;
    
    public PersonaDB(Persona persona)
    {
        setPersona(persona);
        this.conexion = new Conexion();
    }
    
    public boolean registrarPersona()
    {
        try
        {
            CallableStatement callStatement = this.conexion.getCallStatement();

            callStatement = this.conexion.getConn().prepareCall("{ CALL SP_GESTIONAR_USUARIOS(?,?,?,?,?,?,?) }");

            //Registrar parámetros de entrada
            callStatement.setString("pcPrimerNombre", this.persona.getPrimerNombre());
            callStatement.setString("pcSegundoNombre", this.persona.getSegundoNombre());
            callStatement.setString("pcPrimerApellido", this.persona.getPrimerApellido());
            callStatement.setString("pcSegundoApellido", this.persona.getSegundoApellido());
            callStatement.setDate("pdFechaNacimiento", this.persona.getFechaSQL());
            callStatement.setString("pcDireccion", this.persona.getDireccion());
            callStatement.setString("pcTelefono", this.persona.getNumeroTelefono());

            callStatement.execute();
            
            return true;
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
            return false;
        }
        
    }
    
    

    /**
     * @return the persona
     */
    public Persona getPersona() {
        return persona;
    }

    /**
     * @param persona the persona to set
     */
    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    
}
