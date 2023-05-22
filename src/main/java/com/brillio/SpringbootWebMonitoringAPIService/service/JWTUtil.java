package com.brillio.SpringbootWebMonitoringAPIService.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JWTUtil {
    public String fetchSubjectFromDecodedPayload(String decodedPayload) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode payloadNode = objectMapper.readTree(decodedPayload);
            return payloadNode.get("sub").asText();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            System.out.println("Error in decryting username");
        }
        return null;
    }
}