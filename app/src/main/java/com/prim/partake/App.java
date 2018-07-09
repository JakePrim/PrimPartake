package com.prim.partake;

import android.app.Application;

import com.lib.share.PrimPartake;
import com.lib.share.config.SharePlatformSpec;

/**
 * @author prim
 * @version 1.0.0
 * @desc
 * @time 2018/7/6 - 下午2:07
 */
public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        SharePlatformSpec platformSpec = SharePlatformSpec.platformBuilder()
                .build();
        PrimPartake.defaultPartake().initShareConfig(this, platformSpec);
    }
}
