package com.maxi.bubbleimage;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.maxi.bubbleimage.widget.BubbleImageView;

public class MainActivity extends AppCompatActivity {
    private BubbleImageView bubbleImageView;
    private BubbleImageView bubbleImageView1;
    private String imageIconUrl = "http://p5.img.cctvpic.com/20100107/images/1262848505292_1262848505292_r.jpg";
    private String imageSrc = "http://img5q.duitang.com/uploads/item/201209/21/20120921194429_eLZBm.thumb.700_0.jpeg";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bubbleImageView = (BubbleImageView) findViewById(R.id.bubble_iv);
        bubbleImageView1 = (BubbleImageView) findViewById(R.id.bubble_iv1);
        bubbleImageView.load(imageIconUrl, R.mipmap.chatfrom_bg_focused, R.mipmap.ic_launcher);
        bubbleImageView1.load(imageSrc, R.mipmap.chatto_bg_focused, R.mipmap.ic_launcher);
    }

//    public static Bitmap getLoacalBitmap(String url) {
//        try {
//            ByteArrayOutputStream out;
//            FileInputStream fis = new FileInputStream(url);
//            BufferedInputStream bis = new BufferedInputStream(fis);
//            out = new ByteArrayOutputStream();
//            @SuppressWarnings("unused")
//            int hasRead = 0;
//            byte[] buffer = new byte[1024 * 2];
//            while ((hasRead = bis.read(buffer)) > 0) {
//                // 读出多少数据，向输出流中写入多少
//                out.write(buffer);
//                out.flush();
//            }
//            out.close();
//            fis.close();
//            bis.close();
//            byte[] data = out.toByteArray();
//            BitmapFactory.Options opts = new BitmapFactory.Options();
//            opts.inSampleSize = 3;
//            return BitmapFactory.decodeByteArray(data, 0, data.length, opts);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//            return null;
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//            return null;
//        }
//    }
}
