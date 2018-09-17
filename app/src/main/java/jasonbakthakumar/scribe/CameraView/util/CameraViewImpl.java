package jasonbakthakumar.scribe.CameraView.util;

import android.view.View;

import java.util.Set;

/**
 * Created by jasonbakthakumar on 30/10/16.
 */

public abstract class CameraViewImpl {
    protected final Callback mCallback;

    protected final PreviewImpl mPreview;

    CameraViewImpl(Callback callback, PreviewImpl preview) {
        mCallback = callback;
        mPreview = preview;
    }

    public View getView() {
        return mPreview.getView();
    }

    public abstract void start();

    public abstract void stop();

    public abstract boolean isCameraOpened();

    public abstract void setFacing(int facing);

    public abstract int getFacing();

    public abstract Set<AspectRatio> getSupportedAspectRatios();

    public abstract void setAspectRatio(AspectRatio ratio);

    public abstract AspectRatio getAspectRatio();

    public abstract void setAutoFocus(boolean autoFocus);

    public abstract boolean getAutoFocus();

    public abstract void setFlash(int flash);

    public abstract int getFlash();

    public abstract void takePicture();

    public abstract void setDisplayOrientation(int displayOrientation);

    public interface Callback {

        void onCameraOpened();

        void onCameraClosed();

        void onPictureTaken(byte[] data);

    }

}
