package eventb.expressions.arith;

import eventb.expressions.AExpression;
import eventb.expressions.bool.ABooleanExpression;
import eventb.tools.formatter.IEventBFormatter;
import eventb.tools.replacer.IAssignableReplacer;

/**
 * Created by gvoiron on 07/07/16.
 * Time : 23:23
 */
public final class LowerOrEqual extends ABooleanExpression {

    private final AArithmeticExpression left;
    private final AArithmeticExpression right;

    public LowerOrEqual(AArithmeticExpression left, AArithmeticExpression right) {
        this.left = left;
        this.right = right;
    }

    public AArithmeticExpression getLeft() {
        return left;
    }

    public AArithmeticExpression getRight() {
        return right;
    }

    @Override
    public String accept(IEventBFormatter visitor) {
        return visitor.visit(this);
    }

    @Override
    public AExpression accept(IAssignableReplacer visitor) {
        return visitor.visit(this);
    }

}