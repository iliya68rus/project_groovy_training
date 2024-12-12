package model

class PersonResponse {
    private String fullName

    PersonResponse(String fullName) {
        this.fullName = fullName
    }

    String getFullName() {
        return fullName
    }
}
