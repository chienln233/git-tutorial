package org.example.quanlythuctap.services;

import org.example.quanlythuctap.dto.TopicDto;
import org.example.quanlythuctap.models.ResponseObject;
import org.example.quanlythuctap.models.Topic;
import org.example.quanlythuctap.repositories.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class TopicService {
    @Autowired
    private TopicRepository topicRepository;
    public List<Topic> getAllTopic(){
        return topicRepository.findAll();
    }
    public List<Object[]> thongTinDT(){
        List<Object[]> tenDT = topicRepository.tenDTKhongCoSVTT();
        return tenDT;
    }
    public ResponseEntity<ResponseObject> finById(@PathVariable Long maDT){
        Optional<Topic> foundTopic=topicRepository.findById(maDT);
        return foundTopic.isPresent() ?
                ResponseEntity.status(HttpStatus.OK).body(
                        new ResponseObject("ok","Query topic successfully",foundTopic)
                ):
                ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                        new ResponseObject("failed","Cannot find topic with maDT = " + maDT,"" )
                );
    }
    public ResponseEntity<ResponseObject> insertTopic(@RequestBody TopicDto newTopic){
        Topic topic = new Topic();
        topic.setTenDT(newTopic.getTenDT());
        topic.setKinhPhi(newTopic.getKinhPhi());
        topic.setNoiThucTap(newTopic.getNoiThucTap());
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok","Insert Topic successfully",topicRepository.save(topic))
        );
    }
    public  ResponseEntity<ResponseObject> updateTopic(@RequestBody TopicDto newTopic,@PathVariable Long maDT) {
        Optional<Topic> updateTopic =topicRepository.findById(maDT)
                .map(topicdto -> {
                    topicdto.setTenDT(newTopic.getTenDT());
                    topicdto.setKinhPhi(newTopic.getKinhPhi());
                    topicdto.setNoiThucTap(newTopic.getNoiThucTap());
                    return topicRepository.save(topicdto);
                });
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok","Update Product successfully",updateTopic)
        );
    }
   public ResponseEntity<ResponseObject> deleteTopic(@PathVariable Long maDT) {
        boolean exits =topicRepository.existsById(maDT);
        if (exits) {
            topicRepository.deleteById(maDT);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("ok","Delete topic successfully","")
            );
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ResponseObject("failedd","Cannot find topic to delete","")
        );
    }
    public  List<Object> deTaiKinhPhiMax() {
        return  topicRepository.deTaiKinhPhiCaoNhat();
    }

}
