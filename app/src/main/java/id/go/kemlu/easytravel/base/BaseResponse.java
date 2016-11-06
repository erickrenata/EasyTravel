package id.go.kemlu.easytravel.base;

/**
 * Created by Erick Renata on 05/11/2016.
 */

public class BaseResponse {

    private MetaEntity meta;

    public MetaEntity getMeta() {
        return meta;
    }

    public static class MetaEntity {
        private int code;
        private String message;

        public int getCode() {
            return code;
        }

        public String getMessage() {
            return message;
        }

    }
}
