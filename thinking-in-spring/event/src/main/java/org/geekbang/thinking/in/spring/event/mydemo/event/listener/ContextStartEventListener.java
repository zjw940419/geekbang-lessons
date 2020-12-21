package org.geekbang.thinking.in.spring.event.mydemo.event.listener;

import org.geekbang.thinking.in.spring.event.mydemo.event.AbstractContextEvent;
import org.geekbang.thinking.in.spring.event.mydemo.event.ContextStartEvent;

/**
 * 功能描述
 * 监听context启动事件
 * @author z00502253
 * @since 2020-12-21
 */
public class ContextStartEventListener implements ContextListener<AbstractContextEvent> {
    @Override
    public void onApplicationEvent(AbstractContextEvent event) {
        if (event instanceof ContextStartEvent) {
            System.out.println("容器启动。。。，启动时间为：" + event.getTimestamp());
        }
    }
}
