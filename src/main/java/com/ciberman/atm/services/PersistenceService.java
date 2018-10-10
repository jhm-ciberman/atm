package com.ciberman.atm.services;

import java.io.*;

/**
 * Service for storing and loading serializable files
 *
 * @param <T> The serializable object type
 */
class PersistenceService<T extends Serializable> {

    /**
     * Saves a serializable object in a file
     *
     * @param obj     The serializable object to save
     * @param outFile The output file
     * @throws IOException Thrown if cannot write to the file
     */
    public void save(T obj, File outFile) throws IOException {
        File parent = outFile.getParentFile();
        if (!parent.exists() && parent.mkdirs()) {
            FileOutputStream f = new FileOutputStream(outFile);
            ObjectOutputStream o = new ObjectOutputStream(f);
            o.writeObject(obj);
            o.close();
            f.close();
        }
    }

    /**
     * Loads a serializable object from a file. If the file does not exists
     * or cannot be loaded, a new empty instance of the object is created.
     * @param clazz The class of the serializable object
     * @param file The file to load
     * @return The serializable object
     * @throws Exception Thrown if the object cannot be loaded
     */
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
