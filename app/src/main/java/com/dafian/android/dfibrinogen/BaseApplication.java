package com.dafian.android.dfibrinogen;

import android.app.Application;

import me.yokeyword.fragmentation.Fragmentation;

/**
 * @author Dafian on 2/7/18
 */

public class BaseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        // Configuration Fragmentation
        Fragmentation.builder()
                .stackViewMode(Fragmentation.BUBBLE)
                .debug(true)
                .handleException(e -> {
                    // Handle error fragment stack
                    // Report to Crash reporting

                })
                .install();
    }
}
