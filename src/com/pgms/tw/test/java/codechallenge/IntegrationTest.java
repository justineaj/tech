//package com.pgms.twitter.test.java.codechallenge;
//
//import static org.hamcrest.MatcherAssert.assertThat;
//import static org.hamcrest.Matchers.*;
//
//import java.util.List;
//import java.util.Optional;
//
//import com.pgms.tw.ConfigurationParser;
//import com.pgms.tw.ConfigurationReader;
//import com.pgms.tw.ParserFactory;
//import org.junit.Test;
//
///*
//  Exercises basic functionality of the parser and resulting configuration.
//
//  This file is intended to provide a basic test style and to provide
//  examples for some of the more nuanced features of the configuration
//  format and behavior.
// */
//public class IntegrationTest {
//  private String configPath = "src/test/resources/test.config";
//
//  // Parses string values
//  @Test
//  public void parsesStringValues() {
//    ConfigurationReader config = getConfig(configPath);
//
//    Optional<String> result = config.getString("user.email");
//
//    assertThat(result.orElse(""), equalTo("alice.sykes@gmail.com"));
//  }
//
//  // Parses integer values
//  @Test
//  public void parsesIntegerValues() {
//    ConfigurationReader config = getConfig(configPath);
//
//    Optional<Number> result = config.getNumber("user.id");
//
//    assertThat(result.map(Number::intValue).orElse(0), equalTo(641220));
//  }
//
//  // Parses decimal values
//  @Test
//  public void parsesDecimalValues() {
//    ConfigurationReader config = getConfig(configPath);
//
//    Optional<Number> result = config.getNumber("color.transparency");
//
//    assertThat(result.map(Number::doubleValue).orElse(0d), equalTo(75.5));
//  }
//
//  // Parses (truthy) boolean values
//  @Test
//  public void parsesBooleanGivenTruthyValue() {
//    ConfigurationReader config = getConfig(configPath);
//
//    Optional<Boolean> result = config.getBoolean("color.ui");
//
//    assertThat(result.orElse(false), is(true));
//  }
//
//  // Parses (false-y) boolean values
//  @Test
//  public void parsesBooleanGivenFalseyValue() {
//    ConfigurationReader config = getConfig(configPath);
//
//    Optional<Boolean> result = config.getBoolean("core.preloadindex");
//
//    assertThat(result.orElse(true), is(false));
//  }
//
//  // Parses quoted string values
//  @Test
//  public void parsesQuotedStringValues() {
//    ConfigurationReader config = getConfig(configPath);
//
//    Optional<String> result = config.getString("user.name");
//
//    assertThat(result.orElse(""), equalTo("Alice Sykes"));
//  }
//
//  // Parses list values
//  @Test
//  public void parsesListValues() {
//    ConfigurationReader config = getConfig(configPath);
//
//    List<String> resultList = config.getStringList("core.excludes");
//
//    assertThat(resultList, contains(".ignore", "~/.ignore", "/etc/ignore"));
//  }
//
//  // Parses override keys, returning overridden values when requested
//  @Test
//  public void parsesOverrideKeys() {
//    String override = "work";
//    ConfigurationReader config = getConfig(configPath, override);
//
//    Optional<String> result = config.getString("user.email");
//
//    assertThat(result.orElse(""), equalTo("asykes@company.com"));
//  }
//
//  // Returns empty optional for non-existent key
//  @Test
//  public void handlesNonExistentKeys() {
//    ConfigurationReader config = getConfig(configPath);
//
//    Optional<String> result = config.getString("user.handle");
//
//    assertThat(result.isPresent(), is(false));
//  }
//
//  private ConfigurationReader getConfig(String path, String ... overrides) {
//    ConfigurationParser parser = ParserFactory.createParser(path);
//    return parser.getConfig(overrides);
//  }
//}
