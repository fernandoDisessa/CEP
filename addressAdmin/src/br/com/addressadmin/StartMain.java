package br.com.addressadmin;

import java.util.HashMap;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
@EnableAutoConfiguration
public class StartMain {

	public static void main(String[] args) throws Exception {
		
		HashMap<String, Object> props = new HashMap<>();
		props.put("server.port", 9999);

		
		new SpringApplicationBuilder()
	    .sources(StartMain.class)                
	    .properties(props)
	    .run(args);
		
	 
	}

}
