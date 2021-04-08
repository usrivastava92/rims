package com.rims.generic.utilities;

import java.io.IOException;
import java.util.Map;

import javax.persistence.AttributeConverter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonMapConversionUtility implements AttributeConverter<Map<String, Object>, String> {

	private ObjectMapper objectMapper = new ObjectMapper();

	@Override
	public String convertToDatabaseColumn(Map<String, Object> map) {

		String json = null;
		try {
			json = objectMapper.writeValueAsString(map);
		} catch (final JsonProcessingException e) {
			e.printStackTrace();
		}

		return json;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> convertToEntityAttribute(String json) {

		Map<String, Object> map = null;
		try {
			map = objectMapper.readValue(json, Map.class);
		} catch (final IOException e) {
			e.printStackTrace();
		}

		return map;
	}

}