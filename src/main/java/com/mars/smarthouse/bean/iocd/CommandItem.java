

package com.mars.smarthouse.bean.iocd;

import java.util.Map;

public class CommandItem {
    private String name;
    private String method;
    private String url;
    private Map<String,Object> parameters;

    /**
     * @roseuid 569361DE0330
     */
    public CommandItem() {

    }

    /**
     * Access method for the name property.
     *
     * @return the current value of the name property
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     *
     * @param aName the new value of the name property
     */
    public void setName(String aName) {
        name = aName;
    }

    /**
     * Access method for the method property.
     *
     * @return the current value of the method property
     */
    public String getMethod() {
        return method;
    }

    /**
     * Sets the value of the method property.
     *
     * @param aMethod the new value of the method property
     */
    public void setMethod(String aMethod) {
        method = aMethod;
    }

    /**
     * Access method for the url property.
     *
     * @return the current value of the url property
     */
    public String getUrl() {
        return url;
    }

    /**
     * Sets the value of the url property.
     *
     * @param aUrl the new value of the url property
     */
    public void setUrl(String aUrl) {
        url = aUrl;
    }

    /**
     * Access method for the parameters property.
     *
     * @return the current value of the parameters property
     */
    public Map<String,Object> getParameters() {
        return parameters;
    }

    /**
     * Sets the value of the parameters property.
     *
     * @param aParameters the new value of the parameters property
     */
    public void setParameters(Map<String,Object> aParameters) {
        parameters = aParameters;
    }
}
