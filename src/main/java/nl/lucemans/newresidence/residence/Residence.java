package nl.lucemans.newresidence.residence;

import nl.lucemans.newresidence.utils.SerializableLocation;

import java.io.Serializable;
import java.util.ArrayList;

/*
 * Created by Lucemans at 06/05/2018
 * See https://lucemans.nl
 */
public class Residence implements Serializable{

    public String owner; // UUID
    public ArrayList<String> members;
    public String residenceType; // ResidenceType
    public SerializableLocation negMark;
    public SerializableLocation posMark;
    public SerializableLocation spawn;

}
