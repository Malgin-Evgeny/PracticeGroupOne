package api.testBase.inBodyClasses;

public class ChangeUserVoidClass {
    public ChangeUserVoidClass() {
    }
    private String requestBody = "{\n" +
            "  \"id\": 315,\n" +
            "  \"firstName\": \"Петр\",\n" +
            "  \"lastName\": \"петечка\",\n" +
            "  \"patronymic\": \"Петрович\",\n" +
            "  \"phone\": \"8-800-555-35-35\",\n" +
            "  \"login\": \"tripleP\",\n" +
            "  \"state\": \"CONFIRMED\",\n" +
            "  \"birthDate\": \"2023-10-10\",\n" +
            "  \"email\": \"petrov@mail.com\",\n" +
            "  \"center\": \"Organization Corp2\",\n" +
            "  \"parentName\": \"Петров Петр Иванович\",\n" +
            "  \"parentPhone\": \"8-801-555-35-36\",\n" +
            "  \"name\": \"string\",\n" +
            "  \"address\": \"string\",\n" +
            "  \"bankName\": \"string\",\n" +
            "  \"ks\": \"string\",\n" +
            "  \"rs\": \"string\",\n" +
            "  \"organizationType\": \"string\",\n" +
            "  \"index\": \"string\",\n" +
            "  \"region\": \"string\",\n" +
            "  \"street\": \"string\",\n" +
            "  \"building\": \"string\",\n" +
            "  \"flat\": \"string\",\n" +
            "  \"contractNumber\": \"string\",\n" +
            "  \"rate\": \"string\",\n" +
            "  \"royalty\": 0,\n" +
            "  \"freeAccountsNumber\": 0,\n" +
            "  \"additionalAccountCost\": 0,\n" +
            "  \"subscriptionType\": \"NOT_CHOSEN\",\n" +
            "  \"source\": \"string\",\n" +
            "  \"sourceInfo\": \"string\",\n" +
            "  \"gender\": \"NOT_CHOSEN\",\n" +
            "  \"city\": \"Казань\",\n" +
            "  \"country\": \"Россия\",\n" +
            "  \"bik\": \"string\",\n" +
            "  \"inn\": \"string\",\n" +
            "  \"kpp\": \"string\",\n" +
            "  \"ogrn\": \"string\"\n" +
            "}";


    public  String getRequestBody() {
        return requestBody;
    }

    private  String expextedBody = "{\n" +
            "    \"id\": 315,\n" +
            "    \"state\": \"CONFIRMED\",\n" +
            "    \"role\": \"STUDENT\",\n" +
            "    \"firstName\": \"Петр\",\n" +
            "    \"lastName\": \"петечка\",\n" +
            "    \"patronymic\": \"Петрович\",\n" +
            "    \"phone\": \"8-800-555-35-35\",\n" +
            "    \"email\": \"petrov@mail.com\",\n" +
            "    \"login\": \"triplep\",\n" +
            "    \"parentName\": \"Петров Петр Иванович\",\n" +
            "    \"parentPhone\": \"8-801-555-35-36\",\n" +
            "    \"age\": null,\n" +
            "    \"gender\": \"NOT_CHOSEN\",\n" +
            "    \"costType\": null,\n" +
            "    \"currencyType\": null,\n" +
            "    \"visits\": null,\n" +
            "    \"birthDate\": \"2023-10-10\",\n" +
            "    \"center\": \"Organization Corp2\",\n" +
            "    \"creator\": null,\n" +
            "    \"trulySolutionsCount\": 0,\n" +
            "    \"completedPercent\": 0,\n" +
            "    \"averageMark\": 0.0,\n" +
            "    \"coursesCount\": 0,\n" +
            "    \"studentsCount\": 0,\n" +
            "    \"teachersCount\": 0,\n" +
            "    \"courseTitle\": null,\n" +
            "    \"courseId\": null,\n" +
            "    \"discount\": null,\n" +
            "    \"onlinePartnerName\": null,\n" +
            "    \"subscriptionType\": \"NOT_CHOSEN\",\n" +
            "    \"studentPaymentSubscription\": null,\n" +
            "    \"source\": \"string\",\n" +
            "    \"sourceInfo\": \"string\",\n" +
            "    \"balance\": null,\n" +
            "    \"cost\": null,\n" +
            "    \"nextCostInMonth\": null,\n" +
            "    \"payouts\": null,\n" +
            "    \"comment\": null,\n" +
            "    \"moneyBackType\": null,\n" +
            "    \"name\": null,\n" +
            "    \"address\": null,\n" +
            "    \"bankName\": null,\n" +
            "    \"ks\": null,\n" +
            "    \"rs\": null,\n" +
            "    \"organizationType\": null,\n" +
            "    \"index\": null,\n" +
            "    \"region\": null,\n" +
            "    \"city\": \"Казань\",\n" +
            "    \"country\": \"Россия\",\n" +
            "    \"street\": null,\n" +
            "    \"building\": null,\n" +
            "    \"flat\": null,\n" +
            "    \"contractNumber\": null,\n" +
            "    \"rate\": null,\n" +
            "    \"royalty\": null,\n" +
            "    \"freeAccountsNumber\": null,\n" +
            "    \"additionalAccountCost\": null,\n" +
            "    \"tempAccessUUID\": null,\n" +
            "    \"tempDateTime\": \"2023-10-06T19:08:23.012\",\n" +
            "    \"registrationDateTime\": \"2023-10-06T19:08:23.012\",\n" +
            "    \"daysOnSite\": 3,\n" +
            "    \"expiresDateTime\": null,\n" +
            "    \"requiredFormIds\": null,\n" +
            "    \"bik\": null,\n" +
            "    \"inn\": null,\n" +
            "    \"kpp\": null,\n" +
            "    \"ogrn\": null\n" +
            "}";

    public String getExpextedBody() {
        return expextedBody;
    }
}

