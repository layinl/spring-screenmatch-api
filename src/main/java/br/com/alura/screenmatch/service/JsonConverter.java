package br.com.alura.screenmatch.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonConverter implements DataConverter {

  private final ObjectMapper mapper = new ObjectMapper();

  @Override
  public <T> T convert(String json, Class<T> classOfT) throws JsonProcessingException {
    return mapper.readValue(json, classOfT);
  }

}
