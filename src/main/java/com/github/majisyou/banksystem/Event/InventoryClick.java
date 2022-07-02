package com.github.majisyou.banksystem.Event;

import com.github.majisyou.banksystem.BankSystem;
import com.github.majisyou.banksystem.Gui.GuiMaster;
import com.github.majisyou.banksystem.System.BankMainSystem;
import org.bukkit.ChatColor;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

public class InventoryClick implements Listener {
    private static BankSystem plugin = BankSystem.getInstance();
    public InventoryClick(BankSystem plugin){plugin.getServer().getPluginManager().registerEvents(this,plugin);}

    @EventHandler
    public static void InvClick(InventoryClickEvent event){
        if(event.getView().getTitle().equals("Prince銀行")){
            event.setCancelled(true);
            if(event.getCurrentItem()!=null){
                if(!event.getClickedInventory().getType().equals(InventoryType.PLAYER)){
                    if(event.getClick().equals(ClickType.LEFT)){
                        int bank = (int) BankMainSystem.getBankMoney((Player) event.getWhoClicked());
                        int wallet = BankMainSystem.getWalletMoney((Player) event.getWhoClicked());
                        if(event.getSlot()==11){
                            GuiMaster.deposit(event.getClickedInventory(),(Player) event.getWhoClicked());
                            plugin.getLogger().info("(BS)"+event.getWhoClicked().getName()+"のBankエメラルドが"+bank+"から"+(int) BankMainSystem.getBankMoney((Player) event.getWhoClicked())+"になった。");
                            plugin.getLogger().info("(BS)"+event.getWhoClicked().getName()+"のWalletエメラルドが"+wallet+"から"+BankMainSystem.getWalletMoney((Player) event.getWhoClicked())+"になった。");
                        }
                        if(event.getSlot()==24){
                            GuiMaster.withdraw(event.getClickedInventory(),(Player) event.getWhoClicked());
                            plugin.getLogger().info("(BS)"+event.getWhoClicked().getName()+"のBankエメラルドが"+bank+"から"+(int) BankMainSystem.getBankMoney((Player) event.getWhoClicked())+"になった。");
                            plugin.getLogger().info("(BS)"+event.getWhoClicked().getName()+"のWalletエメラルドが"+wallet+"から"+BankMainSystem.getWalletMoney((Player) event.getWhoClicked())+"になった。");
                        }
                        if(event.getSlot()==19||event.getSlot()==20||event.getSlot()==21){
                            GuiMaster.Eme_deposit(event.getClickedInventory(),(Player) event.getWhoClicked(),event.getCurrentItem());
                        }
                        if(event.getSlot()==14||event.getSlot()==15||event.getSlot()==16){
                            GuiMaster.Eme_withdraw(event.getClickedInventory(),(Player) event.getWhoClicked(),event.getCurrentItem());
                        }
                        if(Math.abs(bank - (int) BankMainSystem.getBankMoney((Player) event.getWhoClicked())) != Math.abs(wallet - BankMainSystem.getWalletMoney((Player) event.getWhoClicked()))){
                            plugin.getLogger().warning("(BS)"+event.getWhoClicked().getName()+"の預け入れたエメラルド数と所持しているエメラルド数が合わない");
                            plugin.getLogger().warning("(BS)"+event.getWhoClicked().getName()+"のBankエメラルドが"+bank+"から"+(int) BankMainSystem.getBankMoney((Player) event.getWhoClicked())+"になった。");
                            plugin.getLogger().warning("(BS)"+event.getWhoClicked().getName()+"のWalletエメラルドが"+wallet+"から"+BankMainSystem.getWalletMoney((Player) event.getWhoClicked())+"になった。");
                        }
                    }
                    if(event.getClick().equals(ClickType.RIGHT)){
                        if(event.getSlot()==14||event.getSlot()==15||event.getSlot()==16||event.getSlot()==19||event.getSlot()==20||event.getSlot()==21){
                            Integer changeRate = 0;
                            NamespacedKey key = new NamespacedKey(plugin,"changeRate");
                            ItemMeta itemMeta = event.getCurrentItem().getItemMeta();
                            PersistentDataContainer pdc = itemMeta.getPersistentDataContainer();
                            if(!pdc.has(key)){
                                pdc.set(key,PersistentDataType.INTEGER,1);
                                itemMeta.setDisplayName(ChatColor.WHITE +"左クリックで"+1+"個預け入れる。右クリックで個数の変更");
                                event.getCurrentItem().setItemMeta(itemMeta);
                            }
                            changeRate = pdc.get(key, PersistentDataType.INTEGER);
                            switch (changeRate){
                                case 1->{
                                    pdc.set(key,PersistentDataType.INTEGER,8);
                                    itemMeta.setDisplayName(ChatColor.WHITE +"左クリックで"+8+"個預け入れる。右クリックで個数の変更");
                                    event.getCurrentItem().setItemMeta(itemMeta);
                                }
                                case 8->{
                                    pdc.set(key,PersistentDataType.INTEGER,16);
                                    itemMeta.setDisplayName(ChatColor.WHITE +"左クリックで"+16+"個預け入れる。右クリックで個数の変更");
                                    event.getCurrentItem().setItemMeta(itemMeta);
                                }
                                case 16->{
                                    pdc.set(key,PersistentDataType.INTEGER,32);
                                    itemMeta.setDisplayName(ChatColor.WHITE +"左クリックで"+32+"個預け入れる。右クリックで個数の変更");
                                    event.getCurrentItem().setItemMeta(itemMeta);
                                }
                                case 32->{
                                    pdc.set(key,PersistentDataType.INTEGER,64);
                                    itemMeta.setDisplayName(ChatColor.WHITE +"左クリックで"+64+"個預け入れる。右クリックで個数の変更");
                                    event.getCurrentItem().setItemMeta(itemMeta);
                                }
                                case 64->{
                                    pdc.set(key,PersistentDataType.INTEGER,1);
                                    itemMeta.setDisplayName(ChatColor.WHITE +"左クリックで"+1+"個預け入れる。右クリックで個数の変更");
                                    event.getCurrentItem().setItemMeta(itemMeta);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

}
