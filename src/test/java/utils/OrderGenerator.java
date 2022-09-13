package utils;

import org.apache.commons.lang3.RandomStringUtils;
import pojos.CreateOrderRequest;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class OrderGenerator {
    public static CreateOrderRequest getOrderWithBothColors() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        CreateOrderRequest createOrderRequest = new CreateOrderRequest();
        createOrderRequest.setFirstName(RandomStringUtils.randomAlphabetic(10));
        createOrderRequest.setLastName(RandomStringUtils.randomAlphabetic(10));
        createOrderRequest.setAddress(RandomStringUtils.randomAlphabetic(10));
        createOrderRequest.setMetroStation(new Random().nextInt(10));
        createOrderRequest.setPhone(RandomStringUtils.randomNumeric(10));
        createOrderRequest.setRentTime(new Random().nextInt(10));
        createOrderRequest.setDeliveryDate(LocalDate.now().format(formatter));
        createOrderRequest.setComment(RandomStringUtils.randomAlphabetic(10));
        createOrderRequest.setColor(Arrays.asList("BLACK ", "GREY"));
        return createOrderRequest;
    }

    public static CreateOrderRequest getOrderWithBlackColor() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        CreateOrderRequest createOrderRequest = new CreateOrderRequest();
        createOrderRequest.setFirstName(RandomStringUtils.randomAlphabetic(10));
        createOrderRequest.setLastName(RandomStringUtils.randomAlphabetic(10));
        createOrderRequest.setAddress(RandomStringUtils.randomAlphabetic(10));
        createOrderRequest.setMetroStation(new Random().nextInt(10));
        createOrderRequest.setPhone(RandomStringUtils.randomNumeric(10));
        createOrderRequest.setRentTime(new Random().nextInt(10));
        createOrderRequest.setDeliveryDate(LocalDate.now().format(formatter));
        createOrderRequest.setComment(RandomStringUtils.randomAlphabetic(10));
        createOrderRequest.setColor(List.of("BLACK"));
        return createOrderRequest;
    }

    public static CreateOrderRequest getOrderWithGreyColor() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        CreateOrderRequest createOrderRequest = new CreateOrderRequest();
        createOrderRequest.setFirstName(RandomStringUtils.randomAlphabetic(10));
        createOrderRequest.setLastName(RandomStringUtils.randomAlphabetic(10));
        createOrderRequest.setAddress(RandomStringUtils.randomAlphabetic(10));
        createOrderRequest.setMetroStation(new Random().nextInt(10));
        createOrderRequest.setPhone(RandomStringUtils.randomNumeric(10));
        createOrderRequest.setRentTime(new Random().nextInt(10));
        createOrderRequest.setDeliveryDate(LocalDate.now().format(formatter));
        createOrderRequest.setComment(RandomStringUtils.randomAlphabetic(10));
        createOrderRequest.setColor(List.of("Grey"));
        return createOrderRequest;
    }

    public static CreateOrderRequest getOrderWithoutColors() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        CreateOrderRequest createOrderRequest = new CreateOrderRequest();
        createOrderRequest.setFirstName(RandomStringUtils.randomAlphabetic(10));
        createOrderRequest.setLastName(RandomStringUtils.randomAlphabetic(10));
        createOrderRequest.setAddress(RandomStringUtils.randomAlphabetic(10));
        createOrderRequest.setMetroStation(new Random().nextInt(10));
        createOrderRequest.setPhone(RandomStringUtils.randomNumeric(10));
        createOrderRequest.setRentTime(new Random().nextInt(10));
        createOrderRequest.setDeliveryDate(LocalDate.now().format(formatter));
        createOrderRequest.setComment(RandomStringUtils.randomAlphabetic(10));
        createOrderRequest.setColor(null);
        return createOrderRequest;
    }
}