package house;

public class Kitchen {
    public void showAppliances() {
        String[] appliances = {"Fridge", "Microwave", "Stove", "Mixer"};
        
        for (int i = 0; i < appliances.length; i++) {
            System.out.println("Appliance " + (i + 1) + ": " + appliances[i]);
        }

        String[] copiedAppliances = new String[appliances.length];
        for (int i = 0; i < appliances.length; i++) {
            copiedAppliances[i] = appliances[i];
        }

        System.out.println("Copied appliances:");
        for (int i = 0; i < copiedAppliances.length; i++) {
            System.out.println("Appliance " + (i + 1) + ": " + copiedAppliances[i]);
        }
    }
}
