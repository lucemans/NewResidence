package nl.lucemans.newresidence.subcommands;

import nl.lucemans.NovaItems.NItem;
import nl.lucemans.newresidence.NewResidenceAPI;
import nl.lucemans.newresidence.command.base.BaseCommand;
import nl.lucemans.newresidence.registry.Registry;
import nl.lucemans.newresidence.residence.Residence;
import nl.lucemans.ninventory.NInventory;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import java.util.ArrayList;

/*
 * Created by Lucemans at 10/05/2018
 * See https://lucemans.nl
 */
public class HomeCommand implements BaseCommand {
    public void execute(Player p, String[] args) {
        Registry reg = NewResidenceAPI.getInstance().getRegistry();
        ArrayList<Residence> residences =  reg.getResidenceByOwner(p.getUniqueId().toString());

        if (residences.size() == 0) {
            p.sendMessage("You do not have a residence.");
            return;
        }
        if (residences.size() == 1) {
            Residence res = residences.get(0);

            p.teleport(res.spawn.getLocation());
        }
        else
        {
            NInventory ninv = new NInventory("Your Residences", ((int) Math.ceil(residences.size()/9))*9, NewResidenceAPI.getInstance());
            int i = 0;
            for (Residence r : residences) {
                final Player pl = p;
                final Residence rl = r;
                ninv.setItem(NItem.create(Material.BED).make(), i);
                ninv.setLClick(i, new Runnable() {
                    public void run() {
                        pl.teleport(rl.spawn.getLocation());
                    }
                });
                i++;
            }
        }
    }
}
