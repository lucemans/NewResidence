package nl.lucemans.subcommands;

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
public class ListCommand implements BaseCommand{
    public void execute(Player p, String[] args) {
        Registry reg = NewResidenceAPI.getInstance().getRegistry();
        if (reg.residenceTypes.size() == 0) {
            p.sendMessage("EMPTY");
        }
        else
        {
            for (ResidenceType res : reg.residenceTypes) {
                p.sendMessage(res.name + " - " + res.state.name());
            }
        }
        if (reg.residences.size() == 0) {
            p.sendMessage("EMPTY");
        }
        else
        {
            for (Residence res : reg.residences) {
                p.sendMessage("Res " + res.residenceType + " owned by " + res.owner);
            }
        }
    }
}
