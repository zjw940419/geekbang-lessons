package org.geekbang.thinking.in.spring.event.mydemo.event;

/**
 * 功能描述
 *
 * @author z00502253
 * @since 2020-12-21
 */
public class AbstractContextEvent implements Event {
    private static final long serialVersionUID = -6159391039546783871L;

    private final long timeStamp = System.currentTimeMillis();

    public final long getTimestamp() {
        return this.timeStamp;
    }
}
