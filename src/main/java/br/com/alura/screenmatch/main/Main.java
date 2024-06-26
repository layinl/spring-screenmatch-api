package br.com.alura.screenmatch.main;

import br.com.alura.screenmatch.model.Episode;
import br.com.alura.screenmatch.model.Season;
import br.com.alura.screenmatch.model.Series;
import br.com.alura.screenmatch.service.APIConsumption;
import br.com.alura.screenmatch.service.JsonConverter;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

  private final String URL = "https://www.omdbapi.com/?t=";
  private final String API_KEY = "&apikey=7e7539a";

  private Scanner scan = new Scanner(System.in);
  private JsonConverter converter = new JsonConverter();

  public void showMenu() throws JsonProcessingException {
    System.out.println("Please type the series name to search");
    var seriesName = scan.nextLine().replace(" ", "+");
    var json = APIConsumption.getData(STR."\{URL}\{seriesName}\{API_KEY}");
    Series series = converter.convert(json, Series.class);
    System.out.println(series);

    List<Season> seasons = new ArrayList<>();
		for(int i = 1; i <= series.totalSeasons(); i++) {
			json = APIConsumption.getData(STR."https://www.omdbapi.com/?t=\{seriesName}&season=\{i}&apikey=7e7539a");
			Season season = converter.convert(json, Season.class);
			seasons.add(season);
		}
		seasons.forEach(System.out::println);

    seasons.forEach(s -> {
      s.episodes().forEach(e -> {
        System.out.println(e.title());
      });
    });

  }

}
