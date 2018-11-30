package com.codecool.dao;

import com.codecool.model.Entry;
import com.codecool.model.Guestbook;

import java.sql.*;
import java.text.DateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;


public class GuestbookDAOimpl implements GuestbookDAO {

    public GuestbookDAOimpl() {}

    @Override
    public Guestbook loadGuestbook() {

        Guestbook guestbook = new Guestbook();
        String query = "SELECT * FROM guestbook";

        try {
            Connection connection = new DBCPDataSource().getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                guestbook.addEntry(getEntry(resultSet));
            }

            statement.close();
            connection.close();
            resultSet.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return guestbook;
    }

    @Override
    public boolean addEntry(Entry entry) {

        return false;
    }

    private Entry getEntry(ResultSet resultSet) throws SQLException {
        String content = resultSet.getString("content");
        String name = resultSet.getString("name");
        long date = resultSet.getDate("date_time").getTime();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(date), ZoneId.systemDefault());

        return new Entry(content, name, localDateTime);
    }

}
