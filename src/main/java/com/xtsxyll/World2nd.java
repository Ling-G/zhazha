package com.xtsxyll;

import java.util.*;
import java.util.stream.Collectors;

import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.FireworkMeta;

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
            if (player.getItemInHand().isSimilar(items.getItem("烟花发射器"))){
                if (!Zhazha.yanhua) return;
                final FireworkEffect.Builder fb = FireworkEffect.builder();
                final Random r = new Random();
                FireworkEffect f = null;
                int rc = r.nextInt(10);
                debug(""+rc);
                switch (rc){
                    case 1:
                        fb.withColor(Color.fromRGB(r.nextInt(255), r.nextInt(255), r.nextInt(255)));
                        break;
                    case 2:
                        fb.withColor(
                                Color.fromRGB(r.nextInt(255), r.nextInt(255), r.nextInt(255)),
                                Color.fromRGB(r.nextInt(255), r.nextInt(255), r.nextInt(255))
                        );
                        break;
                    case 3:
                        fb.withColor(
                                Color.fromRGB(r.nextInt(255), r.nextInt(255), r.nextInt(255)),
                                Color.fromRGB(r.nextInt(255), r.nextInt(255), r.nextInt(255)),
                                Color.fromRGB(r.nextInt(255), r.nextInt(255), r.nextInt(255))
                        );
                        break;
                    case 4:
                        fb.withColor(
                                Color.fromRGB(r.nextInt(255), r.nextInt(255), r.nextInt(255)),
                                Color.fromRGB(r.nextInt(255), r.nextInt(255), r.nextInt(255)),
                                Color.fromRGB(r.nextInt(255), r.nextInt(255), r.nextInt(255)),
                                Color.fromRGB(r.nextInt(255), r.nextInt(255), r.nextInt(255))
                        );
                        break;
                    case 5:
                        fb.withColor(
                                Color.fromRGB(r.nextInt(255), r.nextInt(255), r.nextInt(255)),
                                Color.fromRGB(r.nextInt(255), r.nextInt(255), r.nextInt(255)),
                                Color.fromRGB(r.nextInt(255), r.nextInt(255), r.nextInt(255)),
                                Color.fromRGB(r.nextInt(255), r.nextInt(255), r.nextInt(255)),
                                Color.fromRGB(r.nextInt(255), r.nextInt(255), r.nextInt(255))
                        );
                        break;
                    case 6:
                        fb.withColor(
                                Color.fromRGB(r.nextInt(255), r.nextInt(255), r.nextInt(255)),
                                Color.fromRGB(r.nextInt(255), r.nextInt(255), r.nextInt(255)),
                                Color.fromRGB(r.nextInt(255), r.nextInt(255), r.nextInt(255)),
                                Color.fromRGB(r.nextInt(255), r.nextInt(255), r.nextInt(255)),
                                Color.fromRGB(r.nextInt(255), r.nextInt(255), r.nextInt(255)),
                                Color.fromRGB(r.nextInt(255), r.nextInt(255), r.nextInt(255))
                        );
                        break;
                    case 7:
                        fb.withColor(
                                Color.fromRGB(r.nextInt(255), r.nextInt(255), r.nextInt(255)),
                                Color.fromRGB(r.nextInt(255), r.nextInt(255), r.nextInt(255)),
                                Color.fromRGB(r.nextInt(255), r.nextInt(255), r.nextInt(255)),
                                Color.fromRGB(r.nextInt(255), r.nextInt(255), r.nextInt(255)),
                                Color.fromRGB(r.nextInt(255), r.nextInt(255), r.nextInt(255)),
                                Color.fromRGB(r.nextInt(255), r.nextInt(255), r.nextInt(255)),
                                Color.fromRGB(r.nextInt(255), r.nextInt(255), r.nextInt(255))
                        );
                        break;
                    case 8:
                        fb.withColor(
                                Color.fromRGB(r.nextInt(255), r.nextInt(255), r.nextInt(255)),
                                Color.fromRGB(r.nextInt(255), r.nextInt(255), r.nextInt(255)),
                                Color.fromRGB(r.nextInt(255), r.nextInt(255), r.nextInt(255)),
                                Color.fromRGB(r.nextInt(255), r.nextInt(255), r.nextInt(255)),
                                Color.fromRGB(r.nextInt(255), r.nextInt(255), r.nextInt(255)),
                                Color.fromRGB(r.nextInt(255), r.nextInt(255), r.nextInt(255)),
                                Color.fromRGB(r.nextInt(255), r.nextInt(255), r.nextInt(255)),
                                Color.fromRGB(r.nextInt(255), r.nextInt(255), r.nextInt(255))
                        );
                        break;
                    case 9:
                        fb.withColor(
                                Color.fromRGB(r.nextInt(255), r.nextInt(255), r.nextInt(255)),
                                Color.fromRGB(r.nextInt(255), r.nextInt(255), r.nextInt(255)),
                                Color.fromRGB(r.nextInt(255), r.nextInt(255), r.nextInt(255)),
                                Color.fromRGB(r.nextInt(255), r.nextInt(255), r.nextInt(255)),
                                Color.fromRGB(r.nextInt(255), r.nextInt(255), r.nextInt(255)),
                                Color.fromRGB(r.nextInt(255), r.nextInt(255), r.nextInt(255)),
                                Color.fromRGB(r.nextInt(255), r.nextInt(255), r.nextInt(255)),
                                Color.fromRGB(r.nextInt(255), r.nextInt(255), r.nextInt(255)),
                                Color.fromRGB(r.nextInt(255), r.nextInt(255), r.nextInt(255))
                        );
                        break;
                    case 10:
                        fb.withColor(
                                Color.fromRGB(r.nextInt(255), r.nextInt(255), r.nextInt(255)),
                                Color.fromRGB(r.nextInt(255), r.nextInt(255), r.nextInt(255)),
                                Color.fromRGB(r.nextInt(255), r.nextInt(255), r.nextInt(255)),
                                Color.fromRGB(r.nextInt(255), r.nextInt(255), r.nextInt(255)),
                                Color.fromRGB(r.nextInt(255), r.nextInt(255), r.nextInt(255)),
                                Color.fromRGB(r.nextInt(255), r.nextInt(255), r.nextInt(255)),
                                Color.fromRGB(r.nextInt(255), r.nextInt(255), r.nextInt(255)),
                                Color.fromRGB(r.nextInt(255), r.nextInt(255), r.nextInt(255)),
                                Color.fromRGB(r.nextInt(255), r.nextInt(255), r.nextInt(255)),
                                Color.fromRGB(r.nextInt(255), r.nextInt(255), r.nextInt(255))
                        );
                        break;
                    default:
                        fb.withColor(Color.fromRGB(r.nextInt(255), r.nextInt(255), r.nextInt(255)));
                }
                final FireworkEffect.Type[] type = FireworkEffect.Type.values();
                fb.with(type[r.nextInt(type.length)]);
                if (r.nextInt(3) == 0) {
                    fb.withTrail();
                    //尾迹
                }
                if (r.nextInt(2) == 0) {
                    //淡出
                    rc = r.nextInt(3);
                    switch (rc) {
                        case 0:
                            fb.withFade(Color.fromRGB(r.nextInt(255), r.nextInt(255), r.nextInt(255)));
                            break;
                        case 1:
                            fb.withFade(
                                    Color.fromRGB(r.nextInt(255), r.nextInt(255), r.nextInt(255)),
                                    Color.fromRGB(r.nextInt(255), r.nextInt(255), r.nextInt(255))
                            );
                            break;
                        case 2:
                            fb.withFade(
                                    Color.fromRGB(r.nextInt(255), r.nextInt(255), r.nextInt(255)),
                                    Color.fromRGB(r.nextInt(255), r.nextInt(255), r.nextInt(255)),
                                    Color.fromRGB(r.nextInt(255), r.nextInt(255), r.nextInt(255))
                            );
                            break;
                        default:
                            fb.withFade(Color.fromRGB(r.nextInt(255), r.nextInt(255), r.nextInt(255)));
                    }
                }
                if (r.nextInt(3) == 0) {
                    //闪烁
                    fb.withFlicker();
                }
                f = fb.build();
                final Firework fw = (Firework) player.getWorld().spawnEntity(player.getLocation().add(0,1,0), EntityType.FIREWORK);
                final FireworkMeta fwm = fw.getFireworkMeta();
                fwm.clearEffects();
                fwm.addEffect(f);
                fwm.setPower(0);
                fw.setFireworkMeta(fwm);
                fw.setVelocity(player.getLocation().getDirection().multiply(0.5));
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
                String[] command = {"spawn", "home home", "bag", "back", "warp cm", "res tp shu", "co i", "signin click", "Balance", "rp"};
                String[] info = {"传送到主城", "传送到名为home的家", "打开远程背包", "返回上一地点", "传送到村民交易所", "传送到小黑塔", "", "", "", ""
                };
                for (int i =0;i < gui.length;i++){
                    if (event.getCurrentItem().isSimilar(items.getItem(gui[i]))){

                        int index = event.getRawSlot();//点击的第几个，从0开始
                        //debug(String.valueOf(a));
                        if (!info[index].equals("")){
                            player.sendMessage((ChatColor.GOLD + info[index]));
                        }
                        event.getView().close();
                        player.performCommand(command[index]);
                        break;
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
