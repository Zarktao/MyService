package me.zarktao.service.boot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by yt005 on 2017/5/9.
 * 读取配置文件并以类的形式存储
 */

@org.springframework.context.annotation.Configuration
@PropertySource("classpath:application.properties")
public class AppProperties {
    public static String APP_NAME;
    public static boolean WECHAT_ENABLED;
    public static String WECHAT_APPID;
    public static String WECHAT_SECRET;

    @Value("${app.name}")
    public void setAppName(String appName) {
        APP_NAME = appName;
    }

    @Value("${wechat.enabled}")
    public void setWechatEnabled(boolean wechatEnabled) {
        WECHAT_ENABLED = wechatEnabled;
    }

    @Value("${wechat.appid}")
    public void setWechatAppId(String wechatAppId) {
        WECHAT_APPID = wechatAppId;
    }

    @Value("${wechat.secret}")
    public void setWechatSecret(String wechatSecret) {
        WECHAT_SECRET = wechatSecret;
    }
}
