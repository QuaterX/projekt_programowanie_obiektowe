public class Effect {

    public enum Type {
        HEAL,
        STRENGTH_BUFF,
        DEXTERITY_BUFF,
        INTELLIGENCE_BUFF,
        POISON,
        REGENERATION
    }

    private final Type type;
    private int duration;
    private final int value;

    public Effect(Type type, int duration, int value) {
        this.type = type;
        this.duration = duration;
        this.value = value;
    }

    public Type getType() {
        return type;
    }

    public int getDuration() {
        return duration;
    }

    public int getValue() {
        return value;
    }

    public void tick() {
        duration--;
    }
}