package com.lib.share.handle;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Log;

import com.lib.share.R;
import com.lib.share.ShareMedia;
import com.lib.share.param.BaseShareParam;
import com.lib.share.param.ShareImage;
import com.lib.share.param.ShareImageParam;
import com.lib.share.param.ShareLinkParam;
import com.lib.share.param.ShareMusicParam;
import com.lib.share.param.ShareTextParam;
import com.lib.share.param.ShareVideoParam;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMWeb;

import java.util.List;

/**
 * @author prim
 * @version 1.0.0
 * @desc default impl share param handler
 * @time 2018/7/5 - 下午11:52
 */
public class DefaultShareParamHandle implements IShareParamHandle<ShareAction> {

    @Override
    public ShareAction loadShareParam(Activity activity, ShareMedia media, BaseShareParam param) {
        ShareAction shareAction = new ShareAction(activity);
        if (param instanceof ShareTextParam) {
            if (!TextUtils.isEmpty(param.getTitle())) {
                shareAction.withText(param.getTitle());
            }
        } else if (param instanceof ShareLinkParam) {
            ShareLinkParam linkParam = (ShareLinkParam) param;
            setLinkParam(activity, linkParam, media, shareAction);
        } else if (param instanceof ShareImageParam) {
            ShareImageParam imageParam = (ShareImageParam) param;
            setImageParam(activity, imageParam, shareAction);
        } else if (param instanceof ShareMusicParam) {

        } else if (param instanceof ShareVideoParam) {

        }
        return shareAction;
    }

    private void setLinkParam(Activity activity, ShareLinkParam linkParam, ShareMedia media, ShareAction shareAction) {
        ShareImage shareImage = linkParam.getShareImage();
        String content = linkParam.getContent();
        String title = linkParam.getTitle();
        String targetUrl = linkParam.getTargetUrl();
        if (media == ShareMedia.SINA) {
            UMImage umImage = getUMImage(activity, shareImage);
            if (umImage != null) {
                umImage.compressStyle = UMImage.CompressStyle.QUALITY;
                shareAction.withMedia(umImage);
            }
            shareAction.withText(linkParam.getTitle() + linkParam.getTargetUrl());
        } else {
            if (TextUtils.isEmpty(targetUrl)) {
                return;
            }
            UMImage umImage = getUMImage(activity, shareImage);
            UMWeb umWeb = new UMWeb(targetUrl);
            umWeb.setTitle(TextUtils.isEmpty(title) ? "" : title);
            umWeb.setDescription(TextUtils.isEmpty(content) ? "" : content);
            if (umImage != null) {
                umImage.compressStyle = UMImage.CompressStyle.QUALITY;
                umWeb.setThumb(umImage);
            }
            shareAction.withMedia(umWeb);
        }
    }

    private void setImageParam(Activity activity, ShareImageParam imageParam, ShareAction shareAction) {
        List<ShareImage> shareImageList = imageParam.getShareImage();
        if (shareImageList.size() == 1) {//share single image
            ShareImage shareImage = shareImageList.get(0);
            UMImage umImage = getUMImage(activity, shareImage);
//            UMImage thumb = new UMImage(activity, -1);
            if (umImage != null) {
                umImage.compressStyle = UMImage.CompressStyle.QUALITY;//质量压缩
//                umImage.setThumb(thumb);
                if (TextUtils.isEmpty(imageParam.getTitle())) {
                    shareAction.withMedia(umImage);
                } else {
                    shareAction.withText(imageParam.getTitle()).withMedia(umImage);
                }
            }
        } else if (shareImageList.size() > 1 && shareImageList.size() < 10) {//share multiple image,max 9
            UMImage[] umImages = new UMImage[10];
            int i = 0;
            for (ShareImage shareImage : shareImageList) {
                UMImage umImage = getUMImage(activity, shareImage);
                if (umImage != null) {
                    UMImage thumb = new UMImage(activity, R.drawable.umeng_socialize_back_icon);
                    umImage.setThumb(thumb);
                    umImage.compressStyle = UMImage.CompressStyle.QUALITY;//质量压缩
                    umImages[i] = umImage;
                    i++;
                }
            }
            Log.e("prim", "setImageParam: " + umImages);
            if (TextUtils.isEmpty(imageParam.getTitle())) {
                shareAction.withMedias(umImages);
            } else {
                shareAction.withMedias(umImages)
                        .withText(imageParam.getTitle());
            }

        }
    }

    /**
     * Obtained by type UMImage
     *
     * @param activity   Activity
     * @param shareImage {@link ShareImage}
     * @return UMImage
     */
    private UMImage getUMImage(Activity activity, ShareImage shareImage) {
        Log.e("prim", "getUMImage: " + shareImage.getImageType());
        UMImage umImage = null;
        if (shareImage.getImageType() == ShareImage.ImageType.URL) {
            umImage = new UMImage(activity, shareImage.getImageUrl());
        } else if (shareImage.getImageType() == ShareImage.ImageType.BITMAP) {
            umImage = new UMImage(activity, shareImage.getBitmap());
        } else if (shareImage.getImageType() == ShareImage.ImageType.FILE) {
            umImage = new UMImage(activity, shareImage.getFile());
        } else if (shareImage.getImageType() == ShareImage.ImageType.RES_ID) {
            umImage = new UMImage(activity, shareImage.getmImgResId());
        }
        return umImage;
    }
}
