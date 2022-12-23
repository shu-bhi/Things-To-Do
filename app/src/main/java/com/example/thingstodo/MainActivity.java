package com.example.thingstodo;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.thingstodo.databinding.ActivityMainBinding;
import com.example.thingstodo.myroomdata.ModelClass;

import java.util.List;

public class MainActivity extends AppCompatActivity {
     ActivityMainBinding binding;
     ViewModelClass viewModelClass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        binding= ActivityMainBinding.inflate(getLayoutInflater());
        //setContentView(binding.getroot());
        setContentView(binding.getRoot());
        viewModelClass = new  ViewModelProvider(this).get(ViewModelClass.class);

        binding.floatingActionButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,DataInsertActivity.class);
                intent.putExtra("type","addMode");

                startActivityForResult(intent,1);
            }
        });

       binding.Rv.setLayoutManager(new LinearLayoutManager(this));
       binding.Rv.setHasFixedSize(true);
       RVadpater rVadpater = new RVadpater();
       binding.Rv.setAdapter(rVadpater);

       viewModelClass.getGetList().observe(this, new Observer<List<ModelClass>>() {
           @Override
           public void onChanged(List<ModelClass> modelClasses) {
              rVadpater.submitList(modelClasses);
           }
       });

       new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT |ItemTouchHelper.RIGHT) {
           @Override
           public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
               return false;
           }

           @Override
           public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
               if (direction == ItemTouchHelper.RIGHT) {
                   viewModelClass.deleteNote(rVadpater.getNote(viewHolder.getAdapterPosition()));

           }else {

              Intent intent = new Intent(MainActivity.this,DataInsertActivity.class);
              intent.putExtra("type","update");
              intent.putExtra("title", rVadpater.getNote(viewHolder.getAdapterPosition()).getTitle());
              intent.putExtra("text", rVadpater.getNote(viewHolder.getAdapterPosition()).getDescriptions());
              intent.putExtra("id", rVadpater.getNote(viewHolder.getAdapterPosition()).getId());
              startActivityForResult(intent,2);
           }
       }
       }).attachToRecyclerView(binding.Rv);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1){
            String Title_ = data.getStringExtra("title");
            String Text_ = data.getStringExtra("text");
            ModelClass modelClass = new ModelClass(Text_,Title_);
            viewModelClass.addNewNote(modelClass);
            Toast.makeText(this, "Inserted", Toast.LENGTH_SHORT).show();
        }
        else if (requestCode == 2){
            String Title_ = data.getStringExtra("title");
            String Text_ = data.getStringExtra("text");
            ModelClass modelClass = new ModelClass(Text_,Title_);
            modelClass.setId(data.getIntExtra("id",0));
            viewModelClass.updateNote(modelClass);
            Toast.makeText(this, "Updated", Toast.LENGTH_SHORT).show();
        }

    }
}