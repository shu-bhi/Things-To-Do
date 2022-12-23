package com.example.thingstodo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.thingstodo.databinding.EachnoteBinding;
import com.example.thingstodo.myroomdata.ModelClass;

public class RVadpater extends ListAdapter<ModelClass,RVadpater.ViewHolder> {
   public  RVadpater(){
    super(CALLBACK);
   }

private static final DiffUtil.ItemCallback <ModelClass>CALLBACK=new DiffUtil.ItemCallback<ModelClass>() {
    @Override
    public boolean areItemsTheSame(@NonNull ModelClass oldItem, @NonNull ModelClass newItem) {
        return oldItem.getId()==newItem.getId();
    }

    @Override
    public boolean areContentsTheSame(@NonNull ModelClass oldItem, @NonNull ModelClass newItem) {
        return oldItem.getTitle().equals(newItem.getTitle()) &&
                oldItem.getDescriptions().equals(newItem.getDescriptions());
    }
};

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.eachnote,parent,false);
       return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ModelClass modelClass = getItem(position);
        holder.binding.textView.setText(modelClass.getTitle());
        holder.binding.textView2.setText(modelClass.getDescriptions());
    }

    public ModelClass getNote(int position){
       return  getItem(position);
    }
    public class  ViewHolder extends RecyclerView.ViewHolder{
      EachnoteBinding binding;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.binding =EachnoteBinding.bind(itemView);
        }
    }
}
