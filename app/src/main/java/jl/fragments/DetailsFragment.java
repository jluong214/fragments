package jl.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;

public class DetailsFragment extends Fragment{
    // Create a DetailsFragment that contains details for the correct index
    public static DetailsFragment newInstance(int index) {
        DetailsFragment frag = new DetailsFragment();

        Bundle args = new Bundle();
        args.putInt("index", index);

        frag.setArguments(args);

        return frag;
    }

    public int getShownIndex() {

        return getArguments().getInt("index", 0);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ScrollView scroller = new ScrollView(getActivity());

        TextView text = new TextView(getActivity());

        int padding = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                4, getActivity().getResources().getDisplayMetrics());

        text.setPadding(padding, padding, padding, padding);

        scroller.addView(text);

        text.setText(Info.DATA[getShownIndex()]);
        return scroller;
    }
}
