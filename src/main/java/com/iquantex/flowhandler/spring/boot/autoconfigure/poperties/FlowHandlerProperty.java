package com.iquantex.flowhandler.spring.boot.autoconfigure.poperties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = FlowHandlerProperty.PREFIX)
public class FlowHandlerProperty {

    public static final String PREFIX = "quantex.flow.handler";

    private boolean enabled;

    private int size;

    public boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

}
