package eventb.expressions.bool;

import eventb.expressions.AExpression;
import eventb.tools.formatter.IEventBFormatter;
import eventb.tools.replacer.IAssignableReplacer;

import java.util.Arrays;
import java.util.List;

/**
 * Created by gvoiron on 07/07/16.
 * Time : 23:30
 */
public final class And extends ABooleanExpression {

    private final List<ABooleanExpression> operands;

    public And(ABooleanExpression... operands) {
        this.operands = Arrays.asList(operands);
    }

    @Override
    public String accept(IEventBFormatter visitor) {
        return visitor.visit(this);
    }

    @Override
    public AExpression accept(IAssignableReplacer visitor) {
        return visitor.visit(this);
    }

    public List<ABooleanExpression> getOperands() {
        return operands;
    }

}