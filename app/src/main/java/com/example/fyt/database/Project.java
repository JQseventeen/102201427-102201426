package com.example.fyt.database;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.Room;

@Entity
public class Project {
    @PrimaryKey(autoGenerate = true)
    public int id;

    public String name;
    public String members;
    public String description;
    public String imagePath; // 图片的 URI 路径
    public long lastModified; // 上次修改时间的时间戳
}
