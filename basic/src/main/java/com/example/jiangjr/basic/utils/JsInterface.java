package com.example.jiangjr.basic.utils;


public class JsInterface extends Object {

    private WebViewEvent  webViewEvent;

    public WebViewEvent getWebViewEvent() {
        return webViewEvent;
    }

    public void setWebViewEvent(WebViewEvent webViewEvent) {
        this.webViewEvent = webViewEvent;
    }


//    /**
//     * 上传文章转发图片thumb
//     */
//    @JavascriptInterface
//    public void addThumbImg() {
//        webViewEvent.selectThumb();
//    }
//
//
//    /**
//     * 文章插入图片方法监听
//     * @return 插入后的图片地址
//     */
//    @JavascriptInterface
//    public void insertPhoto() {
//        webViewEvent.selectPhoto();
//    }
//
//    @JavascriptInterface
//    public void toMyArticleList() {
//        webViewEvent.toMyArticleList();
//    }
//
//    @JavascriptInterface
//    public void saveArticleSuc(String url,String thumb) {
//        webViewEvent.saveArticleSuc(url,thumb);
//    }
//
//    @JavascriptInterface
//    public void doLevelUp(String level) {
//        webViewEvent.doLevelUp(level);
//    }
//    //提现完成
//    @JavascriptInterface
//    public void finishCash() {
//        webViewEvent.finishCash();
//    }
//    /**
//     * 会员升级跳转
//     */
//    @JavascriptInterface
//    public void toLevelUp() {
//        webViewEvent.toLevelUp();
//    }

    public interface  WebViewEvent{
//        public void selectThumb();
//        public void selectPhoto();
//        public void toMyArticleList();
//        public void toLevelUp();
//        public void saveArticleSuc(String url, String thumb);
//        public void doLevelUp(String level);
//        public void finishCash();
    }
}