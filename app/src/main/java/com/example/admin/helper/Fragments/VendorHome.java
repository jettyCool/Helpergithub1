package com.example.admin.helper.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.admin.helper.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class VendorHome extends Fragment {

    TextView free;

    public VendorHome() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_vendor_home, container, false);

        free=v.findViewById(R.id.free);

        free.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Vendorhomefree detailsFragment = new Vendorhomefree();
                android.support.v4.app.FragmentManager fragmentManager = getFragmentManager();
                android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fram,detailsFragment);
                fragmentTransaction.commit();

            }
        });

    return  v;
    }

}
