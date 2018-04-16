package com.pointless;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.google.firebase.FirebaseApp;
import com.pointless.image;

import static android.Manifest.permission.RECORD_AUDIO;

public class AndroidLauncher extends AndroidApplication {
	ImageLoader imageLoader;
	ExerciseData exercise ;
	image imagestart ;

	AndroidApplicationConfiguration config;
	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		FirebaseApp.initializeApp(this);
		config = new AndroidApplicationConfiguration();
		RetroHandler urlHandler = new RetroHandler();
		imageLoader = new ImageLoader(this);
		imagestart = new image(imageLoader,urlHandler) ;
		initialize(imagestart, config);
	}
	@Override
	public void onRequestPermissionsResult(int requestCode, String permissions[],
										   int[] grantResults) {
		switch (requestCode) {

			case 1: {

				if (grantResults[0] == PackageManager.PERMISSION_DENIED) {

					if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
						if (shouldShowRequestPermissionRationale(RECORD_AUDIO)) {
							showMessageOKCancel("You need to allow access to this permissions",
									new DialogInterface.OnClickListener() {
										@Override
										public void onClick(DialogInterface dialog, int which) {
											if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
												requestPermissions(new String[]{RECORD_AUDIO},
														1);

											}
										}
									}, new DialogInterface.OnClickListener() {
										@Override
										public void onClick(DialogInterface dialogInterface, int i) {

										}
									});

						}
					}
				}

			}
		}
	}
	private void showMessageOKCancel(String message, DialogInterface.OnClickListener okListener, DialogInterface.OnClickListener cancelListener) {
		new AlertDialog.Builder(AndroidLauncher.this)
				.setMessage(message)
				.setPositiveButton("OK", okListener)
				.setNegativeButton("Cancel", cancelListener)
				.create()
				.show();
	}

	@Override
	public void onBackPressed() {

	}

}
