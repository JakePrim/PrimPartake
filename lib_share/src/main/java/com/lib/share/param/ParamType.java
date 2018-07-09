package com.lib.share.param;

/**
 * @author prim
 * @version 1.0.0
 * @desc share param type
 * @time 2018/7/5 - 下午6:53
 */
public enum ParamType {
    TEXT, //only text
    TEXT_URL,// text and url
    NET_IMAGE_TEXT, //image and text
    FILE_IMAGE_TEXT, //image and text
    BITMAP_IMAGE_TEXT, //image and text
    RES_IMAGE_TEXT, //image and text
    NET_IMAGE_TEXT_URL, //image and text and url
    FILE_IMAGE_TEXT_URL, //image and text and url
    BITMAP_IMAGE_TEXT_URL, //image and text and url
    RES_IMAGE_TEXT_URL, //image and text and url
    NET_IMAGE, //only image
    FILE_IMAGE, //only image
    BITMAP_IMAGE, //only image
    RES_IMAGE //only image
}
