package com.mvc;

// 생성자는 데이터 타입 X, 클래스명과 대소문자까지 동일해야 함.
public class Constructor {
	int num;

	public Constructor() { 
		System.out.println(num);
	}
	
	public Constructor(int num) { 
		this.num = num;
		System.out.println(num);
	}
}

class Execute {
	public static void main(String[] args) {
		Constructor c = new Constructor(80);
		System.out.println(c.num);
	}
}
