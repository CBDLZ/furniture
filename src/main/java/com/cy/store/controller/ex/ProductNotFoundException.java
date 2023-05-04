package com.cy.store.controller.ex;

/** 上传的文件为空的异常，例如没有选择上传的文件就提交了表单，或选择的文件是0字节的空文件 */
public class ProductNotFoundException extends FileUploadException {
    public ProductNotFoundException() {
        super();
    }

    public ProductNotFoundException(String message) {
        super(message);
    }

    public ProductNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ProductNotFoundException(Throwable cause) {
        super(cause);
    }

    protected ProductNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
