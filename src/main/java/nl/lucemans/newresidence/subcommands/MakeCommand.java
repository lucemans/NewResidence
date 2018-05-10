package nl.lucemans.newresidence.subcommands;

import nl.lucemans.newresidence.NewResidenceAPI;
import nl.lucemans.newresidence.command.base.BaseCommand;
import nl.lucemans.newresidence.residence.Residence;
import nl.lucemans.newresidence.residence.ResidenceType;
import org.bukkit.entity.Player;

/*
 * Created by Lucemans at 10/05/2018
 * See https://lucemans.nl
 */
public class MakeCommand implements BaseCommand {

    // -/res make <name>
    public void execute(Player p, String[] args) {

        if (args.length == 1) {
            p.sendMessage("Please use /res make <name>");
            return;
        }
        ResidenceType type = NewResidenceAPI.getInstance().getRegistry().getResidenceTypeByName(args[1]);
        if (type == null) {
            p.sendMessage("That type does not exist.");
            return;
        }

        p.sendMessage("Creating house!");
        Residence r = NewResidenceAPI.createResidence(type, p.getUniqueId().toString());
        if (r != null) {
            NewResidenceAPI.getInstance().getRegistry().residences.add(r);
            p.sendMessage("Success!");
            return;
        }
        p.sendMessage("An Error Occured");
    }
}
