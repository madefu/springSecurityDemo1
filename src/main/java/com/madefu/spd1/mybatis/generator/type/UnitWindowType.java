package com.madefu.spd1.mybatis.generator.type;

public class UnitWindowType {

    private String windowTreatmentType;

    public String getWindowTreatmentType() {
        return windowTreatmentType;
    }

    public void setWindowTreatmentType(String windowTreatmentType) {
        this.windowTreatmentType = windowTreatmentType;
    }

    @Override
    public String toString() {
        return "UnitWindowType{" +
            "windowTreatmentType='" + windowTreatmentType + '\'' +
            '}';
    }

}
