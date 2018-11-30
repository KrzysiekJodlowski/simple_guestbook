package com.codecool.dao;

import com.codecool.model.Entry;
import com.codecool.model.Guestbook;


public interface GuestbookDAO {

    Guestbook loadGuestbook();
    boolean addEntry(Entry entry);
    
}
