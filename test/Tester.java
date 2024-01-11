import java.util.Scanner;

import ABPM.AmbulatoryBloodPressureController;

public class Tester {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        AmbulatoryBloodPressureController abpc =
                new AmbulatoryBloodPressureController("John", "Doe", 62);

        int choice;

        do {
            System.out.println("\n----- Tester Menu -----");
            System.out.println("1. InitializingSystolicPressure_InvalidInput");
            System.out.println("2. InitializingSystolicPressure_ValidInput");
            System.out.println("3. InitializingDiastolicPressure_InvalidInput");
            System.out.println("4. InitializingDiastolicPressure_ValidInput");
            System.out.println("5. ChangingSystolicPressure_InvalidInput");
            System.out.println("6. ChangingSystolicPressure_ValidInput");
            System.out.println("7. ChangingDiastolicPressure_InvalidInput");
            System.out.println("8. ChangingDiastolicPressure_ValidInput");
            System.out.println("9. GetBloodPressureLevel_BeforeInitialization");
            System.out.println("10. GetSystolicPressure_AfterInitilization");
            System.out.println("11. GetSystolicPressure_BeforeInitialization");
            System.out.println("12. GetDiastolicPressure_AfterInitilization");
            System.out.println("13. GetDiastolicPressure_BeforeInitialization");
            System.out.println("14. DetermineBloodPressure_LOWBP && DetermineSignal_<ALERT_AND_VIBRATE>");
            System.out.println("15. DetermineBloodPressure_NORMAL && DetermineSignal_<SILENT>");
            System.out.println("16. DetermineBloodPressure_ELEVATED && DetermineSignal_<VIBRATE>");
            System.out.println("17. DetermineBloodPressure_HBPSTAGE1 && DetermineSignal_<ALERT_AND_VIBRATE>");
            System.out.println("18. DetermineBloodPressure_HBPSTAGE2 && DetermineSignal_<ALERT_AND_VIBRATE>");
            System.out.println("19. DetermineBloodPressure_HYPERTENSIVECRISIS && DetermineSignal_<ALERT_AND_VIBRATE>");
            System.out.println("0. Exit\n");

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Expected Output: Exception thrown and Systolic set to 0");
                    abpc.setInitialSystolicPressure(500);
                    System.out.println("Actual Output: "+abpc.getSystolic());
                    break;

                case 2:
                    System.out.println("Expected Output: Systolic set to 150");
                    abpc.setInitialSystolicPressure(150);
                    System.out.println("Actual Output: "+abpc.getSystolic());
                    break;

                case 3:
                    System.out.println("Expected Output: Exception thrown and Diastolic set to 0");
                    abpc.setInitialDiastolicPressure(450);
                    System.out.println("Actual Output: "+abpc.getDiastolic());
                    break;
                
                case 4:
                    System.out.println("Expected Output: Diastolic set to 100");
                    abpc.setInitialDiastolicPressure(100);
                    System.out.println("Actual Output: "+abpc.getDiastolic());
                    break;

                case 5:
                    System.out.println("Expected Output: Exception Thrown: Pre-condition Failed." + 
                            "Systolic does not Changed (0)");
                    abpc.changeSystolicPressure(410);
                    System.out.println("Actual Output: "+abpc.getSystolic());
                    break;

                case 6:
                    System.out.println("Expected Output: Systolic = 200");
                    abpc.changeSystolicPressure(200);
                    System.out.println("Actual Output: "+abpc.getSystolic());
                    break;
                
                case 7:
                    System.out.println("Expected Output: Exception Thrown: Pre-condition Failed." + 
                            "Diastolic does not Changed (0)");
                    abpc.changeDiastolicPressure(460);
                    System.out.println("Actual Output: "+abpc.getDiastolic());
                    break;

                case 8:
                    System.out.println("Expected Output: Systolic = 160");
                    abpc.changeDiastolicPressure(160);
                    System.out.println("Actual Output: "+abpc.getDiastolic());
                    break;

                case 9:
                    AmbulatoryBloodPressureController newone =new AmbulatoryBloodPressureController("John", "Doe", 62);
                    System.out.println("Expected Output: Exception Thrown: Pre-condition Failed.");
                    System.out.println("Actual Output: ");
                    newone.getCurrentBloodPressureLevel();
                    break;

                case 10:
                    AmbulatoryBloodPressureController newten =new AmbulatoryBloodPressureController("John", "Doe", 62);
                    System.out.println("Expected Output: Systolic is initialized. " + " And " + " systolic=70" + "");
                    newten.setInitialSystolicPressure(70);
                    System.out.println("Actual Output: "+newten.getSystolic());
                    break;
                
                case 11:
                    AmbulatoryBloodPressureController newtwo =new AmbulatoryBloodPressureController("John", "Doe", 62);
                    System.out.println("Exception Thrown: Pre-condition Failed.");
                    System.out.println("Actual Output: "+newtwo.getSystolic());
                    break;

                case 12:
                    AmbulatoryBloodPressureController newtw =new AmbulatoryBloodPressureController("John", "Doe", 62);
                    System.out.println("Expected Output: Diastolic  is initialized. " + " And " + " Diastolic =70" + "");
                    newtw.setInitialDiastolicPressure(70);
                    System.out.println("Actual Output: "+newtw.getDiastolic());
                    break;
                
                case 13:
                    AmbulatoryBloodPressureController newthree =new AmbulatoryBloodPressureController("John", "Doe", 62);
                    System.out.println("Expected Output: Exception Thrown: Pre-condition Failed.");
                    System.out.println("Actual Output: "+newthree.getDiastolic());
                    break;
                
                case 14:
                    AmbulatoryBloodPressureController h5 =new AmbulatoryBloodPressureController("John", "Doe", 62);
                    System.out.println("Expected Output: bloodPressureOut = <LOW_BLOOD_PRESSURE> and Signal: <ALERT_AND_VIBRATE>");
                    h5.setInitialSystolicPressure(150);
                    h5.setInitialDiastolicPressure(100);
                    h5.changeDiastolicPressure(55);
                    h5.changeSystolicPressure(85);
                    System.out.println("Actual Output: "+h5.determineBloodPressureLevel()+" "+h5.determineSignal());
                    break;

                case 15:
                    AmbulatoryBloodPressureController h4 =new AmbulatoryBloodPressureController("John", "Doe", 62);
                    System.out.println("Expected Output: bloodPressureOut = <NORMAL> and Signal: <SILENT>");
                    h4.setInitialSystolicPressure(150);
                    h4.setInitialDiastolicPressure(100);
                    h4.changeDiastolicPressure(70);
                    h4.changeSystolicPressure(100);
                    System.out.println("Actual Output: "+h4.determineBloodPressureLevel()+" "+h4.determineSignal());
                    break;
                
                case 16:
                    AmbulatoryBloodPressureController h3 =new AmbulatoryBloodPressureController("John", "Doe", 62);
                    System.out.println("Expected Output: bloodPressureOut = <ELEVATED> and Signal: <VIBRATE>");
                    h3.setInitialSystolicPressure(150);
                    h3.setInitialDiastolicPressure(100);
                    h3.changeDiastolicPressure(78);
                    h3.changeSystolicPressure(121);
                    System.out.println("Actual Output: "+h3.determineBloodPressureLevel()+" "+h3.determineSignal());
                    break;

                case 17:
                    AmbulatoryBloodPressureController h2 =new AmbulatoryBloodPressureController("John", "Doe", 62);
                    System.out.println("Expected Output: bloodPressureOut = <HBP_STAGE1> and Signal: <ALERT_AND_VIBRATE>");
                    h2.setInitialSystolicPressure(150);
                    h2.setInitialDiastolicPressure(100);
                    h2.changeDiastolicPressure(85);
                    h2.changeSystolicPressure(135);
                    System.out.println("Actual Output: "+h2.determineBloodPressureLevel()+" "+h2.determineSignal());
                    break;

                case 18:
                    AmbulatoryBloodPressureController htwo =new AmbulatoryBloodPressureController("John", "Doe", 62);
                    System.out.println("Expected Output: bloodPressureOut = <HBP_STAGE2> and Signal: <ALERT_AND_VIBRATE>");
                    htwo.setInitialSystolicPressure(145);
                    htwo.setInitialDiastolicPressure(85);
                    System.out.println("Actual Output: "+htwo.determineBloodPressureLevel()+" "+htwo.determineSignal());
                    break;

                case 19:
                    AmbulatoryBloodPressureController h1 =new AmbulatoryBloodPressureController("John", "Doe", 62);
                    System.out.println("Expected Output: bloodPressureOut = <HYPERTENSIVECRISIS> and Signal: <ALERT_AND_VIBRATE>");
                    h1.setInitialSystolicPressure(150);
                    h1.setInitialDiastolicPressure(100);
                    h1.changeDiastolicPressure(100);
                    h1.changeSystolicPressure(145);
                    System.out.println("Actual Output: "+h1.determineBloodPressureLevel()+" "+h1.determineSignal());
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