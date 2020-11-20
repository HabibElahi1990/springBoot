package service;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;


/**
 * Created by Habib, on 17/11/2020
 */
@Service
public class ProducerService {

    private static final Logger logger = LoggerFactory.getLogger(ProducerService.class);
    private final KafkaTemplate<String, Object> kafkaTemplate;

    public ProducerService(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(Object obj) {
        try {
            logger.info("Producing message start");
            ObjectMapper objectMapper = new ObjectMapper();
            String message="";
            if (obj instanceof User) {
                objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
                message=objectMapper.writeValueAsString(obj);
            }else {
                message= (String) obj;
            }
            ListenableFuture<SendResult<String, Object>> future = this.kafkaTemplate.send("first_topic", message);
            future.addCallback(new ListenableFutureCallback<SendResult<String, Object>>() {
                public void onFailure(Throwable throwable) {
                    logger.info("unable send message");
                }

                public void onSuccess(SendResult<String, Object> stringObjectSendResult) {
                    logger.info("success send message");
                }
            });
        } catch (JsonProcessingException e) {
           logger.error(e.getMessage());
        }
    }
}
