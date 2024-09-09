package com.example.calendartodo_pjt.bbs.service;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.calendartodo_pjt.bbs.dao.EventMapper;
import com.example.calendartodo_pjt.bbs.domain.EventRequestDTO;
import com.example.calendartodo_pjt.bbs.domain.EventResponseDTO;


@Service
public class EventService {

    // 의존관계 주입
    @Autowired
    private EventMapper eventMapper;

    public List<EventResponseDTO> findAll() {
        // 의존관계 주입이 제대로 되었는지 확인
        System.out.println("debug >>> service findAll " + eventMapper);
        return eventMapper.findAllRow() ;
    }

    public List<EventResponseDTO> findlist(Map<String, String> map) {
        System.out.println("debug >>> service findlist " + eventMapper);
        return eventMapper.findlist(map);
    }

    public EventResponseDTO findRow(Map<String, Integer> map) {
        System.out.println("debug >>> service findRow " + eventMapper);
        return eventMapper.findRow(map);
    }

    public void save(EventRequestDTO params) {
        System.out.println("debug >>> service save " + eventMapper);
        System.out.println(params);
        eventMapper.insertRow(params);
    }

    public void delete(Map<String, Integer> map) {
        System.out.println("debug >>> service delete " + eventMapper);
        eventMapper.deleteRow(map);
    }

    // public BbsResponseDTO find(Map<String, Integer> map) {
    //     System.out.println("debug >>> service find " + bbsMapper);

    //     BbsResponseDTO result = bbsMapper.findRow(map);
    //     List<CommentResponseDTO> list = bbsMapper.findByIdComment(map);
    //     result.setComments(list);
    //     return result;
    // }

    // public void createComment(CommentRequestDTO params) {
    //     System.out.println("debug >>> service commentsave " + bbsMapper);
    //     bbsMapper.insertCommentRow(params);
    // }

    // public List<CommentResponseDTO> findComment(Map<String, Integer> map) {
    //     System.out.println("debug >>> service findComment " + bbsMapper);
    //     List<CommentResponseDTO> result = bbsMapper.findByIdComment(map);
    //     System.out.println("debug >>> findComment reslut " + result);
    //     return result;
    // }

    // public void bbsdelete(Map<String, Integer> map) {
    //     System.out.println("debug >>> service bbsdelete " + bbsMapper);
    //     bbsMapper.bbsdeleteRow(map);
    // }

    // public BbsResponseDTO bbsfind(Map<String, Integer> map) {
    //     System.out.println("debug >>> service findbbs " + bbsMapper);
    //     BbsResponseDTO result = bbsMapper.bbsfindRow(map);
    //     return result ;
    // }

    // public void update(BbsRequestDTO params) {
    //     System.out.println("debug >>> service bbsupdate " + bbsMapper);
    //     bbsMapper.updateRow(params);
    //     System.out.println("되니");
        
    // }



    
}
