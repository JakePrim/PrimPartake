package com.lib.share.client;

import android.app.Activity;

import com.lib.share.ShareMedia;
import com.lib.share.handle.IShareParamHandle;
import com.lib.share.listener.SocializeListener;
import com.lib.share.param.BaseShareParam;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;

/**
 * @author prim
 * @version 1.0.0
 * @desc default impl share client
 * @time 2018/7/6 - 上午12:00
 */
public class DefaultShareClient implements IShareClient, UMShareListener {

    private SocializeListener.ShareListenerAdapter listenerAdapter;

    @Override
    public void share(Activity activity, ShareMedia media, IShareParamHandle paramHandle, BaseShareParam param, SocializeListener.ShareListenerAdapter listener) {
        this.listenerAdapter = listener;
        //load share param
        ShareAction shareAction = (ShareAction) paramHandle.loadShareParam(activity, media, param);
        shareAction.setPlatform(getShareMedia(media)).setCallback(this).share();
    }


    private SHARE_MEDIA getShareMedia(ShareMedia media) {
        SHARE_MEDIA share_media = null;
        if (media == ShareMedia.SINA) {
            share_media = SHARE_MEDIA.SINA;
        } else if (media == ShareMedia.QQ) {
            share_media = SHARE_MEDIA.QQ;
        } else if (media == ShareMedia.WEIXIN) {
            share_media = SHARE_MEDIA.WEIXIN;
        } else if (media == ShareMedia.QZONE) {
            share_media = SHARE_MEDIA.QZONE;
        } else if (media == ShareMedia.WEIXIN_CIRCLE) {
            share_media = SHARE_MEDIA.WEIXIN_CIRCLE;
        }
        return share_media;
    }

    private ShareMedia getAgentMedia(SHARE_MEDIA media) {
        ShareMedia share_media = null;
        if (media == SHARE_MEDIA.SINA) {
            share_media = ShareMedia.SINA;
        } else if (media == SHARE_MEDIA.QQ) {
            share_media = ShareMedia.QQ;
        } else if (media == SHARE_MEDIA.WEIXIN) {
            share_media = ShareMedia.WEIXIN;
        } else if (media == SHARE_MEDIA.QZONE) {
            share_media = ShareMedia.QZONE;
        } else if (media == SHARE_MEDIA.WEIXIN_CIRCLE) {
            share_media = ShareMedia.WEIXIN_CIRCLE;
        }
        return share_media;
    }

    @Override
    public void onStart(SHARE_MEDIA share_media) {
        if (listenerAdapter != null) {
            listenerAdapter.onStart(getAgentMedia(share_media));
        }
    }

    @Override
    public void onResult(SHARE_MEDIA share_media) {
        if (listenerAdapter != null) {
            listenerAdapter.onResult(getAgentMedia(share_media));
        }
    }

    @Override
    public void onError(SHARE_MEDIA share_media, Throwable throwable) {
        if (listenerAdapter != null) {
            listenerAdapter.onError(getAgentMedia(share_media), throwable);
        }
    }

    @Override
    public void onCancel(SHARE_MEDIA share_media) {
        if (listenerAdapter != null) {
            listenerAdapter.onCancle(getAgentMedia(share_media));
        }
    }
}
