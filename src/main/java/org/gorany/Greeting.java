package org.gorany;

import lombok.Data;

@Data
public class Greeting {

	private String content;
	
	public Greeting() {
    }

    public Greeting(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

}

/*-----------주의할 점----------------------------------
모든 클래스는  메인함수가 실행 되는 곳에 만들어야 하는듯,...,.       ㅣ 
config 클래스의 register웅앵웅 메소드의 경로는 .js와 맞춰야 함        ㅣ
웹 프로젝트 셋팅에서 /로 꼭 바꿔야 한다                                                 ㅣ
메인.css는 필요 없는듯 하다(아직은....)                      ㅣ  
실행 경로는 http://localhost:8080/                      ㅣ
물론 다른 접속자는 10.10.10.87 /name 
https://spring.io/guides/gs/messaging-stomp-websocket/                          ㅣ
------------------------------------------------------*/
