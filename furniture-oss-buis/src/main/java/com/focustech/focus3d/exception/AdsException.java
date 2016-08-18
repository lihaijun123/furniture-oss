package com.focustech.focus3d.exception;

import com.focustech.oss2008.exception.service.OssRollbackCheckedException;


public class AdsException extends OssRollbackCheckedException {
    /**
     *
     */
    private static final long serialVersionUID = -551243623332554331L;

    /**
	 *
	 */
    public AdsException() {
    }

    /**
     * @param message
     */
    public AdsException(String message) {
        super(message);
    }

    /**
     * @param cause
     */
    public AdsException(Throwable cause) {
        super(cause);
    }

    /**
     * @param message
     * @param cause
     */
    public AdsException(String message, Throwable cause) {
        super(message, cause);
    }
}
