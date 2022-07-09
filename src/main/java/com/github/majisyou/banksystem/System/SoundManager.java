package com.github.majisyou.banksystem.System;

import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.entity.Player;

public class SoundManager {

    public static void OpenEnder(Player player){
        player.playSound(player.getLocation(), Sound.BLOCK_ENDER_CHEST_OPEN,SoundCategory.BLOCKS, 1.0F, 1.0F);
    }
    public static void CloseEnder(Player player){
        player.playSound(player.getLocation(), Sound.BLOCK_ENDER_CHEST_CLOSE,SoundCategory.BLOCKS, 1.0F, 1.0F);
    }
    public static void Click(Player player){
        player.playSound(player.getLocation(), Sound.UI_BUTTON_CLICK,SoundCategory.BLOCKS, 1.0F, 1.0F);
    }
}
