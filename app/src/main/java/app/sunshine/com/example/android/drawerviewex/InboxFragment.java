package app.sunshine.com.example.android.drawerviewex;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class InboxFragment extends Fragment {
    ListView listView;
    MessageAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View fragment = inflater.inflate(R.layout.inbox_fragment, container, false);


        listView = (ListView) fragment.findViewById(R.id.EmailsListView);
        adapter = new MessageAdapter(getActivity());
        listView.setAdapter(adapter);

    return fragment;
    }
    }
