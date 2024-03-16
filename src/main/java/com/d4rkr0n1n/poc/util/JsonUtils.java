package com.d4rkr0n1n.poc.util;

import java.util.Map;

import org.json.JSONObject;

public class JsonUtils {

  private JsonUtils() {
    // This utility class is not publicly instantiable
  }

  public static JSONObject toJSONObject(Map<String, Object> data) {
    return new JSONObject(data);
  }

  public static String toJson(Map<String, Object> data) {
    return toJSONObject(data).toString();
  }

}
