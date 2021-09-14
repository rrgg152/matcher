package com.rookie.shared.infrastructure;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rookie.shared.infrastructure.utils.Utils;

import io.swagger.v3.oas.annotations.media.Schema;

public class HttpResponse {
	  public static final String ACR="MATCHER";
	  
	   @Schema(description = "Identificador de la petición", 
	            example = "MATCHER-202102091130189044557", required = true)
	  private String id;

	   @Schema(description = "Contenido de la respuesta", 
	            example = "", required = true)
	  private Collection<?> body;
	   
	   @Schema(description = "Fecha de la respuesta", 
	            example = "2021-02-09", required = true)
	  private String timestamp;
	   
	   @Schema(description = "Código compuesto por respuesta http", 
	            example = "200", required = true)
	  private int codigo;


	  public HttpResponse(String id, Collection<?> body, String timestamp, int codigo) {
		this.id = id;
		this.body = body;
		this.timestamp = timestamp;
		this.codigo = codigo;
	}


	  public static HttpResponse responseWithError(int codigo, Collection<?> errores) {
	    return new HttpResponse(generateId(),
		  errores,
		  generateTimeStamp(),
		  codigo);
	  }

	  public static HttpResponse responseOk(int codigo, Collection<?> body) {
	    return new HttpResponse(generateId(), body,
		  generateTimeStamp(), codigo);
	  }
	  
	  public static String JsonResponseWithBody(Collection<?> body, int codigo) {
		  try {
			return new ObjectMapper().writeValueAsString(responseOk(codigo, body));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return null;
		}
	  }
	  
	  private static String generateId() {
	    SimpleDateFormat sdf =
		  new SimpleDateFormat("YYYYMMddHHmmSS");
	    String date=sdf.format(new Date());
	    Random rnd = new Random();
	    String random=String.format("%06d", rnd.nextInt(999999));
	    return ACR + "-" + date + random;
	  }

	  private static String generateTimeStamp() {
	    return Utils.dateToString(LocalDateTime.now());
	  }

	  public String timestamp() {
	    return timestamp;
	  }

	  public int codigo() {
	    return codigo;
	  }

	  public String getTimestamp() {
	    return timestamp;
	  }

	  public int getCodigo() {
	    return codigo;
	  }

	  public void setTimestamp(String timestamp) {
	    this.timestamp = timestamp;
	  }

	  public void setCodigo(int codigo) {
	    this.codigo = codigo;
	  }


	  public String getId() {
	    return id;
	  }

	  public void setId(String id) {
	    this.id = id;
	  }

	  public Collection<?> getBody() {
	    return body;
	  }

	  public void setBody(List<HashMap<String, String>> body) {
	    this.body = body;
	  }
}