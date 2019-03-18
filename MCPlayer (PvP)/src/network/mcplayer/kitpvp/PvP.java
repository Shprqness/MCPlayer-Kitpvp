package network.mcplayer.kitpvp;

import network.mcplayer.kitpvp.events.*;
import network.mcplayer.kitpvp.events.killmessages.BreakBlocks;
import network.mcplayer.kitpvp.events.killmessages.KillMessages;
import network.mcplayer.kitpvp.ranking.RankingSystem;

import network.mcplayer.kitpvp.stats.Stats;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Statistic;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

public class PvP extends JavaPlugin implements Listener {

    /*
    TODO List
    1. Stats feature

     */


    public void onEnable(){
        registerCommands();
        registerEvents();
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "gamerule showDeathMessages false");

    }



    public void registerEvents(){

        Bukkit.getServer().getPluginManager().registerEvents(new JoinEvent(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new Kits(), this);
        Bukkit.getServer().getPluginManager().registerEvents(this, this);
        Bukkit.getServer().getPluginManager().registerEvents(new RankingSystem(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new InvMoveItem(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new DropEvent(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new DeathEvent(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new KillMessages(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new FoodEvent(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new BreakBlocks(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new RespawnEvent(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new DamageEvent(), this);

    }


    private RankingSystem cmd1 = new RankingSystem();
    private Stats cmd2 = new Stats();

    public void registerCommands(){
        getCommand(RankingSystem.rank).setExecutor(cmd1);
        getCommand(Stats.stats).setExecutor(cmd2);

    }



    public void onDisable(){

    }


    @EventHandler
    public void scoreboard(PlayerJoinEvent e){
        Scoreboard s = Bukkit.getScoreboardManager().getNewScoreboard();
        Objective o = s.registerNewObjective("dummy", "dummy");

Player p = e.getPlayer();
        o.setDisplayName(ChatColor.DARK_RED + "" + ChatColor.BOLD + "PvP" + ChatColor.GRAY +" | " + ChatColor.GREEN + "MCPlayer");
        o.setDisplaySlot(DisplaySlot.SIDEBAR);

        BukkitScheduler scheduler = Bukkit.getServer().getScheduler();

        Team kills = s.registerNewTeam("kills");
        Team deaths = s.registerNewTeam("deaths");

        deaths.addEntry(ChatColor.RED + "Deaths" + ChatColor.GRAY +": " + ChatColor.BLUE);
        kills.addEntry(ChatColor.RED + "Kills" + ChatColor.GRAY +": " + ChatColor.BLUE);
        o.getScore(ChatColor.RED + "Deaths" + ChatColor.GRAY +": " + ChatColor.BLUE).setScore(5);
        o.getScore(ChatColor.RED + "Kills" + ChatColor.GRAY +": " + ChatColor.BLUE).setScore(6);

        scheduler.scheduleSyncRepeatingTask(this, new Runnable() {
            @Override
            public void run() {

                kills.setSuffix(p.getStatistic(Statistic.PLAYER_KILLS) + "");
                deaths.setSuffix(p.getStatistic(Statistic.DEATHS) + "");


            }
        }, 0L, 20L);



        o.getScore(ChatColor.STRIKETHROUGH + "                              ").setScore(8);
        o.getScore("   ").setScore(7);
        o.getScore(" ").setScore(4);
        o.getScore("     ").setScore(3);
        o.getScore(ChatColor.GREEN + "" + ChatColor.ITALIC + "MCPlayer.Network").setScore(2);
        o.getScore(ChatColor.STRIKETHROUGH + "" + ChatColor.WHITE + "                            ").setScore(1);

        o.setDisplaySlot(DisplaySlot.SIDEBAR);

        p.setScoreboard(s);

    }





}
