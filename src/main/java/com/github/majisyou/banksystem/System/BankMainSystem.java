package com.github.majisyou.banksystem.System;

import com.github.majisyou.banksystem.BankSystem;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class BankMainSystem {

    private static BankSystem plugin = BankSystem.getInstance();

    public static void addBank(Player player,double money){
        Economy eco = BankSystem.getEconomy();
        eco.depositPlayer(player,money);
    }

    public static int getWalletMoney(Player player){
        int WalletMoney = 0;
        Inventory playerInv = player.getInventory();
        for (ItemStack item: playerInv.getContents()){
            if(item != null){
                if(!item.getType().equals(Material.AIR)){
                    if(item.getType().equals(Material.EMERALD)){
                        WalletMoney += item.getAmount();
                    }
                    if(item.getType().equals(Material.EMERALD_BLOCK)){
                        WalletMoney += 64 * item.getAmount();
                    }
                    if(item.getType().equals(Material.REPEATING_COMMAND_BLOCK)){
                        WalletMoney += 4096 * item.getAmount();
                    }
                }
            }
        }
        return WalletMoney;
    }

    public static ItemStack LiquidEmerald(int Amount){
        ItemStack LiquidEmerald = new ItemStack(Material.REPEATING_COMMAND_BLOCK,Amount);
        ItemMeta itemMeta = LiquidEmerald.getItemMeta();
        itemMeta.setCustomModelData(1000);
        itemMeta.setDisplayName(ChatColor.WHITE+"リキッドエメラルド");
        LiquidEmerald.setItemMeta(itemMeta);
        return LiquidEmerald;
    }

    public static boolean removeBank(Player player,double money){
        Economy eco  = BankSystem.getEconomy();
        if(eco.getBalance(player) - money < 0.0D){
//            plugin.getLogger().info("(BS)"+player.getName()+"の口座に十分なお金が無かったため、"+money+"Eを徴収できなかった");
            return false;
        }
        eco.withdrawPlayer(player,money);
        return true;
    }

    public static double getBankMoney(Player player){
        Economy eco  = BankSystem.getEconomy();
        return eco.getBalance(player);
    }

    public static void reset(Player player){
        Economy eco = BankSystem.getEconomy();
        eco.withdrawPlayer(player,eco.getBalance(player));
    }

}
