
package com.shardingsphere.utils;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class JsonUtils
{


    public static interface Checked<T, V>
    {

        V checked(T v);
    }

    public static final Checked<Object, Long> LongChecked = new Checked<Object, Long>()
    {

        @Override
        public Long checked(Object n)
        {

            if (n != null)
            {
                if (n instanceof String)
                {
                    return Long.valueOf(( String ) n);
                }
                else
                {
                    return Long.valueOf(Number.class.cast(n).longValue());
                }
            }
            return null;
        }

    };

    public static final Checked<Object, Integer> IntChecked = new Checked<Object, Integer>()
    {

        @Override
        public Integer checked(Object n)
        {

            if (n != null)
            {
                if (n instanceof String)
                {
                    return Integer.valueOf(( String ) n);
                }
                else
                {
                    return Integer.valueOf(Number.class.cast(n).intValue());
                }
            }
            return null;
        }

    };

    public static final Checked<Object, String> StrChecked = new Checked<Object, String>()
    {

        @Override
        public String checked(Object n)
        {

            if (n != null)
            {
                return String.valueOf(n);
            }
            return null;
        }

    };

    public static final Checked<List<Object>, List<Long>> ListLongChecked = new Checked<List<Object>, List<Long>>()
    {

        @Override
        public List<Long> checked(List<Object> n)
        {

            return checkedLongList(n);
        }

    };

    public static final Checked<List<Object>, List<Integer>> ListIntChecked = new Checked<List<Object>, List<Integer>>()
    {

        @Override
        public List<Integer> checked(List<Object> n)
        {

            return checkedIntList(n);
        }

    };

    public static final Checked<List<Object>, List<String>> ListStrChecked = new Checked<List<Object>, List<String>>()
    {

        @Override
        public List<String> checked(List<Object> n)
        {

            return checkedStrList(n);
        }

    };

    public static <V> Map<String, V> checkedMap(Map<String, Object> v,
                                                Checked<Object, V> valueChecked)
    {

        if (v != null)
        {
            Map<String, V> r = new LinkedHashMap<String, V>();
            for (Entry<String, Object> n : v.entrySet())
            {
                if (n.getKey() != null)
                {
                    r.put(String.valueOf(n.getKey()),
                          valueChecked.checked(n.getValue()));
                }
                else
                {
                    r.put(n.getKey(), valueChecked.checked(n.getValue()));
                }
            }
            return r;
        }
        return null;
    }

    public static <V> Map<String, List<V>> checkedMapList(Checked<List<Object>, List<V>> valueChecked,
                                                          Map<String, List<Object>> v)
    {

        if (v != null)
        {
            Map<String, List<V>> r = new LinkedHashMap<String, List<V>>();
            for (Entry<String, List<Object>> n : v.entrySet())
            {
                if (n.getKey() != null)
                {
                    r.put(String.valueOf(n.getKey()),
                          valueChecked.checked(n.getValue()));
                }
                else
                {
                    r.put(n.getKey(), valueChecked.checked(n.getValue()));
                }
            }
            return r;
        }
        return null;
    }

    public static List<Long> checkedLongList(List< ? > v)
    {

        if (v != null)
        {
            List<Long> r = new ArrayList<Long>(v.size());
            for (Object n : v)
            {
                if (n != null)
                {
                    if (n instanceof String)
                    {
                        r.add(Long.valueOf(( String ) n));
                    }
                    else
                    {
                        r.add(Long.valueOf(Number.class.cast(n).longValue()));
                    }
                }
                else
                {
                    r.add(null);
                }
            }
            return r;
        }
        return null;
    }

    public static List<Integer> checkedIntList(List< ? > v)
    {

        if (v != null)
        {
            List<Integer> r = new ArrayList<Integer>(v.size());
            for (Object n : v)
            {
                if (n != null)
                {
                    if (n instanceof String)
                    {
                        r.add(Integer.valueOf(( String ) n));
                    }
                    else
                    {
                        r.add(Integer.valueOf(Number.class.cast(n).intValue()));
                    }
                }
                else
                {
                    r.add(null);
                }
            }
            return r;
        }
        return null;
    }

    public static List<String> checkedStrList(List< ? > v)
    {

        if (v != null)
        {
            List<String> r = new ArrayList<String>(v.size());
            for (Object n : v)
            {
                if (n != null)
                {
                    r.add(String.valueOf(n));
                }
                else
                {
                    r.add(null);
                }
            }
            return r;
        }
        return null;
    }

}
