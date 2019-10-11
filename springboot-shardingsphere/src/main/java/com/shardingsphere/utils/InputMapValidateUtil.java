
package com.shardingsphere.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;

public class InputMapValidateUtil
{

    public static List<Long> getLongValues(Map<String, Object> arg, String key,
                                           StringBuilder errPara)
    {

        Object o = arg.get(key);
        if (o == null)
        {
            logPara(errPara, key, ( String ) arg.get(key));
            return Collections.emptyList();
        }
        if (o instanceof List)
        {
            try
            {
                return JsonUtils.checkedLongList(( List ) o);
            }
            catch (Exception e)
            {
                logPara(errPara, key, String.valueOf(arg.get(key)));
                return Collections.emptyList();
            }
        }
        String vs = StringUtils.trimToNull(String.valueOf(o));
        if (vs == null)
        {
            logPara(errPara, key, ( String ) arg.get(key));
            return Collections.emptyList();
        }
        String[] vStrs = vs.split(",");
        Set<Long> result = new LinkedHashSet<Long>();
        for (String v : vStrs)
        {
            v = StringUtils.trimToNull(v);
            if (v == null)
            {
                logPara(errPara, key, ( String ) arg.get(key));
                return Collections.emptyList();
            }
            try
            {
                result.add(Long.valueOf(v));
            }
            catch (Exception e)
            {
                logPara(errPara, key, ( String ) arg.get(key));
                return Collections.emptyList();
            }
        }
        return new ArrayList<Long>(result);
    }

    public static List<Integer> getIntegerValues(Map<String, Object> arg,
                                                 String key,
                                                 StringBuilder errPara)
    {

        Object o = arg.get(key);
        if (o == null)
        {
            logPara(errPara, key, ( String ) arg.get(key));
            return Collections.emptyList();
        }
        if (o instanceof List)
        {
            try
            {
                return JsonUtils.checkedIntList(( List ) o);
            }
            catch (Exception e)
            {
                logPara(errPara, key, String.valueOf(arg.get(key)));
                return Collections.emptyList();
            }
        }
        String vs = StringUtils.trimToNull(String.valueOf(o));
        if (vs == null)
        {
            logPara(errPara, key, ( String ) arg.get(key));
            return Collections.emptyList();
        }
        String[] vStrs = vs.split(",");
        Set<Integer> result = new LinkedHashSet<Integer>();
        for (String v : vStrs)
        {
            v = StringUtils.trimToNull(v);
            if (v == null)
            {
                logPara(errPara, key, ( String ) arg.get(key));
                return Collections.emptyList();
            }
            try
            {
                result.add(Integer.valueOf(v));
            }
            catch (Exception e)
            {
                logPara(errPara, key, ( String ) arg.get(key));
                return Collections.emptyList();
            }
        }
        return new ArrayList<Integer>(result);
    }

    public static short getShortValue(Map<String, Object> arg, String key,
                                      short defaultValue)
    {

        return getShortValue(arg, key, defaultValue, null);
    }

    public static short getShortValue(Map<String, Object> arg, String key,
                                      short defaultValue, StringBuilder errPara)
    {

        Object o = arg.get(key);
        if (o == null)
        {
            return defaultValue;
        }
        if (o instanceof Number)
        {
            return (( Number ) o).shortValue();
        }
        String v = StringUtils.trimToNull(String.valueOf(o));
        if (v == null)
        {
            return defaultValue;
        }
        short i = defaultValue;
        try
        {
            i = Short.parseShort(v);
        }
        catch (Exception e)
        {
            logPara(errPara, key, v);
        }
        return i;
    }

    public static int getIntValue(Map<String, Object> arg, String key,
                                  int defaultValue)
    {

        return getIntValue(arg, key, defaultValue, null);
    }

    public static boolean getBoolValue(Map<String, Object> arg, String key,
                                       boolean defaultValue)
    {

        Object o = arg.get(key);
        if (o == null)
        {
            return defaultValue;
        }
        String tmp = StringUtils.trimToNull(String.valueOf(o));
        if (tmp == null)
        {
            return defaultValue;
        }
        if (defaultValue)
        {
            if ("0".equals(tmp) || "false".equalsIgnoreCase(tmp))
            {
                return false;
            }
            else
            {
                return true;
            }
        }
        else
        {
            if ("1".equals(tmp) || "true".equalsIgnoreCase(tmp))
            {
                return true;
            }
            else
            {
                return false;
            }

        }
    }

    public static int getIntValue(Map<String, Object> arg, String key,
                                  int defaultValue, StringBuilder errPara)
    {

        Object o = arg.get(key);
        if (o == null)
        {
            return defaultValue;
        }
        if (o instanceof Number)
        {
            return (( Number ) o).intValue();
        }
        String v = StringUtils.trimToNull(String.valueOf(o));
        if (v == null)
        {
            return defaultValue;
        }
        int i = defaultValue;
        try
        {
            i = Integer.parseInt(v);
        }
        catch (Exception e)
        {
            logPara(errPara, key, v);
        }
        return i;
    }

    public static long getLongValue(Map<String, Object> arg, String key,
                                    long defaultValue)
    {

        return getLongValue(arg, key, defaultValue, null);
    }

    public static long getLongValue(Map<String, Object> arg, String key,
                                    long defaultValue, StringBuilder errPara)
    {

        Object o = arg.get(key);
        if (o == null)
        {
            return defaultValue;
        }
        if (o instanceof Number)
        {
            return (( Number ) o).longValue();
        }
        String v = StringUtils.trimToNull(String.valueOf(o));
        if (v == null)
        {
            return defaultValue;
        }
        long i = defaultValue;
        try
        {
            i = Long.parseLong(v);
        }
        catch (Exception e)
        {
            logPara(errPara, key, v);
        }
        return i;
    }
    
    public static Long getLongValue(Map<String, Object> arg, String key,
                                    Long defaultValue)
    {

        Object o = arg.get(key);
        if (o == null)
        {
            return defaultValue;
        }
        Long result = defaultValue;
        try
        {
            result = Long.valueOf(o.toString());
        }
        catch (NumberFormatException e)
        {
            throw e;
        }
        return result;
    }

    public static byte getByteValue(Map<String, Object> arg, String key,
                                    byte defaultValue)
    {

        return getByteValue(arg, key, defaultValue, null);
    }

    public static byte getByteValue(Map<String, Object> arg, String key,
                                    byte defaultValue, StringBuilder errPara)
    {

        Object o = arg.get(key);
        if (o == null)
        {
            return defaultValue;
        }
        if (o instanceof Number)
        {
            return (( Number ) o).byteValue();
        }
        String v = StringUtils.trimToNull(String.valueOf(o));
        if (v == null)
        {
            return defaultValue;
        }
        byte i = defaultValue;
        try
        {
            i = Byte.parseByte(v);
        }
        catch (NumberFormatException nfe)
        {
            logPara(errPara, key, v);
        }
        return i;
    }

    public static long validateOperatorId(Map<String, Object> arg,
                                          StringBuilder errPara)
    {

        long len = -1;
        if (errPara != null)
        {
            len = errPara.length();
        }
        long operatorId = getNumberValue("operator_id",
                                         arg,
                                         errPara,
                                         Long.MIN_VALUE);
        if (errPara != null && len == errPara.length())
        {
            if (operatorId <= 0)
            {
                logPara(errPara,
                        "operator_id",
                        String.valueOf(arg.get("operator_id")));
            }
        }
        return operatorId;
    }

    public static long getMechantId(Map<String, Object> arg, long def,
                                    StringBuilder errPara)
    {

        return getNumberValue("merchant_id", arg, errPara, Long.valueOf(def));
    }

    public static String getThirdId(Map<String, Object> arg, String key)
    {

        return ( String ) arg.get(key);
    }
    public static String getString(Map<String, Object> arg, String key)
    {

        return ( String ) arg.get(key);
    }

    public static String getStringTrimToNull(Map<String, Object> arg,
                                             String key)
    {

        return StringUtils.trimToNull(( String ) arg.get(key));
    }

    public static String validateString(Map<String, Object> arg, String key,
                                        StringBuilder errPara)
    {

        String value = StringUtils.trimToNull(( String ) arg.get(key));
        if (value == null || value.length() == 0)
        {
            logPara(errPara, key, value);
        }
        return value;
    }

    @SuppressWarnings("unchecked")
    private static <T extends Number> T getNumberValue(String key,
                                                       Map<String, Object> arg,
                                                       StringBuilder errPara,
                                                       T def)
    {

        T value = def;
        if (arg.get(key) == null)
        {
            logPara(errPara, key, "");
            return value;
        }
        String tmp = arg.get(key).toString();
        if (!StringUtils.isBlank(tmp))
        {
            try
            {
                if (value instanceof Integer)
                {
                    value = ( T ) Integer.valueOf(tmp);
                }
                else if (value instanceof Long)
                {
                    value = ( T ) Long.valueOf(tmp);
                }
                else if (value instanceof Byte)
                {
                    value = ( T ) Byte.valueOf(tmp);
                }
                else if (value instanceof Short)
                {
                    value = ( T ) Short.valueOf(tmp);
                }
            }
            catch (Exception e)
            {
                if (errPara != null)
                {
                    logPara(errPara, key, tmp);
                }
            }
        }
        else
        {
            if (errPara != null)
            {
                logPara(errPara, key, tmp);
            }
        }
        return value;
    }

    private static void logPara(StringBuilder para, String name, String value)
    {

        if (para == null)
        {
            return;
        }
        if (para.length() > 0)
        {
            para.append(", ");
        }
        para.append(name);
        para.append('=');
        para.append(value);
    }

}
