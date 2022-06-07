class IntToWords{
    public static String[] basicNumbers = {"One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
    public static String[] tens = {"Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};

    public static String ToWords(int i){
        //nums from 1 -> 2,147,483,647
        if (i == 0){
            return "Zero";
        }
        String number = "";
        String value = String.valueOf(i);
        int length = value.length();
        int[] input = new int[10];
        for (int j = 0; j <= length -1; j++){
            input[j] = value.charAt(j) - '0';
        }

        if (length == 10){
            number += basicNumbers[input[0]-1];
            number += " Billion";
            if (Integer.valueOf(value.substring(1)) != 0){
                number += " ";
                number += ToWords(Integer.valueOf(value.substring(1)));
            }
        }
        else if(length >= 7 && length <=9){
            int a = length - 7;
            number += ToWords(Integer.valueOf(value.substring(0,a+1)));
            number += " Million";
            if (Integer.valueOf(value.substring(a+1)) != 0){
                number += " ";
                number += ToWords(Integer.valueOf(value.substring(a+1)));
            }
        }
        else if(length >= 4 && length <=6){
            int a = length - 4;
            number += ToWords(Integer.valueOf(value.substring(0,a+1)));
            number += " Thousand";
            if (Integer.valueOf(value.substring(a+1)) != 0){
                number += " ";
                number += ToWords(Integer.valueOf(value.substring(a+1)));
            }
        }
        else if(length == 3){
            number += basicNumbers[input[0]-1];
            number += " Hundred";
            if (Integer.valueOf(value.substring(1)) != 0){
                number += " ";
                number += ToWords(Integer.valueOf(value.substring(1)));
            }
        }

        if (i <= 19){
            number+= basicNumbers[i-1];
        }
        else if (i <= 99){
            number += tenses(input);
        }
        
        return number;
    }

    public static String tenses(int[] input){
        String x = "";
        //deal with 00
        if (input[0]!= 0 && input[0]!= 1){
            x += tens[input[0] - 2];
        }
        if(input[1] != 0){
            x += " ";
            x += basicNumbers[input[1]-1];
        }
        return x;
    }
    public static void main(String[] args) {
        System.out.println(ToWords(355000));
    }
}