package com.pgms.tw;

import com.pgms.tw.impl.SimpleConfigurationParserImpl;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

/**
 * Factory for {@link ConfigurationParser} instances, which in turn can be used to parse
 * configuration files and return a {@link ConfigurationReader} for interacting with values
 * in those files.
 */
public class ParserFactory {

  private static Map<String, ConfigurationParser> parserMap = new HashMap<>();


  private ParserFactory() {

  }

  /**
   * @return a {@link ConfigurationParser} for the file located at configPath
   */
  public static ConfigurationParser createParser(String configPath) {

    ConfigurationParser parser = parserMap.get(configPath);
    if (parser == null) {
        parser = new SimpleConfigurationParserImpl(configPath);
        parserMap.put(configPath, parser);
    }
    return parser;
  }
}
