package org.home.demoauthentication.exceptions;

public class ValidationException extends RuntimeException {
    public ValidationException(String message) {
        super(message);
    }
    public ValidationException(ValidationMessage validationMessage, Object... args) {
        super(String.format(validationMessage.messageFormat(), args));
    }
    public enum ValidationMessage {
        ID_NOT_NUMERIC("ID is not numeric"),
        DESCRITPION_TOO_LONG("Description is too long"),
        TITLE_TOO_LONG("Title is too long"),
        TITLE_CAN_NOT_BE_NULL("Title can not be null"),
        FAILED_GET_ALL("Failed to return all of the results"),
        FAILED_ADD("Failed to add the challenge"),
        FAILED_DELETE("Failed to delete '%s' id"),
        ID_NOT_VALID("Id is not valid "),
        ID_ALREADY_EXISTS("ID already exists in DB"),
        ID_INEXISTENT("The id is not in DB"),
        DB_FIELD_ERROR("DB modifier multiple fields"),
        TITLE_IS_NULL("Title from input is null"),
        EXPECTED_ID("You should provide value for ID."),
        CREDITS_IS_NULL("The credits field is null"),
        NAME_IS_NULL("The Name field is null"),
        URL_IS_NULL("The url field is null"),
        CREDITS_NOT_NUMERIC("The credits are not numeric"),
        URL_TOO_LONG("URL is too long"),
        NAME_TOO_LONG("NAME is too long"),
        DESCRIPTION_IS_NULL("Description from input is null");

        String messageFormat;
        ValidationMessage(String messageFormat) {
            this.messageFormat = messageFormat;
        }

        public String messageFormat() {
            return this.messageFormat;
        }
    }
}
