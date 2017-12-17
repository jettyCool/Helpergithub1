package com.example.admin.helper.Fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.TextView;

import com.example.admin.helper.CustomGridAdapter;
import com.example.admin.helper.DataProvider;
import com.example.admin.helper.R;
import com.example.admin.helper.RecviewAdapter;
import com.example.admin.helper.SecRecDownprovider;
import com.example.admin.helper.SecondDownAdapter;
import com.example.admin.helper.VendorActiNaviDrawer;
import com.example.admin.helper.ViewPagerAdapter;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

/**
 * A simple {@link Fragment} subclass.
 */
public class UserHome extends Fragment {

    GridView grid;
    Context context;
    View v;

    EditText sersearch;

    //Slider Code
    ViewPager viewPager;
    ViewPagerAdapter viewPagerAdapter;

    RecyclerView recyclerView;
    RecviewAdapter adapter;
    RecyclerView.LayoutManager layoutManager;

    RecyclerView recyclerView2;
    SecondDownAdapter adapter2;
    RecyclerView.LayoutManager layoutManager2;

    String[] S_name;
    String[] DL_name;

    int [] Img_res={R.drawable.pc,R.drawable.wp,R.drawable.es,R.drawable.pc,
            R.drawable.ac,R.drawable.pc,R.drawable.wp,R.drawable.es,R.drawable.pc,R.drawable.ac};

    ArrayList<DataProvider> arrayList=new ArrayList<>();
    ArrayList<SecRecDownprovider> arrayList2=new ArrayList<>();

    TextView tseeall;


    public UserHome() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_user_home, container, false);

        tseeall=v.findViewById(R.id.tseeall);
        //GridView Code
        context=getContext();

        sersearch=(EditText)v.findViewById(R.id.sersearch);

        grid=(GridView)v.findViewById(R.id.gridview);
        CustomGridAdapter cd=new CustomGridAdapter(context);

        grid.setAdapter(cd);
        //Slider Code
        viewPager=v.findViewById(R.id.view_pager);
        viewPagerAdapter=new ViewPagerAdapter(context);
        viewPager.setAdapter(viewPagerAdapter);


        //


        InputMethodManager imm = (InputMethodManager)getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(sersearch.getWindowToken(),
                InputMethodManager.RESULT_UNCHANGED_SHOWN);


        //

        recyclerView=v.findViewById(R.id.recyclerview);
        S_name=getResources().getStringArray(R.array.s_name);

        int i=0;

        for(String name: S_name){

            DataProvider dataProvider=new DataProvider(Img_res[i],name);
            arrayList.add(dataProvider);
            i++;
        }
        adapter=new RecviewAdapter(arrayList);
        recyclerView.setHasFixedSize(true);
        layoutManager=new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        //-----------------

        recyclerView2=(RecyclerView)v. findViewById(R.id.r2);
        DL_name=getResources().getStringArray(R.array.dl_name);

        int j=0;

        for(String names: DL_name){

            SecRecDownprovider secRecDownprovider=new SecRecDownprovider(Img_res[j],names);
            arrayList2.add(secRecDownprovider);
            j++;
        }

        //------------------

        adapter2=new SecondDownAdapter(arrayList2);
        recyclerView2.setHasFixedSize(true);
        layoutManager2=new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
        recyclerView2.setLayoutManager(layoutManager2);
        recyclerView2.setAdapter(adapter2);


        tseeall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent inn=new Intent(getActivity(),VendorActiNaviDrawer.class);
                startActivity(inn);

            }
        });


        return v;

    }

    //on create ends here

}
