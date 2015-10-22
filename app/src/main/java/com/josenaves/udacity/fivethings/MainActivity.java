package com.josenaves.udacity.fivethings;

import java.util.Locale;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import android.support.annotation.LayoutRes;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.FragmentPagerAdapter;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MainActivity extends FragmentActivity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide fragments for each
     * of the sections. We use a {@link FragmentPagerAdapter} derivative, which will keep
     * every loaded fragment in memory. If this becomes too memory intensive, it may be best to
     * switch to a {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(mSectionsPagerAdapter);
    }

     /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            // Show 5 total pages.
            return 5;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            Locale l = Locale.getDefault();
            switch (position) {
                case 0:
                    return getString(R.string.title_section1).toUpperCase(l);
                case 1:
                    return getString(R.string.title_section2).toUpperCase(l);
                case 2:
                    return getString(R.string.title_section3).toUpperCase(l);
                case 3:
                    return getString(R.string.title_section4).toUpperCase(l);
                case 4:
                    return getString(R.string.title_section5).toUpperCase(l);
            }
            return null;
        }
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        /**
         * Returns a new instance of this fragment for the given section number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {

            @LayoutRes
            int layout = R.layout.fragment_word_1;

            int color = R.color.red;

            Bundle args = getArguments();
            switch (args.getInt(ARG_SECTION_NUMBER)) {
                case 1:
                    layout = R.layout.fragment_word_1;
                    color = R.color.red;
                    break;

                case 2:
                    layout = R.layout.fragment_word_2;
                    color = R.color.blue;
                    break;

                case 3:
                    layout = R.layout.fragment_word_2;
                    color = R.color.green;
                    break;

                case 4:
                    layout = R.layout.fragment_word_2;
                    color = R.color.yellow;
                    break;

                case 5:
                    layout = R.layout.fragment_word_2;
                    color = R.color.purple;
            }
            View rootView = inflater.inflate(layout, container, false);
            TextView textView = (TextView)rootView.findViewById(R.id.section_label);
            textView.setText(Integer.toString(args.getInt(ARG_SECTION_NUMBER)));

            // seta a cor do fragment
            rootView.setBackgroundColor(getResources().getColor(color));

            return rootView;
        }
    }

    public void onClick(View view) {
        String url = "https://www.oicloud.com.br/#!/ajuda";
        Uri data = Uri.parse(url);
        startActivity(new Intent(Intent.ACTION_VIEW, data));
    }
}
