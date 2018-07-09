package com.lib.share.config;

import android.text.TextUtils;

import com.lib.share.ShareMedia;
import com.lib.share.entity.PlatformConfig;

/**
 * @author prim
 * @version 1.0.0
 * @desc share platform config spec
 * @time 2018/7/5 - 下午2:30
 */
public class SharePlatformSpec {

    private PlatformConfig platformConfig;

    public SharePlatformSpec(Builder builder) {
        this.platformConfig = builder.platformConfig;
    }

    /**
     * get share platform config info
     *
     * @return {@link PlatformConfig}
     */
    public PlatformConfig getPlatformConfig() {
        return platformConfig;
    }

    public static Builder platformBuilder() {
        return new Builder();
    }

    public static class Builder {

        private PlatformConfig platformConfig;

        public Builder() {
            platformConfig = new PlatformConfig();
        }

        public Builder sina(String appId, String appKey) {
            sina(appId, appKey, null);
            return this;
        }

        public Builder sina(String appId, String appKey, String redirectUrl) {
            if (TextUtils.isEmpty(redirectUrl)) {
                redirectUrl = DefaultConfig.REDIRECT_URL;
            }
            platformConfig.addPlatformConfig(ShareMedia.SINA,
                    PlatformConfig.APP_ID, appId,
                    PlatformConfig.APP_KEY, appKey,
                    PlatformConfig.REDIRECT_URL, redirectUrl);
            return this;
        }

        public Builder qq(String appId, String appKey) {
            platformConfig.addPlatformConfig(ShareMedia.QQ,
                    PlatformConfig.APP_ID, appId,
                    PlatformConfig.APP_KEY, appKey);
            return this;
        }

        public Builder wx(String appId, String appKey) {
            platformConfig.addPlatformConfig(ShareMedia.WEIXIN,
                    PlatformConfig.APP_ID, appId,
                    PlatformConfig.APP_KEY, appKey);
            return this;
        }

        public SharePlatformSpec build() {
            return new SharePlatformSpec(this);
        }
    }
}
