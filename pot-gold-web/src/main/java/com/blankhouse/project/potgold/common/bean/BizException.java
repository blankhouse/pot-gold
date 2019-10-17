package com.blankhouse.project.potgold.common.bean;

/**
 * @author hujia
 * @date 8/10/2019
 * @since 1.0.0
 */
public class BizException extends Exception{

    public BizException() {
        super();
    }

    public BizException(String message, Throwable cause) {
        super(message, cause);
    }

    public BizException(String message) {
        super(message);
    }

    public BizException(Throwable cause) {
        super(cause);
    }
}
