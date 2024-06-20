package br.com.alura.screenmatch;

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
import java.util.PriorityQueue;
import java.util.Queue;


@SpringBootApplication
public class ScreenMatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenMatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		String title = "The-Office";
		String json;
		var converter = new JsonConverter();

		json = APIConsumption.getData(STR."https://www.omdbapi.com/?t=\{title}&apikey=7e7539a");
		Series series = converter.convert(json, Series.class);

		json = APIConsumption.getData(STR."https://www.omdbapi.com/?t=\{title}&season=1&episode=2&apikey=7e7539a");
		Episode episode = converter.convert(json, Episode.class);
		System.out.println(series);

		List<Season> seasons = new ArrayList<>();
		for(int i = 1; i <= series.totalSeasons(); i++) {
			json = APIConsumption.getData(STR."https://www.omdbapi.com/?t=\{title}&season=\{i}&apikey=7e7539a");
			Season season = converter.convert(json, Season.class);
			seasons.add(season);
		}
		seasons.forEach(System.out::println);
	}

}
