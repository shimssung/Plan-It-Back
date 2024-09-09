package com.example.calendartodo_pjt.bbs.ctrl;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.calendartodo_pjt.bbs.domain.EventRequestDTO;
import com.example.calendartodo_pjt.bbs.domain.EventResponseDTO;
import com.example.calendartodo_pjt.bbs.service.EventService;


@RestController
@RequestMapping("/events") // 엔트 컨트롤을 위한 메핑
public class BbsController {

    @Autowired
    private EventService eventService;

    @GetMapping("/index")
    public ResponseEntity<Object> landing() {
        System.out.println("client end point : /events/index" + eventService);
        List<EventResponseDTO> list = eventService.findAll();
        System.out.println("result size : " + list.size());
        if (list.size() == 0) {
	            Map<String, String> map = new HashMap<>();
	            map.put("info", "저장된 데이터가 존재하지 않습니다.");
	            return new ResponseEntity<>(list, HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(list, HttpStatus.OK);
        }
    }

    @GetMapping("/viewday/{dateId}")
	    public ResponseEntity<Object> view(@PathVariable("dateId") String dateId) {
	        System.out.println("client end point : /events/view/{id}");
	        System.out.println("params = " + dateId);
	        Map<String, String> map = new HashMap<>();
	        map.put("id", dateId);
            List<EventResponseDTO> list = eventService.findlist(map);
            System.out.println("client list data : " + list);
	        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping("/save")
    public String save(@RequestBody EventRequestDTO params) {
        System.out.println("client end point : /events/save ");
        System.out.println(params);
        eventService.save(params);
        return null;
    }

    @GetMapping("/gettodo/{eventid}")
    public ResponseEntity<Object> view(@PathVariable("eventid") Integer eventid) {
        System.out.println("client end point : /events/gettodo/{eventid}");
        System.out.println("params = " + eventid);
        Map<String, Integer> map = new HashMap<>();
        map.put("id", eventid);
        EventResponseDTO reslut = eventService.findRow(map);
        System.out.println("client list data : " + reslut);
        return new ResponseEntity<>(reslut, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Integer id) {
        System.out.println("client end poin : /events/delete/{id}");
        System.out.println("params = " + id);
        Map<String, Integer> map = new HashMap<>();
        map.put("id", id);
        eventService.delete(map);
        return new ResponseEntity<>(id+"번 데이터 삭제완료",HttpStatus.OK);
    }
    
    

    // // 리액트와 비동기 통신을 위한 템플릿 - responseEntity
    // // user endpoint : http:// ip : port /bbs/index
    // @GetMapping("/index")
    // public ResponseEntity<Object> landing() {
    //     System.out.println("client end point : /bbs/index " + bbsService);
    //     List<BbsResponseDTO> list = bbsService.findAll() ;
    //     System.out.println("result size : " + list.size()) ;
    //     if (list.size() == 0) {
    //         Map<String, String> map = new HashMap<>();
    //         map.put("info", "저장된 데이터가 존재하지 않습니다.");
    //         return new ResponseEntity<>(map, HttpStatus.OK);
    //     } else {
    //         return new ResponseEntity<>(list, HttpStatus.OK);
    //     }
        
    // }

    // // 리액트에서 글작성하기버튼 누를시
    // @PostMapping("/save")
    // public ResponseEntity<Void> save(@RequestBody BbsRequestDTO params) {
    //     System.out.println("client end point : /bbs/save ");
    //     System.out.println(params);
    //     bbsService.save(params); // 강사님은 create()
    //     return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    // }

    // @GetMapping("/view/{id}")
    // public ResponseEntity<BbsResponseDTO> view(@PathVariable(name ="id") Integer id) {
    //     System.out.println("client end point : /bbs/view/{id}");
    //     System.out.println("params = " + id);
    //     Map<String, Integer> map = new HashMap<>();
    //     map.put("id", id);
    //     BbsResponseDTO result = bbsService.find(map);
    //     System.out.println(result);

    //     return new ResponseEntity<>(result, HttpStatus.OK);
    // }

    // @PostMapping("/comments/save")
    // public ResponseEntity<Void> commentsave(@RequestBody CommentRequestDTO params) {
    //     System.out.println(params);
    //     bbsService.createComment(params);
    //     return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    // }

    // /*
    // 1. 파라미터 넘겨받은 데이터를 Map에 담고
    // 2. bbsService.findComment(amp)
    // 3. BbsMapper에 기존에있는 findByIdComment를 사용
    // 4. 반환값으로 List<CommentResponseDTO>
    // 5. ResponseEntity<> 탬플릿을 이용해서 프론트로 전달
    
    //  */
    // @GetMapping("/comment/getComment/{id}")
    // public ResponseEntity<List<CommentResponseDTO>> getComment(@PathVariable(name ="id") Integer bbsid) {
    //     System.out.println("client endpoint : /bbs/comment/getComment ");
    //     System.out.println("param = " + bbsid);
    //     Map<String, Integer> map = new HashMap<>();
    //     map.put("id", bbsid);
    //     List<CommentResponseDTO> result = bbsService.findComment(map);
    //     System.out.println("debug >>> result size : " + result.size());
    //     return new ResponseEntity<>(result, HttpStatus.OK);
    // }

    // @DeleteMapping("/delete/{id}")
    // public ResponseEntity<String> delete(@PathVariable(name ="id") Integer bbsid) {
    //     System.out.println("client endpoint : /bbs/comment/getComment ");
    //     System.out.println("param = " + bbsid);
    //     Map<String, Integer> map = new HashMap<>();
    //     map.put("id", bbsid);
    //     bbsService.bbsdelete(map);
    //     return new ResponseEntity<>("게시글삭제완료", HttpStatus.NO_CONTENT);
    // }

    // @GetMapping("/getbbs/{bbsid}")
    // public ResponseEntity<BbsResponseDTO> getbbs(@PathVariable(name ="bbsid") Integer bbsid) {
    //     System.out.println("cliendt endpoint :  /bbs/getbbs ");
    //     Map<String, Integer> map = new HashMap<>();
    //     map.put("id", bbsid);
    //     BbsResponseDTO result = bbsService.bbsfind(map);
    //     return new ResponseEntity<>(result, HttpStatus.OK);

    // }

    // @PutMapping("/update")
    // public ResponseEntity<Void> update(@RequestBody BbsRequestDTO params) {
    //     System.out.println("client endpoint : /bbs/update ");
    //     System.out.println("params : " + params);
    //     bbsService.update(params);
    //     return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    // }
    
}
