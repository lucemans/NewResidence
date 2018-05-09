package nl.lucemans.newresidence.setup;

import nl.lucemans.newresidence.NewResidenceAPI;
import nl.lucemans.newresidence.command.base.BaseCommand;
import nl.lucemans.newresidence.residence.ResidenceType;
import org.bukkit.entity.Player;

/*
 * Created by Lucemans at 06/05/2018
 * See https://lucemans.nl
 */
public class CreateCommand implements BaseCommand {

    // -/res setup create <name>
    public void execute(Player p, String[] args) {
        if (args.length == 2) {
            p.sendMessage("Please use /res setup create <name>");
            return;
        }

        String name = args[2];
        if (NewResidenceAPI.getInstance().getRegistry().getResidenceTypeByName(name) != null) {
            p.sendMessage("Name Already in use please use another one.");
            return;
        }

        ResidenceType res = new ResidenceType();
        res.name = name;
        res.check();
        NewResidenceAPI.getInstance().getRegistry().residenceTypes.add(res);
        p.sendMessage("ResidenceType `" + name + "` successfully created.");
    }
}