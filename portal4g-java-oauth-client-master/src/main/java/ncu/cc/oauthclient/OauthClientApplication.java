package ncu.cc.oauthclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OauthClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(OauthClientApplication.class, args);
	}

}


//https://portal.ncu.edu.tw/oauth2/authorization
//	?response_type=code
//	&client_id=202311252147033QEHmIcMbB02
//	&scope=identifier%20chinese-name%20english-name%20student-id%20academy-records
//	&state=Xf6iqqxLjO41dFVET174y9STeqETxzrsEwHkswIjDgY%3D
//	&redirect_uri=http://127.0.0.1:8080/login/oauth2/code/client