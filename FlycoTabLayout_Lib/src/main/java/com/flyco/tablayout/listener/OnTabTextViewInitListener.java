package com.flyco.tablayout.listener;

import android.widget.TextView;

public interface OnTabTextViewInitListener {

    void onTabTextViewInit(int position, TextView tv);

    void onTabTextViewSelect(int position,boolean isSelect, TextView tv);
}
