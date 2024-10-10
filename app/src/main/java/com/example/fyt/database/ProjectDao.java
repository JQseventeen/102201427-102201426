package com.example.fyt.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ProjectDao {
    @Insert
    void insertProject(Project project);

    @Query("SELECT * FROM Project WHERE id = :projectId")
    Project findById(long projectId);

    @Update
    void updateProject(Project project);

    @Delete
    void deleteProject(Project project);

    @Query("SELECT * FROM Project")
    List<Project> getAllProjects();

}