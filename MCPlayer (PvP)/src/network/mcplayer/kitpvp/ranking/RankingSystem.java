package network.mcplayer.kitpvp.ranking;

import org.bukkit.ChatColor;
import org.bukkit.Statistic;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class RankingSystem implements Listener, CommandExecutor {
    String prefix = ChatColor.DARK_GRAY + "[" + ChatColor.RED + "" + ChatColor.BOLD + "PvP" + ChatColor.DARK_GRAY + "] ";

    @EventHandler
    public void onDeathandKill(PlayerJoinEvent e){

        Player p = e.getPlayer();

        if(p.getStatistic(Statistic.PLAYER_KILLS) >= 15){
            p.setDisplayName(ChatColor.DARK_GRAY + "[" + ChatColor.AQUA + "Bronze" + ChatColor.DARK_GRAY + "] " +
                    ChatColor.GRAY + p.getDisplayName());
        }

        if(p.getStatistic(Statistic.PLAYER_KILLS) < 15){
            p.setDisplayName(ChatColor.DARK_GRAY + "[" + ChatColor.WHITE + "Not Ranked" + ChatColor.DARK_GRAY + "] " +
                    ChatColor.GRAY + p.getDisplayName());
        }

        if(p.getStatistic(Statistic.PLAYER_KILLS) >= 30){
            p.setDisplayName(ChatColor.DARK_GRAY + "[" + ChatColor.BLUE + "Iron" + ChatColor.DARK_GRAY + "] " +
                    ChatColor.GRAY + p.getDisplayName());
        }

        if(p.getStatistic(Statistic.PLAYER_KILLS) >= 80){
            p.setDisplayName(ChatColor.DARK_GRAY + "[" + ChatColor.DARK_BLUE + "Diamond" + ChatColor.DARK_GRAY + "] " +
                    ChatColor.GRAY + p.getDisplayName());
        }

        if(p.getStatistic(Statistic.PLAYER_KILLS) >= 130){
            p.setDisplayName(ChatColor.DARK_GRAY + "[" + ChatColor.RED + "Master" + ChatColor.DARK_GRAY + "] " +
                    ChatColor.GRAY + p.getDisplayName());
        }

        if(p.getName() == "Shprq"){
            p.setDisplayName(ChatColor.DARK_GRAY + "[" + ChatColor.DARK_RED + "Owner" + ChatColor.DARK_GRAY + "] " +
                    ChatColor.GRAY + p.getDisplayName());
        }



    }

    public static String rank = "rank";

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(cmd.getName().equalsIgnoreCase(rank)){
            Player p = (Player) sender;


            if(p.getStatistic(Statistic.PLAYER_KILLS) >= 15){
                p.sendMessage(prefix + "Your current rank is " + ChatColor.AQUA + "Bronze");
            }

            if(p.getStatistic(Statistic.PLAYER_KILLS) < 15){
                p.sendMessage(prefix + "Your current rank is " + ChatColor.GRAY + "Not Ranked");
            }

            if(p.getStatistic(Statistic.PLAYER_KILLS) >= 30){
                p.sendMessage(prefix + "Your current rank is " + ChatColor.BLUE + "Iron");
            }

            if(p.getStatistic(Statistic.PLAYER_KILLS) >= 80){
                p.sendMessage(prefix + "Your current rank is " + ChatColor.DARK_BLUE + "Diamond");
            }

            if(p.getStatistic(Statistic.PLAYER_KILLS) >= 130){
                p.sendMessage(prefix + "Your current rank is " + ChatColor.RED + "Master");
            }


        }

        return true;
    }
}
