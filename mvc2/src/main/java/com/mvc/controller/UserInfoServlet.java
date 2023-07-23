package com.mvc.controller;

import java.io.IOException;
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
		// 클라이언트 요청 처리하는 GET 메서드
		// 요청된 URI를 파싱하여 해당하는 작업 수행

		String uri = request.getRequestURI();
		int idx = uri.lastIndexOf("/")+1;
		uri = uri.substring(idx);
		String path = "/WEB-INF/views/";

		if ("list".equals(uri)) {
			// 사용자 목록을 조회하는 경우
			path += "user-info/list.jsp";
			// 사용자 정보 목록을 데이터베이스에서 가져와서 "userInfoList"라는 이름으로 뷰에 전달
			request.setAttribute("userInfoList", uiRepo.selectuserInfoList());
		} else if ("view".equals(uri)) {
			// 특정 사용자 정보를 조회하는 경우
			path += "user-info/view.jsp";
			// 요청 파라미터로 받은 사용자 번호(uiNum)를 이용해 해당 사용자 정보를 데이터베이스에서 조회
			String uiNum = request.getParameter("uiNum");
			// 조회한 사용자 정보를 "userInfo"라는 이름으로 뷰에 전달
			Map<String, String> userInfo = uiRepo.selectuserInfo(uiNum);
			request.setAttribute("userInfo", userInfo);
		} else if ("insert".equals(uri)) {
			// 사용자 정보를 추가하는 페이지를 보여주는 경우
			path += "user-info/insert.jsp";
		} else if ("update".equals(uri)) {
			// 사용자 정보를 수정하는 페이지를 보여주는 경우
			path += "user-info/update.jsp";
		} else if ("delete".equals(uri)) {
			// 사용자 정보를 삭제하는 페이지를 보여주는 경우
			path += "user-info/delete.jsp";
		}

		// 선택된 뷰 페이지로 이동하여 결과 출력, 포워딩
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
