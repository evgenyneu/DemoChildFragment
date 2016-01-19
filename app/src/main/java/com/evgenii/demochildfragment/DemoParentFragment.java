package com.evgenii.demochildfragment;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class DemoParentFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_parent, container, false);
    }

    @Override
    public void onResume() {
        super.onResume();

        TextView textView = (TextView)getActivity().findViewById(R.id.parent_text_view);

        // getChildFragmentManager().findFragmentById works in Android API Level 21 newer.
        // Does NOT work in Android API level 19 and older.
        // Why?
        // -----------

        Fragment fragment = getChildFragmentManager().findFragmentById(R.id.child);

        String errorMessage = "Parent fragment.\nError getting child fragment with getChildFragmentManager.";

        if (fragment == null) {
            textView.setText(errorMessage);
        }

        // getFragmentManager().findFragmentById works in Android API Level 19 and older.
        // Can be used a workaround.
        // -----------

        fragment = getActivity().getFragmentManager().findFragmentById(R.id.child);

        if (fragment != null) {
            textView.setText(errorMessage + "\nWorks with getFragmentManager.");
        }
    }
}
