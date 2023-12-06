package com.phinco.bootcamp.raka;

import com.phinco.bootcamp.raka.model.Account;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RakaApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(RakaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		for (int i = 0; i < 10; i++ ) {
			Account account = new Account();
			account.setId(i);

			System.out.println("Id : " + account.getId());
		}

		boolean max = true;
		int d = 0;
		while (max) {
			d++;
			Account account = new Account();
			account.setId(d);
			System.out.println("while Id : " + account.getId());

			if (d==5) {
				max = false;
			}
		}
	}
}
