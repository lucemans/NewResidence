package nl.lucemans.newresidence.command.base;

import org.bukkit.entity.Player;

/*
 * Created by Lucemans at 06/05/2018
 * See https://lucemans.nl
 */
public interface BaseCommand {

    public void execute(Player p, String[] args);
}
