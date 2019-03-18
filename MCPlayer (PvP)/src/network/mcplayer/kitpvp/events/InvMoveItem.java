package network.mcplayer.kitpvp.events;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryMoveItemEvent;

public class InvMoveItem implements Listener {

    @EventHandler
    public void onMoveInv(InventoryMoveItemEvent e){
        if(e.getItem().getType() == Material.WATCH){
            e.setCancelled(true);
        }
    }


}
