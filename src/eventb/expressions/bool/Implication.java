package eventb.expressions.bool;

import eventb.formatter.IEventBFormatter;

/**
 * Created by gvoiron on 07/07/16.
 * Time : 01:09
 */
public final class Implication extends ABooleanExpression {

    private final ABooleanExpression ifPart;
    private final ABooleanExpression thenPart;

    public Implication(ABooleanExpression ifPart, ABooleanExpression thenPart) {
        this.ifPart = ifPart;
        this.thenPart = thenPart;
    }

    @Override
    public String accept(IEventBFormatter visitor) {
        return visitor.visit(this);
    }

    public ABooleanExpression getIfPart() {
        return ifPart;
    }

    public ABooleanExpression getThenPart() {
        return thenPart;
    }

}