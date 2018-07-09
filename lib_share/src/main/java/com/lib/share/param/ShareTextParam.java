package com.lib.share.param;

import android.os.Parcel;

/**
 * @author prim
 * @version 1.0.0
 * @desc
 * @time 2018/7/5 - 下午11:20
 */
public class ShareTextParam extends BaseShareParam {

    public ShareTextParam(String title, String content) {
        super(title, content);
    }

    public ShareTextParam(String title) {
        super(title, null);
    }

    public ShareTextParam() {
    }

    @Override
    public int describeContents() {
        return super.describeContents();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
    }

    protected ShareTextParam(Parcel in) {
        super(in);
    }

    public static final Creator<ShareTextParam> CREATOR = new Creator<ShareTextParam>() {
        @Override
        public ShareTextParam createFromParcel(Parcel in) {
            return new ShareTextParam(in);
        }

        @Override
        public ShareTextParam[] newArray(int size) {
            return new ShareTextParam[size];
        }
    };
}
