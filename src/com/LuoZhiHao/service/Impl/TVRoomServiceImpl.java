package com.LuoZhiHao.service.Impl;

import com.LuoZhiHao.model.TelevisionRoom;
import com.LuoZhiHao.service.ITVRoomService;

import java.util.ArrayList;
import java.util.List;

public class TVRoomServiceImpl implements ITVRoomService {
    @Override
    public List<TelevisionRoom> getAllTvRoom() throws Exception {
        List<TelevisionRoom> televisionRooms = new ArrayList<>();
        televisionRooms.add(new TelevisionRoom(101, 150.00F));
        televisionRooms.add(new TelevisionRoom(102, 100.00F));
        televisionRooms.add(new TelevisionRoom(103, 169.50F));
        return televisionRooms;
    }

    @Override
    public void delTVRoomById(Integer tvrId) {

    }
}
