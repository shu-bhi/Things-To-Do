package com.example.thingstodo.myroomdata;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface DAOclass {
    @Insert
    public void Insert(ModelClass modelClass);
    @Update
    public void Update(ModelClass modelClass);
    @Delete
    public void Delete(ModelClass modelClass);
    @Query("SELECT * FROM Note_Table")
    public LiveData<List<ModelClass>>GetAllList();
}
