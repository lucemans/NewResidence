package nl.lucemans.newresidence.registry;

import nl.lucemans.newresidence.NewResidence;
import nl.lucemans.newresidence.NewResidenceAPI;
import nl.lucemans.newresidence.residence.Residence;
import nl.lucemans.newresidence.residence.ResidenceType;

import java.io.*;
import java.util.ArrayList;

/*
 * Created by Lucemans at 06/05/2018
 * See https://lucemans.nl
 */
public class Registry {

    private File residenceFile;
    private File residenceTypeFile;

    public ArrayList<Residence> residences = new ArrayList<Residence>();
    public ArrayList<ResidenceType> residenceTypes = new ArrayList<ResidenceType>();

    public ResidenceType getResidenceTypeByName(String name) {
        for (ResidenceType res : residenceTypes) {
            if (res.name.equalsIgnoreCase(name))
                return res;
        }
        return null;
    }

    public void init(){
        residenceFile = new File(NewResidenceAPI.getInstance().getDataFolder(), "residences.dat");
        residenceTypeFile = new File(NewResidenceAPI.getInstance().getDataFolder(), "residencestypes.dat");
    }

    public void load(){
        init();
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
