package utils;

import org.apache.commons.lang3.RandomStringUtils;
import pojos.CreateCourierRequest;

public class CourierGenerator {
    public static CreateCourierRequest getNewCourier() {
        return new CreateCourierRequest(RandomStringUtils.randomAlphanumeric(16),
                RandomStringUtils.randomAlphanumeric(16), RandomStringUtils.randomAlphanumeric(16));
    }
}
