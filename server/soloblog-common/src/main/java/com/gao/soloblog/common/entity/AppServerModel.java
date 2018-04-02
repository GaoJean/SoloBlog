package com.gao.soloblog.common.entity;

/**
 * appserver.prpperties的模型文件
 */
public class AppServerModel {

    public static boolean verifyToken;

    public static boolean picThumbanailEnabled;

    public static String picThumbanailSuffix;

    public static boolean isVerifyToken() {
        return verifyToken;
    }

    public static void setVerifyToken(boolean verifyToken) {
    	AppServerModel.verifyToken = verifyToken;
    }
    
	public static boolean isPicThumbanailEnabled() {
        return picThumbanailEnabled;
    }

    public static void setPicThumbanailEnabled(String picThumbanailEnabled) {
    	AppServerModel.picThumbanailEnabled = Boolean.valueOf(picThumbanailEnabled);
    }

    public static String getPicThumbanailSuffix() {
        return picThumbanailSuffix;
    }

    public static void setPicThumbanailSuffix(String picThumbanailSuffix) {
    	AppServerModel.picThumbanailSuffix = picThumbanailSuffix;
    }

}
