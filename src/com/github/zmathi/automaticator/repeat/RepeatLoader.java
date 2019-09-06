package com.github.zmathi.automaticator.repeat;

import com.google.common.collect.Lists;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.plugin.Plugin;

import java.util.List;

public class RepeatLoader {

    private RepeatManager repeatManager;

    public RepeatLoader(RepeatManager repeatManager) {
        this.repeatManager = repeatManager;
    }

    public void load(Plugin plugin) {
        ConfigurationSection configSection = plugin.getConfig().getConfigurationSection("automaticator.repeat");
        if (configSection == null) return;

        for (String configPath : configSection.getKeys(false)) {
            int time = configSection.getInt(configPath + ".time");
            List<String> commands = Lists.newArrayList();
            if (configSection.contains(configPath + ".commands")) {
                commands.addAll(configSection.getStringList(configPath + ".commands"));
            }

            Repeat repeat = new Repeat(time, commands);
            repeatManager.getRepeats().add(repeat);
        }
    }
}
