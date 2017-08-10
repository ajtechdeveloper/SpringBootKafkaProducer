package com.aj.springbootkafkaproducer.controller;

import com.aj.springbootkafkaproducer.domain.KafkaProducerRequest;
import com.aj.springbootkafkaproducer.service.KafkaProducerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/")
public class KafkaProducerController {

    private static final Logger logger = LoggerFactory.getLogger(KafkaProducerController.class);

    @Autowired
    private KafkaProducerService kafkaProducerService;

    @RequestMapping(value = "kafka", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, String>> sendMessageToTopic(@RequestBody KafkaProducerRequest kafkaProducerRequest)  {
        logger.info("Request received is: " + kafkaProducerRequest );
        Map<String, String> response = new HashMap<>();
        String status = kafkaProducerService.sendMessageToTopic(kafkaProducerRequest.getTopic(),kafkaProducerRequest.getMessage());
        if("success".equalsIgnoreCase(status)) {
            response.put("Status is: " + status, "Message has been sent to Topic: " + kafkaProducerRequest.getTopic());
        }
        else{
            response.put("Status is: " + status, "Error in sending Message to Topic: " + kafkaProducerRequest.getTopic());
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
