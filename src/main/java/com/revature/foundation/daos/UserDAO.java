package com.revature.foundation.daos;

import com.revature.foundation.models.AppUser;
import com.revature.foundation.util.ConnectionFactory;
import com.revature.foundation.util.exceptions.DataSourceException;
import com.revature.foundation.util.exceptions.ResourcePersistenceException;

import java.sql.*;

// TODO attempt to centralize exception handling in service layer
public class UserDAO implements CrudDAO<AppUser> {

    public AppUser findUserByUsername(String username) {

        AppUser user = null;

        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM ers_users WHERE user_name = ?");
            pstmt.setString(1, username);

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                user = new AppUser();
                user.setId(rs.getString("user_id"));
                user.setFirstName(rs.getString("given_name"));
                user.setLastName(rs.getString("surname"));
                user.setEmail(rs.getString("email"));
                user.setUsername(rs.getString("user_name"));
                user.setPassword(rs.getString("password"));
                // TODO fix AppUser to include role
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

    public AppUser findUserByEmail(String email) {

        AppUser user = null;

        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM ers_users WHERE email = ?");
            pstmt.setString(1, email);

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                user = new AppUser();
                user.setId(rs.getString("user_id"));
                user.setFirstName(rs.getString("given_name"));
                user.setLastName(rs.getString("surname"));
                user.setEmail(rs.getString("email"));
                user.setUsername(rs.getString("user_name"));
                user.setPassword(rs.getString("password"));
                // TODO fix AppUser to include role
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;

    }

    public AppUser findUserByUsernameAndPassword(String username, String password) {

        System.out.println("findUserByUsernameAndPassword was invoked!!!!!");

        AppUser authUser = null;

        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM ers_users WHERE user_name = ? AND password = ?");
            pstmt.setString(1, username);
            pstmt.setString(2, password);

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                authUser = new AppUser();
                authUser.setId(rs.getString("user_id"));
                authUser.setFirstName(rs.getString("given_name"));
                authUser.setLastName(rs.getString("surname"));
                authUser.setEmail(rs.getString("email"));
                authUser.setUsername(rs.getString("user_name"));
                authUser.setPassword(rs.getString("password"));
                // TODO fix AppUser to include role
            }

        } catch (SQLException e) {
            throw new DataSourceException(e);
        }

        return authUser;
    }

    @Override
    public void save(AppUser newUser) {

        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            conn.setAutoCommit(false);
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO ers_users(user_id,given_name,surname,email,user_name,password,role_id) VALUES (?, ?, ?, ?, ?, ?, ?)");
            pstmt.setString(1, newUser.getId());
            pstmt.setString(2, newUser.getFirstName());
            pstmt.setString(3, newUser.getLastName());
            pstmt.setString(4, newUser.getEmail());
            pstmt.setString(5, newUser.getUsername());
            pstmt.setString(6, newUser.getPassword());
            pstmt.setString(7, "7c3521f5-ff75-4e8a-9913-01d15ee4dc98"); // TODO fix with Role enum

            int rowsInserted = pstmt.executeUpdate();
            if (rowsInserted != 1) {
                conn.rollback();
                throw new ResourcePersistenceException("Failed to persist user to data source");
            }

            conn.commit();

        } catch (SQLException e) {
            throw new DataSourceException(e);
        }
    }

    @Override
    public AppUser getById(String id) {

        AppUser user = null;

        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM ers_users WHERE id = ?");
            pstmt.setString(1, id);

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                user = new AppUser();
                user.setId(rs.getString("user_id"));
                user.setFirstName(rs.getString("given_name"));
                user.setLastName(rs.getString("surname"));
                user.setEmail(rs.getString("email"));
                user.setUsername(rs.getString("user_name"));
                user.setPassword(rs.getString("password"));
                // TODO fix AppUser to include role
            }

        } catch (SQLException e) {
            throw new DataSourceException(e);
        }

        return user;

    }

    @Override // TODO this should probably return a dynamically size
    public AppUser[] getAll() {

        AppUser[] users;

        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            Statement getRecordCount = conn.createStatement();
            ResultSet countResult = getRecordCount.executeQuery("SELECT COUNT(*) FROM ers_users");
            countResult.next();
            int userCount = countResult.getInt("count");
            users = new AppUser[userCount];

            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM ers_users");
            for (int i = 0; i <= userCount; i++, rs.next()) {
                AppUser user = new AppUser();
                user.setId(rs.getString("user_id"));
                user.setFirstName(rs.getString("given_name"));
                user.setLastName(rs.getString("surname"));
                user.setEmail(rs.getString("email"));
                user.setUsername(rs.getString("user_name"));
                user.setPassword(rs.getString("password"));
                // TODO include role
                users[i] = user;
            }

        } catch (SQLException e) {
            throw new DataSourceException(e);
        }

        return users;
    }

    @Override
    public void update(AppUser updatedUser) {
        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            conn.setAutoCommit(false);
            PreparedStatement pstmt = conn.prepareStatement("UPDATE ers_users " +
                                                            "SET given_name = ?, " +
                                                                "surname = ?, " +
                                                                "email = ?, " +
                                                                "user_name = ?, " +
                                                                "password = ? " +
                                                            "WHERE user_id = ?");
            pstmt.setString(1, updatedUser.getFirstName());
            pstmt.setString(2, updatedUser.getLastName());
            pstmt.setString(3, updatedUser.getEmail());
            pstmt.setString(4, updatedUser.getUsername());
            pstmt.setString(5, updatedUser.getPassword());
            pstmt.setString(6, updatedUser.getId());

            // TODO allow role to be updated as well

            int rowsInserted = pstmt.executeUpdate();
            if (rowsInserted != 1) {
                throw new ResourcePersistenceException("Failed to update user data within datasource.");
            }

            conn.commit();

        } catch (SQLException e) {
            throw new DataSourceException(e);
        }
    }

    @Override
    public void deleteById(String id) {
        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            conn.setAutoCommit(false);
            PreparedStatement pstmt = conn.prepareStatement("DELETE FROM ers_users WHERE id = ?");
            pstmt.setString(1, id);

            int rowsInserted = pstmt.executeUpdate();
            if (rowsInserted != 1) {
                conn.rollback();
                throw new ResourcePersistenceException("Failed to delete user from data source");
            }

            conn.commit();

        } catch (SQLException e) {
            throw new DataSourceException(e);
        }
    }
}