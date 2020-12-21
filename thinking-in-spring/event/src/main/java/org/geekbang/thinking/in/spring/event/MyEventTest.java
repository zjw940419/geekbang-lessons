package org.geekbang.thinking.in.spring.event;

import org.geekbang.thinking.in.spring.event.mydemo.event.ContextDestroyEvent;
import org.geekbang.thinking.in.spring.event.mydemo.event.ContextRunningEvent;
import org.geekbang.thinking.in.spring.event.mydemo.event.ContextStartEvent;
import org.geekbang.thinking.in.spring.event.mydemo.event.listener.ContextDestroyEventListener;
import org.geekbang.thinking.in.spring.event.mydemo.event.listener.ContextRunningEventListener;
import org.geekbang.thinking.in.spring.event.mydemo.event.listener.ContextStartEventListener;
import org.geekbang.thinking.in.spring.event.mydemo.multicaster.ApplicationEventMulticaster;
import org.geekbang.thinking.in.spring.event.mydemo.multicaster.SimpleApplicationEventMulticaster;
import org.junit.Test;

import java.util.concurrent.CountDownLatch;

/**
 * 功能描述
 *
 * @author z00502253
 * @since 2020-12-21
 */
public class MyEventTest {
    @Test
    public void testContextLifecycleEventInSync() {
        // 新建SimpleApplicationEventMulticaster对象，并添加容器生命周期监听器
        ApplicationEventMulticaster eventMulticaster = new SimpleApplicationEventMulticaster();
        eventMulticaster.addContextListener(new ContextStartEventListener());
        eventMulticaster.addContextListener(new ContextRunningEventListener());
        eventMulticaster.addContextListener(new ContextDestroyEventListener());
        // 发射容器启动事件ContextStartEvent
        eventMulticaster.multicastEvent(new ContextStartEvent());
        // 发射容器正在运行事件ContextRunningEvent
        eventMulticaster.multicastEvent(new ContextRunningEvent());
        // 发射容器正在运行事件ContextDestroyEvent
        eventMulticaster.multicastEvent(new ContextDestroyEvent());
    }

    @Test
    public void testContextLifecycleEventInAsync() throws InterruptedException {
        // 新建SimpleApplicationEventMulticaster对象，并添加容器生命周期监听器
        ApplicationEventMulticaster eventMulticaster = new SimpleApplicationEventMulticaster();
        eventMulticaster.addContextListener(new ContextStartEventListener());
        eventMulticaster.addContextListener(new ContextRunningEventListener());
        eventMulticaster.addContextListener(new ContextDestroyEventListener());

        ((SimpleApplicationEventMulticaster) eventMulticaster).setAsync(true);

        // 发射容器启动事件ContextStartEvent
        eventMulticaster.multicastEvent(new ContextStartEvent());
        // 发射容器正在运行事件ContextRunningEvent
        eventMulticaster.multicastEvent(new ContextRunningEvent());
        // 发射容器正在运行事件ContextDestroyEvent
        eventMulticaster.multicastEvent(new ContextDestroyEvent());
        CountDownLatch countDownLatch = new CountDownLatch(1);
        countDownLatch.await();

    }

    public static void main(String[] args) throws InterruptedException {
        // 新建SimpleApplicationEventMulticaster对象，并添加容器生命周期监听器
        ApplicationEventMulticaster eventMulticaster = new SimpleApplicationEventMulticaster();
        eventMulticaster.addContextListener(new ContextStartEventListener());
        eventMulticaster.addContextListener(new ContextRunningEventListener());
        eventMulticaster.addContextListener(new ContextDestroyEventListener());

        ((SimpleApplicationEventMulticaster) eventMulticaster).setAsync(true);

        // 发射容器启动事件ContextStartEvent
        eventMulticaster.multicastEvent(new ContextStartEvent());
        // 发射容器正在运行事件ContextRunningEvent
        eventMulticaster.multicastEvent(new ContextRunningEvent());
        // 发射容器正在运行事件ContextDestroyEvent
        eventMulticaster.multicastEvent(new ContextDestroyEvent());

    }
}
