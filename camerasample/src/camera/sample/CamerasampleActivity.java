package camera.sample;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.hardware.Camera.PictureCallback;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;

public class CamerasampleActivity extends Activity {
	static Bitmap temp;
	static int nnn = 0;
	private static final String TAG = "Activity";
	private static final int MENU_ID_MENU1 = 0;
	private boolean visible = true;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	 
        super.onCreate(savedInstanceState);
        
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        
        
        LinearLayout l = new LinearLayout(this);
        //sdlog.put("hogehoge");
        l.addView(new SampleView(this));
        setContentView(l);


}}
	   


