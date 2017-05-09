package me.zarktao.service.service.wechat;

import me.zarktao.service.boot.AppProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import weixin.popular.api.TokenAPI;
import weixin.popular.bean.token.Token;

import java.util.concurrent.*;

/**
 * Created by Tao on 2017/5/3.
 * <p>
 * 维护微信公众平台API Token自动刷新任务
 */
public class TokenManager extends RefreshManager {
    private static final Logger logger = LoggerFactory.getLogger(TokenManager.class);
    private static final int REFRESH_INTERVAL = 118;
    private String token;

    private TokenManager() {
        init();
    }

    @Override
    public void init() {
        if (scheduledExecutorService == null) {
            initScheduledExecutorService();
        }
        if (future != null) {
            future.cancel(true);
        }
        token = getTokenFromWechat();
        future = scheduledExecutorService.scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {
                try {
                    token = getTokenFromWechat();
                    if (saveHandler != null) {
                        saveHandler.save(token);
                    }
                } catch (Exception e) {
                    logger.error("ACCESS_TOKEN refurbish error with appid:{}", AppProperties.WECHAT_APPID);
                    e.printStackTrace();
                }
            }
        }, REFRESH_INTERVAL, REFRESH_INTERVAL, TimeUnit.MINUTES);
        logger.info("Access token refresh daemon started.");
    }

    @Override
    public void stop() {
        if (future != null) {
            future.cancel(true);
            scheduledExecutorService.shutdownNow();
            logger.info("Access token refresh daemon stopped.");
        }
    }

    /**
     * 获取 access_token
     *
     * @return token
     */
    public String getToken() {
        return token;
    }

    public void setSaveHandler(TokenSaveHandler handler) {
        saveHandler = handler;
    }

    public static TokenManager getInstance() {
        return InstanceKeeper.instance;
    }

    private static class InstanceKeeper {
        private static TokenManager instance = new TokenManager();
    }

    private String getTokenFromWechat() {
        Token tokenObj = TokenAPI.token(AppProperties.WECHAT_APPID, AppProperties.WECHAT_SECRET);
        logger.info("ACCESS_TOKEN get from wechat with appid:{}, token:{}.", AppProperties.WECHAT_APPID, tokenObj.getAccess_token());
        return tokenObj.getAccess_token();
    }
}
