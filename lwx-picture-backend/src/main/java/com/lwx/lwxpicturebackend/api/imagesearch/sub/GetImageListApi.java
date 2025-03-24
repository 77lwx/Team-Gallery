package com.lwx.lwxpicturebackend.api.imagesearch.sub;


import com.lwx.lwxpicturebackend.api.imagesearch.model.ImageSearchResult;
import com.lwx.lwxpicturebackend.exception.BusinessException;
import com.lwx.lwxpicturebackend.exception.ErrorCode;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
//
//import java.util.List;
//
//@Slf4j
//public class GetImageListApi {
//
//    /**
//     * 获取图片列表(3)
//     *
//     * @param url
//     * @return
//     */
//    public static List<ImageSearchResult> getImageList(String url) {
//        try {
//            // 发起GET请求
//            HttpResponse response = HttpUtil.createGet(url).execute();
//            // 获取响应内容
//            int statusCode = response.getStatus();
//            String body = response.body();
//
//            // 处理响应
//            if (statusCode == 200) {
//                // 解析 JSON 数据并处理
//                return processResponse(body);
//            } else {
//                throw new BusinessException(ErrorCode.OPERATION_ERROR, "接口调用失败");
//            }
//        } catch (Exception e) {
//            log.error("获取图片列表失败", e);
//            throw new BusinessException(ErrorCode.OPERATION_ERROR, "获取图片列表失败");
//        }
//    }
//
//    /**
//     * 处理接口响应内容
//     *
//     * @param responseBody 接口返回的JSON字符串
//     */
//    private static List<ImageSearchResult> processResponse(String responseBody) {
//        // 解析响应对象
//        JSONObject jsonObject = new JSONObject(responseBody);
//        if (!jsonObject.containsKey("data")) {
//            throw new BusinessException(ErrorCode.OPERATION_ERROR, "未获取到图片列表");
//        }
//        JSONObject data = jsonObject.getJSONObject("data");
//        if (!data.containsKey("list")) {
//            throw new BusinessException(ErrorCode.OPERATION_ERROR, "未获取到图片列表");
//        }
//        JSONArray list = data.getJSONArray("list");
//        return JSONUtil.toList(list, ImageSearchResult.class);
//    }
//
//    public static void main(String[] args) {
//        String url = "https://graph.baidu.com/ajax/pcsimi?carousel=503&entrance=GENERAL&extUiData%5BisLogoShow%5D=1&inspire=general_pc&limit=30&next=2&render_type=card&session_id=2366955152723622859&sign=12693e97cd54acd88139901739365329&tk=36805&tpl_from=pc&page=1&";
//        List<ImageSearchResult> imageList = getImageList(url);
//        System.out.println("搜索成功" + imageList);
//    }
//}



@Slf4j
public class GetImageListApi {

    /**
     * 获取图片列表
     *
     * @param query 搜索关键词
     * @return 图片搜索结果列表
     */
    public static List<ImageSearchResult> getImageList(String query) {
        try {
            // 使用 Pexels API 搜索图片
            PexelsImageSearch imageSearch = new PexelsImageSearch();
            List<String> imageUrls = imageSearch.searchPictures(query);

            // 将图片的URL转为ImageSearchResult对象
            return convertToImageSearchResults(imageUrls);
        } catch (Exception e) {
            log.error("获取图片列表失败", e);
            throw new BusinessException(ErrorCode.OPERATION_ERROR, "获取图片列表失败");
        }
    }

    /**
     * 将图片URL列表转换为ImageSearchResult列表
     *
     * @param imageUrls 图片URL列表
     * @return ImageSearchResult列表
     */
    private static List<ImageSearchResult> convertToImageSearchResults(List<String> imageUrls) {
        List<ImageSearchResult> imageSearchResults = new ArrayList<>();
        for (String url : imageUrls) {
            ImageSearchResult result = new ImageSearchResult();
            // 使用Pexels提供的原图URL作为缩略图
            result.setThumbUrl(url);
            // 这里假设来源地址与缩略图相同
            result.setFromUrl(url);
            imageSearchResults.add(result);
        }
        return imageSearchResults;
    }

    public static void main(String[] args) {
        // 示例：通过 Pexels API 获取与“nature”相关的图片列表
        String query = "nature";
        List<ImageSearchResult> imageList = getImageList(query);
        System.out.println("搜索成功，获取到图片列表：" + imageList);
    }
}

