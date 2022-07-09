package com.github.majisyou.banksystem.Command;

import com.github.majisyou.banksystem.BankSystem;
import com.github.majisyou.banksystem.System.BankMainSystem;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public class Cmd_Pay implements CommandExecutor {
    BankSystem plugin = BankSystem.getInstance();
    public Cmd_Pay(BankSystem plugin){plugin.getCommand("send").setExecutor(this);}


    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(sender instanceof Player player){
            if(args.length==2){
                if(args[1].matches("-?\\d+")){
                    if(BankMainSystem.getBankMoney(player) >= Double.parseDouble(args[1])){
                        double sendMoney = Double.parseDouble(args[1]);
                        if(sendMoney <= 0){
                            sender.sendMessage("負の金額か0は送ることはできません");
                            return true;
                        }
                        OfflinePlayer player2 = plugin.getServer().getOfflinePlayer(args[0]);
                        if(player2.isOnline()){
                            if(player==player2){
                                player.sendMessage("この操作は実行できません");
                                return true;
                            }
                            BankMainSystem.removeBank(player,sendMoney);
                            BankMainSystem.addBank((Player) player2,sendMoney);
                            player.sendMessage(ChatColor.WHITE+player2.getName()+"に"+ ChatColor.GREEN+sendMoney+"E"+ChatColor.WHITE+"送金した");
                            ((Player) player2).sendMessage(ChatColor.WHITE+player.getName()+"から"+ ChatColor.GREEN+sendMoney+"E"+ChatColor.WHITE+"送金された");
                            return true;
                        }else {
                            if(Arrays.stream(plugin.getServer().getOfflinePlayers()).toList().contains(player2)){
                                BankMainSystem.removeBank(player,sendMoney);
                                BankMainSystem.addBank(player2,sendMoney);
                                player.sendMessage(ChatColor.WHITE+player2.getName()+"に"+ ChatColor.GREEN+sendMoney+"E"+ChatColor.WHITE+"送金した");
                                return true;
                            }else {
                                player.sendMessage(ChatColor.WHITE+"プレイヤーが見つからなかった");
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
}
