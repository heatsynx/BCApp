package com.example.bcapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BCAppAdapter extends RecyclerView.Adapter<BCAppAdapter.BCAppHolder> {

    List<Integer> numbers;
    Context context;

    Random rand = new Random();

    public BCAppAdapter(Context context) {
        numbers = new ArrayList<>();

        for(int i = 0;  i < 100; i++)
        {
            numbers.add(rand.nextInt(100));

            System.out.println(numbers);
        }
        this.context = context;
    }

    @NonNull
    @Override
    public BCAppHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View numberView = inflater.inflate(R.layout.number,parent,false);
        return new BCAppHolder(numberView);
    }

    @Override
    public void onBindViewHolder(@NonNull BCAppHolder holder, int position) {
        holder.bind(numbers.get(position));
    }

    @Override
    public int getItemCount() {
        return numbers.size();
    }

    class BCAppHolder extends RecyclerView.ViewHolder {
        TextView tvNumbers;

        public BCAppHolder(@NonNull View itemView) {
            super(itemView);
            tvNumbers = itemView.findViewById(R.id.tv_numbers);
        }

        public void bind(int item){
            String itemString =  Integer.toString(item);
            tvNumbers.setText(itemString);

        }
    }
}
