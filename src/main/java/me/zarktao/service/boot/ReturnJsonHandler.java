package me.zarktao.service.boot;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.core.MethodParameter;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.servlet.mvc.method.annotation.RequestResponseBodyMethodProcessor;

import java.io.IOException;
import java.util.List;

/**
 * Created by Tao on 2017/3/27.
 */
public class ReturnJsonHandler extends RequestResponseBodyMethodProcessor {

    private static Log logger = LogFactory.getLog(Configuration.class);

    public ReturnJsonHandler(final List<HttpMessageConverter<?>> messageConverters) {
        super(messageConverters);
    }

    public ReturnJsonHandler(final List<HttpMessageConverter<?>> messageConverters, final ContentNegotiationManager contentNegotiationManager) {
        super(messageConverters, contentNegotiationManager);
    }

    @Override
    public boolean supportsReturnType(final MethodParameter returnType) {
        logger.info("==========================================================");
        logger.info("Start support judge");
        return (AnnotatedElementUtils.hasAnnotation(returnType.getContainingClass(), JsonResponseBody.class) ||
                returnType.hasMethodAnnotation(JsonResponseBody.class));
    }

    @Override
    public void handleReturnValue(final Object returnValue, final MethodParameter returnType, final ModelAndViewContainer mavContainer, final NativeWebRequest webRequest) throws IOException, HttpMediaTypeNotAcceptableException {
        logger.info("==========================================================");
        logger.info("Start Handle");
        super.handleReturnValue(returnValue, returnType, mavContainer, webRequest);
    }
}