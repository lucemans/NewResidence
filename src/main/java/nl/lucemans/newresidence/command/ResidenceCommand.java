package nl.lucemans.newresidence.command;

import nl.lucemans.newresidence.setup.SetupCommand;
import nl.lucemans.subcommands.ListCommand;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.util.ArrayList;
import java.util.Arrays;

/*
 * Created by Lucemans at 06/05/2018
 * See https://lucemans.nl
 */
public class ResidenceCommand implements CommandExecutor {

    private SetupCommand setupCMD = new SetupCommand();
    private ListCommand listCMD = new ListCommand();

    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {
        if (args.length == 0){
            commandSender.sendMessage("Please perform /residence help");
        }
        if (!(commandSender instanceof Player)){
            commandSender.sendMessage("Sorry, you need to be a player to perform these commands.");
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
        commandSender.sendMessage("Please perform /residence help");

        return true;
    }

}
