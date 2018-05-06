package nl.lucemans.newresidence.utils;

import org.bukkit.Bukkit;
import org.bukkit.Location;

import java.io.Serializable;

/*
 * Created by Lucemans at 06/05/2018
 * See https://lucemans.nl
 */
public class SerializableLocation implements Serializable {

    public double x,y,z;
    public String world;

    public SerializableLocation(Location loc) {
        this.x = loc.getX();
        this.y = loc.getY();
        this.z = loc.getZ();
        this.world = loc.getWorld().getName();
    }

    public Location getLocation() {
        return new Location(Bukkit.getWorld(world), x, y, z);
    }
}
