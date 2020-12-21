package org.geekbang.thinking.in.spring.event.mydemo.event.listener;

import org.geekbang.thinking.in.spring.event.mydemo.event.AbstractContextEvent;
import org.geekbang.thinking.in.spring.event.mydemo.event.ContextDestroyEvent;

/**
 * 功能描述
 *
 * @author z00502253
 * @since 2020-12-21
 */
public class ContextDestroyEventListener implements ContextListener<AbstractContextEvent> {
    @Override
    public void onApplicationEvent(AbstractContextEvent event) {
        if (event instanceof ContextDestroyEvent) {
            System.out.println("容器销毁。。。，销毁时间为：" + event.getTimestamp());
        }
    }
}
