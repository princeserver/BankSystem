package com.github.majisyou.banksystem.Gui;

import com.github.majisyou.banksystem.BankSystem;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

public class GuiItem {
    private static BankSystem plugin = BankSystem.getInstance();

    public static ItemStack BackGround(){
        ItemStack item = new ItemStack(Material.WHITE_STAINED_GLASS_PANE,1);
        ItemMeta itemMeta = item.getItemMeta();
        String name = " ";
        itemMeta.setDisplayName(name);
        itemMeta.setCustomModelData(3410);
        item.setItemMeta(itemMeta);
        return item;
    }

    public static ItemStack Number(){
        ItemStack item = new ItemStack(Material.WHITE_STAINED_GLASS_PANE,1);
        ItemMeta itemMeta = item.getItemMeta();
        String name = " ";
        itemMeta.setDisplayName(name);
        itemMeta.setCustomModelData(3201);
        item.setItemMeta(itemMeta);
        return item;
    }
    public static ItemStack Number(Integer integer){
        ItemStack item = new ItemStack(Material.WHITE_STAINED_GLASS_PANE,1);
        ItemMeta itemMeta = item.getItemMeta();
        String name = " ";
        itemMeta.setDisplayName(name);
        switch (integer){
            case 1->{
                itemMeta.setCustomModelData(3011);
            }
            case 2->{
                itemMeta.setCustomModelData(3012);
            }
            case 3->{
                itemMeta.setCustomModelData(3013);
            }
            case 4->{
                itemMeta.setCustomModelData(3014);
            }
            case 5->{
                itemMeta.setCustomModelData(3015);
            }
            case 6->{
                itemMeta.setCustomModelData(3016);
            }
            case 7->{
                itemMeta.setCustomModelData(3017);
            }
            case 8->{
                itemMeta.setCustomModelData(3018);
            }
            case 9->{
                itemMeta.setCustomModelData(3019);
            }
            case 0-> {
                itemMeta.setCustomModelData(3010);
            }
            case 10->{
                itemMeta.setCustomModelData(3201);
            }

        }
        item.setItemMeta(itemMeta);
        return item;
    }

    public static ItemStack AddPane(){
        ItemStack item = new ItemStack(Material.WHITE_STAINED_GLASS_PANE,1);
        ItemMeta itemMeta = item.getItemMeta();
        String name = ChatColor.WHITE+"全額預け入れる";
        itemMeta.setDisplayName(name);
        itemMeta.setCustomModelData(3407);
        item.setItemMeta(itemMeta);
        return item;
    }
    public static ItemStack TakePane(){
        ItemStack item = new ItemStack(Material.WHITE_STAINED_GLASS_PANE,1);
        ItemMeta itemMeta = item.getItemMeta();
        String name = ChatColor.WHITE+"全額引き出す";
        itemMeta.setDisplayName(name);
        itemMeta.setCustomModelData(3408);
        item.setItemMeta(itemMeta);
        return item;
    }
    public static ItemStack Emerald(){
        ItemStack item = new ItemStack(Material.EMERALD,1);
        ItemMeta itemMeta = item.getItemMeta();
        NamespacedKey key = new NamespacedKey(plugin,"changeRate");
        PersistentDataContainer pdc = itemMeta.getPersistentDataContainer();
        pdc.set(key,PersistentDataType.INTEGER,1);
        String name = ChatColor.WHITE +"左クリックで"+1+"個預け入れる。右クリックで個数の変更";
        itemMeta.setDisplayName(name);
//        itemMeta.setCustomModelData(3000);
        item.setItemMeta(itemMeta);
        return item;
    }
    public static ItemStack EmeraldBlock(){
        ItemStack item = new ItemStack(Material.EMERALD_BLOCK,1);
        ItemMeta itemMeta = item.getItemMeta();
        NamespacedKey key = new NamespacedKey(plugin,"changeRate");
        PersistentDataContainer pdc = itemMeta.getPersistentDataContainer();
        pdc.set(key,PersistentDataType.INTEGER,1);
        String name = ChatColor.WHITE +"左クリックで"+1+"個預け入れる。右クリックで個数の変更";
        itemMeta.setDisplayName(name);
//        itemMeta.setCustomModelData(3000);
        item.setItemMeta(itemMeta);
        return item;
    }
    public static ItemStack LiquidEmerald(){
        ItemStack item = new ItemStack(Material.REPEATING_COMMAND_BLOCK,1);
        ItemMeta itemMeta = item.getItemMeta();
        NamespacedKey key = new NamespacedKey(plugin,"changeRate");
        PersistentDataContainer pdc = itemMeta.getPersistentDataContainer();
        pdc.set(key,PersistentDataType.INTEGER,1);
        String name = ChatColor.WHITE +"左クリックで"+1+"個預け入れる。右クリックで個数の変更";
        itemMeta.setDisplayName(name);
        itemMeta.setCustomModelData(1000);
        item.setItemMeta(itemMeta);
        return item;
    }
    public static ItemStack EmeraldPane(){
        ItemStack item = new ItemStack(Material.WHITE_STAINED_GLASS_PANE,1);
        ItemMeta itemMeta = item.getItemMeta();
        String name = " ";
        itemMeta.setDisplayName(name);
        itemMeta.setCustomModelData(3200);
        item.setItemMeta(itemMeta);
        return item;
    }


}
