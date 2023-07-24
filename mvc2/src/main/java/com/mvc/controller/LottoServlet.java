package com.mvc.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LottoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<String> lotto = new ArrayList<>();

	public LottoServlet() {
		// 중복되지 않는 난수 1-45 6개를 만들어서 lotto에 저장
		Random r = new Random();
		while(lotto.size()<6) {
			String rNum = r.nextInt(45) + 1 + "";
//			 얜 반대로 없으면 true
			if(!lotto.contains(rNum)) { // contains 메서드는 해당 요소가 리스트에 있으면 true, 없으면 flase
				lotto.add(rNum);
			}
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();
		int idx = uri.lastIndexOf("/");
		uri = uri.substring(idx + 1);
		String path = "/WEB-INF/views/";
		if ("lotto".equals(uri)) {
			path += "lotto/lotto.jsp";
		} else if ("comp".equals(uri)) {
			String[] nums = request.getParameterValues("num");
			int correctCount = 0;
			for(String num:nums) {
				if(lotto.contains(num)) {
					correctCount++;
				}
			}
			request.setAttribute("correctCount", correctCount);
			path += "lotto/result.jsp";
		}
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
