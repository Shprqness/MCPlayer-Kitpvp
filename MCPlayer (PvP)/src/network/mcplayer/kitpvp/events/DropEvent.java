package network.mcplayer.kitpvp.events;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

public class DropEvent implements Listener {

    @EventHandler
    public void onDrop(PlayerDropItemEvent e){
       if(e.getItemDrop().getItemStack().getType() == Material.WATCH){
           Player p = e.getPlayer();
           e.setCancelled(true);
           p.sendMessage("Why would you want to drop this item...");

        }


    }
}
