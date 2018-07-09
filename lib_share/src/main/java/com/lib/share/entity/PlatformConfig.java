package com.lib.share.entity;

import android.util.SparseArray;

import com.lib.share.ShareMedia;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @author prim
 * @version 1.0.0
 * @desc share platform config entity
 * @time 2018/7/5 - 上午11:35
 */
public class PlatformConfig implements Serializable {

    public static final String APP_ID = "app_id";
    public static final String APP_KEY = "app_key";
    public static final String REDIRECT_URL = "redirect_url";

    /**
     * save platform config info
     */
    private SparseArray<Map<String, String>> mPlatformConfig = new SparseArray<>();

    /**
     * add platform config info
     *
     * @param media platform
     * @param info  config info
     */
    public void addPlatformConfig(ShareMedia media, String... info) {
        if (info == null || info.length % 2 != 0) {
            throw new RuntimeException("please check app platform config");
        }

        Map<String, String> infoMap = new HashMap<>();
        int length = info.length / 2;
        for (int i = 0; i < length; i++) {
            infoMap.put(info[i * 2], info[(i * 2) + 1]);
        }
        //以分享类型的枚举序数作为key
        mPlatformConfig.put(media.ordinal(), infoMap);
    }

    /**
     * get platform config info
     *
     * @param media {@link ShareMedia} select share platform
     * @return config info
     */
    public Map<String, String> getPlatformConfig(ShareMedia media) {
        return mPlatformConfig.get(media.ordinal());
    }

    /**
     * share platform has config ?
     *
     * @param media {@link ShareMedia} select share platform
     * @return true has config; false not config
     */
    public boolean hasPlatformConfig(ShareMedia media) {
        return mPlatformConfig.size() > 0 && mPlatformConfig.get(media.ordinal()).isEmpty();
    }

    /**
     * Is there a platform config
     * @return true has config; false not config
     */
    public boolean hasConfig() {
        return mPlatformConfig.size() > 0;
    }
}
