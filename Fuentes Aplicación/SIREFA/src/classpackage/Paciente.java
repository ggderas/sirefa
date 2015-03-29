package classpackage;

import java.util.Vector;

public class Paciente {
	private Persona _idPersona;
	private Vector<Cita> _cita = new Vector<Cita>();

    /**
     * @return the _idPersona
     */
    public Persona getIdPersona() {
        return _idPersona;
    }

    /**
     * @param _idPersona the _idPersona to set
     */
    public void setIdPersona(Persona _idPersona) {
        this._idPersona = _idPersona;
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
}