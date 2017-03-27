package me.zarktao.service.boot;

import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter4;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tao on 2017/3/27.
 *
 * Configuration for this application.
 * Handle return values to JSON format.
 */

@EnableWebMvc
@org.springframework.context.annotation.Configuration
public class Configuration extends WebMvcConfigurerAdapter {

    private static Log logger = LogFactory.getLog(Configuration.class);

    @Override
    public void addReturnValueHandlers(final List<HandlerMethodReturnValueHandler> returnValueHandlers) {
        logger.info("=====================================================================");
        logger.info("Init json return value handler.");
        List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
        messageConverters.add(new FastJsonHttpMessageConverter4());
        returnValueHandlers.add(new ReturnJsonHandler(messageConverters));
    }
}
