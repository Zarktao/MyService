package me.zarktao.service.service.wechat;

import me.zarktao.service.exception.TokenSaveFailedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import weixin.popular.api.TokenAPI;
import weixin.popular.bean.token.Token;

import java.util.concurrent.*;

/**
 * Created by Tao on 2017/5/3.
 * <p>
 * 维护一些定时刷新任务的抽象实现自动刷新任务
 */
public abstract class RefreshManager {
    protected ScheduledExecutorService scheduledExecutorService;
    protected final int POOL_SIZE = 1;
    protected final boolean IS_DAEMON = Boolean.TRUE;
    protected Future future;
    protected TokenSaveHandler saveHandler;

    /**
     * 初始化 scheduledExecutorService
     */
    protected void initScheduledExecutorService() {
        scheduledExecutorService = Executors.newScheduledThreadPool(POOL_SIZE, new ThreadFactory() {
            @Override
            public Thread newThread(Runnable arg0) {
                Thread thread = Executors.defaultThreadFactory().newThread(arg0);
                thread.setDaemon(IS_DAEMON);
                return thread;
            }
        });
    }

    /**
     * 初始化。
     */
    public abstract void init() throws Exception;

    /**
     * 结束定时任务。
     */
    public abstract void stop();

    public void setSaveHandler(TokenSaveHandler handler) {
        saveHandler = handler;
    }

    public interface TokenSaveHandler {
        void save(String token) throws TokenSaveFailedException;
    }
}
