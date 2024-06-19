package br.com.alura.screenmatch.service;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface IDataConverter {

  <T> T obtainData(String json, Class<T> classOfT) throws JsonProcessingException;

}
