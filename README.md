# BubbleImage
示例图片：
![image](https://github.com/Maxi-Mao/BubbleImage/blob/master/BubbleImg/img1.png)

使用方法:
在BubbleImageView中我定义了两种加载图片的方式，
一种是加载网络图片
```java  
   
load(String url, int res, int placeHolderPic)
   
```
一种是加载本地图片

```java  
   
setLocalImageBitmap(Bitmap bm, int res)
   
```

大家可以根据需要加载图片。其中的参数代码中都有详细介绍。 

该项目图片加载框架为universal-image-loader。详见[Android聊天页面发送图片定制(类似微信)](http://blog.csdn.net/omrapollo/article/details/51093766)

还有用Glide封装的，详见[Android聊天界面搭建](http://blog.csdn.net/omrapollo/article/details/52691320)中的BubbleImageView类
