package nl.lucemans.newresidence;

import nl.lucemans.newresidence.residence.Residence;
import nl.lucemans.newresidence.residence.ResidenceType;
import nl.lucemans.newresidence.utils.SerializableLocation;
import nl.lucemans.newresidence.world.WorldGenerator;
import nl.lucemans.newresidence.world.WorldManipulator;
import org.bukkit.Location;
import org.bukkit.World;

/*
 * Created by Lucemans at 06/05/2018
 * See https://lucemans.nl
 */
public class NewResidenceAPI {

    protected static NewResidence instance;

    public static NewResidence getInstance() {
        return instance;
    }

    public static Residence createResidence(ResidenceType type, String owner) {

        // Create the residence
        Residence r = new Residence();
        r.owner = owner;
        r.residenceType = type.name;

        // Generates a new world
        World w = WorldGenerator.createEmpty(WorldGenerator.getNewWorldName(owner));

        // Move the structure
        WorldManipulator.moveStructure(type.negMark.getLocation(), type.posMark.getLocation(), w.getSpawnLocation());

        r.negMark = new SerializableLocation(w.getSpawnLocation());
        Location posDiff = type.posMark.getLocation().subtract(type.negMark.getLocation());
        r.posMark = new SerializableLocation(w.getSpawnLocation().clone().add(posDiff.getX(), posDiff.getY(), posDiff.getZ()));
        r.spawn = new SerializableLocation(w.getSpawnLocation().clone().add(type.spawn.x, type.spawn.y, type.spawn.z));

        return r;
    }
}
