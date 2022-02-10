package hello.springmvc.basic.requestmapping;


import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;



import static java.awt.PageAttributes.*;

@RestController
public class MappingController {
    private Logger log = LoggerFactory.getLogger(getClass());

    @RequestMapping(value = "/hello-basic", method = RequestMethod.GET)
    public String helloBasic(){
        log.info("hellobasic");
        return "ok";

    }
    /**
     * 편리한 축약 애노테이션
     * @GETMAPPING
     * @POSTMAPPING
     * @PUTMAPPING
     * @DELETEMAPPING
     * @PATCHMAPPING
     */

    @GetMapping(value = "/mapping-get-v2")
    public String mappingGetV2(){
        log.info("mapping_get-v2");
        return "ok";
    }

    /**
     * 경로변수(pathvariable)
     */
    ///mapping/userA
    @GetMapping("/mapping/{userId}")
    public String mappingPath(@PathVariable("userId") String data){
        log.info("mappingPath userID ={} ", data);
        return "ok";
    }

    /**
     * Pathvariable 다중 사용
     */
    @GetMapping("/mapping/user/{userId}/orders/{orderId}")
    public String mappingPath(@PathVariable String userId, @PathVariable Long orderId){
        log.info("mappingPath userId = {}, orderId = {}", userId, orderId);
        return "ok";

    }

    /**
     * 파라미터로 추가 매핑
     * params = "mode"
     * params = "!mode"
     * params = "mode=debug"
     * params = "mode!=debug"
     * params = {"mode=debug", "data=good"}
     */
    @GetMapping(value = "/mapping-param", params = "mode-debug")
    public String mappingParam(){
        log.info("mappingParam");
        return "ok";
    }

    /**
     * 특정 헤더로 추가 매핑
     * headers = "mode"
     * headers = "!mode"
     * headers = "mode=debug"
     * headers = "mode!=debug"
     */
    @GetMapping(value = "/mapping-header", headers = "mode=debug")
    public String mappingHeader() {
        log.info("mappingHeader");
        return "ok";
    }



     /**
     * Content-Type 헤더 기반 추가 매핑 Media Type * consumes="application/json"
     * consumes="!application/json"
     * consumes="application/*"
     * consumes="*\/*"
     * MediaType.APPLICATION_JSON_VALUE
     */
    @PostMapping(value = "/mapping-consume", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String mappingConsumes() {
        log.info("mappingConsumes");
        return "ok";
    }
    /**

     * Accept 헤더 기반 Media Type * produces = "text/html"
     * produces = "!text/html" * produces = "text/*"
     * produces = "*\/*"
     */
    @PostMapping(value = "/mapping-produce", produces = MediaType.TEXT_HTML_VALUE)
    public String mappingProduces() {
        log.info("mappingProduces");
        return "ok";
    }






}



















