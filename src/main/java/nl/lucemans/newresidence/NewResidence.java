package nl.lucemans.newresidence;

import nl.lucemans.newresidence.command.ResidenceCommand;
import nl.lucemans.newresidence.lang.Lang;
import nl.lucemans.newresidence.registry.Registry;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

/*
 * Created by Lucemans at 06/05/2018
 * See https://lucemans.nl
 */
public class NewResidence extends JavaPlugin {

    private Registry registry;

    @Override
    public void onEnable() {
        super.onEnable();
        saveDefaultConfig();

        registry = new Registry();
        registry.load();

        getCommand("residence").setExecutor(new ResidenceCommand());

        NewResidenceAPI.instance = this;
        Bukkit.getLogger().info(Lang.get(Lang.lang.BOOT));
    }

    @Override
    public void onDisable() {
        registry.save();
    }

    public Registry getRegistry() {
        return registry;
    }

    /*
    for (final Player p : Bukkit.getOnlinePlayers())
    {
        p.openInventory(
                new NInventory("Hello", 3*9, this)
                .setItem(NItem.create(Material.GOLD_AXE).setName("&c&lHello").make(), 5)
                .setLClick(5, new Runnable() {
                    public void run() {
                        p.sendMessage("Hello!!");
                    }
                }).getInv()
        );
    }
    */
}
