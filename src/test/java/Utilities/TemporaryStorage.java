package Utilities;

import com.google.gson.internal.bind.util.ISO8601Utils;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.HashMap;
import java.util.Map;

public class TemporaryStorage{

    private static Map<String, String> data = new HashMap<> ();

    public static void addData( String key , String value ) {

        data.put (key , value);

    }

    public static String getData( String key ) {

        return data.get (key);
    }
    public static void clearData() {

        data.clear ();
    }

    public static String print(){

        return data.toString ();
    }


}

