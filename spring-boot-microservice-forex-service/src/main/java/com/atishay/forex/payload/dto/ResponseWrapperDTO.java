package com.atishay.forex.payload.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/***
 * This class indicates response object when there is no errors from from API.
 * 
 * @author vishvas
 *
 */
@JsonInclude(Include.NON_EMPTY)
public class ResponseWrapperDTO {

	private Integer status;
	private String message;
	private Object data;

	private String path;

	public ResponseWrapperDTO() {
	}

	public ResponseWrapperDTO(Integer status, String path, String message) {
		this.status = status;
		this.path = path;
		this.message = message;
	}

	public ResponseWrapperDTO(Integer status, String path, String message, Object data) {
		super();
		this.status = status;
		this.path = path;
		this.message = message;
		this.data = data;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

}
