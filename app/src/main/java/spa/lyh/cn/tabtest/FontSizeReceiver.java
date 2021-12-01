package spa.lyh.cn.tabtest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

public class FontSizeReceiver extends BroadcastReceiver {
    private Message message;
    public static final String LAN_ACTION = ".fontsize.change";

    public FontSizeReceiver(Message message){
        this.message = message;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        if (message != null){
            message.onFontSizeChange();
        }
    }

    public interface Message{
        void onFontSizeChange();
    }

    public static void register(Context context,FontSizeReceiver receiver){
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(context.getPackageName()+LAN_ACTION);
        context.registerReceiver(receiver, intentFilter);
    }

    public static void unregister(Context context,FontSizeReceiver receiver){
        if (receiver != null){
            try {
                context.unregisterReceiver(receiver);
            }catch (IllegalArgumentException e){
            }
        }
    }
}
