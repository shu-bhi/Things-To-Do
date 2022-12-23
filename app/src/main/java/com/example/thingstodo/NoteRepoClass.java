package com.example.thingstodo;

import android.app.Application;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;

import androidx.lifecycle.LiveData;

import com.example.thingstodo.myroomdata.DAOclass;
import com.example.thingstodo.myroomdata.DataBaseClass;
import com.example.thingstodo.myroomdata.ModelClass;

import java.nio.channels.AsynchronousChannelGroup;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NoteRepoClass {
    private DAOclass dAOclass;
    private LiveData<List<ModelClass>> modelclass;
    public NoteRepoClass(Application application){
        DataBaseClass dataBaseClass = DataBaseClass.getInstance(application);
        dAOclass=dataBaseClass.daoClass();
        modelclass=dAOclass.GetAllList();
    }

    public LiveData<List<ModelClass>> getModelclass() {
        return dAOclass.GetAllList();
    }

   public void  insertClass(ModelClass modelClass){
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.getMainLooper());
        executor.execute(new Runnable() {
            @Override
            public void run() {
                //Inserting Notes
                dAOclass.Insert(modelClass);
            }
        });
    }

    public void  deleteClass(ModelClass modelClass){
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.getMainLooper());
        executor.execute(new Runnable() {
            @Override
            public void run() {
                //Inserting Notes
                dAOclass.Delete(modelClass);
            }
        });
    }

    public void  updateClass(ModelClass modelClass){
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.getMainLooper());
        executor.execute(new Runnable() {
            @Override
            public void run() {
                //Inserting Notes
                dAOclass.Update(modelClass);
            }
        });
    }

}
