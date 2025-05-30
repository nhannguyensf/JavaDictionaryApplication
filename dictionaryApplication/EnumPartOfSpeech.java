// Enum for different parts of speech
public enum EnumPartOfSpeech {
    NOUN("noun"),
    VERB("verb"),
    ADJECTIVE("adjective"),
    ADVERB("adverb"),
    CONJUNCTION("conjunction"),
    INTERJECTION("interjection"),
    PRONOUN("pronoun"),
    PREPOSITION("preposition"),
    ;
    private final String partOfSpeech;

    private EnumPartOfSpeech(String partOfSpeech) {
        this.partOfSpeech = partOfSpeech;
    }

    public String getPartOfSpeech() {
        return partOfSpeech;
    }
}
