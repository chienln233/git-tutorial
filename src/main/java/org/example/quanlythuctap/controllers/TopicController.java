package org.example.quanlythuctap.controllers;

import org.example.quanlythuctap.dto.TopicDto;
import org.example.quanlythuctap.models.ResponseObject;
import org.example.quanlythuctap.models.Topic;
import org.example.quanlythuctap.repositories.TopicRepository;
import org.example.quanlythuctap.services.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/Topic")
public class TopicController extends BaseController {
    @Autowired
    private TopicService topicService;

    @GetMapping("")
    List<Topic> getAllTopic() {
        return topicService.getAllTopic();
    }

    @GetMapping("/detai_khongco_svthuctap")
    List<Object[]> thongTinDT() {
        return topicService.thongTinDT();
    }

    @GetMapping("/{maDT}")
    ResponseEntity<ResponseObject> finById(@PathVariable Long maDT) {
            return topicService.finById(maDT);
    }

    @PostMapping("/insert")
    ResponseEntity<ResponseObject> insertTopic(@RequestBody TopicDto newTopic) {
            return topicService.insertTopic(newTopic);
    }

    @PutMapping("/{maDT}")
    ResponseEntity<ResponseObject> updateTopic(@RequestBody TopicDto newTopic, @PathVariable Long maDT) {
            return topicService.updateTopic(newTopic, maDT);
    }

    @DeleteMapping("/{maDT}")
    ResponseEntity<ResponseObject> deleteTopic(@PathVariable Long maDT) {
            return topicService.deleteTopic(maDT);
    }

    @GetMapping("/detai_kinhphi_caonhat")
    List<Object> deTaiKinhPhiMax() {
        return topicService.deTaiKinhPhiMax();
    }
}
