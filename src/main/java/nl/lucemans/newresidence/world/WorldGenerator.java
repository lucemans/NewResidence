package nl.lucemans.newresidence.world;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.WorldType;

/*
 * Created by Lucemans at 06/05/2018
 * See https://lucemans.nl
 */
public class WorldGenerator {

    public static World createEmpty(String name) {
        WorldCreator wc = new WorldCreator(name);

        wc.type(WorldType.FLAT);
        wc.generatorSettings("2;0;1;");

        World w = wc.createWorld();

        return w;
    }

    public static String getNewWorldName(String user) {
        String name = "residence-" + user + "-" + Math.random();
        while (Bukkit.getWorld(name) != null) {
            name = "residence-" + user + "-" + Math.random();
        }
        return name;
    }
}
