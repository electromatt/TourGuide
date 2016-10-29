package com.electromatt.tourguide;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.ArrayList;

public class ParksFragment extends Fragment {

    public ParksFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.attraction_list, container, false);

        final ArrayList<Attraction> attractions = new ArrayList<Attraction>();
        attractions.add(new Attraction(R.string.parks_manito, R.drawable.parks_manito));
        attractions.add(new Attraction(R.string.parks_mt_spokane, R.drawable.parks_mt_spokane));
        attractions.add(new Attraction(R.string.parks_riverfront, R.drawable.parks_riverfront));
        attractions.add(new Attraction(R.string.parks_riverside, R.drawable.parks_riverside));
        attractions.add(new Attraction(R.string.parks_spokane_falls, R.drawable.parks_spokane_falls));

        AttractionAdapter adapter = new AttractionAdapter(getActivity(), attractions, R.color.category_parks);

        ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Attraction word = attractions.get(position);
                Uri gmmIntentUri = Uri.parse(R.string.google_search+getString(word.getDefaultId())+R.string.city);
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
            }
        });

        return rootView;
    }
}