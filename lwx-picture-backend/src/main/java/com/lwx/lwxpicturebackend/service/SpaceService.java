package com.lwx.lwxpicturebackend.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lwx.lwxpicturebackend.model.dto.space.SpaceAddRequest;
import com.lwx.lwxpicturebackend.model.dto.space.SpaceQueryRequest;
import com.lwx.lwxpicturebackend.model.entity.Space;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lwx.lwxpicturebackend.model.entity.User;
import com.lwx.lwxpicturebackend.model.vo.SpaceVO;

import javax.servlet.http.HttpServletRequest;

/**
* @author 潘佳豪
* @description 针对表【space(空间)】的数据库操作Service
* @createDate 2025-02-09 15:29:33
*/
public interface SpaceService extends IService<Space> {

    long addSpace(SpaceAddRequest spaceAddRequest, User loginUser);

    SpaceVO getSpaceVO(Space space, HttpServletRequest request);

    Page<SpaceVO> getSpaceVOPage(Page<Space> spacePage, HttpServletRequest request);

    QueryWrapper<Space> getQueryWrapper(SpaceQueryRequest spaceQueryRequest);

    void validSpace(Space space, boolean add);

    void fillSpaceBySpaceLevel(Space space);

    /**
     * 校验空间权限
     *
     * @param loginUser
     * @param space
     */
    void checkSpaceAuth(User loginUser, Space space);
}
