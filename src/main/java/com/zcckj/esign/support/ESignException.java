package com.zcckj.esign.support;

public class ESignException extends RuntimeException{
    private static final long serialVersionUID = 4359180081622082792L;
    private Exception e;

    public ESignException(String msg) {
        super(msg);
    }

    public ESignException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public ESignException() {

    }

    public Exception getE() {
        return e;
    }

    public void setE(Exception e) {
        this.e = e;
    }
}
