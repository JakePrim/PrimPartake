package com.lib.share.param;

import android.os.Parcel;

/**
 * @author prim
 * @version 1.0.0
 * @desc
 * @time 2018/7/6 - 下午4:43
 */
public class ShareVideoParam extends BaseShareParam {

    private ShareImage thumbImage;

    private String videoUrl;

    public ShareVideoParam() {

    }

    public ShareImage getThumbImage() {
        return thumbImage;
    }

    public void setThumbImage(ShareImage thumbImage) {
        this.thumbImage = thumbImage;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeString(videoUrl);
        dest.writeParcelable(thumbImage, 0);
    }

    protected ShareVideoParam(Parcel in) {
        super(in);
        videoUrl = in.readString();
        thumbImage = in.readParcelable(ShareImage.class.getClassLoader());
    }

    public static final Creator<ShareVideoParam> CREATOR = new Creator<ShareVideoParam>() {
        @Override
        public ShareVideoParam createFromParcel(Parcel in) {
            return new ShareVideoParam(in);
        }

        @Override
        public ShareVideoParam[] newArray(int size) {
            return new ShareVideoParam[size];
        }
    };
}
