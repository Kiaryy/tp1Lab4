package utn.supercell.TP1;

import java.time.LocalDate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Tp1BackEnd {

	public static void main(String[] args) {
		SpringApplication.run(Tp1BackEnd.class, args);
				System.out.println("BACKEND INITIALIZED AT: " + LocalDate.now());
	}

}
