package nl.lucemans.newresidence.world;

import org.bukkit.Location;
import org.bukkit.block.Block;

/*
 * Created by Lucemans at 06/05/2018
 * See https://lucemans.nl
 */
public class WorldManipulator {

    public static void moveStructure(Location negMark, Location posMark, Location negMark2) {
        int x = 0;
        while (x <= posMark.getX() - negMark.getX())
        {
            int y = 0;
            while (y <= posMark.getY() - negMark.getY())
            {
                int z = 0;
                while (z <= posMark.getZ() - negMark.getZ())
                {
                    moveBlock(negMark.clone().add(x, y, z), negMark2.clone().add(x, y, z));
                    z++;
                }
                y++;
            }
            x++;
        }
    }

    public static void moveBlock(Location loc, Location loc2) {
        Block b = loc.getBlock();

        loc2.getBlock().setType(b.getType());
        loc2.getBlock().getState().setData(b.getState().getData());
    }
}
