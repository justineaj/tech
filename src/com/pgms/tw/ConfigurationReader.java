package com.pgms.tw;

import java.util.List;
import java.util.Optional;

/**
 * Supports interaction with the keys and values of a parsed configuration file.
 */
public interface ConfigurationReader {
  /**
   * @return true if any config values exist for the given key
   */
  boolean hasKey(String key);

  /**
   * @return the value at the given key; an empty {@link Optional} if no config values exist
   * for the given key
   */
  Optional<Object> get(String key);

  /**
   * @return the boolean value at the given key; if no boolean value is associated with the key,
   * an empty {@link Optional}
   */
  Optional<Boolean> getBoolean(String key);

  /**
   * @return the list of booleans at the given key; null if a boolean list is not associated with
   * that key
   */
  List<Boolean> getBooleanList(String key);

  /**
   * @return the numeric value at the given key; if no numeric value is associated with the key,
   * an empty {@link Optional}
   */
  Optional<Number> getNumber(String key);


  /**
   * @return the list of numerics at the given key; null if a numeric list is not associated with
   * that key
   */
  List<Number> getNumberList(String key);

  /**
   * @return the string value at the given key; if no string value is associated with the key,
   * an empty {@link Optional}
   */
  Optional<String> getString(String key);

  /**
   * @return the list of string at the given key; null if a string list is not associated with
   * that key
   */
  List<String> getStringList(String key);
}
