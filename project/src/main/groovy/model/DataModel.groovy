package model

class DataModel {
    private String field1
    private String field2

    DataModel(String field1, String field2) {
        this.field1 = field1
        this.field2 = field2
    }

    String getField1() {
        return field1
    }

    String getField2() {
        return field2
    }
}
