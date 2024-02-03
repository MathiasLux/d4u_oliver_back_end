package com.d4u.Decision4You.persistence.exception;

public class DataQualityException extends RuntimeException {
    public DataQualityException(String message) {
        super(message);
    }

    public static DataQualityException forInvalidEnumDBValue(String dbValue, Class<? extends Enum> enumType) {
        String msg = "Unknown dbValue of '%s' for enumType '%s' ".formatted(dbValue, enumType.getSimpleName());
        return new DataQualityException(msg);
    }
}
