package com.example.yohan.fragmentrecyclertest;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class PersonAdapter extends RecyclerView.Adapter <PersonAdapter.ViewHolder>{

    private ArrayList<Person> people;

    ItemClicked activity;

    public interface ItemClicked{

        void onItemClicked(int index);
        void dialNumber(int index);


    }

    public PersonAdapter(Context context, ArrayList<Person> list){

        people=list;
        activity = (ItemClicked) context;

    }

    public class ViewHolder extends  RecyclerView.ViewHolder{ //its decribes item view and metadata about its place witihin the RecyclerView.viewHolder belong to the adapter


        TextView tName;
        ImageView call;


        public ViewHolder(@NonNull final View itemView) {
            super(itemView);
           tName = itemView.findViewById(R.id.listName);
           call = itemView.findViewById(R.id.callid);



           itemView.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {

                   activity.onItemClicked(people.indexOf((Person)v.getTag()));

               }
           });

         call.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {

                   activity.dialNumber(people.indexOf((Person)v.getTag()));

               }
           });
        }
    }


    @NonNull
    @Override
    public PersonAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) { // when needs new Recyclerview.viewholder


        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_contact,viewGroup,false);
        return new ViewHolder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull PersonAdapter.ViewHolder viewHolder, int i) { //show data

        viewHolder.itemView.setTag(people.get(i));

        viewHolder.tName.setText(people.get(i).getName());



    }

    @Override
    public int getItemCount()
    {

        return people.size();
    }
}
