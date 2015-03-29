package classpackage;

import java.util.Vector;

public class Diagnostico {
	private int _idDiagnostico;
	private Vector<Enfermedades> _idEnfermedad = new Vector<Enfermedades>();
	private Cita _idCita;

    /**
     * @return the _idDiagnostico
     */
    public int getIdDiagnostico() {
        return _idDiagnostico;
    }

    /**
     * @param _idDiagnostico the _idDiagnostico to set
     */
    public void setIdDiagnostico(int _idDiagnostico) {
        this._idDiagnostico = _idDiagnostico;
    }

    /**
     * @return the _idEnfermedad
     */
    public Vector<Enfermedades> getIdEnfermedad() {
        return _idEnfermedad;
    }

    /**
     * @param _idEnfermedad the _idEnfermedad to set
     */
    public void setIdEnfermedad(Vector<Enfermedades> _idEnfermedad) {
        this._idEnfermedad = _idEnfermedad;
    }

    /**
     * @return the _idCita
     */
    public Cita getIdCita() {
        return _idCita;
    }

    /**
     * @param _idCita the _idCita to set
     */
    public void setIdCita(Cita _idCita) {
        this._idCita = _idCita;
    }
}