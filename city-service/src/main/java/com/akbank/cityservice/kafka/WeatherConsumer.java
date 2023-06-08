package com.akbank.cityservice.kafka;

import com.akbank.cityservice.dto.response.CityEventResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class WeatherConsumer {

    @KafkaListener(
            topics = "${spring.kafka.topic.name}",
            groupId = "${spring.kafka.consumer.group-id}"
    )
    public void consume(CityEventResponse cityEventResponse) {
        log.info("Weather Event Received in City service -> {}", cityEventResponse);
    }
}
