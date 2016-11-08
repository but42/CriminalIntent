package com.but42.criminalintent;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;

import java.io.File;

/**
 * Created by but on 08.11.2016.
 */
public class LargeImageDialog extends DialogFragment {
    private static final String ARG_STRING = "mPhotoFile";
    private ImageView mPhotoView;
    private File mPhotoFile;

    public static LargeImageDialog newInstance(File path) {
        Bundle args = new Bundle();
        args.putSerializable(ARG_STRING, path);
        LargeImageDialog fragment = new LargeImageDialog();
        fragment.setArguments(args);
        return fragment;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        mPhotoFile = (File) getArguments().getSerializable(ARG_STRING);
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_large_image, null);
        mPhotoView = (ImageView) view.findViewById(R.id.large_image_view);
        ViewTreeObserver observer = mPhotoView.getViewTreeObserver();
        observer.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                if (mPhotoFile == null || !mPhotoFile.exists()) {
                    mPhotoView.setImageDrawable(null);
                } else {
                    Bitmap bitmap = PictureUtils.getScaledBitmap(mPhotoFile.getPath(), mPhotoView.getWidth(), mPhotoView.getHeight());
                    mPhotoView.setImageBitmap(bitmap);
                }
            }
        });


        return new AlertDialog.Builder(getActivity())
                .setView(view)
                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        getTargetFragment().onActivityResult(getTargetRequestCode(), Activity.RESULT_OK, null);
                    }
                })
                .create();
    }
}
