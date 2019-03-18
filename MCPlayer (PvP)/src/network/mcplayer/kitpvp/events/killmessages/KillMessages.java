package network.mcplayer.kitpvp.events.killmessages;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Statistic;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class KillMessages implements Listener {


    @EventHandler
    public void onDeath(PlayerDeathEvent e){

        e.setDeathMessage(null);

        if(e.getEntity().getKiller() instanceof Player){
            Player killer = e.getEntity().getKiller();
            Player p = e.getEntity();

            Bukkit.broadcastMessage(ChatColor.RED + p.getName() + ChatColor.GRAY + "[" + ChatColor.GREEN + p.getStatistic(Statistic.PLAYER_KILLS) + ChatColor.GRAY + "] " + ChatColor.YELLOW + "was killed by " + ChatColor.RED + killer.getName() + ChatColor.GRAY + "[" + ChatColor.GREEN + killer.getStatistic(Statistic.PLAYER_KILLS) + ChatColor.GRAY + "] ");
        }


    }


}
