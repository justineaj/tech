package com.pgms.tw.impl;

import com.pgms.tw.ConfigurationParser;
import com.pgms.tw.ConfigurationReader;
import com.pgms.tw.ParserUtil;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Given a configuration file, produces a {@link ConfigurationReader} that allows consumers
 * to interact with the configuration values specified in that file.
 *
 * Supports overrides - an ordered list of preferences for configuration keys that have been
 * specified with multiple overrides.
 */
public class SimpleConfigurationParserImpl implements ConfigurationParser {

  /*Map<Override,Map<key,value>> valuesGroupByOverride*/;

  Map<String,Map<String,String>> valuesGroupByOverride=new HashMap<>();

  public SimpleConfigurationParserImpl(String configPath)  {

    try {
      readValues(configPath);
    } catch (Exception e) {
      e.printStackTrace(); //Cannt read File
    }
  }

  private void readValues(String configPath) throws Exception {

    String line;
    String group=null;
    String override=null;

    FileReader fileReader = new FileReader(configPath);
    BufferedReader bufferedReader = new BufferedReader(fileReader);
    Map<String,String> keyValueMap=null;

      while((line = bufferedReader.readLine()) != null) {
        System.out.println(line);

        line=removeCommentAndSpace(line);

        if(line.length()==0){
          continue;
        }

        if(isGroup(line)){
          group=line.replace("[","").replace("]","");
          continue;
        }
        else{
          if(group==null){
            throw new RuntimeException("config values should come after a group only");
          }
          override=getOverride(line);  /* override = <work> */
          line=line.replace(override,"");
          override=override.replace("<","").replace(">",""); /* override = work */

          keyValueMap=valuesGroupByOverride.get(override);
          if(keyValueMap==null){
            keyValueMap=new HashMap<>();
            valuesGroupByOverride.put(override,keyValueMap);
          }
            String [] keyValue=getKeyAndValue(line);

          keyValueMap.put(group+"."+keyValue[0],keyValue[1]);
        }

      }
  }

  private String getOverride(String line) {
    String override="default";

    Pattern pattern = Pattern.compile("<\\w+>");
    Matcher matcher = pattern.matcher(line);
    if(matcher.find()){
      override=matcher.group();
    }
    return override;
  }

  private String[] getKeyAndValue(String line){
    String [] splits=line.split("=");
    if(splits==null || splits.length!=2 || splits[0].trim().length()==0 || splits[1].trim().length()==0){
      throw new RuntimeException("Invalid Configuration "+line);
    }
    else return new String[]{ ParserUtil.formatKey(splits[0].trim()),splits[1].trim()};
  }



  private String removeCommentAndSpace(String line){

    if(line==null || line.trim().length()==0){
      return "";
    }

    line=line.trim();

    int i=line.indexOf(";");
    if(i>-1){
      line=line.substring(0,i);
    }

    return line;
  }

  private boolean isGroup(String line){
    return  line.matches("\\[\\w*\\]");
  }

  /**
   * @return a {@link ConfigurationReader} that returns values ignoring any overrides
   */
  public ConfigurationReader getConfig(){
    return getConfig(new String [] {});
  }

  /**
   * @param overrides
   * @return a {@link ConfigurationReader} that returns values by giving preferences to those
   * specified in the overrides list - where the order of the overrides is respected.
   */
  public ConfigurationReader getConfig(String... overrides){

    Map<String,String> defaultMap=valuesGroupByOverride.get("default");

  if(overrides!=null && overrides.length>0){
    for(String override:overrides){
      if(valuesGroupByOverride.get(override)!=null){
        defaultMap.putAll(valuesGroupByOverride.get(override));
      }
    }
  }
    return new SimpleConfigurationReader(defaultMap);

  }





}
