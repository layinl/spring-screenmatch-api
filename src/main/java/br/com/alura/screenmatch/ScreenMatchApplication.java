package br.com.alura.screenmatch;

import br.com.alura.screenmatch.main.Main;
import br.com.alura.screenmatch.model.Episode;
import br.com.alura.screenmatch.model.Season;
import br.com.alura.screenmatch.model.Series;
import br.com.alura.screenmatch.service.APIConsumption;
import br.com.alura.screenmatch.service.JsonConverter;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;


@SpringBootApplication
public class ScreenMatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenMatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Main main = new Main();
		main.showMenu();
	}

}
