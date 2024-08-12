package com.work.translator.dto;

/**
 *
 * @author linux
 */
public class RequestTranslatorDTO {

    private String source;
    private String target;
    private String q;
    private String format;
    private int alternatives;
    private String api_key;

    public String getApi_key() {
        return api_key;
    }

    public void setApi_key(String api_key) {
        this.api_key = api_key;
    }

    
    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getQ() {
        return q;
    }

    public void setQ(String q) {
        this.q = q;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public int getAlternatives() {
        return alternatives;
    }

    public void setAlternatives(int alternatives) {
        this.alternatives = alternatives;
    }

}
