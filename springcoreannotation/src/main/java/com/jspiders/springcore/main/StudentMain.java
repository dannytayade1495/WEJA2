package com.jspiders.springcore.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.
				AnnotationConfigApplicationContext;

import com.jspiders.springcore.beans.StudentBean;
import com.jspiders.springcore.config.StudentConfig;

public class StudentMain {
	
	public static void main(String[] args) {
		
		ApplicationContext context = 
				new AnnotationConfigApplicationContext
					(StudentConfig.class);
		
		StudentBean student2 = (StudentBean) context.
				getBean("student2");
		
		System.out.println(student2);
		
		((AnnotationConfigApplicationContext)context).close();
		
	}

}
