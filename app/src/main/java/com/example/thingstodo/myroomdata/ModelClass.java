package com.example.thingstodo.myroomdata;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import androidx.databinding.library.baseAdapters.BR;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "Note_Table")


  public class ModelClass extends BaseObservable {

    @PrimaryKey(autoGenerate = true)
    private int id ;

    @ColumnInfo(name = "title")
    private  String title;

    @ColumnInfo(name = "descriptions")
    private String descriptions;

    @Ignore
    public ModelClass() {
    }

    @Ignore
    public ModelClass(int id, String title, String descriptions) {
        this.id = id;
        this.title = title;
        this.descriptions = descriptions;
    }

    public ModelClass(String descriptions , String title) {
        this.descriptions = descriptions;
        this.title=title;
    }

    @Bindable
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    notifyPropertyChanged(BR.id);
    }
    @Bindable
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
        notifyPropertyChanged(BR.title);
    }
    @Bindable
    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
        notifyPropertyChanged(BR.descriptions);
    }
}
