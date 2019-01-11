package com.iquantex.flowhandler.spring.boot.autoconfigure;

import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.core.env.Environment;

public class SpringBootBindUtil {
    public SpringBootBindUtil() {
    }

    public static <T> T bind(Environment environment, String prefix, Class<T> cls) {
        Binder binder = Binder.get(environment);
        BindResult<T> bindResult = binder.bind(prefix, cls);
        return bindResult.isBound() ? bindResult.get() : null;
    }
}
