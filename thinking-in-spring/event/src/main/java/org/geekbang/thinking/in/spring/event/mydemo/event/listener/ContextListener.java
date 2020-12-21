package org.geekbang.thinking.in.spring.event.mydemo.event.listener;

import org.geekbang.thinking.in.spring.event.mydemo.event.AbstractContextEvent;

/**
 * 功能描述
 * 容器事件监听器接口
 * @author z00502253
 * @since 2020-12-21
 */
public interface ContextListener<T extends AbstractContextEvent> extends EventListener {
    /**
     * Handle an application event
     * @param event the event to respond
     */
    void onApplicationEvent(T event);
}
