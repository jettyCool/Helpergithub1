package com.example.admin.helper.Fragments;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.admin.helper.R;
import com.example.admin.helper.VenderMyProfile;
import com.example.admin.helper.VendorActiNaviDrawer;

/**
 * A simple {@link Fragment} subclass.
 */
public class VendorProfile extends Fragment {

    TextView submit;

    public VendorProfile() {
        // Required empty public constructor

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

View v = inflater.inflate(R.layout.fragment_vendor_profile, container, false);

        submit=(TextView)v.findViewById(R.id.submit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent inn=new Intent(getActivity(),VenderMyProfile.class);
                startActivity(inn);

            }
        });


        return v;

    }





}
