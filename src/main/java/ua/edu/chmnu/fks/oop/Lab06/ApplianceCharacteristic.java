package ua.edu.chmnu.fks.oop.Lab06;

public abstract class ApplianceCharacteristic {
    private EfficiencyClass energyClass;
    private String[] features;

    public ApplianceCharacteristic(EfficiencyClass energyClass) {
        this.energyClass = energyClass;
    }

    public ApplianceCharacteristic(EfficiencyClass energyClass, String[] features) {
        this.energyClass = energyClass;
        this.features = features;
    }

    public void setEnergyClass(EfficiencyClass energyClass) {
        this.energyClass = energyClass;
    }

    public void setFeatures(String[] features) {
        this.features = features;
    }

    public EfficiencyClass getEnergyClass() {
        return energyClass;
    }

    public String[] getFeatures() {
        return features;
    }
}
