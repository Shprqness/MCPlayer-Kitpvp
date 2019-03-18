package network.mcplayer.kitpvp.events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.Potion;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.potion.PotionType;

import java.util.ArrayList;

import static org.bukkit.Material.AIR;
import static org.bukkit.Material.SLIME_BALL;

public class Kits implements Listener {

    public void kitsGUI(Player p){
        String name = ChatColor.GOLD + "" + ChatColor.BOLD + "Select a Kit";
        Inventory inv = Bukkit.createInventory(null, 9, name);

        ArrayList<String> lore = new ArrayList<String>();

        ArrayList<String> lore2 = new ArrayList<String>();

        ItemStack kit1 = new ItemStack(Material.DIAMOND_CHESTPLATE);
        ItemMeta k1 = kit1.getItemMeta();
        k1.setDisplayName(ChatColor.LIGHT_PURPLE + "Potions");
        lore.add("Similar to Potion PvP");
        k1.setLore(lore);
        kit1.setItemMeta(k1);
        inv.setItem(0, kit1);



        p.openInventory(inv);

    }


    String prefix = ChatColor.DARK_GRAY + "[" + ChatColor.RED + "" + ChatColor.BOLD + "PvP" + ChatColor.DARK_GRAY + "] ";

    @EventHandler
    public void Interact(PlayerInteractEvent e){
        Player p = e.getPlayer();
        Action a = e.getAction();

        if(a == Action.PHYSICAL || e.getItem() == null || e.getItem().getType() == AIR)
            return;


        if(e.getItem().getType() == Material.SUGAR){
            if(!e.getItem().hasItemMeta())
                return;

            //todo check if this works
            p.sendMessage(prefix + "Applied Strength for '1 second'.");
            p.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 3, 1, false, true));
        }

        if(e.getItem().getType() == Material.WATCH){

            p.sendMessage(prefix + ChatColor.YELLOW + "Opening Kits....");


            kitsGUI(p);
        }


    }

    @EventHandler
    public void onInvClick(InventoryClickEvent e) {
        if (ChatColor.stripColor(e.getInventory().getName()).equalsIgnoreCase("Select a Kit")) {
            Player p = (Player) e.getWhoClicked();
            e.setCancelled(true);
            if (e.getCurrentItem() == null || e.getCurrentItem().getType() == AIR) {
                p.sendMessage(prefix + "Not a valid kit :p");
                p.closeInventory();
                return;
            }


            switch (e.getCurrentItem().getType()) {
                case DIAMOND_CHESTPLATE:

                    p.getInventory().clear();

                    ItemStack h = new ItemStack(Material.DIAMOND_HELMET);
                    ItemMeta h1 = h.getItemMeta();
                    h1.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
                    h.setItemMeta(h1);
                    p.getInventory().setHelmet(h);

                    ItemStack c = new ItemStack(Material.DIAMOND_CHESTPLATE);
                    ItemMeta c1 = c.getItemMeta();
                    c1.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
                    c.setItemMeta(c1);
                    p.getInventory().setChestplate(c);

                    ItemStack l = new ItemStack(Material.DIAMOND_LEGGINGS);
                    ItemMeta l1 = l.getItemMeta();
                    l1.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
                    l.setItemMeta(l1);
                    p.getInventory().setLeggings(l);

                    ItemStack b = new ItemStack(Material.DIAMOND_BOOTS);
                    ItemMeta b1 = b.getItemMeta();
                    b1.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
                    b.setItemMeta(h1);
                    p.getInventory().setBoots(b);

                    ItemStack s = new ItemStack(Material.DIAMOND_SWORD);
                    ItemMeta s1 = s.getItemMeta();
                    s1.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
                    s1.addEnchant(Enchantment.FIRE_ASPECT, 1, true);
                    s.setItemMeta(s1);
                    p.getInventory().setItem(0, s);


                    ItemStack item = new ItemStack(Material.POTION);
                    Potion pot = new Potion(1);
                    pot.setType(PotionType.INSTANT_HEAL);
                    pot.setSplash(true);
                    pot.apply(item);
                    p.getInventory().addItem(item);

                    ItemStack item2 = new ItemStack(Material.POTION);
                    Potion pot2 = new Potion(1);
                    pot2.setType(PotionType.INSTANT_HEAL);
                    pot2.setSplash(true);
                    pot2.apply(item2);
                    p.getInventory().addItem(item2);

                    ItemStack item3 = new ItemStack(Material.POTION);
                    Potion pot3 = new Potion(1);
                    pot3.setType(PotionType.INSTANT_HEAL);
                    pot3.setSplash(true);
                    pot3.apply(item3);
                    p.getInventory().addItem(item3);

                    ItemStack item4 = new ItemStack(Material.POTION);
                    Potion pot4 = new Potion(1);
                    pot4.setType(PotionType.INSTANT_HEAL);
                    pot4.setSplash(true);
                    pot4.apply(item4);
                    p.getInventory().addItem(item4);

                    ItemStack item5 = new ItemStack(Material.POTION);
                    Potion pot5 = new Potion(1);
                    pot5.setType(PotionType.INSTANT_HEAL);
                    pot5.setSplash(true);
                    pot5.apply(item5);
                    p.getInventory().addItem(item5);

                    ItemStack item6 = new ItemStack(Material.POTION);
                    Potion pot6 = new Potion(1);
                    pot6.setType(PotionType.INSTANT_HEAL);
                    pot6.setSplash(true);
                    pot6.apply(item6);
                    p.getInventory().addItem(item6);

                    ItemStack item7 = new ItemStack(Material.POTION);
                    Potion pot7 = new Potion(1);
                    pot7.setType(PotionType.INSTANT_HEAL);
                    pot7.setSplash(true);
                    pot7.apply(item7);
                    p.getInventory().addItem(item7);

                    ItemStack item8 = new ItemStack(Material.POTION);
                    Potion pot8 = new Potion(1);
                    pot8.setType(PotionType.INSTANT_HEAL);
                    pot8.setSplash(true);
                    pot8.apply(item8);
                    p.getInventory().addItem(item8);

                    ItemStack item9 = new ItemStack(Material.POTION);
                    Potion pot9 = new Potion(1);
                    pot9.setType(PotionType.INSTANT_HEAL);
                    pot9.setSplash(true);
                    pot9.apply(item9);
                    p.getInventory().addItem(item9);

                    ItemStack item10 = new ItemStack(Material.POTION);
                    Potion pot10 = new Potion(1);
                    pot10.setType(PotionType.INSTANT_HEAL);
                    pot10.setSplash(true);
                    pot10.apply(item10);
                    p.getInventory().addItem(item10);

                    ItemStack item11 = new ItemStack(Material.POTION);
                    Potion pot11 = new Potion(1);
                    pot11.setType(PotionType.INSTANT_HEAL);
                    pot11.setSplash(true);
                    pot11.apply(item11);
                    p.getInventory().addItem(item11);

                    ItemStack item12 = new ItemStack(Material.POTION);
                    Potion pot12 = new Potion(1);
                    pot12.setType(PotionType.INSTANT_HEAL);
                    pot12.setSplash(true);
                    pot12.apply(item12);
                    p.getInventory().addItem(item12);

                    ItemStack item13 = new ItemStack(Material.POTION);
                    Potion pot13 = new Potion(1);
                    pot13.setType(PotionType.INSTANT_HEAL);
                    pot13.setSplash(true);
                    pot13.apply(item13);
                    p.getInventory().addItem(item13);

                    ItemStack item14 = new ItemStack(Material.POTION);
                    Potion pot14 = new Potion(1);
                    pot14.setType(PotionType.INSTANT_HEAL);
                    pot14.setSplash(true);
                    pot14.apply(item14);
                    p.getInventory().addItem(item14);

                    ItemStack item15 = new ItemStack(Material.POTION);
                    Potion pot15 = new Potion(1);
                    pot15.setType(PotionType.INSTANT_HEAL);
                    pot15.setSplash(true);
                    pot15.apply(item15);
                    p.getInventory().addItem(item15);

                    ItemStack item16 = new ItemStack(Material.POTION);
                    Potion pot16 = new Potion(1);
                    pot16.setType(PotionType.INSTANT_HEAL);
                    pot16.setSplash(true);
                    pot16.apply(item16);
                    p.getInventory().addItem(item16);

                    ItemStack item17 = new ItemStack(Material.POTION);
                    Potion pot17 = new Potion(1);
                    pot17.setType(PotionType.INSTANT_HEAL);
                    pot17.setSplash(true);
                    pot17.apply(item17);
                    p.getInventory().addItem(item17);

                    ItemStack item18 = new ItemStack(Material.POTION);
                    Potion pot18 = new Potion(1);
                    pot18.setType(PotionType.INSTANT_HEAL);
                    pot18.setSplash(true);
                    pot18.apply(item18);
                    p.getInventory().addItem(item18);

                    ItemStack item19 = new ItemStack(Material.POTION);
                    Potion pot19 = new Potion(1);
                    pot19.setType(PotionType.INSTANT_HEAL);
                    pot19.setSplash(true);
                    pot19.apply(item19);
                    p.getInventory().addItem(item19);

                    ItemStack item20 = new ItemStack(Material.POTION);
                    Potion pot20 = new Potion(1);
                    pot20.setType(PotionType.INSTANT_HEAL);
                    pot20.setSplash(true);
                    pot20.apply(item20);
                    p.getInventory().addItem(item20);

                    ItemStack item21 = new ItemStack(Material.POTION);
                    Potion pot21 = new Potion(1);
                    pot21.setType(PotionType.INSTANT_HEAL);
                    pot21.setSplash(true);
                    pot21.apply(item21);
                    p.getInventory().addItem(item21);

                    ItemStack item22 = new ItemStack(Material.POTION);
                    Potion pot22 = new Potion(1);
                    pot22.setType(PotionType.INSTANT_HEAL);
                    pot22.setSplash(true);
                    pot22.apply(item22);
                    p.getInventory().addItem(item22);

                    ItemStack item23 = new ItemStack(Material.POTION);
                    Potion pot23 = new Potion(1);
                    pot23.setType(PotionType.INSTANT_HEAL);
                    pot23.setSplash(true);
                    pot23.apply(item23);
                    p.getInventory().addItem(item23);

                    ItemStack item24 = new ItemStack(Material.POTION);
                    Potion pot24 = new Potion(1);
                    pot24.setType(PotionType.INSTANT_HEAL);
                    pot24.setSplash(true);
                    pot24.apply(item24);
                    p.getInventory().addItem(item24);

                    ItemStack item25 = new ItemStack(Material.POTION);
                    Potion pot25 = new Potion(1);
                    pot25.setType(PotionType.INSTANT_HEAL);
                    pot25.setSplash(true);
                    pot25.apply(item25);
                    p.getInventory().addItem(item25);

                    ItemStack item26 = new ItemStack(Material.POTION);
                    Potion pot26 = new Potion(1);
                    pot26.setType(PotionType.INSTANT_HEAL);
                    pot26.setSplash(true);
                    pot26.apply(item26);
                    p.getInventory().addItem(item26);

                    ItemStack item27 = new ItemStack(Material.POTION);
                    Potion pot27 = new Potion(1);
                    pot27.setType(PotionType.INSTANT_HEAL);
                    pot27.setSplash(true);
                    pot27.apply(item27);
                    p.getInventory().addItem(item27);

                    ItemStack item28 = new ItemStack(Material.POTION);
                    Potion pot28 = new Potion(1);
                    pot28.setType(PotionType.INSTANT_HEAL);
                    pot28.setSplash(true);
                    pot28.apply(item28);
                    p.getInventory().addItem(item28);

                    ItemStack item29 = new ItemStack(Material.POTION);
                    Potion pot29 = new Potion(1);
                    pot29.setType(PotionType.INSTANT_HEAL);
                    pot29.setSplash(true);
                    pot29.apply(item29);
                    p.getInventory().addItem(item29);

                    ItemStack item30 = new ItemStack(Material.POTION);
                    Potion pot30 = new Potion(1);
                    pot30.setType(PotionType.INSTANT_HEAL);
                    pot30.setSplash(true);
                    pot30.apply(item30);
                    p.getInventory().addItem(item30);

                    ItemStack item31 = new ItemStack(Material.POTION);
                    Potion pot31 = new Potion(1);
                    pot31.setType(PotionType.INSTANT_HEAL);
                    pot31.setSplash(true);
                    pot31.apply(item31);
                    p.getInventory().addItem(item31);

                    ItemStack item32 = new ItemStack(Material.POTION);
                    Potion pot32 = new Potion(1);
                    pot32.setType(PotionType.INSTANT_HEAL);
                    pot32.setSplash(true);
                    pot32.apply(item32);
                    p.getInventory().addItem(item32);

                    ItemStack item33 = new ItemStack(Material.POTION);
                    Potion pot33 = new Potion(1);
                    pot33.setType(PotionType.INSTANT_HEAL);
                    pot33.setSplash(true);
                    pot33.apply(item33);
                    p.getInventory().addItem(item33);

                    ItemStack item34 = new ItemStack(Material.POTION);
                    Potion pot34 = new Potion(1);
                    pot34.setType(PotionType.FIRE_RESISTANCE);
                    pot34.apply(item34);
                    p.getInventory().setItem(34, item34);

                    ItemStack item35 = new ItemStack(Material.POTION);
                    Potion pot35 = new Potion(1);
                    pot35.setType(PotionType.SPEED);
                    pot35.apply(item35);
                    p.getInventory().setItem(35, item35);

                    p.sendMessage(prefix + "Equipped Potions Kit!");

                    p.closeInventory();





                    }

            switch (e.getCurrentItem().getType()){
                case OBSIDIAN:

                    p.getInventory().clear();

                    ItemStack helmet = new ItemStack(Material.OBSIDIAN);
                    p.getInventory().setHelmet(helmet);

                    ItemStack chest = new ItemStack(Material.DIAMOND_CHESTPLATE);
                    ItemMeta c1 = chest.getItemMeta();
                    c1.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3, true );
                    chest.setItemMeta(c1);
                    p.getInventory().setChestplate(chest);

                    ItemStack legs = new ItemStack(Material.DIAMOND_LEGGINGS);
                    ItemMeta l1 = legs.getItemMeta();
                    l1.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, true );
                    legs.setItemMeta(l1);
                    p.getInventory().setLeggings(legs);

                    ItemStack boots = new ItemStack(Material.DIAMOND_BOOTS);
                    ItemMeta b1 = boots.getItemMeta();
                    b1.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3, true );
                    boots.setItemMeta(b1);
                    p.getInventory().setBoots(boots);

                    ItemStack sword = new ItemStack(Material.STONE_SWORD);
                    sword.getItemMeta().addEnchant(Enchantment.DAMAGE_ALL, 1, true);
                    p.getInventory().setItem(0, sword);

                    ItemStack s = new ItemStack(Material.SUGAR);
                    ItemMeta s1 = s.getItemMeta();
                    s1.setDisplayName(ChatColor.RED + "" + ChatColor.BOLD + "Right Click for Strength");
                    s.setItemMeta(s1);
                    p.getInventory().setItem(1, s);

                    ItemStack apple = new ItemStack(Material.GOLDEN_APPLE, 8);
                    p.getInventory().setItem(8, apple);

                    p.sendMessage(prefix + "Equipped Tank Kit!");
                    p.closeInventory();
            }

            }
        }
    }

