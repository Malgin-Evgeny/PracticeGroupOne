package api.testBase.inBodyClasses;

public class ArchiveBody {
    private static String requestArchiveBody = "{\n" +
            "  \"archiveComment\": \"Какая-то причина\",\n" +
            "  \"archiveReason\": \"OTHER\"\n" +
            "}";

    public static String getRequestArchiveBody() {
        return requestArchiveBody;
    }

    public ArchiveBody() {
    }

}
