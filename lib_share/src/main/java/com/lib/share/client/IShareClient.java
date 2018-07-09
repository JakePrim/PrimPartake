package com.lib.share.client;

import android.app.Activity;

import com.lib.share.ShareMedia;
import com.lib.share.handle.IShareParamHandle;
import com.lib.share.listener.SocializeListener;
import com.lib.share.param.BaseShareParam;

/**
 * @author prim
 * @version 1.0.0
 * @desc share client interface, need to impl {@link IShareClient} interface.
 * @time 2018/7/5 - 上午11:25
 */
public interface IShareClient {

    /**
     * start share
     *
     * @param activity    context
     * @param media       {@link ShareMedia} select share media
     * @param paramHandle {@link IShareParamHandle} set share param handler
     * @param param       {@link BaseShareParam} share param
     * @param listener    {@link SocializeListener} share listener
     */
    void share(Activity activity, ShareMedia media, IShareParamHandle paramHandle, BaseShareParam param, SocializeListener.ShareListenerAdapter listener);
}
