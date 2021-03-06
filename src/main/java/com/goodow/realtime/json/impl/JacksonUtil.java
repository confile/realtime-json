/*
 * Copyright 2013 Goodow.com
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package com.goodow.realtime.json.impl;

import com.goodow.realtime.json.JsonElement;
import com.goodow.realtime.json.JsonException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.util.List;
import java.util.Map;

public class JacksonUtil {

  private final static ObjectMapper mapper = new ObjectMapper();
  private final static ObjectMapper prettyMapper = new ObjectMapper();

  static {
    // Non-standard JSON but we allow C style comments in our JSON
    mapper.configure(JsonParser.Feature.ALLOW_COMMENTS, true);
    prettyMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
  }

  @SuppressWarnings("unchecked")
  public static <T extends JsonElement> T convert(Object pojo) throws JsonException {
    try {
      if (pojo instanceof List || pojo instanceof Object[]) {
        return (T) new JreJsonArray(mapper.convertValue(pojo, List.class));
      } else {
        return (T) new JreJsonObject(mapper.convertValue(pojo, Map.class));
      }
    } catch (Exception e) {
      throw new JsonException("Failed to convert: " + e.getMessage());
    }
  }

  @SuppressWarnings("unchecked")
  public static <T> T decodeValue(String str, Class<?> clazz) throws JsonException {
    try {
      return (T) mapper.readValue(str, clazz);
    } catch (Exception e) {
      throw new JsonException("Can't parse JSON string: " + e.getMessage());
    }
  }

  public static String encode(Object obj) throws JsonException {
    try {
      return mapper.writeValueAsString(obj);
    } catch (Exception e) {
      throw new JsonException("Failed to encode as JSON: " + e.getMessage());
    }
  }

  public static String encodePrettily(Object obj) throws JsonException {
    try {
      return prettyMapper.writeValueAsString(obj);
    } catch (Exception e) {
      throw new JsonException("Failed to encode as JSON: " + e.getMessage());
    }
  }
}