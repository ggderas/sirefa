package classpackage;

import java.util.Vector;

public class Medicamento {
	private int _idMedicamento;
	private String _nombre;
	private Integer _idCategoria;
	private Tipo_medicamento _idTipoMedicamento;
	private Vector<Medicamento_instancia> _medicamento_instancia = new Vector<Medicamento_instancia>();
	private Vector<Medicamento_prescripcion> _medicamento_prescripcion = new Vector<Medicamento_prescripcion>();

    /**
     * @return the _idMedicamento
     */
    public int getIdMedicamento() {
        return _idMedicamento;
    }

    /**
     * @param _idMedicamento the _idMedicamento to set
     */
    public void setIdMedicamento(int _idMedicamento) {
        this._idMedicamento = _idMedicamento;
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
     * @return the _idCategoria
     */
    public Integer getIdCategoria() {
        return _idCategoria;
    }

    /**
     * @param _idCategoria the _idCategoria to set
     */
    public void setIdCategoria(Integer _idCategoria) {
        this._idCategoria = _idCategoria;
    }

    /**
     * @return the _idTipoMedicamento
     */
    public Tipo_medicamento getIdTipoMedicamento() {
        return _idTipoMedicamento;
    }

    /**
     * @param _idTipoMedicamento the _idTipoMedicamento to set
     */
    public void setIdTipoMedicamento(Tipo_medicamento _idTipoMedicamento) {
        this._idTipoMedicamento = _idTipoMedicamento;
    }

    /**
     * @return the _medicamento_instancia
     */
    public Vector<Medicamento_instancia> getMedicamento_instancia() {
        return _medicamento_instancia;
    }

    /**
     * @param _medicamento_instancia the _medicamento_instancia to set
     */
    public void setMedicamento_instancia(Vector<Medicamento_instancia> _medicamento_instancia) {
        this._medicamento_instancia = _medicamento_instancia;
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