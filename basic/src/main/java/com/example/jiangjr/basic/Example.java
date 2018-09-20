package com.example.jiangjr.basic;

/**
 * Created by Jiangjr on 2015/11/23.
 */
public class Example {

    /*    // 回调函数中不能做UI操作，所以可以使用runOnUiThread函数来包装一下代码块
    runOnUiThread(new Runnable() {
        public void run() {
            pd.hide();
            ticketInfo = new TicketInfo();
            try {
                ticketInfo.loadFromServerData(DataParser
                        .parseJSON2Map(new JSONObject(data_json)));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            showTicketInfo();
        }
    });*/

}
