package nl.lucemans.newresidence.registry;

import nl.lucemans.newresidence.residence.Residence;
import nl.lucemans.newresidence.residence.ResidenceType;

import java.io.*;
import java.util.ArrayList;

/*
 * Created by Lucemans at 06/05/2018
 * See https://lucemans.nl
 */
public class Registry {

    private File residenceFile = new File("/plugins/NewResidence/residences.dat");
    private File residenceTypeFile = new File("/plugins/NewResidence/residencetypes.dat");

    public ArrayList<Residence> residences;
    public ArrayList<ResidenceType> residenceTypes;

    public ResidenceType getResidenceTypeByName(String name) {
        for (ResidenceType res : residenceTypes) {
            if (res.name.equalsIgnoreCase(name))
                return res;
        }
        return null;
    }

    public void load(){
        if (residenceTypeFile.exists()) {
            try {
                FileInputStream fis = new FileInputStream(residenceTypeFile);
                ObjectInputStream ois = new ObjectInputStream(fis);
                residenceTypes = (ArrayList<ResidenceType>)ois.readObject();
            }catch(Exception e) {
                e.printStackTrace();
            }
        }
        if(residenceFile.exists()){
            try{
                FileInputStream fis = new FileInputStream(residenceFile);
                ObjectInputStream ois = new ObjectInputStream(fis);
                residences = (ArrayList<Residence>)ois.readObject();
                ois.close();
                fis.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    public void save(){
        save(residenceFile, residences);
        save(residenceTypeFile, residenceTypes);
    }

    private void save(File f, ArrayList<?> objects) {
        try{
            if(f.exists())
                f.delete();
            FileOutputStream fos = new FileOutputStream(f);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(objects);
            oos.flush();
            fos.flush();
            oos.close();
            fos.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
