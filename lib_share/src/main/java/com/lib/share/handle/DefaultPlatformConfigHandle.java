package com.lib.share.handle;

import android.app.Application;

import com.lib.share.ShareMedia;
import com.lib.share.entity.PlatformConfig;
import com.umeng.commonsdk.UMConfigure;

import java.util.Map;

/**
 * @author prim
 * @version 1.0.0
 * @desc share platform real init config handle
 * @time 2018/7/5 - 下午6:14
 */
public class DefaultPlatformConfigHandle implements IPlatformConfigHandle {
    @Override
    public void initConfig(Application application, PlatformConfig platformConfig) {
        Map<String, String> wxConfig = platformConfig.getPlatformConfig(ShareMedia.WEIXIN);
        Map<String, String> qqConfig = platformConfig.getPlatformConfig(ShareMedia.QQ);
        Map<String, String> sinaConfig = platformConfig.getPlatformConfig(ShareMedia.SINA);

        String wxAppId = wxConfig.get(PlatformConfig.APP_ID);
        String wxAppKey = wxConfig.get(PlatformConfig.APP_KEY);

        String qqAppId = qqConfig.get(PlatformConfig.APP_ID);
        String qqAppKey = qqConfig.get(PlatformConfig.APP_KEY);

        String sinaAppId = sinaConfig.get(PlatformConfig.APP_ID);
        String sinaAppKey = sinaConfig.get(PlatformConfig.APP_KEY);
        String sinaRedirectUrl = sinaConfig.get(PlatformConfig.REDIRECT_URL);

        UMConfigure.setLogEnabled(true);

        com.umeng.socialize.PlatformConfig.setWeixin(wxAppId, wxAppKey);
        com.umeng.socialize.PlatformConfig.setQQZone(qqAppId, qqAppKey);
        com.umeng.socialize.PlatformConfig.setSinaWeibo(sinaAppId, sinaAppKey, sinaRedirectUrl);
    }
}
