package com.mvc;

class ParamConstructor {
	ParamConstructor(String str) {
		
	}
}

public class Constructor3 extends ParamConstructor {

	public Constructor3() {
		super("정의"); // 괄호 안에 넣어도 그만 안넣어도 그만, 생략 가능
		// 상속을 받는 순간 정의를 해줘야 함
	}
}

class Exam {
	public static void main(String[] args) {
		new Constructor3();
	}
}
