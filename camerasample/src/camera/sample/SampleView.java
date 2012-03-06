package camera.sample;

import java.io.IOException;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.hardware.Camera;
import android.hardware.Camera.PictureCallback;
import android.provider.MediaStore;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;

//SurfaceView�쐬
public class SampleView extends SurfaceView implements Callback ,PictureCallback {
	static int count = 0;
	static Camera camera;
	Bitmap aaa;
	int rx=0;
	String heyaban =":7:";
	
	public SampleView(Context context) {
		super(context);
		SurfaceHolder holder = getHolder();
		holder.addCallback(this);
		holder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
	}

	public void surfaceCreated(SurfaceHolder holder) {
		try {
			camera = Camera.open();
			camera.setPreviewDisplay(holder);
		} catch(IOException e) {
		}
		
	}

	public void surfaceChanged(SurfaceHolder holder, int f, int w, int h) {
		Camera.Parameters p = camera.getParameters();
		camera.startPreview();
	}

	public void surfaceDestroyed(SurfaceHolder holder) {
		camera.setPreviewCallback(null); 
		camera.stopPreview();
		camera.release();
		camera = null; 
	}

//�B�e�㏈��
	public void onPictureTaken(byte[] data, Camera c)  {
		Bitmap bmp = BitmapFactory.decodeByteArray(data, 0, data.length, null);
		MediaStore.Images.Media.insertImage(getContext().getContentResolver(), bmp, "", null);
		camera.startPreview();
	}

//�^�b�`�����Ƃ��̏���
	@Override
	public boolean onTouchEvent(MotionEvent me) {
		if(me.getAction()==MotionEvent.ACTION_DOWN) {
			//xperia�̂�
			autoFocus();
			camera.takePicture(null,null,this);
		}
		return true;
	}
	
//�I�[�g�t�H�[�J�X
	public void autoFocus(){
	    if( camera != null ){
	    	camera.autoFocus( new Camera.AutoFocusCallback() {
	    		public void onAutoFocus( boolean success, Camera camera ){
	    			camera.autoFocus( null );	
	    				
	    		}
	    	} );
	    }
	}
	
	
	        
	
	
	    }


	
	
