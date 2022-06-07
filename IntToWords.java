class IntToWords{
    public static String[] basicNumbers = {"One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
    public static String[] tens = {"Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
    public static String[] bigger = {"Hundred","Thousand","Million","Billion"};

    public static String ToWords(int i){
        //nums from 1 -> 2,147,483,647
        String number = "";
        String value = String.valueOf(i);
        int length = value.length();
        int[] input = new int[10];
        for (int j = 0; j <= length -1; j++){
            input[j] = value.charAt(j) - '0';
        }

        if (length == 10){
            number += basicNumbers[input[0]-1];
            number += "Billion";

        }

        if (i <= 19){
            number+= basicNumbers[i-1];
            return number;
        }
        else if (i <= 99){
            number += tenses(input);
            return number;
        }
        return null;
    }

    public static String hundredses(int[] input){
        String x = "";
        x += tens[input[0] - 2];
        x += " ";
        if(input[1] != 0){
            x += basicNumbers[input[1]-1];
        }
        return x;
    }

    public static String tenses(int[] input){
        String x = "";
        //deal with 00
        if (input[0]!= 0 && input[0]!= 1){
            x += tens[input[0] - 2];
            x += " ";
        }
        if(input[1] != 0){
            x += basicNumbers[input[1]-1];
        }
        return x;
    }
    public static void main(String[] args) {
        System.out.println(ToWords(88));
    }
}