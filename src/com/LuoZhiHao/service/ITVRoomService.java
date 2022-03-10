package com.LuoZhiHao.service;

import com.LuoZhiHao.model.TelevisionRoom;

import java.util.List;

public interface ITVRoomService {
    List<TelevisionRoom> getAllTvRoom() throws Exception;

    void delTVRoomById(Integer tvrId);
}
