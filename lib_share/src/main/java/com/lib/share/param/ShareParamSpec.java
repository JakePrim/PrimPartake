package com.lib.share.param;

import android.graphics.Bitmap;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author prim
 * @version 1.0.0
 * @desc set share param
 * @time 2018/7/5 - 下午6:55
 */
public class ShareParamSpec {

    private BaseShareParam param;

    private ParamType paramType;


    public static Builder paramBuilder() {
        return new Builder();
    }

    public ShareParamSpec(BaseShareParam param) {
        this.param = param;
    }

    public BaseShareParam getShareParam() {
        return param;
    }

    public static class Builder {
        /**
         * add only text param
         *
         * @return TextParamBuilder
         */
        public TextParamBuilder addTextParam() {
            return new TextParamBuilder();
        }

        /**
         * add image param,can add title
         *
         * @return ImageParamBuilder
         */
        public ImageParamBuilder addImageParam() {
            return new ImageParamBuilder();
        }

        /**
         * add link param,need ser title 、 content 、 image 、 targetUrl
         *
         * @return LinkParamBuilder
         */
        public LinkParamBuilder addLinkParam() {
            return new LinkParamBuilder();
        }

        /**
         * add video param
         *
         * @return VideoParamBuilder
         */
        public VideoParamBuilder addVideoParam() {
            return new VideoParamBuilder();
        }

        /**
         * add audio param
         *
         * @return MusicParamBuilder
         */
        public MusicParamBuilder addMusicParam() {
            return new MusicParamBuilder();
        }
    }

    public static class VideoParamBuilder {
        private ShareVideoParam shareVideoParam;
        private ShareImage thumbImage;

        public VideoParamBuilder() {
            shareVideoParam = new ShareVideoParam();
            thumbImage = new ShareImage();
        }

        public VideoParamBuilder addShareTitle(String title) {
            shareVideoParam.setTitle(title);
            return this;
        }

        public VideoParamBuilder addShareContent(String content) {
            shareVideoParam.setContent(content);
            return this;
        }

        public VideoParamBuilder addVideoUrl(String videoUrl) {
            shareVideoParam.setVideoUrl(videoUrl);
            return this;
        }

        public VideoParamBuilder addShareImageUrl(String imageUrl) {
            thumbImage.setImageUrl(imageUrl);
            return this;
        }

        public VideoParamBuilder addShareBitmap(Bitmap bitmap) {
            thumbImage.setBitmap(bitmap);
            return this;
        }

        public VideoParamBuilder addShareFile(File file) {
            thumbImage.setFile(file);
            return this;
        }

        public VideoParamBuilder addShareImageRes(int imgResId) {
            thumbImage.setmImgResId(imgResId);
            return this;
        }

        public ShareParamSpec build() {
            shareVideoParam.setThumbImage(thumbImage);
            return new ShareParamSpec(shareVideoParam);
        }

    }

    public static class MusicParamBuilder {
        private ShareMusicParam shareMusicParam;
        private ShareImage thumbImage;

        public MusicParamBuilder() {
            shareMusicParam = new ShareMusicParam();
            thumbImage = new ShareImage();
        }

        public MusicParamBuilder addShareTitle(String title) {
            shareMusicParam.setTitle(title);
            return this;
        }

        public MusicParamBuilder addShareContent(String content) {
            shareMusicParam.setContent(content);
            return this;
        }

        public MusicParamBuilder addMusicUrl(String musicUrl) {
            shareMusicParam.setMusicUrl(musicUrl);
            return this;
        }

        public MusicParamBuilder addShareTargetUrl(String targetUtl) {
            shareMusicParam.setTargetUrl(targetUtl);
            return this;
        }

        public MusicParamBuilder addShareImageUrl(String imageUrl) {
            thumbImage.setImageUrl(imageUrl);
            return this;
        }

        public MusicParamBuilder addShareBitmap(Bitmap bitmap) {
            thumbImage.setBitmap(bitmap);
            return this;
        }

        public MusicParamBuilder addShareFile(File file) {
            thumbImage.setFile(file);
            return this;
        }

        public MusicParamBuilder addShareImageRes(int imgResId) {
            thumbImage.setmImgResId(imgResId);
            return this;
        }

        public ShareParamSpec build() {
            shareMusicParam.setThumbImage(thumbImage);
            return new ShareParamSpec(shareMusicParam);
        }

    }

    /**
     * only add text param
     */
    public static class TextParamBuilder {
        private ShareTextParam shareTextParam;

        public TextParamBuilder() {
            shareTextParam = new ShareTextParam();
        }

        public TextParamBuilder addShareTitle(String title) {
            shareTextParam.setTitle(title);
            return this;
        }

        public ShareParamSpec build() {
            return new ShareParamSpec(shareTextParam);
        }
    }

    /**
     * share image param info,can share multiple image
     */
    public static class ImageParamBuilder {
        private ShareImageParam shareImageParam;
        private List<ShareImage> shareImageList;

        public ImageParamBuilder() {
            shareImageParam = new ShareImageParam();
            shareImageList = new ArrayList<>();
        }

        public ImageParamBuilder addShareTitle(String title) {
            shareImageParam.setTitle(title);
            return this;
        }

        public ImageParamBuilder addShareImageUrl(String imageUrl) {
            ShareImage shareImage = new ShareImage(imageUrl);
            shareImageList.add(shareImage);
            return this;
        }

        public ImageParamBuilder addShareBitmap(Bitmap bitmap) {
            ShareImage shareImage = new ShareImage(bitmap);
            shareImageList.add(shareImage);
            return this;
        }

        public ImageParamBuilder addShareFile(File file) {
            ShareImage shareImage = new ShareImage(file);
            shareImageList.add(shareImage);
            return this;
        }

        public ImageParamBuilder addShareImageRes(int imgResId) {
            ShareImage shareImage = new ShareImage(imgResId);
            shareImageList.add(shareImage);
            return this;
        }

        public ShareParamSpec build() {
            shareImageParam.setShareImage(shareImageList);
            return new ShareParamSpec(shareImageParam);
        }
    }

    /**
     * only add image param
     */
    public static class LinkParamBuilder {
        private ShareLinkParam shareLinkParam;
        private ShareImage shareImage;

        public LinkParamBuilder() {
            shareLinkParam = new ShareLinkParam();
            shareImage = new ShareImage();
        }

        public LinkParamBuilder addShareTitle(String title) {
            shareLinkParam.setTitle(title);
            return this;
        }

        public LinkParamBuilder addShareTargetUrl(String targetUtl) {
            shareLinkParam.setTargetUrl(targetUtl);
            return this;
        }

        public LinkParamBuilder addShareContent(String content) {
            shareLinkParam.setContent(content);
            return this;
        }

        public LinkParamBuilder addShareImageUrl(String imageUrl) {
            shareImage.setImageUrl(imageUrl);
            return this;
        }

        public LinkParamBuilder addShareBitmap(Bitmap bitmap) {
            shareImage.setBitmap(bitmap);
            return this;
        }

        public LinkParamBuilder addShareFile(File file) {
            shareImage.setFile(file);
            return this;
        }

        public LinkParamBuilder addShareImageRes(int imgResId) {
            shareImage.setmImgResId(imgResId);
            return this;
        }

        public ShareParamSpec build() {
            shareLinkParam.setShareImage(shareImage);
            return new ShareParamSpec(shareLinkParam);
        }
    }

}
