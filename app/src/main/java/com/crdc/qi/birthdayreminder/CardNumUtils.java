package com.crdc.qi.birthdayreminder;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by qi on 2017/8/26.
 */

public class CardNumUtils {

    public static final String CARD_REG = "(^[1-9]\\d{5}(?<year>[1-9]\\d{3})(?<month>((0\\d)|(1[0-2])))(?<day>(([0|1|2]\\d)|3[0-1]))((\\d{4})|\\d{3}[Xx])$)";

    public CardBirthday getYMDFormCardNum(String cardNum) {
        Pattern pattern = Pattern.compile(CARD_REG);
        if (pattern.matcher(cardNum).matches()) {
            Matcher matcher = pattern.matcher(cardNum);
            String year = matcher.group(2);
            String month = matcher.group(3);
            String day = matcher.group(7);
            return new CardBirthday(Integer.valueOf(year),
                    Integer.valueOf(month), Integer.valueOf(day));
        }
        return CardBirthday.DEFAULT;
    }
}
