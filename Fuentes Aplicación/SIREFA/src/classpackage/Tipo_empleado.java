package classpackage;

import java.util.Vector;

public class Tipo_empleado {
	private int _idTipo_Empleado;
	private String _descripcion;
	private Vector<Empleado> _empleado = new Vector<Empleado>();

    /**
     * @return the _idTipo_Empleado
     */
    public int getIdTipo_Empleado() {
        return _idTipo_Empleado;
    }

    /**
     * @param _idTipo_Empleado the _idTipo_Empleado to set
     */
    public void setIdTipo_Empleado(int _idTipo_Empleado) {
        this._idTipo_Empleado = _idTipo_Empleado;
    }

    /**
     * @return the _descripcion
     */
    public String getDescripcion() {
        return _descripcion;
    }

    /**
     * @param _descripcion the _descripcion to set
     */
    public void setDescripcion(String _descripcion) {
        this._descripcion = _descripcion;
    }

    /**
     * @return the _empleado
     */
    public Vector<Empleado> getEmpleado() {
        return _empleado;
    }

    /**
     * @param _empleado the _empleado to set
     */
    public void setEmpleado(Vector<Empleado> _empleado) {
        this._empleado = _empleado;
    }
}