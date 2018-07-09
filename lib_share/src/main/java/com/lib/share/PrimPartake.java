package com.lib.share;

import android.app.Activity;
import android.app.Application;
import android.text.TextUtils;

import com.lib.share.client.DefaultShareClient;
import com.lib.share.client.IShareClient;
import com.lib.share.config.SharePlatformSpec;
import com.lib.share.handle.IPlatformConfigHandle;
import com.lib.share.handle.IShareParamHandle;
import com.lib.share.handle.DefaultPlatformConfigHandle;
import com.lib.share.handle.DefaultShareParamHandle;
import com.lib.share.listener.SocializeListener;
import com.lib.share.param.ShareParamSpec;

import java.util.HashMap;
import java.util.Map;

/**
 * @author prim
 * @version 1.0.0
 * @desc share entrance
 * @time 2018/7/5 - 上午11:18
 */
public class PrimPartake {
    private static final String TAG = "PrimPartake";

    private static PrimPartake primPartake = null;

    private static final String DEFAULT_CLIENT_NAME = "_share_client_name_default";

    private static final Map<String, PrimPartake> CLIENT_MAP = new HashMap<>();

    private String clientKey;

    private SharePlatformSpec platformSpec;

    private IShareClient shareClient;

    private IPlatformConfigHandle platformConfigHandle;

    private IShareParamHandle shareParamHandle;

    /**
     * get share client
     *
     * @param key {{@link #CLIENT_MAP}} key
     * @return PrimPartake
     */
    public static PrimPartake partake(String key) {
        if (TextUtils.isEmpty(key)) {
            throw new IllegalArgumentException("client key can not be null");
        }
        PrimPartake partake = CLIENT_MAP.get(key);
        if (partake == null) {
            synchronized (CLIENT_MAP) {
                partake = CLIENT_MAP.get(key);
                if (partake == null) {
                    partake = new PrimPartake(key);
                    CLIENT_MAP.put(key, partake);
                    primPartake = partake;
                }
                return partake;
            }
        } else {
            primPartake = partake;
        }
        return partake;
    }

    /**
     * get default share client
     *
     * @return PrimPartake
     */
    public static PrimPartake defaultPartake() {
        return partake(DEFAULT_CLIENT_NAME);
    }

    private PrimPartake(String key) {
        this.clientKey = key;
    }

    //------------------- core method ---------------------//

    //------------------in application init platform config --> start-------------------//

    /**
     * init share platform info config,application init.
     * {@link DefaultPlatformConfigHandle} handle init config
     * {@link com.lib.share.client.DefaultShareClient} handle share
     *
     * @param platformSpec share platform info
     */
    public void initShareConfig(Application application, SharePlatformSpec platformSpec) {
        this.platformSpec = platformSpec;
        if (platformConfigHandle == null) {
            platformConfigHandle = new DefaultPlatformConfigHandle();
        }
        platformConfigHandle.initConfig(application, platformSpec.getPlatformConfig());
    }

    /**
     * init share platform info config,application init.
     * {@link DefaultPlatformConfigHandle} handle init config
     *
     * @param platformSpec share platform info
     * @param shareClient  set custom share client
     */
    public void initShareConfig(Application application, SharePlatformSpec platformSpec, IShareClient shareClient) {
        this.platformSpec = platformSpec;
        this.shareClient = shareClient;
        if (platformConfigHandle == null) {
            platformConfigHandle = new DefaultPlatformConfigHandle();
        }
        platformConfigHandle.initConfig(application, platformSpec.getPlatformConfig());
    }

    /**
     * init share platform info config,application init.
     * {@link com.lib.share.client.DefaultShareClient} handle share
     *
     * @param platformSpec share platform info
     * @param handle       handling it yourself share platform config init.
     */
    public void initShareConfig(Application application, SharePlatformSpec platformSpec, IPlatformConfigHandle handle) {
        this.platformSpec = platformSpec;
        handle.initConfig(application, platformSpec.getPlatformConfig());
    }

    /**
     * init share platform info config,application init.
     *
     * @param platformSpec share platform info
     * @param shareClient  share client
     * @param handle       handling it yourself share platform config init.
     */
    public void initShareConfig(Application application, SharePlatformSpec platformSpec, IShareClient shareClient, IPlatformConfigHandle handle) {
        this.platformSpec = platformSpec;
        this.shareClient = shareClient;
        handle.initConfig(application, platformSpec.getPlatformConfig());
    }

    //---------------------- in application init platform config <--end ---------------------//

    /**
     * set share client
     *
     * @param shareClient {@link IShareClient}
     */
    public PrimPartake setShareClient(IShareClient shareClient) {
        this.shareClient = shareClient;
        return this;
    }

    /**
     * set share param handler
     *
     * @param shareParamHandle {@link IShareParamHandle}
     * @return PrimPartake
     */
    public PrimPartake setShareParamHandle(IShareParamHandle shareParamHandle) {
        this.shareParamHandle = shareParamHandle;
        return this;
    }

    /**
     * get share client,handling it yourself handle share.
     *
     * @return {@link IShareClient}
     */
    public IShareClient getShareClient() {
        if (shareClient == null) {
            throw new NullPointerException("share client not null");
        }
        return shareClient;
    }

    /**
     * start share
     *
     * @param activity
     * @param media
     * @param paramSpec
     * @param listener
     */
    public void share(Activity activity, ShareMedia media, ShareParamSpec paramSpec, SocializeListener.ShareListenerAdapter listener) {
        if (platformSpec == null) {
            throw new IllegalArgumentException("SharePlatformConfig must be initialized invoke share");
        }
        if (paramSpec == null) {
            throw new NullPointerException("ShareParamSpec must not null");
        }

        if (media == null) {
            throw new NullPointerException("ShareMedia must not null");
        }

        if (shareClient == null) {
            shareClient = new DefaultShareClient();
        }

        if (shareParamHandle == null) {
            shareParamHandle = new DefaultShareParamHandle();
        }

        shareClient.share(activity, media, shareParamHandle, paramSpec.getShareParam(), listener);

    }
}
