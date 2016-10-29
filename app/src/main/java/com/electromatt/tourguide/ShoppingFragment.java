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

public class ShoppingFragment extends Fragment {

    public ShoppingFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.attraction_list, container, false);

        final ArrayList<Attraction> attractions = new ArrayList<Attraction>();
        attractions.add(new Attraction(R.string.shopping_valley_mall, R.raw.shopping_valley_mall));
        attractions.add(new Attraction(R.string.shopping_paradise_fibers, R.raw.shopping_paradise_fibers));
        attractions.add(new Attraction(R.string.shopping_river_park_square, R.raw.shopping_river_park_square));
        attractions.add(new Attraction(R.string.shopping_steamplant_square, R.raw.shopping_steamplant_square));
        attractions.add(new Attraction(R.string.shopping_aunties, R.raw.shopping_aunties));

        AttractionAdapter adapter = new AttractionAdapter(getActivity(), attractions, R.color.category_shopping);

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