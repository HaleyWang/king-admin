package com.oukingtim.util.exception;

/**
 * Created by haley on 21/01/2018.
 */
public class NormalException extends Exception {

    String msg;

    public NormalException() {
        super();
    }

    public NormalException( String msg) {
        super(msg);
        this.msg = msg;
    }
}
