package network.mcplayer.kitpvp.events;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class RespawnEvent implements Listener {

    @EventHandler
    public void onRespawn(PlayerRespawnEvent e){
        ItemStack select = new ItemStack(Material.WATCH);
        ItemMeta s1 = select.getItemMeta();
        Player p = e.getPlayer();

        ArrayList<String> lore =new ArrayList<String>();
        s1.setDisplayName(ChatColor.YELLOW + "" + ChatColor.BOLD + "Kits");
        lore.add(ChatColor.GRAY + "Select a kit!");
        s1.setLore(lore);
        select.setItemMeta(s1);

        p.getInventory().setItem(4, select);
    }



}
