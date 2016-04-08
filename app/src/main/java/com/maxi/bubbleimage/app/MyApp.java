package com.maxi.bubbleimage.app;

import android.app.Application;
import android.os.Environment;

import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiscCache;
import com.nostra13.universalimageloader.cache.memory.impl.LruMemoryCache;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;

import java.io.File;

/**
 * Created by Administrator on 2016/4/7.
 */
public class MyApp extends Application {
    public static String BITMAP_CACHE_DIR = Environment.getExternalStorageDirectory().toString()+ "/BAL/bitmap_cache/";
    @Override
    public void onCreate() {
        super.onCreate();
        initImageLoader();
    }

    public void initImageLoader() {
        ImageLoaderConfiguration.Builder config = new ImageLoaderConfiguration.Builder(getApplicationContext());
        config.threadPriority(Thread.NORM_PRIORITY - 2);
        config.denyCacheImageMultipleSizesInMemory();
        config.memoryCache(new LruMemoryCache(10 * 1024 * 1024));
        config.diskCache(new UnlimitedDiscCache(new File(BITMAP_CACHE_DIR)));
        config.diskCacheSize(50 * 1024 * 1024); // 50 MiB
        config.tasksProcessingOrder(QueueProcessingType.LIFO);
        ImageLoader.getInstance().init(config.build());
    }
}
