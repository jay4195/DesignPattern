package com.example.mediator;

import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ColleagueCheckbox extends Checkbox implements ItemListener, Colleague {

    private Mediator mediator;

    public ColleagueCheckbox(String text, CheckboxGroup group, boolean state) {
        super(text, group, state);
    }

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void setColleagueEnabled(boolean enabled) {
        // Mediator 下达启用/禁用指示
        setEnabled(enabled);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        // 当文字发生变化时通知Mediator
        mediator.colleagueChanged();
    }
}
