package nl.lucemans.newresidence.setup;

import com.sk89q.worldedit.bukkit.WorldEditAPI;
import com.sk89q.worldedit.bukkit.WorldEditPlugin;
import com.sk89q.worldedit.bukkit.selections.CuboidSelection;
import com.sk89q.worldedit.bukkit.selections.Selection;
import nl.lucemans.newresidence.NewResidenceAPI;
import nl.lucemans.newresidence.command.base.BaseCommand;
import nl.lucemans.newresidence.registry.Registry;
import nl.lucemans.newresidence.residence.ResidenceType;
import nl.lucemans.newresidence.utils.SerializableLocation;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

/*
 * Created by Lucemans at 06/05/2018
 * See https://lucemans.nl
 */
public class LocationCommand implements BaseCommand {
    public void execute(Player p, String[] args) {
        Registry reg = NewResidenceAPI.getInstance().getRegistry();
        if (args.length == 2) {
            p.sendMessage("Please use -/res setup region <name>");
            return;
        }
        String res = args[2];
        ResidenceType resT = reg.getResidenceTypeByName(res);
        if (resT == null) {
            p.sendMessage("Could not find residence.");
            return;
        }

        // fetch both points, write them.
        WorldEditPlugin plug = (WorldEditPlugin) Bukkit.getPluginManager().getPlugin("WorldEdit");
        Selection sel = plug.getSelection(p);
        if (sel == null) {
            p.sendMessage("Please select something using WorldEdit.");
            return;
        }

        if (!(sel instanceof CuboidSelection)) {
            p.sendMessage("Worth a try but selections need to be cuboid.");
            return;
        }

        resT.negMark = new SerializableLocation(sel.getMinimumPoint());
        resT.posMark = new SerializableLocation(sel.getMaximumPoint());

        resT.check();
        p.sendMessage("Successfully saved the points!");
    }
}
