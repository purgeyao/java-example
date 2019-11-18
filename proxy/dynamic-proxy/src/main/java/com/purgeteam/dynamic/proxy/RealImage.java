package com.purgeteam.dynamic.proxy;

import lombok.extern.slf4j.Slf4j;

/**
 * @author purgeyao
 * @since 1.0
 */
@Slf4j
public class RealImage implements Image {

    private static final String TAG = "RealImage";

    @Override
    public void display() {
        log.info(TAG, "display target...");
    }
}
