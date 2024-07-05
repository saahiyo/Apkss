package com.my.apk.list;

import com.my.apk.list.SplashActivity;
import android.animation.*;
import android.app.*;
import android.content.*;
import android.content.res.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.media.*;
import android.net.*;
import android.os.*;
import android.text.*;
import android.text.style.*;
import android.util.*;
import android.view.*;
import android.view.View;
import android.view.View.*;
import android.view.animation.*;
import android.webkit.*;
import android.widget.*;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import arabware.file.*;
import com.google.android.material.chip.*;
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.*;
import org.json.*;
import androidx.core.content.ContextCompat;
import com.google.android.material.chip.ChipGroup;
import com.google.android.material.chip.Chip;

public class MainActivity extends AppCompatActivity {
	
	private boolean systemApp = false;
	private String uri = "";
	private double pi = 0;
	private String app = "";
	private String finalpath = "";
	private boolean isUserApp = false;
	
	private ArrayList<HashMap<String, Object>> appList = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> data = new ArrayList<>();
	
	private LinearLayout toolbar;
	private ChipGroup linear37;
	private LinearLayout linear40;
	private TextView title;
	private ImageView menu;
	private Chip linear38;
	private Chip linear39;
	private ListView listview1;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.main);
		initialize(_savedInstanceState);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		toolbar = findViewById(R.id.toolbar);
		linear37 = findViewById(R.id.linear37);
		linear40 = findViewById(R.id.linear40);
		title = findViewById(R.id.title);
		menu = findViewById(R.id.menu);
		linear38 = findViewById(R.id.linear38);
		linear39 = findViewById(R.id.linear39);
		listview1 = findViewById(R.id.listview1);
		
		menu.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_PopUpMenu(menu);
			}
		});
		
		linear38.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				isUserApp = true;
				systemApp = false;
				_show_app(isUserApp);
			}
		});
		
		linear39.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				isUserApp = false;
				systemApp = true;
				_show_app(isUserApp);
			}
		});
		
		listview1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> _param1, View _param2, int _param3, long _param4) {
				final int _position = _param3;
				SketchwareUtil.showMessage(getApplicationContext(), name_list.get((int)(_position)));
			}
		});
		
		listview1.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
			@Override
			public boolean onItemLongClick(AdapterView<?> _param1, View _param2, int _param3, long _param4) {
				final int _position = _param3;
				_extractApk(package_list.get((int)(_position)), name_list.get((int)(_position)));
				return true;
			}
		});
	}
	
	private void initializeLogic() {
		if (Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT) {
			Window w =MainActivity.this.getWindow();
			w.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
			w.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS); w.setStatusBarColor(0xFF651FFF);
		}
		linear38.performClick();
		Resources res = this.getResources();
		final ImageView image = (ImageView) findViewById(R.id.menu);
		final int newColor = ContextCompat.getColor(this, R.color.colorAccent);
		image.setColorFilter(newColor, PorterDuff.Mode.SRC_ATOP);
	}
	
	public void _extra() {
	}
	private ArrayList<String> name_list = new ArrayList<>();
	private ArrayList<String> package_list = new ArrayList<>();
	private ArrayList<String> version_list = new ArrayList<>();
	private ArrayList<String> versionCode_list = new ArrayList<>();
	private ArrayList < HashMap < String, android.graphics.drawable.Drawable> > icon_list = new ArrayList<>(); 
	private String applistData ="Allinstallapp";
	private void nothing(){
	}
	
	
	public void _extractApk(final String _package_n, final String _name) {
		String uri = _package_n;
		android.content.pm.PackageManager pm = this.getPackageManager();
		
		try {
			    // Get the package info of the app
			    android.content.pm.PackageInfo pi = pm.getPackageInfo(uri, android.content.pm.PackageManager.GET_ACTIVITIES);
			    
			    // Get the path of the APK file
			    String app = pi.applicationInfo.publicSourceDir;
			    
			    // Define the path where the APK file will be saved
			    String finalpath = "/storage/emulated/0/Apkss/".concat(_name.concat(".apk"));
			    
			    // Ensure the directory exists before copying the file
			    File directory = new File("/storage/emulated/0/Apkss/");
			    if (!directory.exists()) {
				        directory.mkdirs();
				    }
			    
			    // Copy the APK file to the specified location
			    FileUtil.copyFile(app, finalpath);
			    
			    // Show a message to the user indicating the save location
			    SketchwareUtil.showMessage(this, "Saved to: \n" + finalpath);
		} catch (android.content.pm.PackageManager.NameNotFoundException e) {
			    // Show an error message if the package is not found
			    SketchwareUtil.showMessage(this, "Error: " + e.getMessage());
		}
	}
	
	
	public void _PopUpMenu(final View _view) {
		View popup = getLayoutInflater().inflate(R.layout.popup_menu, null);
		final PopupWindow pop_up = new PopupWindow(popup, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);
		final LinearLayout bg = popup.findViewById(R.id.bg);
		//bg [ Easy Layout Design ]
		int[] EGKDFB = { (0xFFFFFFFF), (0xFFFFFFFF) };
		GradientDrawable KDFB = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, EGKDFB);
		KDFB.setCornerRadii(new float[]{(int)14,(int)14,(int)14,(int)14,(int)14,(int)14,(int)14,(int)14});
		KDFB.setStroke((int) 2, (0xffbf00ff));
		bg.setElevation((float) 29);
		bg.setBackground(KDFB);
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
			bg.setOutlineAmbientShadowColor(0xffbf00ff);
			bg.setOutlineSpotShadowColor(0xffbf00ff); }
		bg.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)15, 0xFFFFFFFF));
		pop_up.showAsDropDown(_view, 0,0);
	}
	
	
	public void _show_app(final boolean _isUserApp) {
		    icon_list.clear();
		    name_list.clear();
		    version_list.clear();
		    package_list.clear();
		    versionCode_list.clear();
		    data.clear();
		    
		    for (android.content.pm.PackageInfo packageInfo : getApplicationContext().getPackageManager().getInstalledPackages(0)) {
			        if (isUserApp && (packageInfo.applicationInfo.flags & android.content.pm.ApplicationInfo.FLAG_SYSTEM) == 0 ||
			            !isUserApp && (packageInfo.applicationInfo.flags & android.content.pm.ApplicationInfo.FLAG_SYSTEM) != 0) {
				            
				            name_list.add(packageInfo.applicationInfo.loadLabel(getPackageManager()).toString());
				            package_list.add(packageInfo.packageName);
				            version_list.add(packageInfo.versionName);
				            versionCode_list.add(String.valueOf(packageInfo.versionCode));
				            
				            HashMap<String, Object> item = new HashMap<>();
				            item.put("key", "items");
				            data.add(item);
				            
				            HashMap<String, android.graphics.drawable.Drawable> iconItem = new HashMap<>();
				            iconItem.put("icon_path", packageInfo.applicationInfo.loadIcon(getPackageManager()));
				            icon_list.add(iconItem);
				        }
			    }
		    listview1.setAdapter(new Listview1Adapter(data));
		    ((BaseAdapter) listview1.getAdapter()).notifyDataSetChanged();
	}
	
	public class Listview1Adapter extends BaseAdapter {
		
		ArrayList<HashMap<String, Object>> _data;
		
		public Listview1Adapter(ArrayList<HashMap<String, Object>> _arr) {
			_data = _arr;
		}
		
		@Override
		public int getCount() {
			return _data.size();
		}
		
		@Override
		public HashMap<String, Object> getItem(int _index) {
			return _data.get(_index);
		}
		
		@Override
		public long getItemId(int _index) {
			return _index;
		}
		
		@Override
		public View getView(final int _position, View _v, ViewGroup _container) {
			LayoutInflater _inflater = getLayoutInflater();
			View _view = _v;
			if (_view == null) {
				_view = _inflater.inflate(R.layout.list_item, null);
			}
			
			final LinearLayout bg1 = _view.findViewById(R.id.bg1);
			final LinearLayout linear10 = _view.findViewById(R.id.linear10);
			final LinearLayout linear12 = _view.findViewById(R.id.linear12);
			final LinearLayout card = _view.findViewById(R.id.card);
			final ImageView app_icon = _view.findViewById(R.id.app_icon);
			final TextView app_name = _view.findViewById(R.id.app_name);
			final TextView app_version = _view.findViewById(R.id.app_version);
			
			//bg1 [ Easy Layout Design ]
			int[] EGDQCH = { (0xFFFFFFFF), (0xFFFFFFFF) };
			GradientDrawable DQCH = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, EGDQCH);
			DQCH.setCornerRadii(new float[]{(int)19,(int)19,(int)19,(int)19,(int)19,(int)19,(int)19,(int)19});
			DQCH.setStroke((int) 0, (0xFF000000));
			bg1.setElevation((float) 12);
			bg1.setBackground(DQCH);
			if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
				bg1.setOutlineAmbientShadowColor(0xffbf00ff);
				bg1.setOutlineSpotShadowColor(0xffbf00ff); }
			app_icon.setImageDrawable(icon_list.get((int)_position).get("icon_path"));
			app_name.setText(name_list.get((int)(_position)));
			app_version.setText(version_list.get((int)(_position)));
			
			return _view;
		}
	}
	
	@Deprecated
	public void showMessage(String _s) {
		Toast.makeText(getApplicationContext(), _s, Toast.LENGTH_SHORT).show();
	}
	
	@Deprecated
	public int getLocationX(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[0];
	}
	
	@Deprecated
	public int getLocationY(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[1];
	}
	
	@Deprecated
	public int getRandom(int _min, int _max) {
		Random random = new Random();
		return random.nextInt(_max - _min + 1) + _min;
	}
	
	@Deprecated
	public ArrayList<Double> getCheckedItemPositionsToArray(ListView _list) {
		ArrayList<Double> _result = new ArrayList<Double>();
		SparseBooleanArray _arr = _list.getCheckedItemPositions();
		for (int _iIdx = 0; _iIdx < _arr.size(); _iIdx++) {
			if (_arr.valueAt(_iIdx))
			_result.add((double)_arr.keyAt(_iIdx));
		}
		return _result;
	}
	
	@Deprecated
	public float getDip(int _input) {
		return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, _input, getResources().getDisplayMetrics());
	}
	
	@Deprecated
	public int getDisplayWidthPixels() {
		return getResources().getDisplayMetrics().widthPixels;
	}
	
	@Deprecated
	public int getDisplayHeightPixels() {
		return getResources().getDisplayMetrics().heightPixels;
	}
}