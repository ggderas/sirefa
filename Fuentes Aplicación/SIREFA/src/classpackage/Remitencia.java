package classpackage;


public class Remitencia {
	private int _idRemitencia;
	private String _hospital;
	private String _nombreDoctor;
	private Cita _idCita;

    /**
     * @return the _idRemitencia
     */
    public int getIdRemitencia() {
        return _idRemitencia;
    }

    /**
     * @param _idRemitencia the _idRemitencia to set
     */
    public void setIdRemitencia(int _idRemitencia) {
        this._idRemitencia = _idRemitencia;
    }

    /**
     * @return the _hospital
     */
    public String getHospital() {
        return _hospital;
    }

    /**
     * @param _hospital the _hospital to set
     */
    public void setHospital(String _hospital) {
        this._hospital = _hospital;
    }

    /**
     * @return the _nombreDoctor
     */
    public String getNombreDoctor() {
        return _nombreDoctor;
    }

    /**
     * @param _nombreDoctor the _nombreDoctor to set
     */
    public void setNombreDoctor(String _nombreDoctor) {
        this._nombreDoctor = _nombreDoctor;
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