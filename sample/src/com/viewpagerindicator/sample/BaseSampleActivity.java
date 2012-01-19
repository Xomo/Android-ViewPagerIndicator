package com.viewpagerindicator.sample;

import java.util.Random;

import android.support.v4.view.Menu;
import android.support.v4.view.MenuItem;
import com.viewpagerindicator.PageIndicator;
import com.viewpagerindicator.sample.R;

import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.widget.Toast;

public abstract class BaseSampleActivity extends FragmentActivity {
	private static final Random RANDOM = new Random();
	
	TestFragmentAdapter mAdapter;
	ViewPager mPager;
	PageIndicator mIndicator;

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.menu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (item.getItemId() == R.id.random) {
				final int page = RANDOM.nextInt(mAdapter.getCount());
				Toast.makeText(this, "Changing to page " + page, Toast.LENGTH_SHORT);
				mPager.setCurrentItem(page);
				return true;
        } else if (item.getItemId() == R.id.add_page) {
				if (mAdapter.getCount() < 10) {
					mAdapter.setCount(mAdapter.getCount() + 1);
					mIndicator.notifyDataSetChanged();
				}
				return true;
        } else if (item.getItemId() == R.id.remove_page) {
				if (mAdapter.getCount() > 1) {
					mAdapter.setCount(mAdapter.getCount() - 1);
					mIndicator.notifyDataSetChanged();
				}
				return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
