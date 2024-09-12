package com.example.calendartodo_pjt.openapi.ctrl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.calendartodo_pjt.Events.service.EventService;
import com.example.calendartodo_pjt.openapi.domain.HistoryDaysDTO;
import com.example.calendartodo_pjt.openapi.service.HistoryService;

@RestController
@RequestMapping("/api")
public class historyController {

    @Autowired
    private HistoryService historyService ;

    @Autowired
    private EventService eventService ;
    

    @Value("${openApi.serviceKey}")
    private String serviceKey ;

    @Value("${openApi.callBackUrl}")
    private String callBackUrl ;

    @Value("${openApi.dataType}")
    private String dataType ;

    @GetMapping("/history")
    public ResponseEntity<Object>  callHistoryApi(
        @RequestParam(value = "solYear") String solYear,
        @RequestParam(value = "solMonth") String solMonth
    ) {
        System.out.println("client end point : /api/history");
        System.out.println("servicekey  = " + serviceKey);
        System.out.println("callBackUrl = " + callBackUrl);
        System.out.println("dataType    = " + dataType);
        System.out.println("params = " + solYear + solMonth);

        String requestURL = callBackUrl+
                            "?serviceKey="+serviceKey+
                            "&solYear="+solYear+
                            "&solMonth="+solMonth;

        System.out.println("url check = " +requestURL);

        
        HttpURLConnection http   = null ;
        InputStream       stream = null ;
        String            result = null ;   // 자바입장에서는 변수, 함수 이런게 아니라 다 문자열로 인식함

        List<HistoryDaysDTO> list = null ;

        try {
            URL url = new URL(requestURL);
            http = (HttpURLConnection)url.openConnection();
            System.out.println("http connection = " + http);
            int code = http.getResponseCode();
            System.out.println("http response code = " + code);
            if( code == 200 ) {
                stream = http.getInputStream();
                result = readString(stream);    // readString은 내가 만든 메서드
                System.out.println("result = " + result );
                list = historyService.parseXml(result);
                eventService.savehistory(list);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
        if (list.size() == 0) {
            Map<String, String> map = new HashMap<>();
            map.put("info", "저장된 데이터가 존재하지 않습니다.");
            return new ResponseEntity<>(map, HttpStatus.OK);
        } else {
            System.out.println("client list size " + list.size());
            System.out.println(list.get(0).getDateName());
            return new ResponseEntity<>(list, HttpStatus.OK);
        }
        

    }

        public String readString(InputStream stream) throws IOException {
        BufferedReader br    = new BufferedReader(new InputStreamReader(stream, "UTF-8"));
        String         input         = null ;
        StringBuilder  result = new StringBuilder();
        // 얼마나 있는지 모르니 while문 돌리기
        while( (input = br.readLine()) != null ) {
            result.append(input + "\n\r");
        }
        br.close();
        return result.toString() ;
    }
}
