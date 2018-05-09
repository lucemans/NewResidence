package nl.lucemans.newresidence.subcommands;

import nl.lucemans.newresidence.NewResidenceAPI;
import nl.lucemans.newresidence.command.base.BaseCommand;
import nl.lucemans.newresidence.registry.Registry;
import nl.lucemans.newresidence.residence.Residence;
import nl.lucemans.newresidence.residence.ResidenceType;
import org.bukkit.entity.Player;

/*
 * Created by Lucemans at 06/05/2018
 * See https://lucemans.nl
 */
public class InfoCommand implements BaseCommand{

    // -/res info <name>
    public void execute(Player p, String[] args) {
        Registry reg = NewResidenceAPI.getInstance().getRegistry();
        if (args.length == 1) {
            p.sendMessage("Please use -/res info <name>");
            return;
        }
        String res = args[1];
        ResidenceType resT = reg.getResidenceTypeByName(res);
        if (resT == null) {
            p.sendMessage("Could not find residence.");
            return;
        }

        p.sendMessage("----" + resT.name + "----");
        p.sendMessage("Status: " + resT.state.name());
        p.sendMessage("Type: " + resT.type.name());
        if (resT.spawn != null)
            p.sendMessage("X: " + resT.spawn.x + " Y: " + resT.spawn.y + " Z: " + resT.spawn.z + " World: " + resT.spawn.world);
        else
            p.sendMessage("No location set.");
        if (resT.negMark == null || resT.posMark == null)
            p.sendMessage("No Region set.");
    }
}
