// Pancu Robert George 324CA

        Punctul de intrare in program se realizeaza in clasa main, unde se efectueaza si citirea
    datelor de intrare din fisierele cu format JSON. Pentru a realiza citirea datelor am folosit
    ObjectMapper() din biblioteca Jackson care mapeaza elementele din fisier cu campurile din 
    clasa de input pe care am creeat-o cu cu campurile specifice. Aceasta clasa stocheaza datele
    citite si pe urma initializeaza baza de date pe care voi lucra mai departe. Clasele ajutatoare
    precum AnnualChangeData, ChildData, ChildUpdateData, GiftData si InitialData toate fac parte
    din pachetul inputData si ma ajuta la structurarea mai buna a datelor de intrare si la la
    citirea lor mai usor.

        Baza de date (clasa Database) reprezinta punctul principal din program in care se
    afla toate datele de care avem nevoie. Am folosit Singleton pattern pentru a instantia
    baza de date o singura data pentru ca avem nevoie doar de o singura instanta a ei.
    Initializarea bazei de date se realizeaza prin preluarea datelor din Input, iar in functie
    de varsta copiilor se creeaza instante diferite ale copiilor care participa la simulare.
    Am folosit o clasa interna, numita Executor, in interiorul bazei de date, unde se realizeaza
    logica pentru prelucrarea datelor si executia programului.

        Pentru a clasifica fiecare copil dupa varsta, am creeat o clasa abstracta Child care
    contine toate campurile ce descriu un copil. Clasele Baby, Kid si Teen sunt clase derivate care
    extind clasa parinte Child pentru avea diferite implementari pentru anumite functionalitati,
    dar si pentru a beneficia de campurile clasei de baza. Tot in clasa abstracta am realizat si
    doua metode specifife clasei care ma ajuta in rezolvare. Sub-clasele au doar doi constructori
    diferiti si metoda de accept pentru Visitor pattern. Cei doi constructori sunt folositi
    diferit in funcite de necesitati. Unul dintre ei primeste ca parametru un ChildData care
    contine date pentru un copil si apeleaza constructorul din clasa parinte, iar celalalt primeste
    ca parametru un Child.

        Am folosit si Visitor pattern pentru a calcula mai usor gradul de cumintenie in functie de
    varsta copiilor. Astfel in interfata Visitor am cele 4 metode de visit pentru clasa parinte
    Child cat si pentru clasele ei derivate, iar in interfata Visitable metoda de accept. Clasa
    ScoreCalculator implementeaza interfata Visitor, deci trebuie suprascriese metodele ei.
    Implementarea pentru fiecare metoda se efectueaza asa cum cere cerinta.

        In pachetul outputdata am facut 3 clase pentru a formata datele de iesire in formatul
    dorit. Clasa ChildOutput contine toate campurile necesare afisarii tuturor informatiilor
    dorite. Astfel pentru afisarea informatiilor unui singur copil se foloseste aceasta clasa
    iar pentru a afisa toti copii dintr-o runda am creeat clasa RoundOutput ce are un singur
    ArrayList cu elemente de tip ChildOutput si astfel retine datele de la toti copii dintr-o
    runda. Clasa OutputData contine un ArrayList cu toate rundele simulate si astfel realizez
    afisarea.
        
        Pentru a afisa datele in format JSON, am creeat o clasa Writer si contine o metoda care
    creeaza un fisier de output si pune in el toate datele de iesire, mai apoi, aceasta metoda
    find apelata in main, intr-o bucla care trece prin toate testele.

        Pentru a tine cont de preferinte, am folosit enumul Category din clasa Category din
    pachetul enums, la fel si cu orasele.
        Am adaugat constante noi in clasa common.Constants precum:
    - TEST_PATH -> pentru a avea acces mai usor la fisierele de input.
    - MAX_BABY_AGE -> varsta maxima pe care o poate avea un bebelus.
    - MAX_KID_AGE -> varsta maxima pe care o poate avea un pusti.
    - MAX_TEEN_AGE -> varsta maxima pe care o poate avea un adolescent.
    - MAX_SCORE -> scorul maxim de cumintenie (10).

        






