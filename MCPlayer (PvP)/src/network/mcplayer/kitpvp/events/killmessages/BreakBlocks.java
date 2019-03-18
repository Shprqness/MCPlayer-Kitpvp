package network.mcplayer.kitpvp.events.killmessages;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

public class BreakBlocks implements Listener {


    @EventHandler
    public void onPlace(BlockPlaceEvent e){

        Player p = e.getPlayer();
        if(!p.isOp()){
            e.setCancelled(true);
        }

    }


    @EventHandler
    public void onBreak(BlockBreakEvent e){
        Player p = e.getPlayer();
        if(!p.isOp()){
            e.setCancelled(true);
        }
    }

}
