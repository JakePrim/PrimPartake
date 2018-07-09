package com.lib.share.handle;

import android.app.Application;

import com.lib.share.entity.PlatformConfig;

/**
 * @author prim
 * @version 1.0.0
 * @desc handle platform config info
 * @time 2018/7/5 - 下午6:07
 */
public interface IPlatformConfigHandle {
    void initConfig(Application application, PlatformConfig platformConfig);
}
