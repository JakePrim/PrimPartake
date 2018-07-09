package com.lib.share.handle;

import android.app.Activity;

import com.lib.share.ShareMedia;
import com.lib.share.param.BaseShareParam;

/**
 * @author prim
 * @version 1.0.0
 * @desc share param handler
 * @time 2018/7/5 - 下午11:52
 */
public interface IShareParamHandle<T> {
    T loadShareParam(Activity activity, ShareMedia media, BaseShareParam param);
}
