package com.lwx.lwxpicturebackend.api.imagesearch;

import com.lwx.lwxpicturebackend.api.imagesearch.model.ImageSearchResult;
import com.lwx.lwxpicturebackend.api.imagesearch.sub.GetImageListApi;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class ImageSearchApiFacade {

//    /**
//     * 搜索图片
//     *
//     * @param imageUrl
//     * @return
//     */
//    public static List<ImageSearchResult> searchImage(String imageUrl) {
//        String imagePageUrl = GetImagePageUrlApi.getImagePageUrl(imageUrl);
//        String imageFirstUrl = GetImageFirstUrlApi.getImageFirstUrl(imagePageUrl);
//        List<ImageSearchResult> imageList = GetImageListApi.getImageList(imageFirstUrl);
//        return imageList;
//    }
//
//    public static void main(String[] args) {
//        // 测试以图搜图功能
//        String imageUrl = "https://www.codefather.cn/logo.png";
//        List<ImageSearchResult> resultList = searchImage(imageUrl);
//        System.out.println("结果列表" + resultList);
//    }

    /**
     * 搜索图片
     *
     * @param query 图片关键字
     * @return 图片搜索结果列表
     */
    public static List<ImageSearchResult> searchImage(String query) {
        // 这里可以通过图像URL获取相关的搜索结果。因为我们使用Pexels，我们可以基于图像URL进行直接搜索。
        return GetImageListApi.getImageList(query);
    }

    public static void main(String[] args) {
        // 测试通过图像URL进行以图搜图功能
        String imageUrl = "https://www.codefather.cn/logo.png";
        List<ImageSearchResult> resultList = searchImage(imageUrl);
        System.out.println("结果列表：" + resultList);
    }
}
