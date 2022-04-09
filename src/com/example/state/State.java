package com.example.state;

/**
 * State
 * 状态模式
 */
public interface State {

    // 设置时间
    void doClock(Context context, int hout);

    // 使用金库
    void doUse(Context context);

    // 按下警铃
    void doAlarm(Context context);

    // 正常通话
    void doPhone(Context context);

}
