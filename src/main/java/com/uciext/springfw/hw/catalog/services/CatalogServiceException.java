package com.uciext.springfw.hw.catalog.services;

public class CatalogServiceException extends Exception {
    public CatalogServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public CatalogServiceException(String message) {
        super(message);
    }
}
