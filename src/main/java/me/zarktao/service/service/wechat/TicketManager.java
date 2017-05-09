package me.zarktao.service.service.wechat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import weixin.popular.api.TicketAPI;
import weixin.popular.bean.ticket.Ticket;

import java.util.concurrent.TimeUnit;

/**
 * Created by Tao on 2017/5/3.
 */
public class TicketManager extends RefreshManager {
    private static final Logger logger = LoggerFactory.getLogger(TicketManager.class);
    private static final int REFRESH_INTERVAL = 118;
    private String ticket;

    private TicketManager() {
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
        ticket = getTicketFromWechat();
        future = scheduledExecutorService.scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {
                try {
                    ticket = getTicketFromWechat();
                    if (saveHandler != null) {
                        saveHandler.save(ticket);
                    }
                } catch (Exception e) {
                    logger.error("JS_API_TICKET refurbish error");
                    e.printStackTrace();
                }
            }
        }, REFRESH_INTERVAL, REFRESH_INTERVAL, TimeUnit.MINUTES);
        logger.info("JS api ticket refresh daemon started.");
    }

    @Override
    public void stop() {
        if (future != null) {
            future.cancel(true);
            scheduledExecutorService.shutdownNow();
            logger.info("JS api ticket refresh daemon stopped.");
        }
    }

    /**
     * 获取 access_token
     *
     * @return ticket
     */
    public String getTicket() {
        return ticket;
    }

    public void setSaveHandler(TokenSaveHandler handler) {
        saveHandler = handler;
    }

    public static TicketManager getInstance() {
        return TicketManager.InstanceKeeper.instance;
    }

    private static class InstanceKeeper {
        private static TicketManager instance = new TicketManager();
    }

    private String getTicketFromWechat() {
        Ticket ticketObj = TicketAPI.ticketGetticket(Wechat.getToken());
        logger.info("JS_API_TICKET get from wechat with ticket:{}.", ticketObj.getTicket());
        return ticketObj.getTicket();
    }
}