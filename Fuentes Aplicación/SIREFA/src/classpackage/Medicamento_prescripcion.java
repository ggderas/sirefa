package classpackage;


public class Medicamento_prescripcion {
	private String _cantidad;
	private Medicamento _idMedicamento;
	private Prescripcion _idPrescripcion;

    /**
     * @return the _cantidad
     */
    public String getCantidad() {
        return _cantidad;
    }

    /**
     * @param _cantidad the _cantidad to set
     */
    public void setCantidad(String _cantidad) {
        this._cantidad = _cantidad;
    }

    /**
     * @return the _idMedicamento
     */
    public Medicamento getIdMedicamento() {
        return _idMedicamento;
    }

    /**
     * @param _idMedicamento the _idMedicamento to set
     */
    public void setIdMedicamento(Medicamento _idMedicamento) {
        this._idMedicamento = _idMedicamento;
    }

    /**
     * @return the _idPrescripcion
     */
    public Prescripcion getIdPrescripcion() {
        return _idPrescripcion;
    }

    /**
     * @param _idPrescripcion the _idPrescripcion to set
     */
    public void setIdPrescripcion(Prescripcion _idPrescripcion) {
        this._idPrescripcion = _idPrescripcion;
    }
}