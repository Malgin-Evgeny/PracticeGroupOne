package api.testBase.inBodyClasses;

import java.util.List;

public class Teachers {
    private String firstName;
    private String lastName;
    private String patronymic;
    private String phone;
    private String email;
    private String birthDate;
    private String city;
    private String state;
    private int teacherId;
    private String photoFileName;
    private String additionalPhoneNumber;
    private String careerBeginningDate;
    private String education;
    private String specialityByEducation;
    private boolean hasPedagogicalEducation;
    private String aboutMe;
    private List<String> stages;
    private List<Language> languages;
    private List<Subject> subjects;
    private Photo photo;

    public Teachers() {
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public String getPhotoFileName() {
        return photoFileName;
    }

    public String getAdditionalPhoneNumber() {
        return additionalPhoneNumber;
    }

    public String getCareerBeginningDate() {
        return careerBeginningDate;
    }

    public String getEducation() {
        return education;
    }

    public String getSpecialityByEducation() {
        return specialityByEducation;
    }

    public boolean isHasPedagogicalEducation() {
        return hasPedagogicalEducation;
    }

    public String getAboutMe() {
        return aboutMe;
    }

    public List<String> getStages() {
        return stages;
    }

    public List<Language> getLanguages() {
        return languages;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public Photo getPhoto() {
        return photo;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public void setPhotoFileName(String photoFileName) {
        this.photoFileName = photoFileName;
    }

    public void setAdditionalPhoneNumber(String additionalPhoneNumber) {
        this.additionalPhoneNumber = additionalPhoneNumber;
    }

    public void setCareerBeginningDate(String careerBeginningDate) {
        this.careerBeginningDate = careerBeginningDate;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public void setSpecialityByEducation(String specialityByEducation) {
        this.specialityByEducation = specialityByEducation;
    }

    public void setHasPedagogicalEducation(boolean hasPedagogicalEducation) {
        this.hasPedagogicalEducation = hasPedagogicalEducation;
    }

    public void setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
    }

    public void setStages(List<String> stages) {
        this.stages = stages;
    }

    public void setLanguages(List<Language> languages) {
        this.languages = languages;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    public void setPhoto(Photo photo) {
        this.photo = photo;
    }

    public static class Language {
        private String language;
        private int level;

        public Language() {
        }

        public String getLanguage() {
            return language;
        }

        public int getLevel() {
            return level;
        }

        public void setLanguage(String language) {
            this.language = language;
        }

        public void setLevel(int level) {
            this.level = level;
        }
    }

    public static class Subject {
        private String subject;
        private boolean teachingNow;

        public Subject() {
        }

        public String getSubject() {
            return subject;
        }

        public boolean isTeachingNow() {
            return teachingNow;
        }

        public void setSubject(String subject) {
            this.subject = subject;
        }

        public void setTeachingNow(boolean teachingNow) {
            this.teachingNow = teachingNow;
        }
    }

    public static class Photo {
        private int id;
        private String storageFileName;
        private String originalFileName;
        private int size;
        private String type;
        private String location;
        private String url;

        public Photo() {
        }

        public int getId() {
            return id;
        }

        public String getStorageFileName() {
            return storageFileName;
        }

        public String getOriginalFileName() {
            return originalFileName;
        }

        public int getSize() {
            return size;
        }

        public String getType() {
            return type;
        }

        public String getLocation() {
            return location;
        }

        public String getUrl() {
            return url;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setStorageFileName(String storageFileName) {
            this.storageFileName = storageFileName;
        }

        public void setOriginalFileName(String originalFileName) {
            this.originalFileName = originalFileName;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public void setType(String type) {
            this.type = type;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}