package com.github.zmathi.automaticator.task;

import com.github.zmathi.automaticator.repeat.Repeat;
import com.github.zmathi.automaticator.repeat.RepeatManager;
import com.github.zmathi.automaticator.timer.Timer;
import com.github.zmathi.automaticator.timer.TimerManager;

import java.util.Calendar;

public class RepeatTask implements Runnable {

    private static final String[] WEEK = { "Sábado", "Domingo", "Segunda", "Terça", "Quarta", "Quinta", "Sexta" };
    private RepeatManager repeatManager;
    private TimerManager timerManager;

    public RepeatTask(RepeatManager repeatManager, TimerManager timerManager) {
        this.repeatManager = repeatManager;
        this.timerManager = timerManager;
    }

    @Override
    public void run() {
        for (Repeat repeat : repeatManager.getRepeats()) {
            repeat.setCalled(repeat.getCalled() + 1);
            if (repeat.getCalled() == repeat.getTime()) {
                repeat.run();
            }
        }

        Calendar calendar = Calendar.getInstance();

        String WEEK_DAY = WEEK[calendar.get(Calendar.DAY_OF_WEEK)].toLowerCase();
        String TIME_NOW = calendar.get(Calendar.HOUR_OF_DAY) + ":" + calendar.get(Calendar.MINUTE) + ":" + calendar.get(Calendar.SECOND);
        for (Timer timer : timerManager.getTimers()) {
            if (timer.getDay().equalsIgnoreCase(WEEK_DAY) && timer.getTime().equalsIgnoreCase(TIME_NOW)) {
                timer.run();
            }
        }
    }
}
