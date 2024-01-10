import FMS.VDM;
import java.util.Scanner;

enum BloodPressureLevel {
  LOW_BLOOD_PRESSURE,
  NORMAL,
  ELEVATED,
  HBP_STAGE_1,
  HBP_STAGE_2,
  HYPERTENSIVE_CRISIS
}
enum SIGNAL { SILENT, VIBRATE, VIBRATE_AND_ALERT }
class AmbulatoryBloodPressureController {
  public String firstname, lastname;
  public int age;
  private int systolic, diastolic;
  private BloodPressureLevel currentBloodPressureLevel = null;
  private SIGNAL currentSignal = null;

  public final int MIN_BLOOD_PRESSURE_LEVEL = 0;
  public static final int MAX_BLOOD_PRESSURE_LEVEL = 400;

  public AmbulatoryBloodPressureController(
      String fname, String lname, int age) {
    this.firstname = fname;
    this.lastname = lname;
    this.age = age;
  }

  private boolean inRange(int val) {
    return val >= MIN_BLOOD_PRESSURE_LEVEL && val <= MAX_BLOOD_PRESSURE_LEVEL;
  }

  public void setInitialSystolicPressure(int pressureIn) {
    try {
      VDM.preTest(inRange(pressureIn));
    } catch (VDM.VDMPreconditionException e) {
      System.err.println("Precondition test failed: "
          + "Initial systolic Value given is out of Range");
    }
    this.systolic = pressureIn;
    try{
      VDM.invTest(this);
    }catch(Exception e) {
      System.err.println("Postcondition test failed: "
          + e.getMessage());
    }
  }

  public void setInitialDiastolicPressure(int pressureIn) {
    try {
      VDM.preTest(inRange(pressureIn));
    } catch (VDM.VDMPreconditionException e) {
      System.err.println("Precondition test failed: "
          + "Initial diastolic Value given is out of Range");
    }
    this.diastolic = pressureIn;
    try{
      VDM.invTest(this);
    }catch(Exception e) {
      System.err.println("Postcondition test failed: "
          + e.getMessage());
    }
  }

  public BloodPressureLevel changeSystolicPressure(int pressureIn) {
    try {
      VDM.preTest(inRange(pressureIn));
    } catch (VDM.VDMPreconditionException e) {
      System.err.println("Precondition test failed: " + e.getMessage());
    }
    this.systolic = pressureIn;
    try{
      VDM.invTest(this);
    }catch(Exception e) {
      System.err.println("Postcondition test failed: "
          + e.getMessage());
    }
    return determineBloodPressureLevel();
  }
  public BloodPressureLevel changeDiastolicPressure(int pressureIn) {
    try {
      VDM.preTest(inRange(pressureIn));
    } catch (VDM.VDMPreconditionException e) {
      System.err.println("Precondition test failed: " + e.getMessage());
    }
    this.diastolic = pressureIn;
   try{
      VDM.invTest(this);
    }catch(Exception e) {
      System.err.println("Postcondition test failed: "
          + e.getMessage());
    }
    return determineBloodPressureLevel();
  }

  public BloodPressureLevel getCurrentBloodPressureLevel() {
    try {
      VDM.preTest(currentBloodPressureLevel != null);
    } catch (VDM.VDMPreconditionException e) {
      System.err.println("Precondition test failed: "
          + "CurrentBloodPressue Level not Intialized");
    }
    try{
      VDM.invTest(this);
    }catch(Exception e) {
      System.err.println("Postcondition test failed: "
          + e.getMessage());
    }
    return currentBloodPressureLevel;
    
  }
  public SIGNAL getCurrentSignal() {
    try {
      VDM.preTest(currentSignal != null);
    } catch (VDM.VDMPreconditionException e) {
      System.err.println("Precondition test failed: "
          + "CurrentBloodPressue Level not Intialized");
    }
    try{
      VDM.invTest(this);
    }catch(Exception e) {
      System.err.println("Postcondition test failed: "
          + e.getMessage());
    }
    return currentSignal;
  }

  public BloodPressureLevel determineBloodPressureLevel() {
    if (systolic < 90 && diastolic < 60) {
      try {
        VDM.preTest(inRange(systolic) && inRange(diastolic));
      } catch (VDM.VDMPreconditionException e) {
        System.err.println("Precondition test failed: " + e.getMessage());
      }
      currentBloodPressureLevel = BloodPressureLevel.LOW_BLOOD_PRESSURE;
      try{
      VDM.invTest(this);
    }catch(Exception e) {
      System.err.println("Postcondition test failed: "
          + e.getMessage());
    }
      return currentBloodPressureLevel;
    } else if (systolic >= 90 && systolic <= 120 && diastolic >= 60
        && diastolic <= 80) {
      try {
        VDM.preTest(inRange(systolic) && inRange(diastolic));
      } catch (VDM.VDMPreconditionException e) {
        System.err.println("Precondition test failed: " + e.getMessage());
      }
      currentBloodPressureLevel = BloodPressureLevel.NORMAL;
      try{
      VDM.invTest(this);
    }catch(Exception e) {
      System.err.println("Postcondition test failed: "
          + e.getMessage());
    }
      return currentBloodPressureLevel;
    } else if (systolic > 120 && systolic <= 130 && diastolic <= 80) {
      try {
        VDM.preTest(inRange(systolic) && inRange(diastolic));
      } catch (VDM.VDMPreconditionException e) {
        System.err.println("Precondition test failed: " + e.getMessage());
      }
      currentBloodPressureLevel = BloodPressureLevel.ELEVATED;
      try{
      VDM.invTest(this);
    }catch(Exception e) {
      System.err.println("Postcondition test failed: "
          + e.getMessage());
    }
      return currentBloodPressureLevel;
    } else if (systolic > 130 && systolic <= 140 && diastolic > 80
        && diastolic <= 90) {
      try {
        VDM.preTest(inRange(systolic) && inRange(diastolic));
      } catch (VDM.VDMPreconditionException e) {
        System.err.println("Precondition test failed: " + e.getMessage());
      }
      currentBloodPressureLevel = BloodPressureLevel.HBP_STAGE_1;
      try{
      VDM.invTest(this);
    }catch(Exception e) {
      System.err.println("Postcondition test failed: "
          + e.getMessage());
    }
      return currentBloodPressureLevel;
    } else if (systolic > 140 && diastolic > 90) {
      try {
        VDM.preTest(inRange(systolic) && inRange(diastolic));
      } catch (VDM.VDMPreconditionException e) {
        System.err.println("Precondition test failed: " + e.getMessage());
      }
      currentBloodPressureLevel = BloodPressureLevel.HYPERTENSIVE_CRISIS;
      try{
      VDM.invTest(this);
    }catch(Exception e) {
      System.err.println("Postcondition test failed: "
          + e.getMessage());
    }
      return currentBloodPressureLevel;
    } else {
      try {
        VDM.preTest(inRange(systolic) && inRange(diastolic));
      } catch (VDM.VDMPreconditionException e) {
        System.err.println("Precondition test failed: " + e.getMessage());
      }
      currentBloodPressureLevel = BloodPressureLevel.HBP_STAGE_2;
      try{
      VDM.invTest(this);
    }catch(Exception e) {
      System.err.println("Postcondition test failed: "
          + e.getMessage());
    }
      return currentBloodPressureLevel;
    }
  }

  public SIGNAL determineSignal() {
    if (systolic < 90 && diastolic < 60) {
      try {
        VDM.preTest(inRange(systolic) && inRange(diastolic));
      } catch (VDM.VDMPreconditionException e) {
        System.err.println("Precondition test failed: " + e.getMessage());
      }
      currentSignal = SIGNAL.VIBRATE_AND_ALERT;
      try{
      VDM.invTest(this);
    }catch(Exception e) {
      System.err.println("Postcondition test failed: "
          + e.getMessage());
    }
      return currentSignal;
    } else if (systolic >= 90 && systolic <= 120 && diastolic >= 60
        && diastolic <= 80) {
      try {
        VDM.preTest(inRange(systolic) && inRange(diastolic));
      } catch (VDM.VDMPreconditionException e) {
        System.err.println("Precondition test failed: " + e.getMessage());
      }
      currentSignal = SIGNAL.SILENT;
      try{
      VDM.invTest(this);
    }catch(Exception e) {
      System.err.println("Postcondition test failed: "
          + e.getMessage());
    }
      return currentSignal;
    } else if (systolic > 120 && systolic <= 130 && diastolic <= 80) {
      try {
        VDM.preTest(inRange(systolic) && inRange(diastolic));
      } catch (VDM.VDMPreconditionException e) {
        System.err.println("Precondition test failed: " + e.getMessage());
      }
      currentSignal = SIGNAL.VIBRATE;
      try{
      VDM.invTest(this);
    }catch(Exception e) {
      System.err.println("Postcondition test failed: "
          + e.getMessage());
    }
      return currentSignal;
    } else if (systolic > 130 && systolic <= 140 && diastolic > 80
        && diastolic <= 90) {
      try {
        VDM.preTest(inRange(systolic) && inRange(diastolic));
      } catch (VDM.VDMPreconditionException e) {
        System.err.println("Precondition test failed: " + e.getMessage());
      }
      currentSignal = SIGNAL.VIBRATE_AND_ALERT;
      try{
      VDM.invTest(this);
    }catch(Exception e) {
      System.err.println("Postcondition test failed: "
          + e.getMessage());
    }
      return currentSignal;
    } else if (systolic > 140 && diastolic > 90) {
      try {
        VDM.preTest(inRange(systolic) && inRange(diastolic));
      } catch (VDM.VDMPreconditionException e) {
        System.err.println("Precondition test failed: " + e.getMessage());
      }
      currentSignal = SIGNAL.VIBRATE_AND_ALERT;
      try{
      VDM.invTest(this);
    }catch(Exception e) {
      System.err.println("Postcondition test failed: "
          + e.getMessage());
    }
      return currentSignal;
    } else {
      try {
        VDM.preTest(inRange(systolic) && inRange(diastolic));
      } catch (VDM.VDMPreconditionException e) {
        System.err.println("Precondition test failed: " + e.getMessage());
      }
      currentSignal = SIGNAL.VIBRATE_AND_ALERT;
      try{
      VDM.invTest(this);
    }catch(Exception e) {
      System.err.println("Postcondition test failed: "
          + e.getMessage());
    }
      return currentSignal;
    }
  }

  public int getSystolic() {
    try {
      VDM.preTest(systolic>MIN_BLOOD_PRESSURE_LEVEL);
    } catch (VDM.VDMPreconditionException e) {
      System.err.println("Precondition test failed: " + e.getMessage());
    }
    try{
      VDM.invTest(this);
    }catch(Exception e) {
      System.err.println("Postcondition test failed: "
          + e.getMessage());
    }
    return systolic;
  }
  public int getDiastolic() {
    try {
      VDM.preTest(diastolic>MIN_BLOOD_PRESSURE_LEVEL);
    } catch (VDM.VDMPreconditionException e) {
      System.err.println("Precondition test failed: " + e.getMessage());
    }
    try{
      VDM.invTest(this);
    }catch(Exception e) {
      System.err.println("Postcondition test failed: "
          + e.getMessage());
    }
    return diastolic;
  }
}
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter first name of patient: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter last name of patient: ");
        String lastName = scanner.nextLine();
        System.out.print("Enter age of patient: ");
        int age = scanner.nextInt();

        AmbulatoryBloodPressureController abpc =
                new AmbulatoryBloodPressureController(firstName, lastName, age);

        System.out.print("Enter initial systolic pressure: ");
        int initialSystolic = scanner.nextInt();
        abpc.setInitialSystolicPressure(initialSystolic);

        System.out.print("Enter initial diastolic pressure: ");
        int initialDiastolic = scanner.nextInt();
        abpc.setInitialDiastolicPressure(initialDiastolic);

        int choice;

        do {
            System.out.println("\n----- Patient Monitoring Menu -----");
            System.out.println("1. Change Systolic Pressure");
            System.out.println("2. Change Diastolic Pressure");
            System.out.println("3. Display Monitor Report");
            System.out.println("0. Exit");

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter new systolic pressure: ");
                    int newSystolic = scanner.nextInt();
                    abpc.changeSystolicPressure(newSystolic);
                    break;

                case 2:
                    System.out.print("Enter new diastolic pressure: ");
                    int newDiastolic = scanner.nextInt();
                    abpc.changeDiastolicPressure(newDiastolic);
                    break;

                case 3:
                    abpc.determineBloodPressureLevel();
                    abpc.determineSignal();

                    System.out.println("\n------------------------------------------------------------------------------------------------------------\n");
                    System.out.println("Display Monitor Report for " + abpc.firstname + " "
                            + abpc.lastname + "'s blood pressure rating: \n");
                    System.out.println(
                            "Name of patient: " + abpc.firstname + " " + abpc.lastname);
                    System.out.println("Age of patient: " + abpc.age);
                    System.out.println("Blood Pressure Rating: " + abpc.getSystolic() + "/"
                            + abpc.getDiastolic());
                    System.out.println(
                            "Blood Pressure Level: " + abpc.getCurrentBloodPressureLevel());
                    System.out.println("Signal: " + abpc.getCurrentSignal());
                    break;

                case 0:
                    System.out.println("Shutting Down the device. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }

        } while (choice != 0);
    }
}