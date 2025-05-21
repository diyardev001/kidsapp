package de.stadtherne.stadtserver.service;

import static java.nio.charset.StandardCharsets.UTF_8;

import com.hivemq.client.mqtt.MqttClient;
import static com.hivemq.client.mqtt.MqttGlobalPublishFilter.ALL;
import com.hivemq.client.mqtt.mqtt5.Mqtt5BlockingClient;

public class MyMqttMain_pub {

    public static void main(String[] args) throws Exception {

        final String host = "746654cc78364c80b4f0b9e3f1077a5b.s1.eu.hivemq.cloud";
        final String username = "kidsappMQTT";
        final String password = "kidsappMQTT2025";

        // create an MQTT client
        final Mqtt5BlockingClient client = MqttClient.builder()
                .useMqttVersion5()
                .serverHost(host)
                .serverPort(8883)
                .sslWithDefaultConfig()
                .buildBlocking();

        // connect to HiveMQ Cloud with TLS and username/pw
        client.connectWith()
                .simpleAuth()
                .username(username)
                .password(UTF_8.encode(password))
                .applySimpleAuth()
                .send();

        System.out.println("Connected successfully");

        // publish a message to the topic "my/test/topic"
        client.publishWith()
                .topic("my/test/topic")
                .payload(UTF_8.encode("Hello"))
                .send();
    }
}
