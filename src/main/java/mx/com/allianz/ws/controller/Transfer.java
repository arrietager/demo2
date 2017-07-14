package mx.com.allianz.ws.controller;

import java.math.BigDecimal;
import java.util.Map;

import javax.sql.DataSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import mx.com.allianz.types.TransferRequest;
import mx.com.allianz.types.TransferResponse;

@RestController
public class Transfer {
	
	private DataSource dataSource;
	
	public Transfer(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/transfer")
	public ResponseEntity<TransferResponse> execute(@RequestBody TransferRequest request){
//		System.out.println("Cuenta origen = " + request.getCuentaOrigen());
//		System.out.println("Cuenta destino = " + request.getCuentaDestino());
//		System.out.println("Monto = " + request.getMonto());
		
		MapSqlParameterSource input = new MapSqlParameterSource();
		
		input.addValue("CUENTAORIGEN", request.getCuentaOrigen());
		input.addValue("CUENTADESTINO", request.getCuentaDestino());
		input.addValue("MONTO", request.getMonto());
		
		SimpleJdbcCall sp = new SimpleJdbcCall(this.dataSource);
		sp.withProcedureName("TRANSFERENORACLE");
		Map<String, Object> output = sp.execute(input);
		
		TransferResponse response = new TransferResponse();
		
		response.setSaldoAnteriorOrigen((BigDecimal)output.get("SALDOANTERIORORIGEN"));
		response.setSaldoNuevoOrigen((BigDecimal)output.get("SALDONUEVOORIGEN"));
		response.setSaldoAnteriorDestino((BigDecimal)output.get("SALDOANTERIORDESTINO"));
		response.setSaldoNuevoDestino((BigDecimal)output.get("SALDONUEVODESTINO"));
		
		return new ResponseEntity<TransferResponse>(response, HttpStatus.OK);
	}
}
