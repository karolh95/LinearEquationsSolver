package solver.parsers;

import solver.Complex;

public interface ComplexParser {

    String NUMBER = "[0-9]+([.][0-9]+)?";
    String OPT_NUMBER = "(" + NUMBER + ")?";

    String getPattern();

    Complex parse(String value);
}
