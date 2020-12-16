package com.xtsxyll;

import org.bukkit.Material;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class Items {

    public ItemStack getItem(String itemName){
        if (itemName.equalsIgnoreCase("菜单")){
            ItemStack caidan = new ItemStack(Material.CLOCK,1);
            ItemMeta meta = caidan.getItemMeta();
            assert meta != null;
            meta.setDisplayName("§c钟表菜单");
            List<String> lore = new ArrayList<>();
            lore.add("§b左键或右键打开菜单");
            meta.setLore(lore);
            meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
            caidan.setItemMeta(meta);
            return caidan;
        }
        if (itemName.equalsIgnoreCase("主城")){
            ItemStack itemStack = new ItemStack(Material.BEACON,1);
            ItemMeta meta = itemStack.getItemMeta();
            assert meta != null;
            meta.setDisplayName("§2§l前往主城");
            List<String> lore = new ArrayList<>();
            lore.add("-系统商店");
            lore.add("-单挑排行榜");
            lore.add("-主城南站入口");
            meta.setLore(lore);
            meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
            itemStack.setItemMeta(meta);
            return itemStack;
        }
        if (itemName.equalsIgnoreCase("回家")){
            ItemStack itemStack = new ItemStack(Material.RED_BED,1);
            ItemMeta meta = itemStack.getItemMeta();
            assert meta != null;
            meta.setDisplayName("§2§l回家");
            List<String> lore = new ArrayList<>();
            lore.add("-回到名为home的家");
            meta.setLore(lore);
            meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
            itemStack.setItemMeta(meta);
            return itemStack;
        }
        if (itemName.equalsIgnoreCase("远程背包")){
            ItemStack itemStack = new ItemStack(Material.CHEST,1);
            ItemMeta meta = itemStack.getItemMeta();
            assert meta != null;
            meta.setDisplayName("§2§l远程背包");
            List<String> lore = new ArrayList<>();
            lore.add("-打开远程背包");
            meta.setLore(lore);
            meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
            itemStack.setItemMeta(meta);
            return itemStack;
        }
        if (itemName.equalsIgnoreCase("返回上一地点")){
            ItemStack itemStack = new ItemStack(Material.WHITE_BANNER,1);
            ItemMeta meta = itemStack.getItemMeta();
            assert meta != null;
            meta.setDisplayName("§2§l返回上一地点");
            List<String> lore = new ArrayList<>();
            lore.add("-返回上一地点");
            meta.setLore(lore);
            meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
            itemStack.setItemMeta(meta);
            return itemStack;
        }
        if (itemName.equalsIgnoreCase("村民交易所")){
            ItemStack itemStack = new ItemStack(Material.VILLAGER_SPAWN_EGG,1);
            ItemMeta meta = itemStack.getItemMeta();
            assert meta != null;
            meta.setDisplayName("§2§l村民交易所");
            List<String> lore = new ArrayList<>();
            lore.add("-开始发家致富");
            meta.setLore(lore);
            meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
            itemStack.setItemMeta(meta);
            return itemStack;
        }
        if (itemName.equalsIgnoreCase("小黑塔")){
            ItemStack itemStack = new ItemStack(Material.ENDERMAN_SPAWN_EGG,1);
            ItemMeta meta = itemStack.getItemMeta();
            assert meta != null;
            meta.setDisplayName("§2§l小黑塔");
            List<String> lore = new ArrayList<>();
            lore.add("-经验大把大把的");
            meta.setLore(lore);
            meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
            itemStack.setItemMeta(meta);
            return itemStack;
        }
        if (itemName.equalsIgnoreCase("COI查询")){
            ItemStack itemStack = new ItemStack(Material.ENDER_PEARL,1);
            ItemMeta meta = itemStack.getItemMeta();
            assert meta != null;
            meta.setDisplayName("§2§l让我康康你发育的怎么样");
            List<String> lore = new ArrayList<>();
            lore.add("-查水表专用");
            meta.setLore(lore);
            meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
            itemStack.setItemMeta(meta);
            return itemStack;
        }
        if (itemName.equalsIgnoreCase("每日签到")){
            ItemStack itemStack = new ItemStack(Material.LEGACY_BOOK_AND_QUILL,1);
            ItemMeta meta = itemStack.getItemMeta();
            assert meta != null;
            meta.setDisplayName("§2§l每日签到");
            List<String> lore = new ArrayList<>();
            lore.add("-白嫖各种资源");
            meta.setLore(lore);
            meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
            itemStack.setItemMeta(meta);
            return itemStack;
        }
        if (itemName.equalsIgnoreCase("你就是土豪")){
            ItemStack itemStack = new ItemStack(Material.GOLD_INGOT,1);
            ItemMeta meta = itemStack.getItemMeta();
            assert meta != null;
            meta.setDisplayName("§2§l你就是土豪");
            List<String> lore = new ArrayList<>();
            lore.add("-查看自己有多少钱");
            meta.setLore(lore);
            meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
            itemStack.setItemMeta(meta);
            return itemStack;
        }
        if (itemName.equalsIgnoreCase("紧急迫降")){
            ItemStack itemStack = new ItemStack(Material.ELYTRA,1);
            ItemMeta meta = itemStack.getItemMeta();
            assert meta != null;
            meta.setDisplayName("§2§l紧急迫降");
            List<String> lore = new ArrayList<>();
            lore.add("-随机传送到一个地方并进行迫降");
            meta.setLore(lore);
            meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
            itemStack.setItemMeta(meta);
            return itemStack;
        }




        return null;
    }
}
