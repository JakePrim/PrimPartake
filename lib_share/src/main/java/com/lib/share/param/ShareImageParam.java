package com.lib.share.param;

import android.os.Parcel;

import java.util.ArrayList;
import java.util.List;

/**
 * @author prim
 * @version 1.0.0
 * @desc set share image param
 * @time 2018/7/5 - 下午3:21
 */
public class ShareImageParam extends BaseShareParam {

    /**
     * can share multiple image
     */
    private List<ShareImage> shareImageList;

    public ShareImageParam(String title, List<ShareImage> image) {
        super(title, null);
        this.shareImageList = image;
    }

    public ShareImageParam(){

    }

    /**
     * set share image info
     *
     * @param shareImage {@link ShareImage}
     */
    public void setShareImage(List<ShareImage> shareImage) {
        this.shareImageList = shareImage;
    }

    public List<ShareImage> getShareImage() {
        return shareImageList;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeTypedList(shareImageList);
    }

    protected ShareImageParam(Parcel in) {
        super(in);
        if (shareImageList == null) {
            shareImageList = new ArrayList<>();
        }
        in.readTypedList(shareImageList, ShareImage.CREATOR);
    }

    public static final Creator<ShareImageParam> CREATOR = new Creator<ShareImageParam>() {
        @Override
        public ShareImageParam createFromParcel(Parcel in) {
            return new ShareImageParam(in);
        }

        @Override
        public ShareImageParam[] newArray(int size) {
            return new ShareImageParam[size];
        }
    };
}
