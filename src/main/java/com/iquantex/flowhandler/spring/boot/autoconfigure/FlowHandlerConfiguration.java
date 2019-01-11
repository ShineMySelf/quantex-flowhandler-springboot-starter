package com.iquantex.flowhandler.spring.boot.autoconfigure;

import com.iquantex.flowhandler.config.Config;
import com.iquantex.flowhandler.spring.boot.autoconfigure.poperties.FlowHandlerProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
@ConditionalOnProperty(name = FlowHandlerProperty.PREFIX + "enabled",havingValue = "true",matchIfMissing = true)
@EnableConfigurationProperties(FlowHandlerProperty.class)
public class FlowHandlerConfiguration implements EnvironmentAware {

    private static final Logger LOG = LoggerFactory.getLogger(FlowHandlerConfiguration.class);

    @Override
    public void setEnvironment(Environment environment) {
        FlowHandlerProperty flowHandlerProperty = SpringBootBindUtil.bind(environment,FlowHandlerProperty.PREFIX,FlowHandlerProperty.class);
        if (flowHandlerProperty==null){
            return;
        }
        Config.FLOW_ENABLED = flowHandlerProperty.getEnabled();
        LOG.info(".....FlowHandlerProperty enabled is " + Config.FLOW_ENABLED);
        int size = flowHandlerProperty.getSize();
        if (size ==0 ){
            LOG.info(".....FlowHandlerProperty size is default Integer.MAX");
        }else {
            Config.FLOW_QUEUE_SIZE = size;
            LOG.info(".....FlowHandlerProperty size is " + size);
        }
    }
}
