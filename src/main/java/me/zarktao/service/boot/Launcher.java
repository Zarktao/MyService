package me.zarktao.service.boot;

import me.zarktao.service.service.wechat.Wechat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by Tao on 2017/3/27.
 * <p>
 * The launcher of this service.
 */

@SpringBootApplication
@ComponentScan("me.zarktao.service")
public class Launcher {
    private static final Logger logger = LoggerFactory.getLogger(Launcher.class);

    @Autowired
    private AppProperties appProperties;

    @Bean
    protected ServletContextListener listener() {
        return new ServletContextListener() {
            @Override
            public void contextInitialized(ServletContextEvent sce) {
                logger.info("ServletContext initialized");
                if (AppProperties.WECHAT_ENABLED) {
                    logger.info("Wechat functionality enabled.");
                    Wechat.init();
                } else {
                    logger.info("Wechat functionality disabled.");
                }
            }

            @Override
            public void contextDestroyed(ServletContextEvent sce) {
                logger.info("ServletContext destroyed");
            }
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(Launcher.class, args);
    }
}
