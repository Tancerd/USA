package pl.usa.utils.core;

public interface ValidationMessages {

	public static final String EMPTY = "Pole nie może być puste";
	public static final String TO_LOW = "Wartość musi być dodatnia";

	public static final String EMAIL_WRONG_PATTERN = "Zły format adresu e-mail";
	public static final String EMAIL_EXISTS = "Taki adres e-mail już widnieje w bazie";
	public static final String PASSWORD_TO_SHORT = "Hasło musi mieć przynajmniej 6 znaków";
	public static final String PASSWORD_TO_LONG = "Hasło może mieć conajwyżej 30 znaków";
	public static final String PASSWORD_NOT_THE_SAME = "Hasła muszą być takie same";

	public static final String NAME_TO_SHORT = "Imie musi mieć przynajmniej 2 znaki";
	public static final String NAME_TO_LONG = "Imie może mieć conajwyżej 30 znaków";
	public static final String LASTNAME_TO_SHORT = "Nazwisko musi mieć przynajmniej 2 znaki";
	public static final String LASTNAME_TO_LONG = "Nazwisko może mieć conajwyżej 40 znaków";
	public static final String NICK_TO_SHORT = "Imie musi mieć przynajmniej 2 znaki";
	public static final String NICK_TO_LONG = "Nazwisko może mieć conajwyżej 40 znaków";
	public static final String PHONENUMBER_TO_LONG = "Numer telefonu może mieć conajwyżej 25 znaków";
	public static final String PAGE_TO_LONG = "Strona internetowa może mieć conajwyżej 30 znaków";

	public static final String STORY_TO_SHORT = "Historia musi mieć przynajmniej 30 znaków";
	public static final String STORY_TO_LONG = "Historia może mieć conajwyżej 700 znaków";
	public static final String CHARACTER_NAME_TO_LONG = "Imie może mieć conajwyżej 30 znaków";
	public static final String NAME_EXISTS = "Istanieje już postać o takim imieniu";

	public static final String DESCRIPTION_TO_LONG = "Opis może mieć conajwyżej 60 znaków";
	public static final String TEXT_TO_LONG = "Tekst może mieć conajwyżej 1000 znaków";
	public static final String IDENTIFIER_EXISTS = "Istnieje już tag o takim identyfikatorze";
}
