package com.github.zmathi.automaticator.timer;

import com.google.common.collect.Lists;

import java.util.List;

public class TimerManager {

    private List<Timer> timers;

    public TimerManager() {
        timers = Lists.newArrayList();
    }

    public List<Timer> getTimers() {
        return timers;
    }
}
