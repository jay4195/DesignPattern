package com.example.state;

public class LunchState implements State {

    private static LunchState singleton = new LunchState();

    private LunchState() {
    }

    public static State getInstance() {
        return singleton;
    }

    @Override
    public void doClock(Context context, int hour) {
        HourManager.Period period = HourManager.getPeriod(hour);
        if (HourManager.Period.DAY.equals(period)) {
            context.changeState(DayState.getInstance());
        }
    }

    @Override
    public void doUse(Context context) {
        context.recordLog("紧急：使用金库（中午）");
    }

    @Override
    public void doAlarm(Context context) {
        context.callSecurityCenter("按下警铃（中午）");
    }

    @Override
    public void doPhone(Context context) {
        context.callSecurityCenter("中午的通话录音");
    }

    @Override
    public String toString() {
        return "[中午]";
    }

}
