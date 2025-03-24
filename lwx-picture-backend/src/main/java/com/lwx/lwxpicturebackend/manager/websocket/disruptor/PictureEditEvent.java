package com.lwx.lwxpicturebackend.manager.websocket.disruptor;

import com.lwx.lwxpicturebackend.manager.websocket.model.PictureEditRequestMessage;
import com.lwx.lwxpicturebackend.model.entity.User;
import lombok.Data;
import org.springframework.web.socket.WebSocketSession;

@Data
public class PictureEditEvent {

    /***
     * 事件是 Disruptor 执行的核心单位，充当了上下文容器，所有处理消息所需的数据都被封装在其中。
     */

    /**
     * 消息
     */
    private PictureEditRequestMessage pictureEditRequestMessage;

    /**
     * 当前用户的 session
     */
    private WebSocketSession session;
    
    /**
     * 当前用户
     */
    private User user;

    /**
     * 图片 id
     */
    private Long pictureId;

}
