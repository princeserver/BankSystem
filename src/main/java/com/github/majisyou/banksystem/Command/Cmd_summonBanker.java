package com.github.majisyou.banksystem.Command;

import com.github.majisyou.banksystem.BankSystem;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.NamespacedKey;
import org.bukkit.attribute.Attribute;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.jetbrains.annotations.NotNull;

public class Cmd_summonBanker implements CommandExecutor {
    private static BankSystem plugin = BankSystem.getInstance();
    public Cmd_summonBanker(BankSystem plugin){plugin.getCommand("summon_banker").setExecutor(this);}


    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(sender instanceof Player player){
            Villager villager = (Villager) player.getWorld().spawnEntity(player.getLocation(), EntityType.VILLAGER);
            villager.setInvulnerable(true);
            villager.setProfession(Villager.Profession.LIBRARIAN);
            villager.setVillagerLevel(5);
            villager.setCustomName(ChatColor.GREEN+"銀行員");
            villager.setCustomNameVisible(true);
            villager.setVillagerType(Villager.Type.JUNGLE);
            PersistentDataContainer pdc = villager.getPersistentDataContainer();
            NamespacedKey key = new NamespacedKey(plugin,"bank");
            villager.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(0.01);
            pdc.set(key, PersistentDataType.INTEGER,1);

            ArmorStand armorStand = (ArmorStand) player.getWorld().spawnEntity(player.getLocation(),EntityType.ARMOR_STAND);
            armorStand.setMarker(true);
            armorStand.setInvisible(true);
            armorStand.addPassenger(villager);

        }
        return true;
    }
}
