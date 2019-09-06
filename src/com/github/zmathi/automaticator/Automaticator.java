package com.github.zmathi.automaticator;

import com.github.zmathi.automaticator.repeat.RepeatLoader;
import com.github.zmathi.automaticator.repeat.RepeatManager;
import com.github.zmathi.automaticator.task.RepeatTask;
import com.github.zmathi.automaticator.timer.TimerLoader;
import com.github.zmathi.automaticator.timer.TimerManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Automaticator extends JavaPlugin {

    private static Automaticator automaticator;

    @Override
    public void onLoad() {
        automaticator = this;
    }

    @Override
    public void onEnable() {
        saveDefaultConfig();

        RepeatManager repeatManager = new RepeatManager();
        TimerManager timerManager = new TimerManager();

        RepeatLoader repeatLoader = new RepeatLoader(repeatManager);
        repeatLoader.load(this);

        TimerLoader timerLoader = new TimerLoader(timerManager);
        timerLoader.load(this);

        RepeatTask repeatTask = new RepeatTask(repeatManager, timerManager);
        Bukkit.getScheduler().runTaskTimerAsynchronously(this, repeatTask, 20, 20);
    }

    @Override
    public void onDisable() {
    }

    public static Automaticator getAutomaticator() {
        return automaticator;
    }
}
