package com.atishay.forex.payload.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/***
 * This class indicates response object when any error exists from API.
 * 
 * @author vishvas
 *
 */
@JsonInclude(Include.NON_EMPTY)
public class ResponseErrorDTO extends ResponseWrapperDTO {

	private String error;

	public ResponseErrorDTO() {
	}

	public ResponseErrorDTO(Integer status, String path, String error) {
		super.setStatus(status);
		super.setPath(path);
		this.error = error;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

}
