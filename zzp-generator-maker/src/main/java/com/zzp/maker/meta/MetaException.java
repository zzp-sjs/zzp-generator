package com.zzp.maker.meta;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: zzp
 * @Date: 2024/07/03/下午3:17
 * @Description:
 */
public class MetaException extends RuntimeException {

    public MetaException(String message) {
        super(message);
    }
    public MetaException(String message, Throwable cause) {
        super(message,cause);
    }
}
