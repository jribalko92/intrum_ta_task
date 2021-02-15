package utils.dictionaries;


import java.util.Map;

public class LVDictionary {

    public static final Map<String, String> lvDictionary = Map.of(
            "title", "Iebildumu un komentāru forma",
            "heading comment", "Lūdzu, korekti aizpildiet formu",
            "response dropdown", "Kā vēlos saņemt atbildi",
            "fields comments", "* Informējam, ka atbildi uz korekti aizpildītu iesniegumu sniegsim 30 dienu laikā.",
            "anonymous comment", "Intrum pieņem arī anonīmas sūdzības/pateicības, bet atbilde šajā gadījumā netiks sniegta.",
            "person data policy", "Lai iegūtu informāciju par to, kā mēs apstrādājam Jūsu personas datus un kādas ir Jūsu tiesības, skatieties šeit vai sazinieties ar mūsu datu aizsardzības speciālistu pa e-pastu LV@intrum.com",
            "mandatory error", "Lūdzu, aizpildiet lauku");


    public static String getDictionaryValue(String key) {
        return lvDictionary.get(key);
    }
}
