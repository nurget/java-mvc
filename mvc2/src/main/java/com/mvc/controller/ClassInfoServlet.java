package com.mvc.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.repository.ClassInfoRepository;

public class ClassInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ClassInfoRepository ciRepo = new ClassInfoRepository();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		// 클라이언트 요청 처리하는 GET 메서드
		// 요청된 URI를 파싱하여 해당하는 작업 수행

		String uri = request.getRequestURI();
		int idx = uri.lastIndexOf("/")+1;
		uri = uri.substring(idx);
		String path = "/WEB-INF/views/";

		if ("list".equals(uri)) {
			path += "class-info/list.jsp";
			request.setAttribute("classInfoList", ciRepo.selectClassInfoList());
		} else if ("view".equals(uri)) {
			path += "class-info/view.jsp";
			String ciNum = request.getParameter("ciNum");
			Map<String, String> classInfo = ciRepo.selectClassInfo(ciNum);
			request.setAttribute("classInfo", classInfo);
		} else if ("insert".equals(uri)) {
			path += "class-info/insert.jsp";
		} else if ("update".equals(uri)) {
			path += "class-info/update.jsp";
		} else if ("delete".equals(uri)) {
			path += "class-info/delete.jsp";
		}

		// 선택된 뷰 페이지로 이동하여 결과 출력, 포워딩
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
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
		RequestDispatcher rd = request.getRequestDispatcher(uri);
		rd.forward(request, response);
	}
}
