package classpackage;

import java.util.Vector;

public class Enfermedades {
	private int _idEnfermedad;
	private String _descripcion;
	private Vector<Diagnostico> _idDiagnostico = new Vector<Diagnostico>();

    /**
     * @return the _idEnfermedad
     */
    public int getIdEnfermedad() {
        return _idEnfermedad;
    }

    /**
     * @param _idEnfermedad the _idEnfermedad to set
     */
    public void setIdEnfermedad(int _idEnfermedad) {
        this._idEnfermedad = _idEnfermedad;
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
     * @return the _idDiagnostico
     */
    public Vector<Diagnostico> getIdDiagnostico() {
        return _idDiagnostico;
    }

    /**
     * @param _idDiagnostico the _idDiagnostico to set
     */
    public void setIdDiagnostico(Vector<Diagnostico> _idDiagnostico) {
        this._idDiagnostico = _idDiagnostico;
    }
}