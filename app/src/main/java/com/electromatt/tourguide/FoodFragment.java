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


public class FoodFragment extends Fragment {

    public FoodFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.attraction_list, container, false);

        // Create a list of words
        final ArrayList<Attraction> attractions = new ArrayList<Attraction>();
        attractions.add(new Attraction(R.string.food_anthonys, R.raw.food_anthonys));
        attractions.add(new Attraction(R.string.food_clinkerdagger, R.raw.food_clinkerdagger));
        attractions.add(new Attraction(R.string.food_flying_goat, R.raw.food_flying_goat));
        attractions.add(new Attraction(R.string.food_manito_taphouse, R.raw.food_manito_taphouse));
        attractions.add(new Attraction(R.string.food_wildsage, R.raw.food_wildsage));

        AttractionAdapter adapter = new AttractionAdapter(getActivity(), attractions, R.color.category_food);
        ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Attraction word = attractions.get(position);
                Uri gmmIntentUri = Uri.parse("geo:0,0?q="+getString(word.getDefaultId())+" Spokane, WA");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
            }
        });

        return rootView;
    }
}