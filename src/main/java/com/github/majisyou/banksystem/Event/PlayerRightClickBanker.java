package com.github.majisyou.banksystem.Event;

import com.github.majisyou.banksystem.BankSystem;
import com.github.majisyou.banksystem.Gui.GuiMaster;
import com.github.majisyou.banksystem.System.SoundManager;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.persistence.PersistentDataContainer;

public class PlayerRightClickBanker implements Listener {
    private static BankSystem plugin = BankSystem.getInstance();
    public PlayerRightClickBanker(BankSystem plugin){plugin.getServer().getPluginManager().registerEvents(this,plugin);}

    @EventHandler
    public static void PlayerRightClick(PlayerInteractEntityEvent event){
        if(event.getRightClicked().getType().equals(EntityType.VILLAGER)){
            Villager villager = (Villager) event.getRightClicked();
            PersistentDataContainer pdc = villager.getPersistentDataContainer();
            NamespacedKey key = new NamespacedKey(plugin,"bank");
            if(pdc.has(key)){
                event.setCancelled(true);
                GuiMaster.OpenBankGui(event.getPlayer());
                SoundManager.OpenEnder(event.getPlayer());
                event.getPlayer().sendMessage("§a[情報]§f"+event.getPlayer().getName()+"様いらっしゃいませ。Prince銀行本店です");
            }
        }
    }
}
