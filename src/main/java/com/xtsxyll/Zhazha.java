package com.xtsxyll;

import java.io.File;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;

public final class Zhazha extends JavaPlugin implements Listener {


    public static FileConfiguration config;

    public static List<String> Worlds;

    public static String[] worldlist;

    public static Boolean debug;

    public static String Qz = "§e[Zhazha] §a";

    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getConsoleSender().sendMessage("");
        loadingconfig();
        getServer().getPluginManager().registerEvents(new World2nd(), (Plugin)this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        Bukkit.getConsoleSender().sendMessage(Qz + "插件已卸载!");
    }

    public void loadingconfig() {
        if (!getDataFolder().exists())
            getDataFolder().mkdir();
        File fileconfig = new File(getDataFolder(), "config.yml");
        if (!fileconfig.exists()) {
            log(Qz + "检测到config.yml不存在,从插件中释放!");
                    saveDefaultConfig();
        }
        log(Qz + "读取配置文件config.yml");
        reloadConfig();
        config = getConfig();
        worldlist = new String[0];
        try {
            debug = config.getBoolean("Debug");
            if (debug)
                log(Qz + "Debug模式已开启");
                config.getStringList("Worlds").forEach(s -> worldlist = insert(worldlist, s));
                config.getStringList("Worlds").forEach(s -> log(Qz + "已加载需要保护的世界："+ s));
                log(Qz + config.getString("ver"));
                World2nd.debug("结束");
        } catch (Exception e) {
            log(Qz + e.toString());
        }
    }

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (label.equalsIgnoreCase("zhazha") || label.equalsIgnoreCase("zz")) {
            if (args.length == 0) {
                sender.sendMessage("§6[Zhazha] §e指令帮助:");
                sender.sendMessage("§a/zz reload - 重载插件配置");
                return true;
            }
            if (args.length == 1 && args[0].equalsIgnoreCase("reload")) {
                loadingconfig();
                sender.sendMessage("§a/插件配置重载成功");
                return true;
            }
        }
        return true;
    }


    public void log(String s){
        Bukkit.getConsoleSender().sendMessage(s);
    }
    /**
     ****向Arr数组增加内容
     * @param arr
     * @param str
     * @return
     */
    private static String[] insert(String[] arr, String str) {
         int size = arr.length;
         int newSize = size + 1;
         String[] tmp = new String[newSize];
         for (int i = 0; i < size; i++)
            tmp[i] = arr[i];
            tmp[size] = str;
         return tmp;
    }
}
