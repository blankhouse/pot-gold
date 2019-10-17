package com.blankhouse.project.potgold.common.bean;

/**
 * @author hujia
 * @date 8/10/2019
 * @since 1.0.0
 */
public class DebugException  extends Exception{
    public DebugException() {
        super();
    }

    public DebugException(String message, Throwable cause) {
        super(message, cause);
    }

    public DebugException(String message) {
        super(message);
    }

    public DebugException(Throwable cause) {
        super(cause);
    }
}
