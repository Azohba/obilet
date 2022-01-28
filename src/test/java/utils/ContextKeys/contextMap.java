package utils.ContextKeys;

import java.util.HashMap;

public class contextMap {
    private static HashMap<ContextKeys, String> contextMap;
    private String flightNo;
    private String EMAIL;
    private String PASS;

    public static void initializeContext(){
        contextMap = new HashMap<ContextKeys, String>();
    }

    public static void addContext(ContextKeys key, String value){
        if(contextMap == null)
            initializeContext();
        if(contextMap.get(key) != null)
            contextMap.remove(key);
        contextMap.put(key, value);
    }

    public static String getContextValue(ContextKeys key){
        if(contextMap == null)
            return "CONTEXT IS NULL";
        String value = contextMap.get(key);
        if(value == null)
            return "CONTEXT WITH KEY " + key + " NOT FOUND";
        return value;
    }

    public String getFlightNo() {
        return flightNo;
    }

    public void setFlightNo(String flightNo) {
        this.flightNo = flightNo;
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }

    public String getPASS() {
        return PASS;
    }

    public void setPASS(String PASS) {
        this.PASS = PASS;
    }

}
