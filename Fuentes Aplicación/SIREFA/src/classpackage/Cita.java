package classpackage;

import java.util.Vector;

public class Cita {
	private int _idCita;
	private String _fecha;
	private Paciente _idPersona;
	private Empleado _idEmpleado;
	private Vector<Diagnostico> _diagnostico = new Vector<Diagnostico>();
	private Vector<Info_preclinica> _info_preclinica = new Vector<Info_preclinica>();
	private Vector<Prescripcion> _prescripcion = new Vector<Prescripcion>();
	private Vector<Remitencia> _remitencia = new Vector<Remitencia>();

    /**
     * @return the _idCita
     */
    public int getIdCita() {
        return _idCita;
    }

    /**
     * @param _idCita the _idCita to set
     */
    public void setIdCita(int _idCita) {
        this._idCita = _idCita;
    }

    /**
     * @return the _fecha
     */
    public String getFecha() {
        return _fecha;
    }

    /**
     * @param _fecha the _fecha to set
     */
    public void setFecha(String _fecha) {
        this._fecha = _fecha;
    }

    /**
     * @return the _idPersona
     */
    public Paciente getIdPersona() {
        return _idPersona;
    }

    /**
     * @param _idPersona the _idPersona to set
     */
    public void setIdPersona(Paciente _idPersona) {
        this._idPersona = _idPersona;
    }

    /**
     * @return the _idEmpleado
     */
    public Empleado getIdEmpleado() {
        return _idEmpleado;
    }

    /**
     * @param _idEmpleado the _idEmpleado to set
     */
    public void setIdEmpleado(Empleado _idEmpleado) {
        this._idEmpleado = _idEmpleado;
    }

    /**
     * @return the _diagnostico
     */
    public Vector<Diagnostico> getDiagnostico() {
        return _diagnostico;
    }

    /**
     * @param _diagnostico the _diagnostico to set
     */
    public void setDiagnostico(Vector<Diagnostico> _diagnostico) {
        this._diagnostico = _diagnostico;
    }

    /**
     * @return the _info_preclinica
     */
    public Vector<Info_preclinica> getInfo_preclinica() {
        return _info_preclinica;
    }

    /**
     * @param _info_preclinica the _info_preclinica to set
     */
    public void setInfo_preclinica(Vector<Info_preclinica> _info_preclinica) {
        this._info_preclinica = _info_preclinica;
    }

    /**
     * @return the _prescripcion
     */
    public Vector<Prescripcion> getPrescripcion() {
        return _prescripcion;
    }

    /**
     * @param _prescripcion the _prescripcion to set
     */
    public void setPrescripcion(Vector<Prescripcion> _prescripcion) {
        this._prescripcion = _prescripcion;
    }

    /**
     * @return the _remitencia
     */
    public Vector<Remitencia> getRemitencia() {
        return _remitencia;
    }

    /**
     * @param _remitencia the _remitencia to set
     */
    public void setRemitencia(Vector<Remitencia> _remitencia) {
        this._remitencia = _remitencia;
    }
}