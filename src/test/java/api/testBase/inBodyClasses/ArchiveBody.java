package api.testBase.inBodyClasses;

public class ArchiveBody {
    private String requestArchiveBody = "{\n" +
            "  \"archiveComment\": \"Какая-то причина\",\n" +
            "  \"archiveReason\": \"OTHER\"\n" +
            "}";

    public String getRequestArchiveBody() {
        return requestArchiveBody;
    }

    public ArchiveBody() {
    }
}
