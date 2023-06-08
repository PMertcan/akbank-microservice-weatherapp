package com.akbank.weatherservice.kafka;

import com.akbank.weatherservice.dto.response.WeatherEvent;
import com.akbank.weatherservice.dto.response.WeatherResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class WeatherProducer {

    private final NewTopic topic;

    private final KafkaTemplate<String, WeatherResponse> kafkaTemplate;

    public void sendMessage(WeatherEvent weatherEvent) {
        log.info("Weather Response Event -> {}", weatherEvent);

        Message<WeatherEvent> message = MessageBuilder
                .withPayload(weatherEvent)
                .setHeader(KafkaHeaders.TOPIC, topic.name())
                .build();

        kafkaTemplate.send(message);
    }

}
