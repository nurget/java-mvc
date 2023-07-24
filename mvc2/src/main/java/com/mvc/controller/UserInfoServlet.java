package com.mvc.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.repository.UserInfoRepository;

public class UserInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserInfoRepository uiRepo = new UserInfoRepository();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		int idx = uri.lastIndexOf("/")+1;
		uri = uri.substring(idx);
		String path = "/WEB-INF/views/";
		if("list".equals(uri)) {
			path += "user-info/list.jsp";
			request.setAttribute("userInfoList", uiRepo.selectuserInfoList());
		}else if("view".equals(uri)) {
			path += "user-info/view.jsp";
			String uiNum = request.getParameter("uiNum");
			Map<String,String> userInfo = uiRepo.selectUserInfo(uiNum);
			request.setAttribute("userInfo", userInfo);
		}else if("insert".equals(uri)) {
			path += "user-info/insert.jsp";
		}else if("update".equals(uri)) {
			path += "user-info/update.jsp";
			String uiNum = request.getParameter("uiNum");
			Map<String,String> userInfo = uiRepo.selectUserInfo(uiNum);
			request.setAttribute("userInfo", userInfo);
		}else if("delete".equals(uri)) {
			path += "user-info/delete.jsp";
		}
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String uri = request.getRequestURI();
		int idx = uri.lastIndexOf("/")+1;
		uri = uri.substring(idx);
		String path = "/WEB-INF/views/common/msg.jsp";
		if("insert".equals(uri)) {
			Map<String,String> param = new HashMap<>();
			param.put("uiId", request.getParameter("uiId"));
			param.put("uiPwd", request.getParameter("uiPwd"));
			param.put("uiName", request.getParameter("uiName"));
			int result = uiRepo.insertUserInfo(param);
			request.setAttribute("msg", "회원등록이 실패하였습니다.");
			request.setAttribute("url", "/user-info/insert");
			if(result==1) {
				request.setAttribute("msg", "회원등록이 성공하였습니다.");
				request.setAttribute("url", "/user-info/list");
			}
		}else if("update".equals(uri)) {
			Map<String,String> param = new HashMap<>();
			param.put("uiId", request.getParameter("uiId"));
			param.put("uiPwd", request.getParameter("uiPwd"));
			param.put("uiName", request.getParameter("uiName"));
			param.put("uiNum", request.getParameter("uiNum"));
			
		}
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}

}
