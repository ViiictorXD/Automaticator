package com.github.zmathi.automaticator.timer;

import com.google.common.collect.Lists;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.plugin.Plugin;

import java.util.Arrays;
import java.util.List;

public class TimerLoader {

    private TimerManager timerManager;

    public TimerLoader(TimerManager timerManager) {
        this.timerManager = timerManager;
    }

    public void load(Plugin plugin) {
        ConfigurationSection configSection = plugin.getConfig().getConfigurationSection("automaticator.timer");
        if (configSection == null) return;

        for (String configPath : configSection.getKeys(false)) {
            String day = configSection.getString(configPath + ".day");
            String time = configSection.getString(configPath + ".time").replace(" ", ":") + ":0";

            List<String> commands = Lists.newArrayList();
            if (configSection.contains(configPath + ".commands")) {
                commands.addAll(configSection.getStringList(configPath + ".commands"));
            }

            System.out.println(day + " = " + time);

            Timer timer = new Timer(day, time, commands);
            timerManager.getTimers().add(timer);
        }
    }
}
