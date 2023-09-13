package com.jspiders.springrest.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.jspiders.springrest.pojo.AdminPOJO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AdminResponse {

	private String msg;
	private AdminPOJO admin;

}
