package com.example.quizmvp.domain;

import com.example.quizmvp.R;
import com.example.quizmvp.data.model.MyCategory;
import com.example.quizmvp.data.model.MyQuestionData;
import com.example.quizmvp.data.model.MyResultData;
import com.example.quizmvp.data.model.SubjectData;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AppController {
    private static AppController instance;
    private MyCategory selectCategoryEnum;
    private final List<MyQuestionData> questionDataENG = new ArrayList<>();
    private final List<MyQuestionData> questionDataHISTORY = new ArrayList<>();
    private final List<MyQuestionData> questionDataLIBRARY = new ArrayList<>();
    private final List<MyQuestionData> questionDataMATH = new ArrayList<>();
    private final List<SubjectData> subjectDataList = new ArrayList<>();
    private MyResultData resultData;


    private void loadSubjects() {
        subjectDataList.add(
                new SubjectData(
                        "Ingiliz Tili",
                        R.drawable.bg_gradient3,
                        R.drawable.english,
                        MyCategory.ENG,
                        questionDataENG.size()
                )
        );
        subjectDataList.add(
                new SubjectData(
                        "Matematika",
                        R.drawable.bg_gradient4,
                        R.drawable.math,
                        MyCategory.MATH,
                        questionDataMATH.size()
                )
        );
        subjectDataList.add(
                new SubjectData(
                        "Tarix",
                        R.drawable.bg_gradient1,
                        R.drawable.history,
                        MyCategory.HISTORY,
                        questionDataHISTORY.size()
                )
        );
        subjectDataList.add(
                new SubjectData(
                        "Adabiyot",
                        R.drawable.bg_gradient2,
                        R.drawable.library,
                        MyCategory.LIBRARY,
                        questionDataLIBRARY.size()
                )
        );
    }

    private AppController() {
        loadSubjects();
    }

    public List<SubjectData> getSubjectDataList() {
        return subjectDataList;
    }

    public static AppController getInstance() {
        if (instance == null) {
            instance = new AppController();
        }
        return instance;
    }

    public void setSelectCategory(MyCategory selectCategoryEnum) {
        this.selectCategoryEnum = selectCategoryEnum;
    }

    public List<MyQuestionData> getQuestionData() {
        switch (selectCategoryEnum) {
            case ENG: {
                Collections.shuffle(questionDataENG);
                return questionDataENG;
            }
            case MATH: {
                Collections.shuffle(questionDataMATH);
                return questionDataMATH;
            }
            case HISTORY: {
                Collections.shuffle(questionDataHISTORY);
                return questionDataHISTORY;
            }
            case LIBRARY: {
                Collections.shuffle(questionDataLIBRARY);
                return questionDataLIBRARY;
            }
        }
        return null;
    }

    public MyCategory getSelectCategoryEnum() {
        return this.selectCategoryEnum;
    }

    public int getBackgroundGradient() {
        for (int i = 0; i < subjectDataList.size(); i++) {
            if (subjectDataList.get(i).type == selectCategoryEnum) {
                return subjectDataList.get(i).bgResId;
            }
        }
        return R.drawable.bg_gradient1;
    }

    {
        questionDataENG.add(new MyQuestionData(
                "Who invented a light bulb ?",
                "Thomas Edison",
                "Alexander Bell", "Steve Jobs", "Thomas Moore", "Thomas Edison"
        ));

        questionDataENG.add(new MyQuestionData(
                "Who invented a telescope ?",
                "Galileo galilei",
                "Galileo galilei", "Steve jobs", "Thomas Edson", "Thomas Moore"
        ));

        questionDataENG.add(new MyQuestionData(
                "A Person .... who  cuts down trees or branches. Who is this ?",
                "Woodcutter",
                "Inventor", "Worker", "Housewife", "Woodcutter"
        ));

        questionDataENG.add(new MyQuestionData(
                "You use …..to  take photographs.",
                "A camera",
                "A camera", "A dictionary", "A book", "A radio"
        ));
        questionDataENG.add(new MyQuestionData(
                "You use … to make better writing.",
                "The teacher's feedback",
                "A  camera", "A  book", "A dictionary", "The teacher's feedback"
        ));
        questionDataENG.add(new MyQuestionData(
                "What motivates the woodcutter to do his best ?",
                "Payment and working environment",
                "Payment and working environment", "Nature and payment", "Trees and nature", "Condition and trees"
        ));
        questionDataENG.add(new MyQuestionData(
                "His family was____ of his attempts to be a writer.",
                "Supportive",
                "Contribute", "Self-assessment", "absence", "Supportive"
        ));
        questionDataENG.add(new MyQuestionData(
                "He is only seventeen,but he has enormous ________",
                "Self-confidence",
                "Self-confidence", "Self-evaluation", "Consult", "audience"
        ));
        questionDataENG.add(new MyQuestionData(
                "Who contributed to science ?",
                "Millan Karki",
                "Millan Karki", "Fraser  Doherty", "Jordan Romero", "Thomas Edison"
        ));
        questionDataENG.add(new MyQuestionData(
                "Accident is the name of the greatest of all inventors.",
                "Mark twain",
                "Mark twain", "Daniel Defoe", "Thomas Moore", "Thomas Edison"
        ));
    }

    {
        questionDataLIBRARY.add(new MyQuestionData(
                "Asqad Muxtorning bir xil janrda yozilgan asarlarini toping.",
                "«Bo‘ronlarda bordek halovat», «Jar yoqasidagi chaqmoq»",
                "«Bo‘ronlarda bordek halovat», «Jar yoqasidagi chaqmoq»",
                "«Davr mening taqdirimda», «Samandar»",
                "\"Tilak\", \"Qorako‘z majnun\"",
                "\"Ikki eshik orasi\", \"Tushda kechgan umrlar\""
        ));
        questionDataLIBRARY.add(new MyQuestionData(
                "Mashrabning asl ismi − Boborahim. Mashrab− uning taxallusi. Mashrab taxallusining ma’nosi qaysi javobda berilgan ?",
                "Ishq sharobini ichgan",
                "Ishq sharobini ichgan",
                "Tug‘ma iste’dod",
                "G‘oyibona oshiq",
                "Haq va haqiqat, adolat yo‘lida navo qiluvchi"
        ));
        questionDataLIBRARY.add(new MyQuestionData(
                "Tog‘ay Murodning qaysi asarida qadimiy xalq musobaqasi − kurash san’atining butun qonun-qoidalari eng mayda jihatlarigacha batafsil tasvirlangan ?",
                "\"Yulduzlar mangu yonadi\"",
                "\"Oydinda yurgan odamlar\"",
                "\"Yulduzlar mangu yonadi\"",
                "\"Ot kishnagan oqshom\"",
                "\"Otamdan qolgan dalalar\""
        ));
        questionDataLIBRARY.add(new MyQuestionData(
                "Italiyada va boshqa mamlakatlarda mohir ertakchi adib sifatida tanilgan, \"Chippolinoning sarguzashtlari\", \"Telefonda aytilgan ertaklar\", \"Jelsamino yolg‘onchilar mamlakatida\" kabi hikoyalar turkumini yaratgan yozuvchini aniqlang.",
                "Janni Rodari",
                "Janni Rodari",
                "Hans Kristian Andersen",
                "Antuan de Sent-Ekzyuperi",
                "Jonatan Svift"
        ));
        questionDataLIBRARY.add(new MyQuestionData(
                "Alisher Navoiyning “Hayrat ul-abror” dostoni haqidagi ma’lumotni aniqlang.",
                "Ushbu asar falsafiy-ta’limiy doston bo‘lib, uning “Salotin bobida” nomli uchinchi maqolatida adib adolat haqidagi qarashlarini ifoda etadi.",
                "Ushbu asar falsafiy-ta’limiy doston bo‘lib, uning “Salotin bobida” nomli uchinchi maqolatida adib adolat haqidagi qarashlarini ifoda etadi.",
                "Ushbu doston ishqiy-sarguzasht xarakterga ega. Bu asarni muallif “shavq dostoni” deb ataydi.",
                "Ushbu asar 3 qismga bo‘linadi. Uning qismlaridan biri har xil odamlarning fe’l-atvori va ahvoli haqidadir.",
                "Ushbu asarda ijodkor turk (o‘zbek) va sort (fors) tillarini solishtirib, o‘z ona tilining tuganmas imkoniyatlarini ilmiy asoslab beradi."
        ));
        questionDataLIBRARY.add(new MyQuestionData(
                "Badiiy adabiyotning qanday turlari mavjud ?",
                "Epik,lirik,drammatik",
                "Epik,lirik,drammatik",
                "Roman,hikoya,povest",
                "G'azal,tuyuq ,qit'a",
                "Ertak,doston,she'r"
        ));
        questionDataLIBRARY.add(new MyQuestionData(
                "Lirik turga mansub asarlar berilgan qatorni belgilang.",
                "G'azal,tuyuq ,qit'a",
                "G'azal,tuyuq ,qit'a",
                "Roman,hikoya,povest",
                "Ertak,doston,she'r",
                "Doston,maqol,latifa, topishmoq"
        ));
        questionDataLIBRARY.add(new MyQuestionData(
                "Go'ro'g'li turkumiga mansub qancha dostonlar mavjud ?",
                "60dan ortiq",
                "100dan ortiq",
                "70dan ortiq",
                "40dan ortiq",
                "60dan ortiq"
        ));
        questionDataLIBRARY.add(new MyQuestionData(
                "Mirg'azab so'zining ma'nosi berilgan qatorni belgilang",
                "Jazo beruvchilarning boshlig'i",
                "Jazo beruvchilarning boshlig'i",
                "Otni suyagidan biluvchi",
                "Munajjim",
                "Hayvon boquvchi"
        ));
        questionDataLIBRARY.add(new MyQuestionData(
                "\"Bibi Hiloldan sohibqiron chiqadi,ekan, o'ldiramiz,kuydiramiz\",degan fikrga kelgan  shoh kim ?",
                "Shohdorxon",
                "Shohdorxon",
                "Odilxon",
                "Rustambek",
                "Holmon shoh"
        ));
    }

    {
        questionDataHISTORY.add(
                new MyQuestionData(
                        "Piromidalar matni marhumlar kitobi asari qaysi xalqqa tegishli ?",
                        "Misr",
                        "Misr",
                        "Falastin",
                        "Turkmaniston",
                        "Yunoniston"
                )
        );
        questionDataHISTORY.add(
                new MyQuestionData(
                        "1876-yilda tugatilgan davlatni aniqlang.",
                        "Qo'qon xonligi",
                        "Qo'qon xonligi",
                        "Xorazm xonligi",
                        "Buxoro amirligi",
                        "Xiva xonligi"
                )
        );
        questionDataHISTORY.add(
                new MyQuestionData(
                        "Amir Temur 1390-yili qayerni bosib olgan ?",
                        "Mug'uliston",
                        "Mug'uliston",
                        "Turkmaniston",
                        "O'rta osiyo",
                        "Hindiston"
                )
        );
        questionDataHISTORY.add(
                new MyQuestionData(
                        "Buхоrо аmirligini mа’muriy bоshkаruv tizimidаgi bulinishni аniklаng ?",
                        "Vilоyat bеklik Аmlоk",
                        "Vilоyat bеklik Аmlоk",
                        "Vilоyat tumаn",
                        "Vilоyat tumаn Bеklik",
                        "Tumаn Bеklik Аmlоk"
                )
        );
        questionDataHISTORY.add(
                new MyQuestionData(
                        "Аntаntа tuzilgаn sаnаni аniklаng ?",
                        "1904 y аprеl",
                        "1904 y аprеl",
                        "1904 y mаy",
                        "1906 y аvgust",
                        "1907 y аvgust"
                )
        );
        questionDataHISTORY.add(
                new MyQuestionData(
                        "Rоssiya tаrkibidа Turkistоn muхtоriyatini tаshkil etish gоyasi kаysi yigindа оldingа surilgаn ?",
                        "Butun itfоk musulmоnlаr kuriltоyi 1917 y аprеl",
                        "Butun itfоk musulmоnlаr kuriltоyi 1917 y аprеl",
                        "Shurоi islоmiyat 1917 y mаrt",
                        "Itfоki muslimi 1917 y sеntyabr",
                        "Shurоi ulаmо 1917 y оktyabr"
                )
        );
        questionDataHISTORY.add(
                new MyQuestionData(
                        "Jаditchilаr оrаsidа  1 оliy mа’lumоtli  Uzbеk аdvоkаti bulgаn jаditchini аniklаng ?",
                        "Аsаdullо хujа ugli Ubаydullо хujа",
                        "Аsаdullо хujа ugli Ubаydullо хujа",
                        "G’itrаt",
                        "Bехbudiy",
                        "Munаvvаr kоri"
                )
        );
        questionDataHISTORY.add(
                new MyQuestionData(
                        "1-jахоn urushidа «Vеrdеn»kirgini nоmini оlgаn jаng sаnаsini аniklаng ?",
                        "1916 y fеvrаl, dеkаbr",
                        "1916 y fеvrаl, dеkаbr",
                        "1916 y fеvrаl , mаy",
                        "1915 y fеvrаl dеkаbr",
                        "1915 y sеntyabr dеkаbr"
                )
        );
        questionDataHISTORY.add(
                new MyQuestionData(
                        "Turkistоn muхtоriyati tuzilgаn 1917 yil 27 nоyabr kunini Milliy lаylаt-ul kаdrimiz dеb аtаgаn kim ?",
                        "G’itrаt",
                        "G’itrаt",
                        "Bехbudiy",
                        "Munаvvаr kоri",
                        "Niyoziy"
                )
        );
        questionDataHISTORY.add(
                new MyQuestionData(
                        "18 аsrning 20-30 yillаridа Аngiliyadа...",
                        "Sаvdо-sоtiq, хunаrmаndchilik tеz rivоjlаndi",
                        "Kirоl Gеnriх tахtdаn ахdаrildi",
                        "Sаvdо-sоtiq, хunаrmаndchilik tеz rivоjlаndi",
                        "Оlivеr Krоmvеl tахtgа utirdi",
                        "Sоliklаr kupаydi"
                )
        );
    }

    {
        questionDataMATH.add(
                new MyQuestionData(
                        "f(x)=1/x funksiya grafigiga x0=1 absissali nuqtada o`tkazilgan urinma bilan Ox o`qi orasidagi burchakni toping ?",
                        "–π/4",
                        "π/2",
                        "–π/4",
                        "π/3",
                        "–π/6"
                )
        );
        questionDataMATH.add(
                new MyQuestionData(
                        "Tenglamalar sistemasining 1-tenglamasi sin(x)∙cos(y)=-1/3    2-tenglamasi cosx∙siny=2/3 Ctg(x-y)= ?",
                        "0",
                        "0",
                        "1",
                        "-0.5",
                        "0.5"
                )
        );
        questionDataMATH.add(
                new MyQuestionData(
                        "Shar radiusi 6  ga teng. Radius uchidan u bilan 30º burchak tashkil qiluvchi tekislik o`tkazilgan. Shra bilan tekislik hosil qilgan kesimning yuzini toping ?",
                        "27π",
                        "27π",
                        "8π",
                        "64π",
                        "25π"
                )
        );
        questionDataMATH.add(
                new MyQuestionData(
                        "ABC uchburchakka ichki chizilgan aylanaga o`tkazilgan urinma BC va AC tomonlarni mos ravishta M va N nuqtalarda kesib o`tadi BC=5 AC=6 AB=7 bo`lsa MNC uchburchak perimetri ?",
                        "4",
                        "4",
                        "5",
                        "3",
                        "4.8"
                )
        );
        questionDataMATH.add(
                new MyQuestionData(
                        "Tomonlari 1,2,3,4 bo`lgan to`rtburchakka ichki tashqi aylana chizilgan  uning kichik dioganalini toping.",
                        "√55/√7",
                        "√55/√7",
                        "2.5",
                        "2√2",
                        "√140/√11"
                )
        );
        questionDataMATH.add(
                new MyQuestionData(
                        "Muntazam to`rtburchakli prizma asosining tomoni 3 , balandligi 4, prizmaning paralell yon yoqlarining o`zaro ayqash dioganallari orasidagi o`tkir burchakni toping ?",
                        "arcsin0.96",
                        "arcsin0.96",
                        "arccos 0,98",
                        "arctg 0,06",
                        "arccos 0,66"
                )
        );
        questionDataMATH.add(
                new MyQuestionData(
                        "Karim uyida 14 bet matn terib, 8ta imloviy xatoga yo’l qo’ydi. Agar 1 betda o’rtacha 380 ta so’z bo’lsa,Karim 100ta so’z terganda o’rtacha qancha xato qiladi?",
                        "0,15",
                        "0,15",
                        "1,5",
                        "0,5",
                        " 0,25"
                )
        );
        questionDataMATH.add(
                new MyQuestionData(
                        "f(x) = x4 − 8x2 + 3 funksiyaning [-4;1] kesmadagi eng kata qiymatini toping",
                        "131",
                        "131",
                        "-13",
                        "-4",
                        "13"
                )
        );
        questionDataMATH.add(
                new MyQuestionData(
                        "Moddiy nuqta S(t)=5t3+3t2+2t+4 qonuniyat bilan harakatlanayotgan jismning t=2 sekunddagi tezliginitoping.",
                        "74",
                        "74",
                        "70",
                        "60",
                        "84"
                )
        );
        questionDataMATH.add(
                new MyQuestionData(
                        "y=-3x3+2x2-4x+5 funksiyaga x0=-1 nuqtada o’tkazilgan urinma tenglamasining burchak koeffitsiyentinitoping.",
                        "-17",
                        "-17",
                        "17",
                        "-13",
                        "15"
                )
        );
    }

    public String getSubjectName() {
        for (int i = 0; i < subjectDataList.size(); i++) {
            if (subjectDataList.get(i).type == selectCategoryEnum) {
                return subjectDataList.get(i).name;
            }
        }
        return "";
    }

    public void setResult(int correctAnswerCount, int currentTest, int testCount) {
        resultData = new MyResultData(correctAnswerCount, currentTest, testCount);
    }

    public MyResultData getResultData() {
        return resultData;
    }
}
