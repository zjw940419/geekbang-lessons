package org.geekbang.thinking.in.spring.event.mydemo.multicaster;

import org.geekbang.thinking.in.spring.event.mydemo.event.AbstractContextEvent;
import org.geekbang.thinking.in.spring.event.mydemo.event.listener.ContextListener;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 功能描述
 * ApplicationEventMulticaster事件发布器接口的默认实现类，主要承担发布事件的功能
 *
 * @author z00502253
 * @since 2020-12-21
 */
public class SimpleApplicationEventMulticaster implements ApplicationEventMulticaster {
    // 异步标识
    private boolean async = false;

    // 线程池
    private Executor taskExecutor = new ThreadPoolExecutor(5, 5, 0, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());

    // 事件监听器列表
    private List<ContextListener<?>> contextListeners = new ArrayList<ContextListener<?>>();

    @Override
    public void addContextListener(ContextListener<?> listener) {
        contextListeners.add(listener);
    }

    @Override
    public void removeContextListener(ContextListener<?> listener) {
        contextListeners.remove(listener);
    }

    @Override
    public void removeAllListeners() {
        contextListeners.clear();
    }

    @Override
    public void multicastEvent(AbstractContextEvent event) {
        for (ContextListener contextListener : contextListeners) {
            // 异步广播事件
            if (async) {
                taskExecutor.execute(() -> invokeListener(contextListener,event));
            } else {
                invokeListener(contextListener, event);
            }
        }
    }

    private void invokeListener(ContextListener contextListener,AbstractContextEvent event) {
        contextListener.onApplicationEvent(event);
    }

    public void setAsync(boolean async) {
        this.async = async;
    }
}
