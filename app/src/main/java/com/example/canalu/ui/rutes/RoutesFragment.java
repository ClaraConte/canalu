package com.example.canalu.ui.rutes;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.canalu.R;
import com.example.canalu.ui.rutes.list.ListRoutesFragment;
import com.example.canalu.ui.rutes.maps.MapsRoutesFragment;
import com.google.android.material.tabs.TabLayout;

public class RoutesFragment extends Fragment {

    private RoutesViewModel mViewModel;

    private View fragment;
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private String list;
    private String maps;

    public static RoutesFragment newInstance() {
        return new RoutesFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,@Nullable Bundle savedInstanceState) {

        fragment = inflater.inflate(R.layout.fragment_routes, container, false);
        tabLayout = fragment.findViewById(R.id.tabs);

        viewPager = fragment.findViewById(R.id.viewPager);
        list =  getString(R.string.tab_title_list);
        maps = getString(R.string.tab_title_maps);
        return fragment;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        setUpViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.addOnTabSelectedListener(new TabLayout.BaseOnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        // TODO: Use the ViewModel
    }

    private void setUpViewPager(ViewPager viewPager) {

    AdapterFragment adapterFragment = new AdapterFragment(getChildFragmentManager());
    adapterFragment.addFragment(new ListRoutesFragment(),list);
    adapterFragment.addFragment(new MapsRoutesFragment(),maps);
    viewPager.setAdapter(adapterFragment);
    }

}
