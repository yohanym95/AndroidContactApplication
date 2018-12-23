package com.example.yohan.fragmentrecyclertest;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TabHost;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListFrag extends Fragment  {

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    View view;



    public ListFrag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        view = inflater.inflate(R.layout.fragment_list, container, false);
        return  view;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        recyclerView = view.findViewById(R.id.list_recycle);
        recyclerView.setHasFixedSize(true);
//set the recycleview layout into fragment
        layoutManager = new LinearLayoutManager(this.getActivity());
        recyclerView.setLayoutManager(layoutManager);

        adapter = new PersonAdapter(this.getActivity(),ApplicationClass.people);
        recyclerView.setAdapter(adapter);



    }
    public void notifyDataChanged(){
        adapter.notifyDataSetChanged();
    }
}
