package moe.xmcn.tips.tips;

import moe.xmcn.tips.tips.listeners.AsyncRunnable;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

public class Tips extends JavaPlugin implements CommandExecutor {

    @Override
    public void onEnable() {
        saveDefaultConfig();
        getCommand("tips").setExecutor(this);
        getServer().getScheduler().runTaskTimer(
                this,
                new AsyncRunnable(),
                getConfig().getLong("time") * 20,
                getConfig().getLong("time") * 20
        );
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (args.length == 1 && args[0].equalsIgnoreCase("reload")) {
            reloadConfig();
            sender.sendMessage(ChatColor.GREEN + "配置文件已重载");
        }
        return true;
    }
}
