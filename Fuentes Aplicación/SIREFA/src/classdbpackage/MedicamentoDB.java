/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package classdbpackage;

import classpackage.Conexion;
import classpackage.Medicamento;
import classpackage.Tipo_medicamento;

import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author Luis Manuel
 */
public class MedicamentoDB 
{
    private Medicamento medicamento;
    private Conexion conexion;
    private ResultSet resultSet;
    
    public MedicamentoDB()
    {
        this.conexion = new Conexion();
    }
    
    public MedicamentoDB(Medicamento medicamento)
    {
        this.setMedicamento(medicamento);
        this.conexion = new Conexion();
    }
    
    
    public String registrarMedicamento(Medicamento medicamento)
    {
        try
        {
            String mensajeError = null;

            CallableStatement callStatement = this.conexion.getCallStatement();

            callStatement = this.conexion.getConn().prepareCall("{CALL SP_REGISTRAR_MEDICAMENTO(?,?,?) }");

            //Registrar parámetros de entrada
            callStatement.setString("pcNombreMedicamento", medicamento.getNombre());
            callStatement.setInt("pnCodigoTipoMedicamento", 
                            medicamento.getIdTipoMedicamento().getIdTipo_Medicamento());;
            
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
    
    public ArrayList<Medicamento> obtenerMedicamentos()
    {
        try
        {
            ArrayList<Medicamento> listaMedicamentos = new ArrayList<Medicamento>();
            String mensajeError = null;

            CallableStatement callStatement = this.conexion.getCallStatement();

            callStatement = this.conexion.getConn().prepareCall("{CALL SP_OBTENER_MEDICAMENTOS(?) }");
            
            //Registrar parámetro de salida
            callStatement.registerOutParameter("pcMensajeError", Types.VARCHAR);

            //Ejecutar PL
            callStatement.execute();
            
            //Obtener parámetro de salida
            mensajeError = callStatement.getString("pcMensajeError");
            
            if(mensajeError != null)
            {
                return null;
            }
            
            //Obtener select (result set)
            this.resultSet = callStatement.getResultSet();
            
            while(this.resultSet.next())
            {
                Tipo_medicamento tipoMedicamento =  new Tipo_medicamento(this.resultSet.getInt("idTipoMedicamento"));
                
                Medicamento medicamento = new Medicamento(this.resultSet.getInt("idMedicamento"),
                                        this.resultSet.getString("nombre"), tipoMedicamento);
                
                listaMedicamentos.add(medicamento);
            }
            
            return listaMedicamentos;

        }
        catch(SQLException e)
        {
            return null;
        }     
    }
    
    
    
    

    /**
     * @return the medicamento
     */
    public Medicamento getMedicamento() {
        return medicamento;
    }

    /**
     * @param medicamento the medicamento to set
     */
    public void setMedicamento(Medicamento medicamento) {
        this.medicamento = medicamento;
    }
    
}
