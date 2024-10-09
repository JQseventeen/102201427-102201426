package com.example.fyt.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ProjectDao {
    @Insert
    void insertProject(Project project);

    @Query("SELECT * FROM Project")
    List<Project> getAllProjects();
}