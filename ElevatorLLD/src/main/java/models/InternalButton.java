package models;

import java.util.List;
import java.util.Objects;

public class InternalButton {
    String emergencyButton;
    List<Integer> floors;

    public String getEmergencyButton() {
        return emergencyButton;
    }

    public void setEmergencyButton(String emergencyButton) {
        this.emergencyButton = emergencyButton;
    }

    public List<Integer> getFloors() {
        return floors;
    }

    public void setFloors(List<Integer> floors) {
        this.floors = floors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof InternalButton that)) return false;
        return Objects.equals(getEmergencyButton(), that.getEmergencyButton()) && Objects.equals(getFloors(), that.getFloors());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEmergencyButton(), getFloors());
    }
    public InternalButton() {
    }

    public InternalButton(String emergencyButton, List<Integer> floors) {
        this.emergencyButton = emergencyButton;
        this.floors = floors;
    }

}
