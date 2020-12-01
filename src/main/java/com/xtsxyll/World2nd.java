package com.xtsxyll;

import java.util.Arrays;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class World2nd implements Listener {
    public static Boolean a = Boolean.TRUE;
    public static void debug(String str) {
        if (Zhazha.debug)
            Bukkit.getLogger().info(str);
    }

    @EventHandler
    public void onPlayerChangedWorldEvent(PlayerChangedWorldEvent e) {
        debug("触发世界切换事件");
                Player player = e.getPlayer();
        String w = player.getWorld().getName();
        debug("这个世界为："+ player.getWorld().getName());
        if (Arrays.<String>asList(Zhazha.worldlist).contains(w)) {
            player.setGameMode(GameMode.SPECTATOR);
            return;
        }
        if (player.getGameMode() != GameMode.SURVIVAL)
            player.setGameMode(GameMode.SURVIVAL);
    }

    @EventHandler
    public void onPlayerInteractEvent(PlayerInteractEvent e) {
        debug("触发方块互动事件");
                Player player = e.getPlayer();
        String worldname = player.getWorld().getName();
        debug("世界名为："+ worldname);
        if (worldname.equals("2nd")) {
            player.setGameMode(GameMode.SPECTATOR);
            e.setCancelled(true);
        }
    }

    public static String getSubString(String text, String left, String right) {
        int zLen;
        String result = "";
        if (left == null || left.isEmpty()) {
            zLen = 0;
        } else {
            zLen = text.indexOf(left);
            if (zLen > -1) {
                zLen += left.length();
            } else {
                zLen = 0;
            }
        }
        int yLen = text.indexOf(right, zLen);
        if (yLen < 0 || right == null || right.isEmpty())
            yLen = text.length();
        result = text.substring(zLen, yLen);
        return result;
    }

}
