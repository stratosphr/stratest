package eventb.expressions.bool;

import eventb.expressions.AExpression;
import eventb.expressions.arith.Variable;
import eventb.tools.formatters.IEventBFormatter;
import eventb.tools.formatters.IExpressionFormatter;
import eventb.tools.primer.IExpressionToExpressionVisitor;
import eventb.tools.replacer.IAssignableReplacer;

/**
 * Created by gvoiron on 14/08/16.
 * Time : 16:52
 */
public final class ForAll extends AQuantifier {

    public ForAll(ABooleanExpression expression, Variable... quantifiedVariables) {
        super(expression, quantifiedVariables);
    }

    @Override
    public String accept(IEventBFormatter visitor) {
        return visitor.visit(this);
    }

    @Override
    public String accept(IExpressionFormatter visitor) {
        return visitor.visit(this);
    }

    @Override
    public AExpression accept(IExpressionToExpressionVisitor visitor) {
        return visitor.visit(this);
    }

    @Override
    public AExpression accept(IAssignableReplacer visitor) {
        return visitor.visit(this);
    }

}
