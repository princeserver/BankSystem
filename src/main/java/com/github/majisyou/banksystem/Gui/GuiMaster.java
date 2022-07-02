package com.github.majisyou.banksystem.Gui;

import com.github.majisyou.banksystem.BankSystem;
import com.github.majisyou.banksystem.System.BankMainSystem;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

import java.util.Arrays;

public class GuiMaster {
    private static BankSystem plugin = BankSystem.getInstance();

    public static void OpenBankGui(Player player) {
        Inventory inventory = Bukkit.createInventory(null, 36, "Prince銀行");
        ItemStack BackGround = GuiItem.BackGround();
        ItemStack Number = GuiItem.Number();
        ItemStack EmeraldPane = GuiItem.EmeraldPane();
        ItemStack AddPane = GuiItem.AddPane();
        ItemStack TakePane = GuiItem.TakePane();
        ItemStack Emerald = GuiItem.Emerald();
        ItemStack EmeraldBlock = GuiItem.EmeraldBlock();
        ItemStack LiquidEmerald = GuiItem.LiquidEmerald();

        ItemStack[] GuiContainer = new ItemStack[]{ BackGround, BackGround, BackGround, Number, Number, EmeraldPane, BackGround, BackGround, BackGround,
                                                    BackGround, BackGround, AddPane, BackGround, BackGround, Emerald, EmeraldBlock, LiquidEmerald, BackGround,
                                                    BackGround, Emerald, EmeraldBlock, LiquidEmerald, BackGround, BackGround, TakePane, BackGround, BackGround,
                                                    BackGround, BackGround, BackGround, Number, Number, EmeraldPane, BackGround, BackGround, BackGround,};
        inventory.setContents(GuiContainer);
        InventoryEmerald(inventory,player);
        BankEmerald(inventory,player);
        player.openInventory(inventory);
    }

    public static void InventoryEmerald(Inventory inventory,Player player){
        Inventory playerInv = player.getInventory();
        int WalletMoney = 0;
        ItemStack backGround = GuiItem.BackGround();
        for (ItemStack item : playerInv.getContents()){
            if(item!=null){
                if(!item.getType().equals(Material.AIR)){
                    if(item.getType().equals(Material.EMERALD)){
                        WalletMoney += item.getAmount();
                    }
                    if(item.getType().equals(Material.EMERALD_BLOCK)){
                        WalletMoney += 64*item.getAmount();
                    }
                    if(item.getType().equals(Material.REPEATING_COMMAND_BLOCK)){
                        WalletMoney +=4096*item.getAmount();
                    }
                }
            }
        }
        char[] calculate = String.valueOf(WalletMoney).toCharArray();
        ItemStack EmeraldPane = GuiItem.EmeraldPane();
        ItemStack Num10000000 = GuiItem.Number();
        ItemStack Num1000000 = GuiItem.Number();
        ItemStack Num100000 = GuiItem.Number();
        ItemStack Num10000 = GuiItem.Number();
        ItemStack Num1000 = GuiItem.Number();
        ItemStack Num100 = GuiItem.Number();
        ItemStack Num10 = GuiItem.Number();
        ItemStack Num0 = GuiItem.Number();

        if(calculate.length >8){
            ItemStack Over = GuiItem.Number(9);
            inventory.setItem(27,Over);
            inventory.setItem(28,Over);
            inventory.setItem(29,Over);
            inventory.setItem(30,Over);
            inventory.setItem(31,Over);
            inventory.setItem(32,Over);
            inventory.setItem(33,Over);
            inventory.setItem(34,Over);
            inventory.setItem(35,EmeraldPane);
            return;
        }
        if(calculate.length>6){
            if(calculate.length==8){
                Num10000000 = GuiItem.Number(Integer.parseInt(String.valueOf(calculate[0])));
                Num0 = GuiItem.Number(Integer.parseInt(String.valueOf(calculate[7])));
                Num10 = GuiItem.Number(Integer.parseInt(String.valueOf(calculate[6])));
                Num100 = GuiItem.Number(Integer.parseInt(String.valueOf(calculate[5])));
                Num1000 = GuiItem.Number(Integer.parseInt(String.valueOf(calculate[4])));
                Num10000 = GuiItem.Number(Integer.parseInt(String.valueOf(calculate[3])));
                Num100000 = GuiItem.Number(Integer.parseInt(String.valueOf(calculate[2])));
                Num1000000 = GuiItem.Number(Integer.parseInt(String.valueOf(calculate[1])));

            }else {
                Num10000000 = GuiItem.Number();
                Num0 = GuiItem.Number(Integer.parseInt(String.valueOf(calculate[6])));
                Num10 = GuiItem.Number(Integer.parseInt(String.valueOf(calculate[5])));
                Num100 = GuiItem.Number(Integer.parseInt(String.valueOf(calculate[4])));
                Num1000 = GuiItem.Number(Integer.parseInt(String.valueOf(calculate[3])));
                Num10000 = GuiItem.Number(Integer.parseInt(String.valueOf(calculate[2])));
                Num100000 = GuiItem.Number(Integer.parseInt(String.valueOf(calculate[1])));
                Num1000000 = GuiItem.Number(Integer.parseInt(String.valueOf(calculate[0])));
            }
            inventory.setItem(27,Num10000000);
            inventory.setItem(28,Num1000000);
            inventory.setItem(29,Num100000);
            inventory.setItem(30,Num10000);
            inventory.setItem(31,Num1000);
            inventory.setItem(32,Num100);
            inventory.setItem(33,Num10);
            inventory.setItem(34,Num0);
            inventory.setItem(35,EmeraldPane);
            return;
        }
        if(calculate.length>4){
            if(calculate.length==6){
                Num100000 = GuiItem.Number(Integer.parseInt(String.valueOf(calculate[0])));
                Num0 = GuiItem.Number(Integer.parseInt(String.valueOf(calculate[5])));
                Num10 = GuiItem.Number(Integer.parseInt(String.valueOf(calculate[4])));
                Num100 = GuiItem.Number(Integer.parseInt(String.valueOf(calculate[3])));
                Num1000 = GuiItem.Number(Integer.parseInt(String.valueOf(calculate[2])));
                Num10000 = GuiItem.Number(Integer.parseInt(String.valueOf(calculate[1])));
            }else {
                Num100000 = GuiItem.Number();
                Num0 = GuiItem.Number(Integer.parseInt(String.valueOf(calculate[4])));
                Num10 = GuiItem.Number(Integer.parseInt(String.valueOf(calculate[3])));
                Num100 = GuiItem.Number(Integer.parseInt(String.valueOf(calculate[2])));
                Num1000 = GuiItem.Number(Integer.parseInt(String.valueOf(calculate[1])));
                Num10000 = GuiItem.Number(Integer.parseInt(String.valueOf(calculate[0])));
            }
            inventory.setItem(27,backGround);
            inventory.setItem(28,Num100000);
            inventory.setItem(29,Num10000);
            inventory.setItem(30,Num1000);
            inventory.setItem(31,Num100);
            inventory.setItem(32,Num10);
            inventory.setItem(33,Num0);
            inventory.setItem(34,EmeraldPane);
            inventory.setItem(35,backGround);
            return;
        }
        if(calculate.length>2){
            if(calculate.length==4){
                Num1000 = GuiItem.Number(Integer.parseInt(String.valueOf(calculate[0])));
                Num0 = GuiItem.Number(Integer.parseInt(String.valueOf(calculate[3])));
                Num10 = GuiItem.Number(Integer.parseInt(String.valueOf(calculate[2])));
                Num100 = GuiItem.Number(Integer.parseInt(String.valueOf(calculate[1])));
            }else {
                Num1000 = GuiItem.Number();
                Num0 = GuiItem.Number(Integer.parseInt(String.valueOf(calculate[2])));
                Num10 = GuiItem.Number(Integer.parseInt(String.valueOf(calculate[1])));
                Num100 = GuiItem.Number(Integer.parseInt(String.valueOf(calculate[0])));
            }
            inventory.setItem(27,backGround);
            inventory.setItem(28,backGround);
            inventory.setItem(29,Num1000);
            inventory.setItem(30,Num100);
            inventory.setItem(31,Num10);
            inventory.setItem(32,Num0);
            inventory.setItem(33,EmeraldPane);
            inventory.setItem(34,backGround);
            inventory.setItem(35,backGround);
            return;
        }
        if(calculate.length==2){
            Num10 = GuiItem.Number(Integer.parseInt(String.valueOf(calculate[0])));
            Num0 = GuiItem.Number(Integer.parseInt(String.valueOf(calculate[1])));
        }else {
            Num10 = GuiItem.Number();
            Num0 = GuiItem.Number(Integer.parseInt(String.valueOf(calculate[0])));
        }
        inventory.setItem(27,backGround);
        inventory.setItem(28,backGround);
        inventory.setItem(29,backGround);
        inventory.setItem(30,Num10);
        inventory.setItem(31,Num0);
        inventory.setItem(32,EmeraldPane);
        inventory.setItem(33,backGround);
        inventory.setItem(34,backGround);
        inventory.setItem(35,backGround);

    }

    public static void BankEmerald(Inventory inventory,Player player){
        int BankMoney = (int) BankMainSystem.getBankMoney(player);
        char[] calculate = String.valueOf(BankMoney).toCharArray();
        ItemStack backGround = GuiItem.BackGround();
        ItemStack EmeraldPane = GuiItem.EmeraldPane();
        ItemStack Num10000000 = GuiItem.Number();
        ItemStack Num1000000 = GuiItem.Number();
        ItemStack Num100000 = GuiItem.Number();
        ItemStack Num10000 = GuiItem.Number();
        ItemStack Num1000 = GuiItem.Number();
        ItemStack Num100 = GuiItem.Number();
        ItemStack Num10 = GuiItem.Number();
        ItemStack Num0 = GuiItem.Number();
        if(calculate.length >8){
            ItemStack Over = GuiItem.Number(9);
            inventory.setItem(0,Over);
            inventory.setItem(1,Over);
            inventory.setItem(2,Over);
            inventory.setItem(3,Over);
            inventory.setItem(4,Over);
            inventory.setItem(5,Over);
            inventory.setItem(6,Over);
            inventory.setItem(7,Over);
            inventory.setItem(8,EmeraldPane);
            return;
        }
        if(calculate.length>6){
            if(calculate.length==8){
                Num10000000 = GuiItem.Number(Integer.parseInt(String.valueOf(calculate[0])));
                Num0 = GuiItem.Number(Integer.parseInt(String.valueOf(calculate[7])));
                Num10 = GuiItem.Number(Integer.parseInt(String.valueOf(calculate[6])));
                Num100 = GuiItem.Number(Integer.parseInt(String.valueOf(calculate[5])));
                Num1000 = GuiItem.Number(Integer.parseInt(String.valueOf(calculate[4])));
                Num10000 = GuiItem.Number(Integer.parseInt(String.valueOf(calculate[3])));
                Num100000 = GuiItem.Number(Integer.parseInt(String.valueOf(calculate[2])));
                Num1000000 = GuiItem.Number(Integer.parseInt(String.valueOf(calculate[1])));

            }else {
                Num10000000 = GuiItem.Number();
                Num0 = GuiItem.Number(Integer.parseInt(String.valueOf(calculate[6])));
                Num10 = GuiItem.Number(Integer.parseInt(String.valueOf(calculate[5])));
                Num100 = GuiItem.Number(Integer.parseInt(String.valueOf(calculate[4])));
                Num1000 = GuiItem.Number(Integer.parseInt(String.valueOf(calculate[3])));
                Num10000 = GuiItem.Number(Integer.parseInt(String.valueOf(calculate[2])));
                Num100000 = GuiItem.Number(Integer.parseInt(String.valueOf(calculate[1])));
                Num1000000 = GuiItem.Number(Integer.parseInt(String.valueOf(calculate[0])));
            }
            inventory.setItem(0,Num10000000);
            inventory.setItem(1,Num1000000);
            inventory.setItem(2,Num100000);
            inventory.setItem(3,Num10000);
            inventory.setItem(4,Num1000);
            inventory.setItem(5,Num100);
            inventory.setItem(6,Num10);
            inventory.setItem(7,Num0);
            inventory.setItem(8,EmeraldPane);
            return;
        }
        if(calculate.length>4){
            if(calculate.length==6){
                Num100000 = GuiItem.Number(Integer.parseInt(String.valueOf(calculate[0])));
                Num0 = GuiItem.Number(Integer.parseInt(String.valueOf(calculate[5])));
                Num10 = GuiItem.Number(Integer.parseInt(String.valueOf(calculate[4])));
                Num100 = GuiItem.Number(Integer.parseInt(String.valueOf(calculate[3])));
                Num1000 = GuiItem.Number(Integer.parseInt(String.valueOf(calculate[2])));
                Num10000 = GuiItem.Number(Integer.parseInt(String.valueOf(calculate[1])));
            }else {
                Num100000 = GuiItem.Number();
                Num0 = GuiItem.Number(Integer.parseInt(String.valueOf(calculate[4])));
                Num10 = GuiItem.Number(Integer.parseInt(String.valueOf(calculate[3])));
                Num100 = GuiItem.Number(Integer.parseInt(String.valueOf(calculate[2])));
                Num1000 = GuiItem.Number(Integer.parseInt(String.valueOf(calculate[1])));
                Num10000 = GuiItem.Number(Integer.parseInt(String.valueOf(calculate[0])));
            }
            inventory.setItem(0,backGround);
            inventory.setItem(1,Num100000);
            inventory.setItem(2,Num10000);
            inventory.setItem(3,Num1000);
            inventory.setItem(4,Num100);
            inventory.setItem(5,Num10);
            inventory.setItem(6,Num0);
            inventory.setItem(7,EmeraldPane);
            inventory.setItem(8,backGround);
            return;
        }
        if(calculate.length>2){
            if(calculate.length==4){
                Num1000 = GuiItem.Number(Integer.parseInt(String.valueOf(calculate[0])));
                Num0 = GuiItem.Number(Integer.parseInt(String.valueOf(calculate[3])));
                Num10 = GuiItem.Number(Integer.parseInt(String.valueOf(calculate[2])));
                Num100 = GuiItem.Number(Integer.parseInt(String.valueOf(calculate[1])));
            }else {
                Num1000 = GuiItem.Number();
                Num0 = GuiItem.Number(Integer.parseInt(String.valueOf(calculate[2])));
                Num10 = GuiItem.Number(Integer.parseInt(String.valueOf(calculate[1])));
                Num100 = GuiItem.Number(Integer.parseInt(String.valueOf(calculate[0])));
            }

            inventory.setItem(0,backGround);
            inventory.setItem(1,backGround);
            inventory.setItem(2,Num1000);
            inventory.setItem(3,Num100);
            inventory.setItem(4,Num10);
            inventory.setItem(5,Num0);
            inventory.setItem(6,EmeraldPane);
            inventory.setItem(7,backGround);
            inventory.setItem(8,backGround);
            return;
        }
        if(calculate.length==2){
            Num10 = GuiItem.Number(Integer.parseInt(String.valueOf(calculate[0])));
            Num0 = GuiItem.Number(Integer.parseInt(String.valueOf(calculate[1])));
        }else {
            Num10 = GuiItem.Number();
            Num0 = GuiItem.Number(Integer.parseInt(String.valueOf(calculate[0])));
        }
        inventory.setItem(0,backGround);
        inventory.setItem(1,backGround);
        inventory.setItem(2,backGround);
        inventory.setItem(3,Num10);
        inventory.setItem(4,Num0);
        inventory.setItem(5,EmeraldPane);
        inventory.setItem(6,backGround);
        inventory.setItem(7,backGround);
        inventory.setItem(8,backGround);
        return;
    }

    public static void deposit(Inventory inventory,Player player){
        int WalletMoney = 0;
        Inventory playerInv = player.getInventory();
        ItemStack item = null;
        for (int i = 0 ; i < playerInv.getContents().length; i++){
            item = playerInv.getItem(i);
            if(item != null){
                if(!item.getType().equals(Material.AIR)){
                    if(item.getType().equals(Material.EMERALD)){
                        playerInv.clear(i);
                        WalletMoney += item.getAmount();
                    }
                    if(item.getType().equals(Material.EMERALD_BLOCK)){
                        playerInv.clear(i);
                        WalletMoney += 64 * item.getAmount();
                    }
                    if(item.getType().equals(Material.REPEATING_COMMAND_BLOCK)){
                        playerInv.clear(i);
                        WalletMoney += 4096 * item.getAmount();
                    }
                }
            }
        }
        BankMainSystem.addBank(player,WalletMoney);
        InventoryEmerald(inventory,player);
        BankEmerald(inventory,player);
    }
    public static void withdraw(Inventory inventory,Player player){
        int bankMoney = (int) BankMainSystem.getBankMoney(player);
        int Liquid_emerald = 0;
        int emeraldBlock = 0;
        int emerald = 0;
        if(bankMoney >= 4096){
            while (bankMoney >= 4096){
                Liquid_emerald += 1;
                bankMoney -= 4096;
            }
        }
        if(bankMoney >= 64){
            while (bankMoney >= 64){
                emeraldBlock += 1;
                bankMoney -= 64;
            }
        }
        emerald = bankMoney;
        ItemStack LiquidEmerald = BankMainSystem.LiquidEmerald(1);
        while (Liquid_emerald >= 64){
            LiquidEmerald.setAmount(64);
            AddIteminInventory(player,LiquidEmerald);
            Liquid_emerald -= 64;
        }
        LiquidEmerald.setAmount(Liquid_emerald);
        ItemStack EmeraldBlock = new ItemStack(Material.EMERALD_BLOCK,emeraldBlock);
        ItemStack Emerald = new ItemStack(Material.EMERALD,emerald);
        AddIteminInventory(player,LiquidEmerald);
        AddIteminInventory(player,EmeraldBlock);
        AddIteminInventory(player,Emerald);

        BankMainSystem.reset(player);
        InventoryEmerald(inventory,player);
        BankEmerald(inventory,player);
    }

    public static void Eme_deposit(Inventory inventory,Player player,ItemStack ChangeItem){
        NamespacedKey key = new NamespacedKey(plugin,"changeRate");
        Integer depositAmount;
        if(ChangeItem.getItemMeta().getPersistentDataContainer().has(key)){
            depositAmount = ChangeItem.getItemMeta().getPersistentDataContainer().get(key, PersistentDataType.INTEGER);
        }else {
            depositAmount = 1;
        }
        if(ChangeItem.getType().equals(Material.EMERALD)){
            ItemStack emerald = null;
            for (int i = 0 ; i < player.getInventory().getContents().length ; i++){
                emerald = player.getInventory().getItem(i);
                if(emerald!=null){
                    if(!emerald.getType().equals(Material.AIR)){
                        if(emerald.getType().equals(Material.EMERALD)){
                            if(emerald.getAmount() >= depositAmount){
                                if(emerald.getAmount() == 1|| emerald.getAmount()==depositAmount ){
                                    player.getInventory().clear(i);
                                }else {
                                    emerald.setAmount(emerald.getAmount()-depositAmount);
                                }
                                BankMainSystem.addBank(player,depositAmount);
                                InventoryEmerald(inventory,player);
                                BankEmerald(inventory,player);
                                return;
                            }
                        }
                    }
                }
            }
        }
        if(ChangeItem.getType().equals(Material.EMERALD_BLOCK)){
            ItemStack emeraldblock = null;
            for (int i = 0 ; i < player.getInventory().getContents().length ; i++){
                emeraldblock = player.getInventory().getItem(i);
                if(emeraldblock!=null){
                    if(!emeraldblock.getType().equals(Material.AIR)){
                        if(emeraldblock.getType().equals(Material.EMERALD_BLOCK)){
                            if(emeraldblock.getAmount() >= depositAmount){
                                if(emeraldblock.getAmount() == 1 || emeraldblock.getAmount()==depositAmount){
                                    player.getInventory().clear(i);
                                }else {
                                    emeraldblock.setAmount(emeraldblock.getAmount()-depositAmount);
                                }
                                BankMainSystem.addBank(player,64*depositAmount);
                                InventoryEmerald(inventory,player);
                                BankEmerald(inventory,player);
                                return;
                            }
                        }
                    }
                }
            }
        }
        if(ChangeItem.getType().equals(Material.REPEATING_COMMAND_BLOCK)){
            ItemStack Liquidemerald = null;
            for (int i = 0 ; i < player.getInventory().getContents().length ; i++){
                Liquidemerald = player.getInventory().getItem(i);
                if(Liquidemerald!=null){
                    if(!Liquidemerald.getType().equals(Material.AIR)){
                        if(Liquidemerald.getType().equals(Material.REPEATING_COMMAND_BLOCK)){
                            if(Liquidemerald.getAmount() >= depositAmount){
                                if(Liquidemerald.getAmount() == 1 || Liquidemerald.getAmount()==depositAmount){
                                    player.getInventory().clear(i);
                                }else {
                                    Liquidemerald.setAmount(Liquidemerald.getAmount()-depositAmount);
                                }
                                BankMainSystem.addBank(player,4096*depositAmount);
                                InventoryEmerald(inventory,player);
                                BankEmerald(inventory,player);
                                return;
                            }
                        }
                    }
                }
            }
        }
    }
    public static void Eme_withdraw(Inventory inventory,Player player,ItemStack ChangeItem){
        NamespacedKey key = new NamespacedKey(plugin,"changeRate");
        Integer withdrawAmount;
        if(ChangeItem.getItemMeta().getPersistentDataContainer().has(key)){
            withdrawAmount = ChangeItem.getItemMeta().getPersistentDataContainer().get(key, PersistentDataType.INTEGER);
        }else {
            withdrawAmount = 1;
        }
        if(ChangeItem.getType().equals(Material.EMERALD)){
            ItemStack item = new ItemStack(Material.EMERALD,withdrawAmount);
            if(BankMainSystem.removeBank(player,withdrawAmount)){
                AddIteminInventory(player,item);
                InventoryEmerald(inventory,player);
                BankEmerald(inventory,player);
                return;
            }
        }
        if(ChangeItem.getType().equals(Material.EMERALD_BLOCK)){
            ItemStack item = new ItemStack(Material.EMERALD_BLOCK,withdrawAmount);
            if(BankMainSystem.removeBank(player,withdrawAmount*64)){
                AddIteminInventory(player,item);
                InventoryEmerald(inventory,player);
                BankEmerald(inventory,player);
                return;
            }
        }
        if(ChangeItem.getType().equals(Material.REPEATING_COMMAND_BLOCK)){
            ItemStack item = BankMainSystem.LiquidEmerald(withdrawAmount);
            if(BankMainSystem.removeBank(player,withdrawAmount*4096)){
                AddIteminInventory(player,item);
                InventoryEmerald(inventory,player);
                BankEmerald(inventory,player);
                return;
            }
        }
    }

    public static void AddIteminInventory(Player player,ItemStack item){
        if(player.getInventory().firstEmpty()!=-1){
            player.getInventory().addItem(item);
        }else {
            player.getWorld().dropItem(player.getLocation(),item);
        }
    }
}
