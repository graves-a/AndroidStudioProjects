package com.zybooks.pizzaparty;

public class PizzaCalculator {

    public enum HungerLevel {
        LIGHT, MEDIUM, RAVENOUS
    }

    public final static int SLICES_PER_PIZZA = 8;

    public HungerLevel mHungerLevel;
    public int mPartySize;

    public PizzaCalculator(int partySize, HungerLevel level) {
        setHungerLeve(level);
        setPartySize(partySize);
    }

    public HungerLevel getHungerLevel() {
        return mHungerLevel;
    }

    public void setHungerLeve(HungerLevel level) {
        mHungerLevel = level;
    }

    public int getPartySize() {
        return mPartySize;
    }

    public void setPartySize(int partySize) {
        if (partySize >= 0 ) {
            mPartySize = partySize;
        }
    }

    public int getTotalPizzas() {
        int slicesPerPerson;
        if (mHungerLevel == HungerLevel.LIGHT) {
            slicesPerPerson = 2;
        } else if (mHungerLevel == HungerLevel.MEDIUM) {
            slicesPerPerson = 3;
        } else {
            slicesPerPerson = 4;
        }
        return (int) Math.ceil(mPartySize * slicesPerPerson / (double) SLICES_PER_PIZZA);
    }
}
