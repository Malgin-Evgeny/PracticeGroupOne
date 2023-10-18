package api.tests;

import api.testBase.inBodyClasses.Teachers;
import api.testBase.token.MyToken;
import com.github.javafaker.Faker;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class UserProfileRestControllerTest extends MyToken {
    Faker faker = new Faker();
    private Teachers createTeacher() {

        List<String> stages = new ArrayList<>();
        stages.add("Stage 1");
        stages.add("Stage 2");
        stages.add("Stage 3");

        List<Teachers.Language> languages = new ArrayList<>();
        {
            Teachers.Language language = new Teachers.Language();
            language.setLanguage("rus");
            language.setLevel(1);
            languages.add(language);
        }

        List<Teachers.Subject> subjects = new ArrayList<>();
        {
            Teachers.Subject subject = new Teachers.Subject();
            subject.setSubject("string");
            subject.setTeachingNow(true);
            subjects.add(subject);
        }

        Teachers.Photo photo = new Teachers.Photo();
        photo.setId(1);
        photo.setStorageFileName("photo_storage.jpg");
        photo.setOriginalFileName("photo.jpg");
        photo.setSize(1024);
        photo.setType("jpg");
        photo.setLocation("Location");
        photo.setUrl("http://example.com/photo.jpg");

        Teachers teachers = new Teachers();
        teachers.setFirstName(faker.name().firstName());
        teachers.setLastName(faker.name().lastName());
        teachers.setPatronymic(faker.name().firstName());
        teachers.setPhone(faker.phoneNumber().cellPhone());
        teachers.setEmail(faker.internet().emailAddress());
        teachers.setBirthDate("2023-10-11");
        teachers.setCity(faker.address().city());
        teachers.setState("CONFIRMED");
        teachers.setTeacherId(0);
        teachers.setPhotoFileName("photo_storage.jpg");
        teachers.setAdditionalPhoneNumber(faker.phoneNumber().phoneNumber());
        teachers.setCareerBeginningDate(faker.date().birthday().toString());
        teachers.setEducation("PRIMARY");
        teachers.setSpecialityByEducation("MIDDLE");
        teachers.setHasPedagogicalEducation(true);
        teachers.setAboutMe("TopTeacher");
        teachers.setStages(stages);
        teachers.setLanguages(languages);
        teachers.setSubjects(subjects);
        teachers.setPhoto(photo);
        return teachers;
    }

    @Test
    public void test() {
        given().header(getHeader())
                .body(createTeacher())
                .header("Content-Type", "application/json")
                .post(URL + "/profiles/teachers")
                .then().log().all()
                .statusCode(200);
    }
}