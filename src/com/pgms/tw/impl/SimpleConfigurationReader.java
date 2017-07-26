package com.pgms.tw.impl;

import com.pgms.tw.ConfigurationReader;
import com.pgms.tw.ParserUtil;

import java.math.BigDecimal;
import java.util.*;

/**
 * Created by root on 5/8/17.
 */
public class SimpleConfigurationReader implements ConfigurationReader {

    Map<String, String> valuesWithOverrides=null;

    /*
    The List values can be cached for performance improvement TODO

    Map<String,List<Boolean>> booleanListCache= new HashMap<>();
    Map<String,List<Number>> booleanListCache= new HashMap<>();
    Map<String,List<String>> booleanListCache= new HashMap<>();
    */


    public SimpleConfigurationReader(Map<String, String> valueMap) {
        this.valuesWithOverrides=valueMap;
    }

    @Override
    public boolean hasKey(String key) {
        return  getValue(key)!=null;
    }

    @Override
    public Optional<Object> get(String key) {
        return  Optional.ofNullable(getValue(key));
    }

    @Override
    public Optional<Boolean> getBoolean(String key) {
        return  Optional.ofNullable(getBooleanValue(key));
    }

    @Override
    public List<Boolean> getBooleanList(String key) {
        return getBooleanValueList(key);
    }

    @Override
    public Optional<Number> getNumber(String key) {
        return  Optional.ofNullable(getNumberValue(key));
    }

    @Override
    public List<Number> getNumberList(String key) {
        return getNumberValueList(key);
    }

    @Override
    public Optional<String> getString(String key){
        return Optional.ofNullable(getStringValue(key));
    }

    @Override
    public List<String> getStringList(String key) {
        return getStringValueList(key);
    }

    private List<Boolean> getBooleanValueList(String key){
        List<Boolean> list=new ArrayList<>();
        String [] values=key.split(",");
        for(String val:values){
            list.add(getBooleanValue(val));
        }
        return list; /*List values can be cached */
    }

    private Boolean getBooleanValue(String key){
        return Boolean.valueOf(getValue(key));
    }

    private List<Number> getNumberValueList(String key){
        List<Number> list=new ArrayList<>();
        String [] values=key.split(",");
        for(String val:values){
            list.add(getNumberValue(val));
        }
        return list; /*List values can be cached */
    }

    private Number getNumberValue(String key){
        return new BigDecimal(getValue(key));
    }

    private String getStringValue(String key){
        return getValue(key);
    }

    private List<String> getStringValueList(String key){
        List<String> list=new ArrayList<>();
        String [] values=key.split(",");
        for(String val:values){
            list.add(val);
        }
        return list; /*List values can be cached */
    }

    private String getValue(String key){
        return   valuesWithOverrides.get(ParserUtil.formatKey(key));
    }


}
