package com.example.payone.room.database.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.payone.room.database.entity.Lead;

import java.util.List;


@Dao
public interface LeadDao {

    @Query("SELECT * FROM leadData")
    List<Lead> gelAll();

    @Query("SELECT * FROM leadData WHERE uid = :uid")
    Lead getSingle(String uid);

    @Insert
    void insertSingle(Lead lead);

}
