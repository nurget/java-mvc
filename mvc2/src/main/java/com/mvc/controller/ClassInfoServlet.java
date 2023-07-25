package com.mvc.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.common.CommonView;
import com.mvc.repository.ClassInfoRepository;

public class ClassInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ClassInfoRepository ciRepo = new ClassInfoRepository();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		// 클라이언트 요청 처리하는 GET 메서드
		// 요청된 URI를 파싱하여 해당하는 작업 수행

		String uri = CommonView.getCmd(request);

		if ("list".equals(uri)) {
			request.setAttribute("classInfoList", ciRepo.selectClassInfoList());
		} else if ("view".equals(uri)) {
			String ciNum = request.getParameter("ciNum");
			Map<String, String> classInfo = ciRepo.selectClassInfo(ciNum);
			request.setAttribute("classInfo", classInfo);
		} else if ("update".equals(uri)) {
			String ciNum = request.getParameter("ciNum");
			Map<String,String> classInfo = ciRepo.selectClassInfo(ciNum);
			request.setAttribute("classInfo", classInfo);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		int idx = uri.lastIndexOf("/")+1;
		uri = uri.substring(idx);
		if("insert".equals(uri)) {
			Map<String,String> param = new HashMap<>();
			param.put("ciName", request.getParameter("ciName"));
			param.put("ciDesc", request.getParameter("ciDesc"));
			int result = ciRepo.insertClassinfo(param);
			request.setAttribute("msg", "강의등록에 실패했습니다.");
			request.setAttribute("url", "/class-info/insert");
			if(result == 1) {
				request.setAttribute("msg", "강의등록에 성공했습니다.");
				request.setAttribute("url", "/class-info/list");
			}
			
		}
		CommonView.goMessagePage(request, response);
	}
}
