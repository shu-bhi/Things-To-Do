package com.example.thingstodo;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.thingstodo.myroomdata.ModelClass;

import java.util.List;

public class ViewModelClass extends AndroidViewModel {
    // Repository
    private NoteRepoClass repoClass;

    //LiveData
    private LiveData<List<ModelClass>> getList;

    public ViewModelClass(@NonNull Application application) {
        super(application);
        repoClass = new NoteRepoClass(application);
    }
    public  LiveData<List<ModelClass>> getGetList(){
        getList = repoClass.getModelclass();
        return getList;
    }


    public void addNewNote(ModelClass modelClass) {
       repoClass.insertClass(modelClass);
    }
    public void deleteNote(ModelClass modelClass){
        repoClass.deleteClass(modelClass);
    }
    public void updateNote(ModelClass modelClass){
        repoClass.updateClass(modelClass);
    }
}


