package br.com.alura.screenmatch.service;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface DataConverter {

  <T> T convert(String json, Class<T> classOfT) throws JsonProcessingException;

}
