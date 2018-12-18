package string.calculator;

/**
 * Simple string calculator
 * @author Simone Debrowney
 */
public class StringCalculator { 
    /**
     * Add method
     * @param numbers to be calculated
     * @return total value, 0 if empty
     */
    public int Add (String numbers){
        //check if input is empty
        if (numbers == null || "".equals(numbers)) {
            return 0;
        }
        
        //deletes all \n from string
        String numReplace = numbers.replaceAll("\n", "");
        
        //split string 
        String array[] = numReplace.split(",");
        
        int total = 0;
        
        //parse through array
        for (int i=0; i < array.length; i++) {
            try {
                //check for negative int
                if (Integer.parseInt(array[i]) < 0){
                    throw new IllegalArgumentException("Negatives not allowed " + array[i] + ". ");
                }
                
                //add to total
                else { 
                    total+= Integer.parseInt(array[i]);
                }
            } 
            catch (IllegalArgumentException ex){
                    System.out.println(ex.getMessage());
            }
        }
        
        return total;
    }
    
    /**
     * Custom delimiter add method
     * @param numbers to be calculated
     * @return total value, 0 if empty
     */
    public int AddDelimiter (String numbers){
        //check if input is empty
        if (numbers == null || "".equals(numbers)) {
            return 0;
        }
        
        //delete \n and // from string
        String numR = numbers.replaceAll("\n", "");
        String numRpl = numR.replaceAll("//", "");
        
        //get demiliter from string
        char del = numRpl.charAt(0);
        String delimiter = String.valueOf(del);   

        //use string to split delimiter
        String array[] = numRpl.split("\\" + delimiter);
        
        int total = 0;
        
        //parse through array 
        for (int i=1; i < array.length; i++) {
            try {
                //check for negative int
                if (Integer.parseInt(array[i]) < 0){
                    throw new IllegalArgumentException("Negatives not allowed " + array[i] + ". ");
                }
                
                //add to total
                else { 
                    total+= Integer.parseInt(array[i]);
                }
            } 
            catch (IllegalArgumentException ex){
                    System.out.println(ex.getMessage());
            }
        }
        
        return total;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        StringCalculator strCal = new StringCalculator();
        
        //test standard
        String string1 = "1,2,5";
        System.out.print("Testing standard input with " + string1 + ".\n");
        System.out.print("Expected output should be 8.\n");
        int test = strCal.Add(string1);
        System.out.print("Actual output is " + test + ".\n");
        
        //test empty string
        String empty = "";
        System.out.print("\nTesting empty string with " + empty + ".\n");
        System.out.print("Expected output should be 0.\n");
        int testEmpty = strCal.Add(empty);
        System.out.print("Actual output is " + testEmpty + ".\n");
         
        //test input with new line
        String string3 = "1\n,2,3";
        System.out.print("\nTesting new line input with " + string3 + ".\n");
        System.out.print("Expected output should be 6.\n");
        int nl = strCal.Add(string3);
        System.out.print("Actual output is " + nl + ".\n");
        
        //test negative
        String string4 = "-1,2,-5";
        System.out.print("\nTesting negative input with " + string4 + ".\n");
        System.out.print("Expected output should be 2.\n");
        int negative = strCal.Add(string4);
        System.out.print("Actual output is " + negative + ".\n");
        
        //test custom delimiter
        String string5 = "//;\n1;3;4";
        System.out.print("\nTesting custom delimiter input with " + string5 + ".\n");
        System.out.print("Expected output should be 8.\n");
        int custom = strCal.AddDelimiter(string5);
        System.out.print("Actual output is " + custom + ".\n");
        
        //test custom delimiter
        String string6 = "//$\n1$2$3";
        System.out.print("\nTesting custom delimiter input with " + string6 +".\n");
        System.out.print("Expected output should be 6.\n");
        int custom2 = strCal.AddDelimiter(string6);
        System.out.print("Actual output is " + custom2 + ".\n");
        
        //test custom delimiter
        String string7 = "//@\n2@3@8";
        System.out.print("\nTesting custom delimiter input with " + string7 +".\n");
        System.out.print("Expected output should be 13.\n");
        int custom3 = strCal.AddDelimiter(string7);
        System.out.print("Actual output is " + custom3 + ".\n");
        
        //test custom delimiter
        String string8 = "//;\n-1;3;4";
        System.out.print("\nTesting custom delimiter input with " + string8 + ".\n");
        System.out.print("Expected output should be 7.\n");
        int custom4 = strCal.AddDelimiter(string8);
        System.out.print("Actual output is " + custom4 + ".\n");
    }
    
}


