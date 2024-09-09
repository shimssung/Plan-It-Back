package com.example.calendartodo_pjt.bbs.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import com.example.calendartodo_pjt.bbs.domain.EventRequestDTO;
import com.example.calendartodo_pjt.bbs.domain.EventResponseDTO;


@Mapper
public interface EventMapper {

    public List<EventResponseDTO> findAllRow() ;

    public List<EventResponseDTO> findlist(Map<String, String> map) ;

    public EventResponseDTO findRow(Map<String, Integer> map) ;

    public void insertRow(EventRequestDTO params) ;

    public void deleteRow(Map<String, Integer> map);

    // public BbsResponseDTO findRow(Map<String, Integer> map) ;

    // public List<CommentResponseDTO> findByIdComment(Map<String, Integer> map) ;

    // public void insertCommentRow(CommentRequestDTO params);

    // public void bbsdeleteRow(Map<String, Integer> map);

    // public BbsResponseDTO bbsfindRow(Map<String, Integer> map);

    // public void updateRow(BbsRequestDTO params);
}
