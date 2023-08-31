package com.jspiders.springcore.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support
				.ClassPathXmlApplicationContext;

import com.jspiders.springcore.bean.StudentBean;

public class StudentMain {
	
	public static void main(String[] args) {
		
		ApplicationContext context = 
				new ClassPathXmlApplicationContext
							("StudentConfig.xml");
		
		
		StudentBean student2 = (StudentBean)context.
				getBean("student2");
		
		System.out.println(student2);
		
		((ClassPathXmlApplicationContext)context).close();
	}

}
