package atm.services;

import java.io.*;

public class PersistenceService<T extends Serializable> {

    public void save(T obj, File outFile) throws IOException {
        FileOutputStream f = new FileOutputStream(outFile);
        ObjectOutputStream o = new ObjectOutputStream(f);
        o.writeObject(obj);
        o.close();
        f.close();
    }

    public T load(Class<T> clazz, File file) throws Exception {
        try {
            FileInputStream fi = new FileInputStream(file);
            ObjectInputStream oi = new ObjectInputStream(fi);
            Object o = oi.readObject();
            oi.close();
            fi.close();
            return clazz.cast(o);
        } catch (IOException e) {
            return clazz.getConstructor().newInstance();
        }
    }
}
