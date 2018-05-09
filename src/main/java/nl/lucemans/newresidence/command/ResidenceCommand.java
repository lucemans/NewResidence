package nl.lucemans.newresidence.command;

import nl.lucemans.newresidence.setup.LocationCommand;
import nl.lucemans.newresidence.setup.SetupCommand;
import nl.lucemans.newresidence.subcommands.InfoCommand;
import nl.lucemans.newresidence.subcommands.ListCommand;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/*
 * Created by Lucemans at 06/05/2018
 * See https://lucemans.nl
 */
public class ResidenceCommand implements CommandExecutor {

    private SetupCommand setupCMD = new SetupCommand();
    private ListCommand listCMD = new ListCommand();
    private InfoCommand infoCMD = new InfoCommand();

    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {
        if (args.length == 0){
            commandSender.sendMessage("Please perform /residence help");
            return true;
        }
        if (!(commandSender instanceof Player)){
            commandSender.sendMessage("Sorry, you need to be a player to perform these commands.");
            return true;
        }

        Player p = (Player) commandSender;
        if (args[0].equalsIgnoreCase("setup")) {
            setupCMD.execute(p, args);
            return true;
        }
        if (args[0].equalsIgnoreCase("list")) {
            listCMD.execute(p, args);
            return true;
        }
        if (args[0].equalsIgnoreCase("info")) {
            infoCMD.execute(p, args);
            return true;
        }
        commandSender.sendMessage("Please perform /residence help");

        return true;
    }

}
