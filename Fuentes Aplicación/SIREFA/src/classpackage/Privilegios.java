package classpackage;

import java.util.Vector;

public class Privilegios {
	private int _idPrivilegio;
	private String _nombre;
	private Vector<Roles> _idRol = new Vector<Roles>();

    /**
     * @return the _idPrivilegio
     */
    public int getIdPrivilegio() {
        return _idPrivilegio;
    }

    /**
     * @param _idPrivilegio the _idPrivilegio to set
     */
    public void setIdPrivilegio(int _idPrivilegio) {
        this._idPrivilegio = _idPrivilegio;
    }

    /**
     * @return the _nombre
     */
    public String getNombre() {
        return _nombre;
    }

    /**
     * @param _nombre the _nombre to set
     */
    public void setNombre(String _nombre) {
        this._nombre = _nombre;
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
}