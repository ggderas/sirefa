package classpackage;

import java.util.Vector;

public class Enfermedades {
	private int idEnfermedad;
	private String descripcion;

    public Enfermedades(int id, String descripcion){
        this.idEnfermedad = id;
        this.descripcion = descripcion;
    }
    /**
     * @return the _idEnfermedad
     */
    public int getIdEnfermedad() {
        return idEnfermedad;
    }

    /**
     * @param idEnfermedad the _idEnfermedad to set
     */
    public void setIdEnfermedad(int idEnfermedad) {
        this.idEnfermedad = idEnfermedad;
    }

    /**
     * @return the _descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param _descripcion the _descripcion to set
     */
    public void setDescripcion(String _descripcion) {
        this.descripcion = _descripcion;
    }
    
    @Override
    public String toString() {
        return descripcion;
    }
}