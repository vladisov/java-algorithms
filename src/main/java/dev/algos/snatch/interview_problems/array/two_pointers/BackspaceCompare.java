package dev.algos.snatch.interview_problems.array.two_pointers;

class BackspaceCompare {

    boolean compare(String s, String t) {
        int sp = s.length() - 1;
        int tp = t.length() - 1;
        while (sp >= 0 || tp >= 0) {
            int schi = getCharIndex(s, sp);
            int tchi = getCharIndex(t, tp);

            if (schi < 0 && tchi < 0) {
                return true;
            }
            if (schi < 0 || tchi < 0) {
                //reached end of one string
                return false;
            }
            if (s.charAt(schi) != t.charAt(tchi)) {
                return false;
            }
            sp = schi - 1;
            tp = tchi - 1;
        }
        return true;
    }

    private int getCharIndex(String s, int index) {
        int countHashSign = 0;
        while (index >= 0) {
            if (s.charAt(index) == '#') {
                countHashSign++;
            } else if (countHashSign > 0) {
                countHashSign--;
            } else {
                break;
            }
            index--;
        }
        return index;
    }
}
