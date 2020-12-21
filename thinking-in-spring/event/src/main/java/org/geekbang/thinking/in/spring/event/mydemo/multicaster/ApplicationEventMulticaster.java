package org.geekbang.thinking.in.spring.event.mydemo.multicaster;

import org.geekbang.thinking.in.spring.event.mydemo.event.AbstractContextEvent;
import org.geekbang.thinking.in.spring.event.mydemo.event.listener.ContextListener;

/**
 * 功能描述
 * 抽象的事件发送器
 *
 * @author z00502253
 * @since 2020-12-21
 */
public interface ApplicationEventMulticaster {
    void addContextListener(ContextListener<?> listener);

    void removeContextListener(ContextListener<?> listener);

    void removeAllListeners();

    void multicastEvent(AbstractContextEvent event);
}
