package com.pgms.tw;

import java.util.List;
import java.util.Optional;

/**
 * Created by root on 5/7/17.
 */
public class TestConfParser {


    private static String configPath = "/Users/jujoseph/personal/tech_workspace/src/com/pgms/tw/test.config";
    private static String override = "work";

    public static void main(String args[]){

        TestConfParser testParser=new TestConfParser();
        testParser.parsesStringValues();
//        testParser.parsesIntegerValues();
//        testParser.parsesDecimalValues();
//        testParser.parsesBooleanGivenTruthyValue();
//        testParser.parsesBooleanGivenFalseyValue();
//        testParser.parsesQuotedStringValues();
//        testParser.parsesListValues();
        testParser.parsesOverrideKeys();
//        testParser.handlesNonExistentKeys();

    }

    // Parses string values
    
    public void parsesStringValues() {
        ConfigurationReader config = getConfig(configPath);

        Optional<String> result = config.getString("user.email");
        System.out.println(result.get());

        
    }

    // Parses integer values
    
    public void parsesIntegerValues() {
        ConfigurationReader config = getConfig(configPath);

        Optional<Number> result = config.getNumber("user.id");

        
    }

    // Parses decimal values
    
    public void parsesDecimalValues() {
        ConfigurationReader config = getConfig(configPath);

        Optional<Number> result = config.getNumber("color.transparency");


    }

    // Parses (truthy) boolean values
    
    public void parsesBooleanGivenTruthyValue() {
        ConfigurationReader config = getConfig(configPath);

        Optional<Boolean> result = config.getBoolean("color.ui");


    }

    // Parses (false-y) boolean values
    
    public void parsesBooleanGivenFalseyValue() {
        ConfigurationReader config = getConfig(configPath);

        Optional<Boolean> result = config.getBoolean("core.preloadindex");


    }

    // Parses quoted string values
    
    public void parsesQuotedStringValues() {
        ConfigurationReader config = getConfig(configPath);

        Optional<String> result = config.getString("user.name");


    }

    // Parses list values
    
    public void parsesListValues() {
        ConfigurationReader config = getConfig(configPath);

        List<String> resultList = config.getStringList("core.excludes");


    }

    // Parses override keys, returning overridden values when requested
    
    public void parsesOverrideKeys() {
        String override = "work";
        ConfigurationReader config = getConfig(configPath, override);

        Optional<String> result = config.getString("user.email");
        System.out.println(result.get());



        override = "olakka";
        config = getConfig(configPath, override);

        result = config.getString("user.email");
        System.out.println(result.get());


    }

    // Returns empty optional for non-existent key
    
    public void handlesNonExistentKeys() {
        ConfigurationReader config = getConfig(configPath);

        Optional<String> result = config.getString("user.handle");


    }

    private ConfigurationReader getConfig(String path, String ... overrides) {
        ConfigurationParser parser = ParserFactory.createParser(path);
        return parser.getConfig(overrides);
    }

}
