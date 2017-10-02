package es.sources.code.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import code.source.es.sosc.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginOrRegisterFragment extends Fragment {


    public LoginOrRegisterFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login_or_register, container, false);
    }

}
