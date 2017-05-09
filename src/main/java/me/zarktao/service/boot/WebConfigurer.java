package me.zarktao.service.boot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tao on 2017/3/27.
 * <p>
 * Configuration for this application.
 * Handle return values to JSON format.
 */

@EnableWebMvc
@Configuration
public class WebConfigurer extends WebMvcConfigurerAdapter {
    private static final Logger logger = LoggerFactory.getLogger(Launcher.class);

    @Override
    public void addReturnValueHandlers(final List<HandlerMethodReturnValueHandler> returnValueHandlers) {
        logger.info("=====================================================================");
        logger.info("Init json return value handler.");
        List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
        messageConverters.add(new MappingJackson2HttpMessageConverter());
        returnValueHandlers.add(new ReturnJsonHandler(messageConverters));
    }
}
