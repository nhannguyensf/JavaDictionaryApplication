enum DictionaryEntry {
    ARROW_NOUN_1("Arrow", "noun", "Here is one arrow: <IMG> -=>> </IMG>"),
    BOOK_NOUN_1("book", "noun", "A set of pages."),
    BOOK_NOUN_2("book", "noun", "A written work published in printed or electronic form."),
    BOOK_VERB_1("book", "verb", "To arrange for someone to have a seat on a plane."),
    BOOK_VERB_2("book", "verb", "To arrange something on a particular date."),
    PLACEHOLDER_ADJECTIVE_1("placeholder", "adjective", "To be updated..."),
    PLACEHOLDER_ADVERB_1("placeholder", "adverb", "To be updated..."),
    PLACEHOLDER_CONJUNCTION_1("placeholder", "conjunction", "To be updated..."),
    PLACEHOLDER_INTERJECTION_1("placeholder", "interjection", "To be updated..."),
    PLACEHOLDER_NOUN_1("placeholder", "noun", "To be updated..."),
    PLACEHOLDER_PREPOSITION_1("placeholder", "preposition", "To be updated..."),
    PLACEHOLDER_PRONOUN_1("placeholder", "pronoun", "To be updated..."),
    PLACEHOLDER_VERB_1("placeholder", "verb", "To be updated..."),
    REVERSE_ADJECTIVE_1("reverse", "adjective", "On back side."),
    REVERSE_ADJECTIVE_2("reverse", "adjective", "Opposite to usual or previous arrangement."),
    REVERSE_NOUN_1("reverse", "noun", "A dictionary program's parameter."),
    REVERSE_NOUN_2("reverse", "noun", "Change to opposite direction."),
    REVERSE_NOUN_3("reverse", "noun", "The opposite."),
    REVERSE_VERB_1("reverse", "verb", "Change something to opposite."),
    REVERSE_VERB_2("reverse", "verb", "Go back"),
    REVERSE_VERB_3("reverse", "verb", "Revoke ruling."),
    ;

    private final String keyword;
    private final String partOfSpeech;
    private final String definition;

    DictionaryEntry(String keyword, String partOfSpeech, String definition) {
        this.keyword = keyword;
        this.partOfSpeech = partOfSpeech;
        this.definition = definition;
    }

    public String getKeyword() {
        return keyword;
    }

    public String getPartOfSpeech() {
        return partOfSpeech;
    }

    public String getDefinition() {
        return definition;
    }
}
