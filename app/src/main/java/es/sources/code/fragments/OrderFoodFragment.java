package es.sources.code.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import code.source.es.sosc.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class OrderFoodFragment extends Fragment {


    public OrderFoodFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_order_food, container, false);
        Bundle bundle = getArguments();
        String data = bundle.getString("main");
        TextView text = (TextView) view.findViewById(R.id.text_order_food);
        if(data != null){
            text.setText(data);
        }
        return view;
    }

}
