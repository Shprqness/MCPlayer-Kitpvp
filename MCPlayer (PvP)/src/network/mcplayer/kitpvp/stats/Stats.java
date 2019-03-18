package network.mcplayer.kitpvp.stats;


import org.bukkit.ChatColor;
import org.bukkit.Statistic;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Stats implements CommandExecutor {


    public static String stats = "stats";


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if(cmd.getName().equalsIgnoreCase(stats)){
            Player p = (Player) sender;

            p.sendMessage(ChatColor.STRIKETHROUGH + "                                ");
            p.sendMessage(ChatColor.GRAY + "Total Kills: " + ChatColor.WHITE + p.getStatistic(Statistic.PLAYER_KILLS));
            p.sendMessage(ChatColor.GRAY + "Total Deaths: " + ChatColor.WHITE + p.getStatistic(Statistic.DEATHS));
            p.sendMessage(ChatColor.GRAY + "Damage Taken: " + ChatColor.WHITE + p.getStatistic(Statistic.DAMAGE_TAKEN));
            p.sendMessage(ChatColor.GRAY + "Damage Dealt: " + ChatColor.WHITE + p.getStatistic(Statistic.DAMAGE_DEALT));
            p.sendMessage(ChatColor.STRIKETHROUGH + "                                ");

        }


        return true;
    }
}




