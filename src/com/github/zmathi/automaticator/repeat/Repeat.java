package com.github.zmathi.automaticator.repeat;

import com.github.zmathi.automaticator.Automaticator;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.List;

public class Repeat {

    private int time, called;
    private List<String> commands;

    public Repeat(int time, List<String> commands) {
        this.time = time;
        this.called = 0;
        this.commands = commands;
    }

    public int getTime() {
        return time;
    }

    public int getCalled() {
        return called;
    }

    public void setCalled(int called) {
        this.called = called;
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
                            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), command.replace("{player}", player.getName()));
                        }
                        continue;
                    }
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), command);
                }
            }
            called = 0;
        });
    }
}
