package nl.lucemans.newresidence.residence;

import nl.lucemans.newresidence.utils.SerializableLocation;

import java.io.Serializable;

/*
 * Created by Lucemans at 06/05/2018
 * See https://lucemans.nl
 */
public class ResidenceType implements Serializable{

    // SCHEMATIC NOT SUPPORTED YET
    public enum Type {
        SCHEMATIC, STRUCTURE
    }
    public enum State {
        SETUP, READY
    }

    public String name;
    public Type type = Type.STRUCTURE;
    public State state = State.SETUP;
    public SerializableLocation spawn;
    public SerializableLocation posMark;
    public SerializableLocation negMark;
}
