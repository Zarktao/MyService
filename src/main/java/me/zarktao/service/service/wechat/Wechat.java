package me.zarktao.service.service.wechat;

import me.zarktao.service.boot.AppProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Tao on 2017/5/3.
 */
public class Wechat {
    private static final Logger logger = LoggerFactory.getLogger(Wechat.class);
    private static TokenManager tokenDaemon;
    private static TicketManager ticketDaemon;

    public static void init() {
        logger.info("Wechat initialize start.");
        logger.debug("APPID: {}, SECRET: {}", AppProperties.WECHAT_APPID, AppProperties.WECHAT_SECRET);
        tokenDaemon = TokenManager.getInstance();
        ticketDaemon = TicketManager.getInstance();
    }

    public static String getToken() {
        return tokenDaemon.getToken();
    }

    public static String getTicket() {
        return ticketDaemon.getTicket();
    }
}
