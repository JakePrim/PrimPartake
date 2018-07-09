package com.lib.share.param;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

import java.io.File;

/**
 * @author prim
 * @version 1.0.0
 * @desc share image
 * @time 2018/7/5 - 下午3:36
 */
public class ShareImage implements Parcelable {

    private Bitmap bitmap;

    private String imageUrl;

    private int mImgResId = -1;

    private File file;

    public ShareImage() {

    }

    public ShareImage(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public ShareImage(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public ShareImage(int resId) {
        this.mImgResId = resId;
    }

    public ShareImage(File file) {
        this.file = file;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public int getmImgResId() {
        return mImgResId;
    }

    public File getFile() {
        return file;
    }

    public String getLocalPath() {
        return file == null ? null : file.exists() ? file.getAbsolutePath() : null;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;

        this.imageUrl = null;
        this.file = null;
        this.mImgResId = -1;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;

        this.bitmap = null;
        this.file = null;
        this.mImgResId = -1;

    }

    public void setmImgResId(int mImgResId) {
        this.mImgResId = mImgResId;

        this.bitmap = null;
        this.imageUrl = null;
        this.file = null;
    }

    public void setFile(File file) {
        this.file = file;

        this.mImgResId = -1;
        this.imageUrl = null;
        this.bitmap = null;
    }

    public boolean isNetImage() {
        return this.imageUrl != null && getImageType() == ImageType.URL;
    }

    public ImageType getImageType() {
        if (!TextUtils.isEmpty(imageUrl)) {
            return ImageType.URL;
        } else if (file != null && file.exists()) {
            return ImageType.FILE;
        } else if (mImgResId != -1) {
            return ImageType.RES_ID;
        } else if (bitmap != null && !bitmap.isRecycled()) {
            return ImageType.BITMAP;
        } else {
            return ImageType.UN_KNOW;
        }
    }

    public enum ImageType {
        UN_KNOW, FILE, BITMAP, RES_ID, URL
    }

    public static final Creator<ShareImage> CREATOR = new Creator<ShareImage>() {
        @Override
        public ShareImage createFromParcel(Parcel in) {
            return new ShareImage(in);
        }

        @Override
        public ShareImage[] newArray(int size) {
            return new ShareImage[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(imageUrl);
        dest.writeInt(mImgResId);
        dest.writeParcelable(bitmap, 0);
        dest.writeString(file == null ? null : file.getAbsolutePath());
    }

    protected ShareImage(Parcel in) {
        imageUrl = in.readString();
        mImgResId = in.readInt();
        bitmap = in.readParcelable(Bitmap.class.getClassLoader());
        String path = in.readString();
        file = TextUtils.isEmpty(path) ? null : new File(path);
    }
}
