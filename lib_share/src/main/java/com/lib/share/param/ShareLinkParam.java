package com.lib.share.param;

import android.os.Parcel;

/**
 * @author prim
 * @version 1.0.0
 * @desc share link param
 * @time 2018/7/5 - 下午11:45
 */
public class ShareLinkParam extends BaseShareParam {

    private ShareImage shareImage;

    public ShareLinkParam(){

    }

    public ShareImage getShareImage() {
        return shareImage;
    }

    public void setShareImage(ShareImage shareImage) {
        this.shareImage = shareImage;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeParcelable(shareImage, 0);
    }

    protected ShareLinkParam(Parcel in) {
        super(in);
        shareImage = in.readParcelable(ShareImage.class.getClassLoader());
    }

    public static final Creator<ShareLinkParam> CREATOR = new Creator<ShareLinkParam>() {
        @Override
        public ShareLinkParam createFromParcel(Parcel in) {
            return new ShareLinkParam(in);
        }

        @Override
        public ShareLinkParam[] newArray(int size) {
            return new ShareLinkParam[size];
        }
    };
}
