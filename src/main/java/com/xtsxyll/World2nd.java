package com.xtsxyll;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.inventory.ItemStack;

public class World2nd implements Listener {
    public static Boolean a = Boolean.TRUE;
    private Items items = new Items();





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
        ItemStack item = e.getItem();

        if (item != null){
            if(player.getItemInHand().isSimilar(items.getItem("菜单"))){
                player.performCommand("zz gui");
                //player.sendMessage("§a你打开了菜单");
                e.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void ClickGUI(InventoryClickEvent event){
        debug("触发背包物品点击事件");
        if (event.getView().getTitle().equalsIgnoreCase(ChatColor.BLUE+"§l服务器菜单")){
            event.setCancelled(true);
            if (event.getCurrentItem() != null){
                Player player = (Player) event.getWhoClicked();
                //debug(event.getCurrentItem().toString());
                String[] gui = {"主城","回家","远程背包","返回上一地点","村民交易所","小黑塔","COI查询","每日签到","你就是土豪","紧急迫降"};
                for (int i =0;i < gui.length;i++){
                    if (event.getCurrentItem().isSimilar(items.getItem(gui[i]))){
                        String[] command = {
                                "spawn",
                                "home",
                                "bag",
                                "back",
                                "warp cm",
                                "res tp shu",
                                "co i",
                                "signin click",
                                "Balance",
                                "rp"
                        };
                        String[] info = {
                                "传送到主城",
                                "传送到名为home的家",
                                "打开远程背包",
                                "返回上一地点",
                                "传送到村民交易所",
                                "传送到小黑塔",
                                "",
                                "",
                                "",
                                ""
                        };
                        int a = event.getRawSlot();//点击的第几个，从0开始
                        //debug(String.valueOf(a));
                        if (!info[a].equals("")){
                            player.sendMessage((ChatColor.GOLD + info[a]));
                        }
                        player.performCommand(command[a]);
                        if (!command[a].equals("bag")){
                            event.getView().close();
                        }
                        //player.sendMessage("99999999999");
                        return;
                    }
                }
            }
        }
    }

    @EventHandler
    public void  onPlayerJoinEvent(PlayerJoinEvent event){
        debug("触发进入服务器事件");
        Player player = event.getPlayer();

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
