package com.yecao.controller;

import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
import org.springframework.web.servlet.ModelAndView;  
import org.springframework.web.servlet.mvc.Controller; 

public class AddSubjectController implements Controller {

	public ModelAndView handleRequest(HttpServletRequest req,
			HttpServletResponse resp) throws Exception {
		 ModelAndView mv = new ModelAndView();  
	       //���ģ������ �����������POJO����  
	       mv.addObject("message", "Hello World!");  
	       //�����߼���ͼ������ͼ����������ݸ����ֽ������������ͼҳ��  
	       mv.setViewName("addsubject");  
	       return mv;  
	}

	

}
