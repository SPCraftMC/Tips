package moe.xmcn.tips.tips.listeners;

import moe.xmcn.tips.tips.Tips;
import org.bukkit.ChatColor;
import org.bukkit.plugin.Plugin;

import java.util.Random;

public class AsyncRunnable implements Runnable {

    Plugin plugin = Tips.getPlugin(Tips.class);;

    @Override
    public void run() {
        Random rand = new Random();
        String[] text = plugin.getConfig().getStringList("messages").toArray(new String[0]);
        plugin.getServer().broadcastMessage(
                ChatColor.translateAlternateColorCodes(
                        '&',
                        plugin.getConfig().getString("prefix") + text[rand.nextInt(text.length)]
                )
        );
    }
}
