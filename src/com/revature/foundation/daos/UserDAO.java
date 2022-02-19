package com.revature.foundation.daos;

import com.revature.foundation.models.AppUser;
import com.revature.foundation.util.exceptions.ResourcePersistenceException;

import java.io.*;

public class UserDAO implements CrudDAO<AppUser> {

    public AppUser findUserByUsername(String username) {
        return null;
    }

    public AppUser findUserByEmail(String email) {
        return null;
    }

    public AppUser findUserByUsernameAndPassword(String username, String password) {
        try {
            BufferedReader dataReader = new BufferedReader(new FileReader("data/users.txt"));
            String dataCursor;
            while ((dataCursor = dataReader.readLine()) != null) {
                String[] recordFragments = dataCursor.split(":");
                if (recordFragments[4].equals(username) && recordFragments[5].equals(password)) {
                    AppUser authUser = new AppUser();
                    authUser.setId(recordFragments[0]);
                    authUser.setFirstName(recordFragments[1]);
                    authUser.setLastName(recordFragments[2]);
                    authUser.setEmail(recordFragments[3]);
                    authUser.setUsername(recordFragments[4]);
                    authUser.setPassword(recordFragments[5]);
                    return authUser;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("An error occurred when accessing the data file.");
        }

        return null;

    }

    @Override
    public void save(AppUser newUser) {
        try {
            File usersDataFile = new File("data/users.txt");
            FileWriter dataWriter = new FileWriter(usersDataFile, true);
            dataWriter.write(newUser.toFileString() + "\n");
            dataWriter.close();
        } catch (IOException e) {
            throw new ResourcePersistenceException("An error occurred when accessing the data file.");
        }
    }

    @Override
    public AppUser getById(String id) {
        return null;
    }

    @Override
    public AppUser[] getAll() {
        return new AppUser[0];
    }

    @Override
    public void update(AppUser updatedObject) {

    }

    @Override
    public void deleteById(String id) {

    }
}
