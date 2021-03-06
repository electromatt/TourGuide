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

public class SightsFragment extends Fragment {

    public SightsFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.attraction_list, container, false);

        final ArrayList<Attraction> attractions = new ArrayList<Attraction>();
        attractions.add(new Attraction(R.string.sights_downtown_spokane, R.drawable.sights_downtown_spokane));
        attractions.add(new Attraction(R.string.sights_gonzaga_university, R.drawable.sights_gonzaga_university));
        attractions.add(new Attraction(R.string.sights_greenbluff, R.drawable.sights_greenbluff));
        attractions.add(new Attraction(R.string.sights_st_johns_cathedral, R.drawable.sights_st_johns_cathedral));
        attractions.add(new Attraction(R.string.sights_steamplant_square, R.drawable.sights_steamplant_square));

        AttractionAdapter adapter = new AttractionAdapter(getActivity(), attractions, R.color.category_sights);

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