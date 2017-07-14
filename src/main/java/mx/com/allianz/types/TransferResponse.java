package mx.com.allianz.types;

import java.math.BigDecimal;

public class TransferResponse {
	private BigDecimal saldoAnteriorOrigen;
	private BigDecimal saldoNuevoOrigen;
	private BigDecimal saldoAnteriorDestino;
	private BigDecimal saldoNuevoDestino;
	
	public BigDecimal getSaldoAnteriorOrigen() {
		return saldoAnteriorOrigen;
	}
	public void setSaldoAnteriorOrigen(BigDecimal saldoAnteriorOrigen) {
		this.saldoAnteriorOrigen = saldoAnteriorOrigen;
	}
	public BigDecimal getSaldoNuevoOrigen() {
		return saldoNuevoOrigen;
	}
	public void setSaldoNuevoOrigen(BigDecimal saldoNuevoOrigen) {
		this.saldoNuevoOrigen = saldoNuevoOrigen;
	}
	public BigDecimal getSaldoAnteriorDestino() {
		return saldoAnteriorDestino;
	}
	public void setSaldoAnteriorDestino(BigDecimal saldoAnteriorDestino) {
		this.saldoAnteriorDestino = saldoAnteriorDestino;
	}
	public BigDecimal getSaldoNuevoDestino() {
		return saldoNuevoDestino;
	}
	public void setSaldoNuevoDestino(BigDecimal saldoNuevoDestino) {
		this.saldoNuevoDestino = saldoNuevoDestino;
	}
	
}
