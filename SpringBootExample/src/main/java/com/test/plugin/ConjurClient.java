package com.test.plugin;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cyberark.conjur.springboot.annotations.ConjurPropertySource;
import com.cyberark.conjur.springboot.annotations.ConjurValue;

@SpringBootApplication
@ConjurPropertySource(value={"db/"})
public class ConjurClient implements CommandLineRunner{

	private static Logger logger = LoggerFactory.getLogger(ConjurClient.class);

	@Value("${password}")
	private String pass;

	@Value("${dbuserName}")
	private String pass1;

	@Value("${dbpassWord}")
	private String pass2;

	@Value("${key}")
	private String pass3;

	@ConjurValue(key="db/password")
	private String customVal;

    public static void main(String[] args) {
        SpringApplication.run(ConjurClient.class, args);
    }

	@Override
	public void run(String... args) throws Exception {
		logger.info("By Using Standard Spring annotation -->  " + pass + "  " );
		logger.info("By Using Custom annotation -->"+customVal);
		System.out.println("By Using Custom annotation -->"+pass);
		System.out.println("By Using Custom annotation -->"+customVal);

		System.out.println("By Using Custom annotation -->"+pass1);
		System.out.println("By Using Custom annotation -->"+customVal);

		System.out.println("By Using Custom annotation -->"+pass2);
		System.out.println("By Using Custom annotation -->"+customVal);

		System.out.println("By Using Custom annotation -->"+pass3);
		System.out.println("By Using Custom annotation -->"+customVal);
	}
}
