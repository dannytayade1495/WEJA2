package com.jspiders.studentmanagement.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.jspiders.studentmanagement.pojo.StudentPOJO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StudentResponse {
	
	private String msg;
	private StudentPOJO data;
	private List<StudentPOJO> list;

}
