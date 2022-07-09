package com.github.majisyou.banksystem.Command;

import com.github.majisyou.banksystem.BankSystem;
import com.github.majisyou.banksystem.Gui.GuiMaster;
import com.github.majisyou.banksystem.System.SoundManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class Cmd_bank implements CommandExecutor {
    BankSystem plugin = BankSystem.getInstance();
    public Cmd_bank(BankSystem plugin){
        plugin.getCommand("emerald").setExecutor(this);
        plugin.getCommand("bank").setExecutor(this);

    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(sender instanceof Player player){
            if(!player.hasPermission("Bank.user")){
                return false;
            }
            GuiMaster.OpenBankGui(player);
            player.sendMessage("§a[情報]§f"+player.getName()+"様いらっしゃいませ。Prince銀行ダイレクトです");
        }else {
         sender.sendMessage("これはコンソールから打てない");
        }
        return true;
    }
}
