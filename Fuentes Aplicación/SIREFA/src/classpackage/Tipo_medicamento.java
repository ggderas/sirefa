package classpackage;

import java.util.Vector;

public class Tipo_medicamento {
	private int _idTipo_Medicamento;
	private String _descripcion;
	private Vector<Medicamento> _medicamento = new Vector<Medicamento>();

    /**
     * @return the _idTipo_Medicamento
     */
    public int getIdTipo_Medicamento() {
        return _idTipo_Medicamento;
    }

    /**
     * @param _idTipo_Medicamento the _idTipo_Medicamento to set
     */
    public void setIdTipo_Medicamento(int _idTipo_Medicamento) {
        this._idTipo_Medicamento = _idTipo_Medicamento;
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
     * @return the _medicamento
     */
    public Vector<Medicamento> getMedicamento() {
        return _medicamento;
    }

    /**
     * @param _medicamento the _medicamento to set
     */
    public void setMedicamento(Vector<Medicamento> _medicamento) {
        this._medicamento = _medicamento;
    }
}