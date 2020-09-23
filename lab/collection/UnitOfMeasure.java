package lab.collection;

public enum UnitOfMeasure {
    KILOGRAMS,
    METERS,
    MILLIGRAMS;

    public static UnitOfMeasure getUnit(String pr){
        switch (pr.toUpperCase().trim()){
            case "KILOGRAMS" :
                return KILOGRAMS;
            case "METERS" :
                return METERS;
            case "MILLIGRAMS" :
                return MILLIGRAMS;
            default:
                return null;

        }
    }

}
