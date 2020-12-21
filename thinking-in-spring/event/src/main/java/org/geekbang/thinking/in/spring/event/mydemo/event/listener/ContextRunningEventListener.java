package org.geekbang.thinking.in.spring.event.mydemo.event.listener;

import org.geekbang.thinking.in.spring.event.mydemo.event.AbstractContextEvent;
import org.geekbang.thinking.in.spring.event.mydemo.event.ContextRunningEvent;

/**
 * 功能描述
 *
 * @author z00502253
 * @since 2020-12-21
 */
public class ContextRunningEventListener implements ContextListener<AbstractContextEvent> {
    @Override
    public void onApplicationEvent(AbstractContextEvent event) {
        if (event instanceof ContextRunningEvent) {
            System.out.println("容器开始运行。。。");
            try {
                Thread.sleep(3000);
                System.out.println("容器运行结束。。。");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
