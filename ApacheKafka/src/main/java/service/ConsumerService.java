package service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

/**
 * Created by Habib, on 17/11/2020
 */
@Service
public class ConsumerService {
    private static final Logger logger=  LoggerFactory.getLogger(ConsumerService.class);

    @KafkaListener(groupId = "group_id",topics = "first_topic")
    public void consumerMessage(Object obj){
        logger.info("consumer message "+obj.toString());
    }
}
