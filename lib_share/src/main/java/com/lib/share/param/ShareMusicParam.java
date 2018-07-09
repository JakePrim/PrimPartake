package com.lib.share.param;

import android.os.Parcel;

/**
 * @author prim
 * @version 1.0.0
 * @desc
 * @time 2018/7/6 - 下午4:43
 */
public class ShareMusicParam extends BaseShareParam {

    private String musicUrl;

    private ShareImage thumbImage;

    public ShareMusicParam() {

    }

    public String getMusicUrl() {
        return musicUrl;
    }

    public void setMusicUrl(String musicUrl) {
        this.musicUrl = musicUrl;
    }

    public ShareImage getThumbImage() {
        return thumbImage;
    }

    public void setThumbImage(ShareImage thumbImage) {
        this.thumbImage = thumbImage;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeString(musicUrl);
        dest.writeParcelable(thumbImage, 0);
    }

    protected ShareMusicParam(Parcel in) {
        super(in);
        musicUrl = in.readString();
        thumbImage = in.readParcelable(ShareImage.class.getClassLoader());
    }

    public static final Creator<ShareMusicParam> CREATOR = new Creator<ShareMusicParam>() {
        @Override
        public ShareMusicParam createFromParcel(Parcel in) {
            return new ShareMusicParam(in);
        }

        @Override
        public ShareMusicParam[] newArray(int size) {
            return new ShareMusicParam[size];
        }
    };
}
