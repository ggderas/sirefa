package classpackage;

import classdbpackage.EmpleadoDB;
import java.util.Date;
import java.util.Vector;

public class Empleado 
{
    private String _nombreDeUsuario;
    private String _clave;
    private Date _fechaIngreso;
    private Vector<Roles> _idRol = new Vector<Roles>();
    private Persona persona;
    private Tipo_empleado _idTipoEmpleado;
    private Vector<Cita> _cita = new Vector<Cita>();
    
    private EmpleadoDB empleadoDB;
        
    public Empleado()
    {
        this.persona = new Persona();
        this.empleadoDB = new EmpleadoDB();
    }

    /**
     * @return the _nombreDeUsuario
     */
    public String getNombreDeUsuario() {
        return _nombreDeUsuario;
    }

    /**
     * @param _nombreDeUsuario the _nombreDeUsuario to set
     */
    public void setNombreDeUsuario(String _nombreDeUsuario) {
        this._nombreDeUsuario = _nombreDeUsuario;
    }

    /**
     * @return the _clave
     */
    public String getClave() {
        return _clave;
    }

    /**
     * @param _clave the _clave to set
     */
    public void setClave(String _clave) {
        this._clave = _clave;
    }

    /**
     * @return the _fechaIngreso
     */
    public Date getFechaIngreso() {
        return _fechaIngreso;
    }

    /**
     * @param _fechaIngreso the _fechaIngreso to set
     */
    public void setFechaIngreso(Date _fechaIngreso) {
        this._fechaIngreso = _fechaIngreso;
    }

    /**
     * @return the _idRol
     */
    public Vector<Roles> getIdRol() {
        return _idRol;
    }

    /**
     * @param _idRol the _idRol to set
     */
    public void setIdRol(Vector<Roles> _idRol) {
        this._idRol = _idRol;
    }

    /**
     * @return the _idPersona
     */
    public Persona getIdPersona() {
        return persona;
    }

    /**
     * @param _idPersona the _idPersona to set
     */
    public void setIdPersona(Persona _idPersona) {
        this.persona = _idPersona;
    }

    /**
     * @return the _idTipoEmpleado
     */
    public Tipo_empleado getIdTipoEmpleado() {
        return _idTipoEmpleado;
    }

    /**
     * @param _idTipoEmpleado the _idTipoEmpleado to set
     */
    public void setIdTipoEmpleado(Tipo_empleado _idTipoEmpleado) {
        this._idTipoEmpleado = _idTipoEmpleado;
    }

    /**
     * @return the _cita
     */
    public Vector<Cita> getCita() {
        return _cita;
    }

    /**
     * @param _cita the _cita to set
     */
    public void setCita(Vector<Cita> _cita) {
        this._cita = _cita;
    }

    /**
     * @return the empleadoDB
     */
    public EmpleadoDB getEmpleadoDB() {
        return empleadoDB;
    }

    /**
     * @param empleadoDB the empleadoDB to set
     */
    public void setEmpleadoDB(EmpleadoDB empleadoDB) {
        this.empleadoDB = empleadoDB;
    }
}