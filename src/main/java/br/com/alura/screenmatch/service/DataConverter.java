package br.com.alura.screenmatch.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataConverter implements IDataConverter {

  private final ObjectMapper mapper = new ObjectMapper();

  @Override
  public <T> T obtainData(String json, Class<T> classOfT) throws JsonProcessingException {
    return mapper.readValue(json, classOfT);
  }

}
