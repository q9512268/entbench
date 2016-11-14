package com.danielkim.soundrecorder.activities;

import android.util.SparseArray;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.view.ViewGroup;
import android.content.BroadcastReceiver;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.astuetz.PagerSlidingTabStrip;
import com.danielkim.soundrecorder.R;
import com.danielkim.soundrecorder.fragments.FileViewerFragment;
import com.danielkim.soundrecorder.fragments.LicensesFragment;
import com.danielkim.soundrecorder.fragments.RecordFragment;

modes {saver <: managed; managed <: full; }

public class MainActivity extends ActionBarActivity{
    public static final String STOP_RECORD_INTENT = "com.danielkim.soundrecorder.activities.STOP_RECORD_INTENT";

    private static final String LOG_TAG = MainActivity.class.getSimpleName();

    private PagerSlidingTabStrip tabs;
    private ViewPager pager;

    private BroadcastReceiver receiver = new BroadcastReceiver() {
      @Override
      public void onReceive(Context context, Intent intent) {
        Intent nintent = new Intent(context, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);

        context.startActivity(nintent);
      }
    };

    @Override
    protected void onNewIntent(Intent intent) {
      System.err.format("ENT: onNewIntent!\n");
      RecordFragment frag = (RecordFragment) (((MyAdapter) pager.getAdapter()).getRegisteredFragment(0));
      frag.stopRecord();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        System.err.format("ENT: onCreate!\n");
        System.err.format("ENT: VM: %s\n", System.getProperty("java.vm.version"));

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pager = (ViewPager) findViewById(R.id.pager);
        pager.setAdapter(new MyAdapter(getSupportFragmentManager()));
        tabs = (PagerSlidingTabStrip) findViewById(R.id.tabs);
        tabs.setViewPager(pager);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setPopupTheme(R.style.ThemeOverlay_AppCompat_Light);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
        }
    }

    @Override
    protected void onResume() {
      super.onResume();
      this.registerReceiver(receiver, new IntentFilter(MainActivity.STOP_RECORD_INTENT));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        // Handle presses on the action bar items
        switch (item.getItemId()) {
            case R.id.action_licenses:
                openLicenses();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void openLicenses(){
        LicensesFragment licensesFragment = new LicensesFragment();
        licensesFragment.show(getSupportFragmentManager().beginTransaction(), "dialog_licenses");
    }

    public class MyAdapter extends FragmentPagerAdapter {
        SparseArray<Fragment> registeredFragments = new SparseArray<Fragment>();

        private String[] titles = { getString(R.string.tab_title_record),
                getString(R.string.tab_title_saved_recordings) };

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch(position){
                case 0:{
                    return RecordFragment.newInstance(position);
                }
                case 1:{
                    return FileViewerFragment.newInstance(position);
                }
            }
            return null;
        }

        @Override
        public int getCount() {
            return titles.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titles[position];
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
          Fragment fragment = (Fragment) super.instantiateItem(container, position);
          registeredFragments.put(position, fragment);
          return fragment;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
          registeredFragments.remove(position);
          super.destroyItem(container, position, object);
        }

        public Fragment getRegisteredFragment(int position) {
          return registeredFragments.get(position);
        }
    }

    public MainActivity() {
    }
}
