package com.maxi.bubbleimage.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;
import com.nostra13.universalimageloader.core.display.SimpleBitmapDisplayer;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class CacheImageView extends ImageView {

	protected ImageLoader imageLoader;
	protected DisplayImageOptions options;
	protected AnimateFirstDisplayListener firstListener;
	protected DisplayImageOptions.Builder builder;
	public CacheImageView(Context context) {
		super(context);
		initCache();
	}

	public CacheImageView(Context context, AttributeSet attrs) {
		super(context, attrs);
		initCache();
	}

	public CacheImageView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		initCache();
	}

	protected void initCache() {
		imageLoader = ImageLoader.getInstance();
		builder = new DisplayImageOptions.Builder();
		options = builder.cacheInMemory(true).cacheOnDisk(true)
				.considerExifParams(true).delayBeforeLoading(1000)
				.imageScaleType(ImageScaleType.IN_SAMPLE_POWER_OF_2)
				.resetViewBeforeLoading(false)
				.displayer(new SimpleBitmapDisplayer()).build();
		firstListener = new AnimateFirstDisplayListener();
	}

	public void setOptions(DisplayImageOptions displayImageOptions) {
		if (null != displayImageOptions) {
			this.options = displayImageOptions;
		}
	}
	public void load(final String url, DisplayImageOptions options,
			AnimateFirstDisplayListener animateFirstDisplayListener) {
		if (null == options) {
			options = this.options;
		}
		if (null == animateFirstDisplayListener) {
			animateFirstDisplayListener = this.firstListener;
		}
		imageLoader.displayImage(url, CacheImageView.this, options,
				animateFirstDisplayListener);
	}

	public void load(final String url, long delayMillis) {
		new Handler().postDelayed(new Runnable() {
			@Override
			public void run() {
				imageLoader.displayImage(url, CacheImageView.this, options,
						firstListener);
			}
		}, delayMillis);
	}

	public void load(final String url) {
		imageLoader.displayImage(url, CacheImageView.this, options,
				firstListener);
	}

	public static class AnimateFirstDisplayListener extends
			SimpleImageLoadingListener {
		static final List<String> displayedImages = Collections
				.synchronizedList(new LinkedList<String>());
		@Override
		public void onLoadingComplete(String imageUri, View view,
				Bitmap loadedImage) {
			if (loadedImage != null) {
				ImageView imageView = (ImageView) view;
				boolean firstDisplay = !displayedImages.contains(imageUri);
				if (firstDisplay) {
					FadeInBitmapDisplayer.animate(imageView, 0);
					displayedImages.add(imageUri);
				}
			}
		}
	}
	
	public AnimateFirstDisplayListener getFirstListener() {
		return firstListener;
	}

	public void setFirstListener(AnimateFirstDisplayListener firstListener) {
		this.firstListener = firstListener;
	}
	
}
