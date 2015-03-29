package classpackage;

import java.util.Date;

public class Medicamento_instancia {
	private int _idMedicamento_Instancia;
	private int _cantidad;
	private Date _fechaIngreso;
	private Date _fechaVencimiento;
	private Medicamento _idMedicamento;

    /**
     * @return the _idMedicamento_Instancia
     */
    public int getIdMedicamento_Instancia() {
        return _idMedicamento_Instancia;
    }

    /**
     * @param _idMedicamento_Instancia the _idMedicamento_Instancia to set
     */
    public void setIdMedicamento_Instancia(int _idMedicamento_Instancia) {
        this._idMedicamento_Instancia = _idMedicamento_Instancia;
    }

    /**
     * @return the _cantidad
     */
    public int getCantidad() {
        return _cantidad;
    }

    /**
     * @param _cantidad the _cantidad to set
     */
    public void setCantidad(int _cantidad) {
        this._cantidad = _cantidad;
    }

    /**
     * @return the _fechaIngreso
     */
    public Date getFechaIngreso() {
        return _fechaIngreso;
    }

    /**
     * @param _fechaIngreso the _fechaIngreso to set
     */
    public void setFechaIngreso(Date _fechaIngreso) {
        this._fechaIngreso = _fechaIngreso;
    }

    /**
     * @return the _fechaVencimiento
     */
    public Date getFechaVencimiento() {
        return _fechaVencimiento;
    }

    /**
     * @param _fechaVencimiento the _fechaVencimiento to set
     */
    public void setFechaVencimiento(Date _fechaVencimiento) {
        this._fechaVencimiento = _fechaVencimiento;
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
}