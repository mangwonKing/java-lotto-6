package controller;

import camp.nextstep.edu.missionutils.Console;
import model.Lotto;
import model.Purchase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserInput {
    //사용자 인풋을 담당하는 클래스
    //객체 생성이 필요 없다.

    public static int purchasePrice(){
        int price;
        try {
            price = Integer.parseInt(Console.readLine());
        }catch (Exception e){
            throw new IllegalArgumentException("[ERROR] 금액은 숫자만 가능합니다.");
        }
        return price;
    }

    public static List<Integer> prizeNumber(){
        String inputNumber = Console.readLine();
        List<String> strPrizeNumbers = Arrays.asList(inputNumber.split(","));
        List<Integer> prizeNumbers = new ArrayList<>();
        for(String prize : strPrizeNumbers){
            int number = Integer.parseInt(prize);
            validateNumber(number);
            prizeNumbers.add(number);
        }
        Lotto.duplicateCheck(prizeNumbers);
        Lotto.validate(prizeNumbers);

        return prizeNumbers;
    }
    public static int bonusNumber(){
        int bonus = Integer.parseInt(Console.readLine());
        validateNumber(bonus);
        return bonus;
    }

    static void validateNumber(int number){
        if(number < 1 || number > 45){
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }
}
