package nl.lucemans.newresidence.setup;

import nl.lucemans.newresidence.command.base.BaseCommand;
import org.bukkit.entity.Player;

/*
 * Created by Lucemans at 06/05/2018
 * See https://lucemans.nl
 */
public class SetupCommand implements BaseCommand {

    private CreateCommand createCMD = new CreateCommand();

    public void execute(Player p, String[] args) {
        if (args.length == 1) {
            p.sendMessage("Please use one of the setup commands.");
            return;
        }

        if (args[1].equalsIgnoreCase("create")) {
            createCMD.execute(p, args);
            return;
        }
    }
}
