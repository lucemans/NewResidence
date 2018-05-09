package nl.lucemans.newresidence.setup;

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
public class SetSpawnCommand implements BaseCommand {

    // -/res setup spawn <name>
    public void execute(Player p, String[] args) {
        Registry reg = NewResidenceAPI.getInstance().getRegistry();
        if (args.length == 2) {
            p.sendMessage("Please use -/res setup spawn <name>");
            return;
        }
        String res = args[2];
        ResidenceType resT = reg.getResidenceTypeByName(res);
        if (resT == null) {
            p.sendMessage("Could not find residence.");
            return;
        }

        if (resT.negMark == null) {
            p.sendMessage("You need to set a region first.");
            return;
        }

        resT.spawn = new SerializableLocation(p.getLocation().clone().subtract(resT.negMark.getLocation()));

        p.sendMessage("Successfully saved the spawn!");
    }
}
