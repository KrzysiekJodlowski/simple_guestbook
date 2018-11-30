package com.codecool.dao;

import com.codecool.model.Entry;
import com.codecool.model.Guestbook;


public class GuestbookDAOimpl implements GuestbookDAO {

    @Override
    public Guestbook loadGuestbook() {

        return new Guestbook();
    }

    @Override
    public boolean addEntry(Entry entry) {

        return false;
    }
}
