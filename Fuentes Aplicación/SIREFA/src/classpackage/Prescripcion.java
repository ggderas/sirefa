package classpackage;

import java.util.Vector;

public class Prescripcion {
	private int _idPrescripcion;
	private String _observacion;
	private String _otros;
	private Cita _idCita;
	private Vector<Medicamento_prescripcion> _medicamento_prescripcion = new Vector<Medicamento_prescripcion>();

    /**
     * @return the _idPrescripcion
     */
    public int getIdPrescripcion() {
        return _idPrescripcion;
    }

    /**
     * @param _idPrescripcion the _idPrescripcion to set
     */
    public void setIdPrescripcion(int _idPrescripcion) {
        this._idPrescripcion = _idPrescripcion;
    }

    /**
     * @return the _observacion
     */
    public String getObservacion() {
        return _observacion;
    }

    /**
     * @param _observacion the _observacion to set
     */
    public void setObservacion(String _observacion) {
        this._observacion = _observacion;
    }

    /**
     * @return the _otros
     */
    public String getOtros() {
        return _otros;
    }

    /**
     * @param _otros the _otros to set
     */
    public void setOtros(String _otros) {
        this._otros = _otros;
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

    /**
     * @return the _medicamento_prescripcion
     */
    public Vector<Medicamento_prescripcion> getMedicamento_prescripcion() {
        return _medicamento_prescripcion;
    }

    /**
     * @param _medicamento_prescripcion the _medicamento_prescripcion to set
     */
    public void setMedicamento_prescripcion(Vector<Medicamento_prescripcion> _medicamento_prescripcion) {
        this._medicamento_prescripcion = _medicamento_prescripcion;
    }
}