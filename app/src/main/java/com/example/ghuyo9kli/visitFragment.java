package com.example.ghuyo9kli;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link visitFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class visitFragment extends Fragment  {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    View _view;



    // TODO: Rename and change types of parameters
    private String mParam1;


    public visitFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment visitFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static visitFragment newInstance(String param1, String param2) {

        visitFragment fragment = new visitFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
        }
        //Manager.visited_places.add(mParam1);
        //TextView txt = _view.findViewById(R.id.name);
        //String str = txt.getText().toString();
        //_view.findViewById(R.id.visit).setOnClickListener(v->Manager.addPlace(str));

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_visit, container, false);
    }
}