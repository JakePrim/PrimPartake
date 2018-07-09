package com.lib.share.param;

import android.os.Parcel;
import android.os.Parcelable;

import com.umeng.socialize.media.Base;

/**
 * @author prim
 * @version 1.0.0
 * @desc share param base class
 * @time 2018/7/5 - 下午3:12
 */
public abstract class BaseShareParam implements Parcelable {

    protected String title;

    protected String content;

    protected String targetUrl;

    public BaseShareParam(String title, String content, String targetUrl) {
        this.title = title;
        this.content = content;
        this.targetUrl = targetUrl;
    }

    public BaseShareParam(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public BaseShareParam(){

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTargetUrl() {
        return targetUrl;
    }

    public void setTargetUrl(String targetUrl) {
        this.targetUrl = targetUrl;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(content);
        dest.writeString(targetUrl);
    }

    protected BaseShareParam(Parcel in) {
        title = in.readString();
        content = in.readString();
        targetUrl = in.readString();
    }
}
