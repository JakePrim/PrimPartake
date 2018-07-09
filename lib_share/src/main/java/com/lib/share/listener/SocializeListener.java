package com.lib.share.listener;

import com.lib.share.ShareMedia;

/**
 * @author prim
 * @version 1.0.0
 * @desc share socialize listener
 * @time 2018/7/5 - 下午3:02
 */
public abstract class SocializeListener {
    public interface ShareListener {
        void onStart(ShareMedia media);

        void onProgress(ShareMedia media, String progress);

        void onResult(ShareMedia media);

        void onError(ShareMedia media, Throwable throwable);

        void onCancle(ShareMedia media);
    }

    public static abstract class ShareListenerAdapter implements ShareListener {
        @Override
        public void onStart(ShareMedia media) {

        }

        @Override
        public void onProgress(ShareMedia media, String progress) {

        }

        @Override
        public void onResult(ShareMedia media) {

        }

        @Override
        public void onError(ShareMedia media, Throwable throwable) {

        }

        @Override
        public void onCancle(ShareMedia media) {

        }
    }
}
