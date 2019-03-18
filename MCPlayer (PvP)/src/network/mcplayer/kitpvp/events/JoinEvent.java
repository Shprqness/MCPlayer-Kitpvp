package network.mcplayer.kitpvp.events;

import network.mcplayer.kitpvp.PvP;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Statistic;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import java.util.ArrayList;

public class JoinEvent implements Listener {



    Scoreboard s = Bukkit.getScoreboardManager().getNewScoreboard();
    Objective o = s.registerNewObjective("dummy", "dummy");

    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        Player p = e.getPlayer();
        e.setJoinMessage(ChatColor.GREEN + p.getDisplayName() + ChatColor.GRAY + " has joined " + ChatColor.DARK_RED + "PvP" + ChatColor.GRAY + "!");

        p.getInventory().clear();
        p.getInventory().setHelmet(null);
        p.getInventory().setChestplate(null);
        p.getInventory().setLeggings(null);
        p.getInventory().setBoots(null);

        ArrayList<String> lore =new ArrayList<String>();

        p.teleport(p.getWorld().getSpawnLocation());


        ItemStack select = new ItemStack(Material.WATCH);
        ItemMeta s1 = select.getItemMeta();

        s1.setDisplayName(ChatColor.YELLOW + "" + ChatColor.BOLD + "Kits");
        lore.add(ChatColor.GRAY + "Select a kit!");
        s1.setLore(lore);
        select.setItemMeta(s1);

        p.getInventory().setItem(4, select);


        p.sendMessage(ChatColor.STRIKETHROUGH + "                                 ");
        p.sendMessage(ChatColor.GRAY + "Welcome to " + ChatColor.DARK_RED + "PvP" + ChatColor.GRAY + ", here you can fight others, practice you're PvP and more. Make sure you do not cheat or abuse any bugs or you will be punished.");
        p.sendMessage(ChatColor.STRIKETHROUGH + "                                 ");





    }



}
