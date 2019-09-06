package com.github.zmathi.automaticator.timer;

import com.github.zmathi.automaticator.Automaticator;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.List;

public class Timer {

    private String day, time;
    private List<String> commands;

    public Timer(String day, String time, List<String> commands) {
        this.day = day;
        this.time = time;
        this.commands = commands;
    }

    public String getDay() {
        return day;
    }

    public String getTime() {
        return time;
    }

    public List<String> getCommands() {
        return commands;
    }

    public void run() {
        Bukkit.getScheduler().runTask(Automaticator.getAutomaticator(), () -> {
            for (int i = 0; i < commands.size(); i++) {
                String command = commands.get(i);
                if (command != null && !command.isEmpty()) {
                    if (command.contains("{player}")) {
                        for (Player player : Bukkit.getOnlinePlayers()) {
                            command = command.replace("{player}", player.getName());

                            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), command);
                        }
                        continue;
                    }
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), command);
                }
            }
        });
    }
}
