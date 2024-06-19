package br.com.alura.screenmatch;

import br.com.alura.screenmatch.model.Series;
import br.com.alura.screenmatch.service.APIConsumption;
import br.com.alura.screenmatch.service.DataConverter;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class ScreenMatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenMatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		String title = "The-Office";
		String json;
		var converter = new DataConverter();

		json = APIConsumption.getData(STR."https://www.omdbapi.com/?t=\{title}&apikey=7e7539a");
		Series series = converter.obtainData(json, Series.class);
		System.out.println(series);
	}

}
