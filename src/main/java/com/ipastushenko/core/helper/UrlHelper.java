package com.ipastushenko.core.helper;

/**
 * url builder
 */
public class UrlHelper {
    private String serverUrl;

    public void setServerUrl(String serverUrl) {
        this.serverUrl = serverUrl;
    }

    public String build(String url) {
        return serverUrl + url;
    }
}
