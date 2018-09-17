package jasonbakthakumar.scribe;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by jasonbakthakumar on 09/12/16.
 */

public class HandlerFragment extends Fragment {

    public HandlerFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_handler, container, false);
        TabLayout tabLayout = (TabLayout) getActivity().findViewById(R.id.tabs);
        ViewPager viewPager = (ViewPager) rootView.findViewById(R.id.viewpager);
        HandlerViewPagerAdapter adapter = new HandlerViewPagerAdapter(getChildFragmentManager());
        adapter.addFragment(new SampleFragment(), "RECENT");
        adapter.addFragment(new ReContactsFragment(), "CONTACTS");
        viewPager.setAdapter(adapter);
        tabLayout.setVisibility(View.VISIBLE);
        tabLayout.setupWithViewPager(viewPager);


        return rootView;
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        List<Fragment> fragments = getChildFragmentManager().getFragments();
        if (fragments != null) {
            for (Fragment fragment : fragments) {
                fragment.onRequestPermissionsResult(requestCode, permissions, grantResults);
            }
        }
    }
}
